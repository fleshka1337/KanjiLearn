package com.example.kanjilearn;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KatakanaFragment extends Fragment {

    List<Card> lstCard;

    CardView katakanaCard;

    public KatakanaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_katakana, container, false);

        katakanaCard = (CardView)view.findViewById(R.id.katakana_card);
        katakanaCard.setFocusableInTouchMode(true);

        lstCard = new ArrayList<>();
        // 1 ряд
        lstCard.add(new Card("ア","a","アア"));
        lstCard.add(new Card("イ","i","イイ"));
        lstCard.add(new Card("ウ","u","ウウ"));
        lstCard.add(new Card("エ","e","エエ"));
        lstCard.add(new Card("オ","o","オオ"));
        // 2 ряд
        lstCard.add(new Card("カ","ka","カア"));
        lstCard.add(new Card("キ","ki","キい"));
        lstCard.add(new Card("ク","ku","クう"));
        lstCard.add(new Card("ケ","ke","ケえ"));
        lstCard.add(new Card("コ","ko","コお"));
        // 3 ряд
        lstCard.add(new Card("サ","sa","さア"));
        lstCard.add(new Card("シ","shi","しい"));
        lstCard.add(new Card("ス","su","すう"));
        lstCard.add(new Card("セ","se","せえ"));
        lstCard.add(new Card("ソ","so","そお"));
        // 4 ряд
        lstCard.add(new Card("タ","ta","たア"));
        lstCard.add(new Card("チ","chi","ちい"));
        lstCard.add(new Card("ツ","tsu","つう"));
        lstCard.add(new Card("テ","te","てえ"));
        lstCard.add(new Card("ト","to","とお"));
        // 5 ряд
        lstCard.add(new Card("ナ","na","なア"));
        lstCard.add(new Card("ニ","ni","にい"));
        lstCard.add(new Card("ヌ","nu","ぬう"));
        lstCard.add(new Card("ネ","ne","ねえ"));
        lstCard.add(new Card("ノ","no","のお"));
        // 6 ряд
        lstCard.add(new Card("ハ","ha","はア"));
        lstCard.add(new Card("ヒ","hi","ひい"));
        lstCard.add(new Card("フ","fu","ふう"));
        lstCard.add(new Card("ヘ","he","へえ"));
        lstCard.add(new Card("ホ","ho","ほお"));
        // 7 ряд
        lstCard.add(new Card("マ","ma","まア"));
        lstCard.add(new Card("ミ","mi","みい"));
        lstCard.add(new Card("ム","mu","むう"));
        lstCard.add(new Card("メ","me","めえ"));
        lstCard.add(new Card("モ","mo","もお"));
        // 8 ряд
        lstCard.add(new Card("ヤ","ya","やア"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ユ","yu","ゆう"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ヨ","yo","よお"));
        // 9 ряд
        lstCard.add(new Card("ラ","ra","らア"));
        lstCard.add(new Card("リ","ri","りい"));
        lstCard.add(new Card("ル","ru","るう"));
        lstCard.add(new Card("レ","re","れえ"));
        lstCard.add(new Card("ロ","ro","ろお"));
        // 10 ряд
        lstCard.add(new Card("ワ","wa","ワア"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ヲ","(w)o","ヴぉお"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ン","n","ンん"));


        RecyclerView myrv = (RecyclerView)view.findViewById(R.id.recyclerView_hiragana);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstCard);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),5));
        myrv.setAdapter(myAdapter);

        myrv.setNestedScrollingEnabled(false);

        return view;
    }

}
