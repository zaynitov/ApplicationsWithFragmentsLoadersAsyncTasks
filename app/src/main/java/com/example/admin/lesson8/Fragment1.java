package com.example.admin.lesson8;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    IActivityCallBack iActivityCallBack;
    TextView textView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iActivityCallBack = (MainActivity) context;
        System.out.println("HIHIHII");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("HEHEHEHEHHEHE");

        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(iActivityCallBack.getData());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment1,container,false);
return v;
    }
}
