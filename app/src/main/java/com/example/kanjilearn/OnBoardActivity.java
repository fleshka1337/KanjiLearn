package com.example.kanjilearn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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
                    .setContent("\"Kanji Learn\""+" - это простой словарь японского языка с удобным дизайном и функционалом, использующий данные из свободных источников.")
                    // Задний фон  - #f85032, #e73827, ef473a, ef5350  #ADA996
                    .setBackgroundColor(Color.parseColor("#ADA996"))
                    .setDrawable(R.drawable.background_one)
                    .setSummary("Знакомство")
                    .build());

            // 2 fragment
            addFragment(new Step.Builder().setTitle("Словарь")
                    .setContent("Мы создаём максимально подробную базу русскоязычного словаря, что позволит максимально подробно изучать иероглифы.")
                    .setBackgroundColor(Color.parseColor("#ADA996"))
                    .setDrawable(R.drawable.logo_one_v)
                    .setSummary("Немного о словаре")
                    .build());

            // 3 fragment
            addFragment(new Step.Builder().setTitle("Дополнительные возможности")
                    .setContent("В \"Kanji Learn\" можно создать свой профиль и отслеживать статистику изученных вами кандзи, синхронизировать закладки между всеми устройствами, а также многое другое!")
                    // Задний фон  - #ADA996 !!!!
                    .setBackgroundColor(Color.parseColor("#ADA996"))
                    .setDrawable(R.drawable.logo_two_v)
                    .setSummary("Профиль и прочее")
                    .build());
        }
        else {
            finishTutorial();
        }
    }
    @Override
    public void finishTutorial() {
        Intent intent = new Intent(OnBoardActivity.this, SplashScreen.class);
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
