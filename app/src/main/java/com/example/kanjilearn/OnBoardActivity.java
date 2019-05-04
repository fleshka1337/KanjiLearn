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
            addFragment(new Step.Builder().setTitle("This is header 1")
                    .setContent("This is content 1")
                    .setBackgroundColor(Color.parseColor("#ef5350")) // int background color   #f85032, #e73827,
                    .setDrawable(R.drawable.ic_character) // int top drawable
                    .setSummary("This is summary 1")
                    .build());

            // 2 fragment
            addFragment(new Step.Builder().setTitle("This is header 2")
                    .setContent("This is content 2")
                    .setBackgroundColor(Color.parseColor("#cb2d3e")) // int background color
                    .setDrawable(R.drawable.ic_second) // int top drawable
                    .setSummary("This is summary 2")
                    .build());

            // 3 fragment
            addFragment(new Step.Builder().setTitle("This is header")
                    .setContent("This is content 3")
                    .setBackgroundColor(Color.parseColor("#ef473a")) // int background color
                    .setDrawable(R.drawable.test_background) // int top drawable
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
