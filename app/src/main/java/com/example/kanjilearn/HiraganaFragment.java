package com.example.kanjilearn;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class HiraganaFragment extends Fragment {

//    Button btnSpeak;
//    EditText edtSpeak;
//
//    TextToSpeech textToSpeech;

    List<Card> lstCard;

    public HiraganaFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hiragana, container, false);

        lstCard = new ArrayList<>();
        // 1 ряд
        lstCard.add(new Card("あ","a","ああ"));
        lstCard.add(new Card("い","i","いい"));
        lstCard.add(new Card("う","u","うう"));
        lstCard.add(new Card("え","e","ええ"));
        lstCard.add(new Card("お","o","おお"));
        // 2 ряд
        lstCard.add(new Card("か","ka","かあ"));
        lstCard.add(new Card("き","ki","きい"));
        lstCard.add(new Card("く","ku","くう"));
        lstCard.add(new Card("け","ke","けえ"));
        lstCard.add(new Card("こ","ko","こお"));
        // 3 ряд
        lstCard.add(new Card("さ","sa","さあ"));
        lstCard.add(new Card("し","shi","しい"));
        lstCard.add(new Card("す","su","すう"));
        lstCard.add(new Card("せ","se","せえ"));
        lstCard.add(new Card("そ","so","そお"));

        RecyclerView myrv = (RecyclerView)view.findViewById(R.id.recyclerView_hiragana);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstCard);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),5));
        myrv.setAdapter(myAdapter);

//
//        //Init text to speech
//        textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//
//                if (status == TextToSpeech.SUCCESS){
//                    int result = textToSpeech.setLanguage(Locale.JAPANESE);
//                    if (result == TextToSpeech.LANG_MISSING_DATA ||
//                            result == TextToSpeech.LANG_NOT_SUPPORTED){
//                        Toast.makeText(getActivity(), "THis language is not supported", Toast.LENGTH_SHORT).show();
//                    } else {
//                        btnSpeak.setEnabled(true);
////                        textToSpeech.setPitch(0.002f);
////                        textToSpeech.setSpeechRate(2.0f);
//                        textToSpeech.setSpeechRate(1.0f);
//                        speak();
//                    }
//                }
//            }
//        });
//
//        //init View
//        edtSpeak = (EditText)view.findViewById(R.id.hiragana_edit);
//        btnSpeak = (Button)view.findViewById(R.id.hiragana_button);
//        btnSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                speak();
//            }
//        });



        return view;
    }

//    private void speak(){
//        String text = edtSpeak.getText().toString();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
//        else
//            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
//    }

    @Override
    public void onDestroy() {
//        if (textToSpeech != null){
//            textToSpeech.stop();
//            textToSpeech.shutdown();
//        }
        super.onDestroy();
    }
}
