package com.example.admin.lesson8;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    IActivityCallBack iActivityCallBack;
    Button buttonRefreshColor;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iActivityCallBack = (MainActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonRefreshColor=(Button) view.findViewById(R.id.refreshColor);
        buttonRefreshColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(iActivityCallBack.getColor());

                getView().setBackgroundColor( Color.parseColor(iActivityCallBack.getColor()));
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
return v;
    }
}
