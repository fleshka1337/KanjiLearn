package com.example.kanjilearn;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DataCommunication {

    private String x;
    private int y;

    DictionaryFragment dictionaryFragment;
    BookmarkFragment bookmarkFragment;
    DetailFragment detailFragment;
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dictionaryFragment = new DictionaryFragment();
        bookmarkFragment = new BookmarkFragment();
        detailFragment  = new DetailFragment();
        profileFragment = new ProfileFragment();
        //goToFragment(dictionaryFragment, true);

        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment_container, dictionaryFragment)
//                .addToBackStack(null)
                .show(dictionaryFragment)
                .detach(dictionaryFragment)
                .attach(dictionaryFragment)
                .commit();

        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.edit_search), "Поиск", "Вы можете искать кандзи в этом поле (ромадзи, кунъёми, онъёми, кандзи)")
                .tintTarget(false));


//        dictionaryFragment.setOnFragmentListener(new FragmentListener() {
//            @Override
//            public void onItemClick(String value) {
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//                Fragment selectedFragment = null;
//                selectedFragment = new DetailFragment();
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.fragment_container, ((DetailFragment) selectedFragment).getNewInstance(value)).
//                        addToBackStack(null).
//                        detach(selectedFragment).attach(selectedFragment).commit();
//
//                //new DetailFragment();
//                //goToFragment(new DetailFragment(), false);
//                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailFragment).commit();
//
//            }
//        });
//
//        bookmarkFragment.setOnFragmentListener(new FragmentListener() {
//            @Override
//            public void onItemClick(String value) {
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//
//                Fragment selectedFragment = null;
//                selectedFragment = new DetailFragment();
//
//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.fragment_container, ((DetailFragment) selectedFragment).getNewInstance(value)).
//                        addToBackStack(null).
//                        detach(selectedFragment).attach(selectedFragment).commit();
//
//                //new DetailFragment();
//                //goToFragment(new DetailFragment(), false);
//            }
//        });

//        dictionaryFragment.setOnFragmentListener(new FragmentListener() {
//            @Override
//            public void onItemClick(String value) {
//                Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
//            }
//        });
//
//        bookmarkFragment.setOnFragmentListener(new FragmentListener() {
//            @Override
//            public void onItemClick(String value) {
//                Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
//            }
//        });

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

//        String id = Global.getState(this, "menu_type");
//        if (id != null)
//            onOptionsItemSelected(menu.findItem(Integer.valueOf(id)));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Global.saveState(this, "menu_type", String.valueOf(id));



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Reload current fragment
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
                Toast.makeText(this,"Этот раздел не ещё не создан",Toast.LENGTH_LONG);
                break;
            case R.id.nav_katakana:
                Toast.makeText(this,"Этот раздел не ещё не создан",Toast.LENGTH_LONG);
                break;
            case R.id.nav_profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;

        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).
//                addToBackStack(null).show(selectedFragment)
//                .detach(selectedFragment).attach(selectedFragment)
//                .commit();

//        if (id == R.id.nav_kanji){
//            goToFragment(dictionaryFragment, false);
//        } else if (id == R.id.nav_bookmark){
//            goToFragment(bookmarkFragment,false);
//        }

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
}
