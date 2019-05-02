package com.example.kanjilearn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class DetailFragment extends Fragment {

    private String value;

    DataCommunication mCallback;

    public DetailFragment() {
        // Required empty public constructor
    }

//    public static DetailFragment getNewInstance(String value){
//        DetailFragment fragment = new DetailFragment();
//        fragment.value = value;
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        Bundle bundle = this.getArguments();
//        if (bundle != null){
//            String kanji = bundle.getString("kanji");
//            Toast.makeText(getContext(),kanji,Toast.LENGTH_LONG).show();
//        }

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String test = mCallback.getMyVariableX();
        Toast.makeText(getContext(),test,Toast.LENGTH_LONG).show();

//        Bundle b = this.getArguments();
//        if (b != null){
//            String s = b.getString("Key");
//            Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show();
//        }
//        Toast.makeText(getContext(),this.value,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (DataCommunication) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DataCommunication");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
