package com.example.kanjilearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements Filterable {

    DataCommunication mCallback;

    Context c;
    ArrayList<SingleRow> originalArray,tempArray;
    CustomFilter cs;

    ArrayList<SingleRow> finalfilters;

    ArrayList<String> dataAd = new ArrayList<String>();

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

    @Override
    public Filter getFilter() {
        if (cs == null) {
            cs = new CustomFilter();
        }
        return cs;
    }

    public ArrayList<SingleRow> getFilterList()
    {   if (cs == null){
        cs = new CustomFilter();

    }
        return finalfilters;
    }

    public ArrayList<String> getDataAd(){
        if (cs == null){
            cs = new CustomFilter();
        }
        return dataAd;
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            finalfilters = new ArrayList<>();

            FilterResults results = new FilterResults();

            if (charSequence != null && charSequence.length() > 0) {

                charSequence = charSequence.toString().toUpperCase();
                ArrayList<SingleRow> filters = new ArrayList<>();

//                String[] kData = null;
//                int section = 0;
//                String[] sectionDa = null;

            for (int i = 0; i < tempArray.size(); i++) {
                if (tempArray.get(i).getTitle().toUpperCase().contains(charSequence)) {
                    SingleRow singleRow = new SingleRow(tempArray.get(i).getTitle()
                            , tempArray.get(i).getDescription()
                            , tempArray.get(i).getImage()
                            ,tempArray.get(i).getKanji());
//                    filters.clear();
                    filters.add(singleRow);
//                    kData[i]=tempArray.get(i).getKanji();
                    finalfilters=filters;
                    dataAd.add(tempArray.get(i).getKanji());

                }
            }
            for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).getDescription().toUpperCase().contains(charSequence)) {
                        SingleRow singleRow = new SingleRow(tempArray.get(i).getTitle()
                                , tempArray.get(i).getDescription()
                                , tempArray.get(i).getImage()
                               ,tempArray.get(i).getKanji());
//                        filters.clear();
                        filters.add(singleRow);
 //                       kData[i]=tempArray.get(i).getKanji();
                        finalfilters=filters;
                        dataAd.add(tempArray.get(i).getKanji());

                    }
                }
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).getKanji().toUpperCase().contains(charSequence)) {
                        SingleRow singleRow = new SingleRow(tempArray.get(i).getTitle()
                                , tempArray.get(i).getDescription()
                                , tempArray.get(i).getImage()
                                ,tempArray.get(i).getKanji());
//                        filters.clear();
                        filters.add(singleRow);
//                       kData[i]=tempArray.get(i).getKanji();
                        finalfilters=filters;
                        dataAd.add(tempArray.get(i).getKanji());
                    }
                }

            results.count = filters.size();
            results.values = filters;
//            mCallback.setMyMass(kData);
        }
            else
            {
                results.count = tempArray.size();
                results.values = tempArray;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            originalArray = (ArrayList<SingleRow>)filterResults.values;
            notifyDataSetChanged();
        }


//        public String[] getListOfWords (){
//            String[] mFind = null;
//            return mFind;
//        }

    }

}
