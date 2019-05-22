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
        lstCard.add(new Card("ク","ku","クウ"));
        lstCard.add(new Card("ケ","ke","ケエ"));
        lstCard.add(new Card("コ","ko","コオ"));
        // 3 ряд
        lstCard.add(new Card("サ","sa","サア"));
        lstCard.add(new Card("シ","shi","シイ"));
        lstCard.add(new Card("ス","su","スウ"));
        lstCard.add(new Card("セ","se","セエ"));
        lstCard.add(new Card("ソ","so","ソオ"));
        // 4 ряд
        lstCard.add(new Card("タ","ta","タア"));
        lstCard.add(new Card("チ","chi","チイ"));
        lstCard.add(new Card("ツ","tsu","ツウ"));
        lstCard.add(new Card("テ","te","テエ"));
        lstCard.add(new Card("ト","to","トオ"));
        // 5 ряд
        lstCard.add(new Card("ナ","na","ナア"));
        lstCard.add(new Card("ニ","ni","ニイ"));
        lstCard.add(new Card("ヌ","nu","ヌウ"));
        lstCard.add(new Card("ネ","ne","ネエ"));
        lstCard.add(new Card("ノ","no","ノオ"));
        // 6 ряд
        lstCard.add(new Card("ハ","ha","ハア"));
        lstCard.add(new Card("ヒ","hi","ヒイ"));
        lstCard.add(new Card("フ","fu","フウ"));
        lstCard.add(new Card("ヘ","he","ヘエ"));
        lstCard.add(new Card("ホ","ho","ホオ"));
        // 7 ряд
        lstCard.add(new Card("マ","ma","マア"));
        lstCard.add(new Card("ミ","mi","ミイ"));
        lstCard.add(new Card("ム","mu","ムウ"));
        lstCard.add(new Card("メ","me","メエ"));
        lstCard.add(new Card("モ","mo","モオ"));
        // 8 ряд
        lstCard.add(new Card("ヤ","ya","ヤア"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ユ","yu","ユウ"));
        lstCard.add(new Card("","",""));
        lstCard.add(new Card("ヨ","yo","ヨオ"));
        // 9 ряд
        lstCard.add(new Card("ラ","ra","ラア"));
        lstCard.add(new Card("リ","ri","リイ"));
        lstCard.add(new Card("ル","ru","ルウ"));
        lstCard.add(new Card("レ","re","レエ"));
        lstCard.add(new Card("ロ","ro","ロオ"));
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
