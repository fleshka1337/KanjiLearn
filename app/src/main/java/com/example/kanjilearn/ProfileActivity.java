package com.example.kanjilearn;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 9119;
    List<AuthUI.IdpConfig> providers;
    Button    sign_out
            , test_send
            , test_get;

    EditText edit_data_FB;

    TextView text_get;

    ImageView img;

    String test;
    String data, displayName;
    long longData;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        database = FirebaseDatabase.getInstance();
//        myRef = database.getReference("item");

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        sign_out = (Button)findViewById(R.id.sign_out);
//        edit_data_FB = (EditText)findViewById(R.id.edit_data_FB);
//        text_get = (TextView)findViewById(R.id.text_get);
//        test_send = (Button)findViewById(R.id.test_send);
//        test_get = (Button)findViewById(R.id.test_get);
//        img = (ImageView)findViewById(R.id.imageView2);

        //init providers
//        providers = Arrays.asList(
//                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.PhoneBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build()
//        );

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Профиль");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        if (user != null){
//            Toast.makeText(this,"Вы вошли в аккаунт",Toast.LENGTH_SHORT).show();
//            sign_out.setEnabled(true);
//        }
//        else
//            {
//                showSignInOptions();
//            }

//        sign_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Logout
//                AuthUI.getInstance()
//                        .signOut(ProfileActivity.this)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                sign_out.setEnabled(false);
//                                showSignInOptions();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(ProfileActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
//
//        test_send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
//
//                String testData = edit_data_FB.getText().toString();
//
//                Map newPost = new HashMap();
//                newPost.put("testData",testData);
//
//                current_user_db.setValue(newPost);
//            }
//        });
//
//        test_get.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                final DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
//
//                    current_user_db.addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            long testData = dataSnapshot.child("testData").getValue(long.class);
//                            //text_get.setText(testData);
//                            longData = testData;
//                            //text_get.setText(String.valueOf(longData));
//                            String phone = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
//                            if (FirebaseAuth.getInstance().getCurrentUser().getDisplayName() != null){
//                                displayName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
//                            }
//                            text_get.setText(displayName);
//                            //String photoUrl = FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString();
//                            Glide.with(ProfileActivity.this)
//                                    .load(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString())
//                                    .into(img);
//
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//
//                        }
//                    });

                    //text_get.setText(data);
                    //Map newPost = new HashMap();
                    //String data = newPost.get();

                    //text_get.setText();

//            }
//        });
//
//
    }

    private void showSignInOptions(){
        FirebaseApp.initializeApp(this);
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
              //  .setLogo(R.mipmap.ic_launcher_round)
              //  .setLogo(R.drawable.test_background)
                .setLogo(R.drawable.ic_launcher_web)
                .setTheme(R.style.AuthUI_Theme)
                .build(), MY_REQUEST_CODE
        );
        Toast.makeText(this,"Войдите или создайте аккаунт",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE){
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK){
                // Получаем пользователя
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // Показываем тост с Email
                Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
                //Изменяем кнопку sign_out
                sign_out.setEnabled(true);

                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                current_user_db.child("testData");
                current_user_db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() == null) {
                            String user_id_2 = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            DatabaseReference user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id_2);

                            user_db.child("testData");
                            //Забиваем информацию
                            Map newPost = new HashMap();
                            newPost.put("testData",0);

                            //Отправляем в Firebase
                            user_db.setValue(newPost);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

//                Map newPost = new HashMap();
//                newPost.put("testData",0);
//
//                current_user_db.setValue(newPost);
            }
            else
                {
//                    Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                    overridePendingTransition(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
                }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.fui_slide_in_right, R.anim.fui_slide_out_left);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
