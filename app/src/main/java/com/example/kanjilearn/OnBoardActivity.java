package com.example.kanjilearn;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firsStart = prefs.getBoolean("firstStart", true);

        if (firsStart) {

            setNextText("Далее");
            setPrevText("Назад");
            setFinishText("Приступить");
            setCancelText("Пропустить");

            // 1 fragment
            addFragment(new Step.Builder().setTitle("Добро пожаловать!")
                    .setContent("\"Kanji Learn\""+" - это простой словарь японского языка, с удобным дизайном и функционалом, использующий данные из свободных источников.")
                    .setBackgroundColor(Color.parseColor("#ADA996")) // int background color   #f85032, #e73827, ef473a, ef5350  #ADA996
                    .setDrawable(R.drawable.background_one) // int top drawable
                    .setSummary("Знакомство")
                    .build());

            // 2 fragment
            addFragment(new Step.Builder().setTitle("This is header 2")
                    .setContent("This is content 2")
                    .setBackgroundColor(Color.parseColor("#ADA996")) // int background color   #ADA996
                    .setDrawable(R.drawable.background_one) // int top drawable
                    .setSummary("This is summary 2")
                    .build());

            // 3 fragment
            addFragment(new Step.Builder().setTitle("This is header")
                    .setContent("This is content 3")
                    .setBackgroundColor(Color.parseColor("#ADA996")) // int background color   #ADA996 !!!!
                    .setDrawable(R.drawable.background_one) // int top drawable
                    .setSummary("This is summary")
                    .build());
        }
        else {
            finishTutorial();
        }
    }
    @Override
    public void finishTutorial() {
        Intent intent = new Intent(OnBoardActivity.this, MainActivity.class);
        startActivity(intent);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();

        finish();
    }

    @Override
    public void currentFragmentPosition(int position) {

    }
}
