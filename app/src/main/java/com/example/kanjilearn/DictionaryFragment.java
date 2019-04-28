package com.example.kanjilearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DictionaryFragment extends Fragment {

    private String value = "Hello!";
    private FragmentListener listener;

    ListView listView;

    String[] mTitle = {
            "六",
            "日",
            "月"
//            "百",
//            "歳",
//            "角",
//            "大",
//            "親",
//            "第",
//            "感",
//            "本",
//            "木",
//            "分",
//            "合",
//            "週",
//            "十",
//            "万",
//            "千",
//            "曜",
//            "水",
//            "火",
//            "数",
//            "今",
//            "昨",
//            "明",
//            "望",
//            "先",
//            "五",
//            "来",
//            "見",
//            "夜",
//            "円",
//            "秒",
//            "一",
//            "二",
//            "三",
//            "四",
//            "七",
//            "八",
//            "九",
//            "入",
//            "出",
//            "半",
//            "方",
//            "外",
//            "父",
//            "母",
//            "亡",
//            "友",
//            "切",
//            "肉",
//            "当",
//            "人",
//            "気",
//            "語",
//            "自",
//            "国",
//            "間",
//            "字",
//            "金",
//            "土",
//            "何",
//            "生",
//            "田",
//            "力",
//            "回",
//            "肉"
    };

    String mDescriprion[] = {
            "Kanji one - SIX",
            "Kanji two - DAY",
            "Kajni three - MOON"
    };

    int images[] = {
        R.drawable.ic_six,
        R.drawable.ic_day,
        R.drawable.ic_moon
    };


    public DictionaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        listView = view.findViewById(R.id.dictionaryList);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_dictionary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Button myButton = (Button)view.findViewById(R.id.myBtn);
//        myButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                if (listener!=null)
//                listener.onItemClick(value);
//            }
//        });

        listView = view.findViewById(R.id.dictionaryList);

        MyAdapter adapter = new MyAdapter(getActivity(), mTitle, mDescriprion, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.replace(R.id.fragment_container, new DetailFragment()).addToBackStack(null);
                transaction.commit();
            }
        });


//        ListView dictList = view.findViewById(R.id.dictionaryList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1, getListOfWords());
//        dictList.setAdapter(adapter);

//        dictList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //listener.onItemClick(value);
//                FragmentManager manager = getFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                transaction.replace(R.id.fragment_container, new DetailFragment()).addToBackStack(null);
//                transaction.commit();
//            }
//        });
    }

//    String[] getListOfWords (){
//        String[] source = new String[]{
//                "六",
//                "日",
//                "月",
//                "百",
//                "歳",
//                "角",
//                "大",
//                "親",
//                "第",
//                "感",
//                "本",
//                "木",
//                "分",
//                "合",
//                "週",
//                "十",
//                "万",
//                "千",
//                "曜",
//                "水",
//                "火",
//                "数",
//                "今",
//                "昨",
//                "明",
//                "望",
//                "先",
//                "五",
//                "来",
//                "見",
//                "夜",
//                "円",
//                "秒",
//                "一",
//                "二",
//                "三",
//                "四",
//                "七",
//                "八",
//                "九",
//                "入",
//                "出",
//                "半",
//                "方",
//                "外",
//                "父",
//                "母",
//                "亡",
//                "友",
//                "切",
//                "肉",
//                "当",
//                "人",
//                "気",
//                "語",
//                "自",
//                "国",
//                "間",
//                "字",
//                "金",
//                "土",
//                "何",
//                "生",
//                "田",
//                "力",
//                "回",
//                "肉"
//        };
//        return source;
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setOnFragmentListener(FragmentListener listener){
        this.listener = listener;
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c,String title[], String description[],int imgs[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row, parent,false);
            ImageView images = row.findViewById(R.id.imageViewKanji);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            //Установим наши ресурсы на view
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}

