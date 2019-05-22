package com.example.kanjilearn;


import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
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

    CardView hiraganaCard;

    public HiraganaFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hiragana, container, false);

        hiraganaCard = (CardView)view.findViewById(R.id.hiragana_card);
        hiraganaCard.setFocusableInTouchMode(true);

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
        // 4 ряд
        lstCard.add(new Card("た","ta","たあ"));
        lstCard.add(new Card("ち","chi","ちい"));
        lstCard.add(new Card("つ","tsu","つう"));
        lstCard.add(new Card("て","te","てえ"));
        lstCard.add(new Card("と","to","とお"));
        // 5 ряд
        lstCard.add(new Card("な","na","なあ"));
        lstCard.add(new Card("に","ni","にい"));
        lstCard.add(new Card("ぬ","nu","ぬう"));
        lstCard.add(new Card("ね","ne","ねえ"));
        lstCard.add(new Card("の","no","のお"));
        // 6 ряд
        lstCard.add(new Card("は","ha","はあ"));
        lstCard.add(new Card("ひ","hi","ひい"));
        lstCard.add(new Card("ふ","fu","ふう"));
        lstCard.add(new Card("へ","he","へえ"));
        lstCard.add(new Card("ほ","ho","ほお"));
        // 7 ряд
        lstCard.add(new Card("ま","ma","まあ"));
        lstCard.add(new Card("み","mi","みい"));
        lstCard.add(new Card("む","mu","むう"));
        lstCard.add(new Card("め","me","めえ"));
        lstCard.add(new Card("も","mo","もお"));
        // 8 ряд
        lstCard.add(new Card("や","ya","やあ"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ゆ","yu","ゆう"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("よ","yo","よお"));
        // 9 ряд
        lstCard.add(new Card("ら","ra","らあ"));
        lstCard.add(new Card("り","ri","りい"));
        lstCard.add(new Card("る","ru","るう"));
        lstCard.add(new Card("れ","re","れえ"));
        lstCard.add(new Card("ろ","ro","ろお"));
        // 10 ряд
        lstCard.add(new Card("わ","wa","わあ"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("を","(w)o","ヴぉお"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ん","n","えん"));


        RecyclerView myrv = (RecyclerView)view.findViewById(R.id.recyclerView_hiragana);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstCard);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),5));
        myrv.setAdapter(myAdapter);

        myrv.setNestedScrollingEnabled(false);

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
