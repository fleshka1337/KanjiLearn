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
            "Шесть",
            "Солнце",
            "Луна",
            "Сто",
            "Возраст",
            "Большой",
            "Угол",
            "Родители",
            "Префикс числительных",
            "Чувство, впечатление",
            "Книга",
            "Дерево",
            "Минута, процент",
            "Соединяться",
            "Неделя",
            "Десять",
            "Десять тысяч",
            "Тысяча",
            "День недели",
            "Вода",
            "Огонь",
            "Число",
            "Сейчас",
            "Вчера",
            "Ясный",
            "Надеяться",
            "Впереди",
            "Пять",
            "Приходить",
            "Видеть",
            "Ночь",
            "Иена, круг",
            "Секунда",
            "Один",
            "Два",
            "Три",
            "Четыре",
            "Семь",
            "Восемь",
            "Девять",
            "Входить",
            "Выходить",
            "Половина",
            "Сторона",
            "Вне",
            "Отец",
            "Мать",
            "Покойный",
            "Друг",
            "Резать, настойчивость",
            "Мясо",
            "Естественно",
            "Человек",
            "Дух",
            "Язык",
            "Сам",
            "Страна",
            "Интервал",
            "Знак",
            "Золото, деньги",
            "Земля",
            "Что?",
            "Жизнь",
            "Рисовое поле",
            "Сила",
            "Вращаться, раз"
    };

    String mDescriprion[] = {
            "Kun: む、 むい\n" +
                    "On: ロク、 リク",
            "Kun: ひ、 -び、 -か、 -け\n" +
                    "On: ニチ、 ジツ",
            "Kun: つき\n" +
                    "On: ゲツ、 ガツ",
            "Kun: もも\n" +
                    "On: ヒャク、 ビャク",
            "Kun: とし、 とせ、 よわい\n" +
                    "On: サイ、 セイ",
            "Kun: おお-、 おおきい\n" +
                    "On: ダイ、 タイ",
            "Kun: かど、 つの\n" +
                    "On: カク",
            "Kun: おや、した.しい\n" +
                    "On: シン",
            "On: ダイ、 テイ",
            "On: カン",
            "Kun: もと\n" +
                    "On: ホン",
            "Kun: き、 こ-\n" +
                    "On: ボク、 モク",
            "Kun: わ.ける、 わ\n" +
                    "On: ブン、 フン、 ブ",
            "Kun: あ.う、あ.わす\n" +
                    "On: ゴウ、 ガッ、 カッ",
            "On: シュウ",
            "Kun:  とお、 と\n" +
                    "On:  ジュウ、 ジッ、 ジュッ",
            "Kun: よろず\n" +
                    "On: マン、 バン",
            "Kun: ち\n" +
                    "On: セン",
            "On: ヨウ",
            "Kun: みず\n" +
                    "On: スイ",
            "Kun: ひ、 -び、 ほ-\n" +
                    "On: カ",
            "Kun: かず、 かぞ、 しばしば\n" +
                    "On: スウ、 サク、シュ",
            "Kun: いま\n" +
                    "On: コン、 キン",
            "On: サク",
            "Kun: あ\n" +
                    "On: メイ、ミョウ、ミン",
            "Kun: のぞ.む、 もち\n" +
                    "On: ボウ、 モウ",
            "Kun: さき、 ま.ず\n" +
                    "On: セン",
            "Kun: いつ、 いつ.つ\n" +
                    "On: ゴ",
            "Kun: く.る、きた.る、き、こ\n" +
                    "On: ライ、 タイ",
            "Kun: み.る、 み.える\n" +
                    "On: ケン",
            "Kun: よ、 よる\n" +
                    "On: ヤ",
            "Kun: まる.い、まど.か\n" +
                    "On: エン",
            "On: ビョウ",
            "Kun: ひと-、 ひと.つ\n" +
                    "On: イチ、 イツ",
            "Kun: ふた、 ふた.つ、 ふたたび\n" +
                    "On: ニ、 ジ",
            "Kun: み、 み.つ、 みっ.つ\n" +
                    "On: サン、 ゾウ",
            "Kun: よ、 よ.つ、 よん\n" +
                    "On: シ",
            "Kun: なな、 なな.つ、 なの\n" +
                    "On: シチ",
            "Kun: や、 や.つ、 やっ.つ、 よう\n" +
                    "On: ハチ",
            "Kun: ここの\n" +
                    "On: キュウ、 ク",
            "Kun: い.る、はい\n" +
                    "On: ニュウ、 ジュ",
            "Kun: で、だ、い\n" +
                    "On: シュツ、 スイ",
            "Kun: なか.ば\n" +
                    "On: ハン",
            "Kun: かた、 -がた\n" +
                    "On: ホウ",
            "Kun: そと、ほか、はず、と-\n" +
                    "On: ガイ、ゲ",
            "Kun: ちち\n" +
                    "On: フ",
            "Kun: はは、 も\n" +
                    "On: ボ",
            "Kun: な、ほろ\n" +
                    "On: ボウ、 モウ",
            "Kun: とも\n" +
                    "On: ユウ",
            "Kun: き、-ぎ.り\n" +
                    "On: セツ、 サイ",
            "Kun: しし\n" +
                    "On: ニク",
            "Kun: あ.たる、あ.たり、まさ.に\n" +
                    "On: トウ",
            "Kun: ひと、 -り、 -と\n" +
                    "On: ジン、 ニン",
            "Kun: いき\n" +
                    "On: キ、 ケ",
            "Kun: かた、ことば \n" +
                    "On: ゴ、ギョ",
            "Kun: みずか、 おの\n" +
                    "On: ジ、 シ",
            "Kun: くに\n" +
                    "On: コク",
            "Kun: あいだ、 ま、 あい\n" +
                    "On: カン、 ケン",
            "Kun: あざ、 あざな、な\n" +
                    "On: ジ",
            "Kun: かね、かな、がね\n" +
                    "On: キン、コン、ゴン",
            "Kun: つち\n" +
                    "On: ド、 ト",
            "Kun: なに、 なん\n" +
                    "On: カ",
            "Kun: なま、い、う、は\n" +
                    "On: セイ、 ショウ",
            "Kun: た\n" +
                    "On: デン",
            "Kun: ちから\n" +
                    "On: リョク、 リキ、 リイ",
            "Kun: まわ、もとお、 \n" +
                    "On: カイ、 エ"

    };

    int images[] = {
        R.drawable.ic_six,
        R.drawable.ic_day,
        R.drawable.ic_moon,
        R.drawable.ic_100,
        R.drawable.ic_age,
        R.drawable.ic_big,
        R.drawable.ic_angle,
        R.drawable.ic_parents,
        R.drawable.ic_prefix,
        R.drawable.ic_feeling,
        R.drawable.ic_book,
        R.drawable.ic_tree,
        R.drawable.ic_minute,
        R.drawable.ic_connect,
        R.drawable.ic_week,
        R.drawable.ic_10,
        R.drawable.ic_10000,
        R.drawable.ic_1000,
        R.drawable.ic_day_of_week,
        R.drawable.ic_water,
        R.drawable.ic_fire,
        R.drawable.ic_number,
        R.drawable.ic_now,
        R.drawable.ic_yesterday,
        R.drawable.ic_clear,
        R.drawable.ic_hope,
        R.drawable.ic_ahead,
        R.drawable.ic_5,
        R.drawable.ic_come,
        R.drawable.ic_watch,
        R.drawable.ic_night,
        R.drawable.ic_circle,
        R.drawable.ic_second,
        R.drawable.ic_1,
        R.drawable.ic_2,
        R.drawable.ic_3,
        R.drawable.ic_4,
        R.drawable.ic_7,
        R.drawable.ic_8,
        R.drawable.ic_nine,
        R.drawable.ic_enter,
        R.drawable.ic_exit,
        R.drawable.ic_half,
        R.drawable.ic_side,
        R.drawable.ic_outside,
        R.drawable.ic_dad,
        R.drawable.ic_mother,
        R.drawable.ic_dead,
        R.drawable.ic_friend,
        R.drawable.ic_cut,
        R.drawable.ic_meat,
        R.drawable.ic_naturally,
        R.drawable.ic_human,
        R.drawable.ic_air,
        R.drawable.ic_language,
        R.drawable.ic_me,
        R.drawable.ic_country,
        R.drawable.ic_interval,
        R.drawable.ic_character,
        R.drawable.ic_gold,
        R.drawable.ic_ground,
        R.drawable.ic_what,
        R.drawable.ic_life,
        R.drawable.ic_rice_field,
        R.drawable.ic_strong,
        R.drawable.ic_rotate
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

