package com.example.kanjilearn;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Card> mData;

    TextToSpeech textToSpeech;

    String dataSpeak;

    public RecyclerViewAdapter(Context mContext, List<Card> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_kana,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.card_Title.setText(mData.get(position).getKanaRead());
        holder.card_Kana.setText(mData.get(position).getKana());

                //Init text to speech
        textToSpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(Locale.JAPANESE);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//////          textToSpeech.setPitch(0.002f);
//////          textToSpeech.setSpeechRate(2.0f);
//                textToSpeech.setSpeechRate(1.0f);
//              speak(mData.get(position).getKanaTTS());
                textToSpeech.setSpeechRate(1.0f);
                dataSpeak = mData.get(position).getKanaTTS().toString();
                textToSpeech.speak(dataSpeak, TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView card_Title;
        TextView card_Kana;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            card_Title = (TextView)itemView.findViewById(R.id.title_id);
            card_Kana = (TextView)itemView.findViewById(R.id.kana_id);
            cardView = (CardView)itemView.findViewById(R.id.cardView_id);
        }
    }
}
