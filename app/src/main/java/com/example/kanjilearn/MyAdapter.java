package com.example.kanjilearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context c;
    ArrayList<SingleRow> originalArray,tempArray;
    public MyAdapter(Context c, ArrayList<SingleRow> originalArray){
        this.c = c;
        this.originalArray = originalArray;
        this.tempArray = originalArray;
    }

    @Override
    public Object getItem(int i) {
        return originalArray.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row,null);

        ImageView images = row.findViewById(R.id.imageViewKanji);
        TextView myTitle = row.findViewById(R.id.textView1);
        TextView myDescription = row.findViewById(R.id.textView2);

        myTitle.setText(originalArray.get(i).getTitle());
        myDescription.setText(originalArray.get(i).getDescription());
        images.setImageResource(originalArray.get(i).getImage());



        return row;
    }

    @Override
    public int getCount() {
        return originalArray.size();
    }

    @Override
    public long getItemId(int i) {
        //return originalArray.indexOf(getItemId(i));
        return i;
    }


}
