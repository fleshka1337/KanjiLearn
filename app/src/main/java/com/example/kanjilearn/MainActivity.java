package com.example.kanjilearn;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DataCommunication, TextWatcher {

    private String x;
    private int y;
    private String[] mass = null;
    private int[] massInt = null;

    DictionaryFragment dictionaryFragment;
    BookmarkFragment bookmarkFragment;
    DetailFragment detailFragment;
    ProfileFragment profileFragment;
    HiraganaFragment hiraganaFragment;

    EditText edit_search;
    DataCommunication mCallback;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView =  navigationView.getHeaderView(0);

        LinearLayout linearLayout =(LinearLayout) hView.findViewById(R.id.nav_header_gradient);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        dictionaryFragment = new DictionaryFragment();
        bookmarkFragment = new BookmarkFragment();
        detailFragment  = new DetailFragment();
        profileFragment = new ProfileFragment();
        mCallback = (DataCommunication) myAdapter;
        //goToFragment(dictionaryFragment, true);

        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment_container, dictionaryFragment)
//                .addToBackStack(null)
                .show(dictionaryFragment)
                .detach(dictionaryFragment)
                .attach(dictionaryFragment)
                .commit();

//        TapTargetView.showFor(this,
//                TapTarget.forView(findViewById(R.id.edit_search_dict), "Поиск", "Вы можете искать кандзи в этом поле (ромадзи, кунъёми, онъёми, кандзи)")
//                .tintTarget(false));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Присваивает фрагмент = 0
        Fragment selectedFragment = null;

        switch (item.getItemId()){
            case R.id.nav_kanji:
                selectedFragment = new DictionaryFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
                        addToBackStack(null).show(selectedFragment)
                        .detach(selectedFragment).attach(selectedFragment)
                        .commit();
                break;
            case R.id.nav_bookmark:
                selectedFragment = new BookmarkFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
                        addToBackStack(null).show(selectedFragment)
                        .detach(selectedFragment).attach(selectedFragment)
                        .commit();
                break;
            case R.id.nav_hiragana:
                selectedFragment = new HiraganaFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
                        addToBackStack(null).show(selectedFragment)
                        .detach(selectedFragment).attach(selectedFragment)
                        .commit();
                break;
            case R.id.nav_katakana:
                selectedFragment = new KatakanaFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
                        addToBackStack(null).show(selectedFragment)
                        .detach(selectedFragment).attach(selectedFragment)
                        .commit();
                break;
            case R.id.nav_profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;

        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
//                addToBackStack(null).show(selectedFragment)
//                .detach(selectedFragment).attach(selectedFragment)
//                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void goToFragment(Fragment fragment, boolean isTop){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, fragment);
        if (!isTop)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        String s="";
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
//            s = "ORIENTATION_LANDSCAPE\n";
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            s = "ORIENTATION_PORTRAIT\n";
//        }
//        s +="onConfigurationChanged() was called "+((Save)getApplicationContext()).ap()+"times";
//        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

    @Override
    public String getMyVariableX(){
        //Get String
        return x;
    }

    @Override
    public void setMyVariableX(String x){
        //Set String
        this.x = x;
    }

    @Override
    public int getMyVariableY(){
        //Get int
        return y;
    }

    @Override
    public void setMyVariableY(int y){
        //Set Int
        this.y = y;
    }

    @Override
    public MyAdapter getMyAdapter() {
        return myAdapter;
    }
    @Override
    public void setMyAdapter(ArrayList<SingleRow> adapterdada) {
        this.myAdapter = new MyAdapter(this, adapterdada);
    }

    @Override
    public void setMyMass (String[] mass){
        this.mass = mass;
    }
    @Override
    public String[] getMyMass(){
        return mass;
    }

    @Override
    public void setMyMassInt (int[] massInt){
        this.massInt = massInt;
    }
    @Override
    public int[] getMyMassInt(){
        return massInt;
    }

//    @Override
//    public void setMyAdapter (ArrayList<SingleRow> adapterdada){
//
//    }
//
//    @Override
//    public MyAdapter getMyAdapter (){
//        return
//    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //this.myAdapter.getFilter().filter(charSequence);
        //mCallback.getMyAdapter().getFilter().filter(charSequence);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
