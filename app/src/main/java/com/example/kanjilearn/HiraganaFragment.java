package com.example.kanjilearn;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class HiraganaFragment extends Fragment {

    Button btnSpeak;
    EditText edtSpeak;

    TextToSpeech textToSpeech;

    public HiraganaFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hiragana, container, false);

        //Init text to speech
        textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(Locale.JAPANESE);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(getActivity(), "THis language is not supported", Toast.LENGTH_SHORT).show();
                    } else {
                        btnSpeak.setEnabled(true);
//                        textToSpeech.setPitch(0.002f);
//                        textToSpeech.setSpeechRate(2.0f);
                        textToSpeech.setSpeechRate(1.0f);
                        speak();
                    }
                }
            }
        });

        //init View
        edtSpeak = (EditText)view.findViewById(R.id.hiragana_edit);
        btnSpeak = (Button)view.findViewById(R.id.hiragana_button);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });

        return view;
    }

    private void speak(){
        String text = edtSpeak.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
        else
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onDestroy() {
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
