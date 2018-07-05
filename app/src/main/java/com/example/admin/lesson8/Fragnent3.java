package com.example.admin.lesson8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Fragnent3 extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mManager;
    private Loader<String> mLoader;
    private String resultString;
    private Button buttonForLoader;
    private Handler handler;
    private List<String> extraDataFromLoaderForRV;
    private List<String> listForRecycleView;
    public static final String STRING_KEY = "String-key";
    public static final Integer idLoaderFragment3 = 2999;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, "HELLO");


        mLoader = getActivity().getSupportLoaderManager().initLoader(idLoaderFragment3, bundle, this);
        mLoader.forceLoad();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    System.out.println(msg.what);
                    System.out.println(msg.obj);
                    extraDataFromLoaderForRV = (ArrayList) msg.obj;
                }

            }
        };

        buttonForLoader = (Button) view.findViewById(R.id.buttonfrag3);
        mRecycleView = view.findViewById(R.id.recycleview);
        mManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycleView.setLayoutManager(mManager);
        listForRecycleView = new ArrayList<String>();
        listForRecycleView.add("Example");
        mAdapter = new CustomAdapter(listForRecycleView);
        mRecycleView.setAdapter(mAdapter);
        buttonForLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listForRecycleView.addAll(extraDataFromLoaderForRV);
                mAdapter.notifyDataSetChanged();

            }
        });

    }


    @Override
    public Loader<String> onCreateLoader(int id, Bundle bundle) {
        Loader<String> mLoader = null;
        if (id == idLoaderFragment3) {
            mLoader = new MyLoaderFor1rdFragment(getActivity(), bundle);
        }

        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        loader.forceLoad();
        Message messageToSend = new Message();
        messageToSend.what = 1;
        List<String> objects = new ArrayList<>();
        objects.add(data);
        messageToSend.obj = objects;
        handler.sendMessage(messageToSend);
        resultString = data;
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
