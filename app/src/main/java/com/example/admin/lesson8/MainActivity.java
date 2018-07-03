package com.example.admin.lesson8;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, IActivityCallBack {
    MyTasl myTasl = new MyTasl();
    private Loader<String> mLoader;
    String stringRandomNumberToFragment;

    @Override
    public String getData() {
        return stringRandomNumberToFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTasl.execute(12);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragnent3 fragnent3 = new Fragnent3();

        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.frame_container, fragment1)
                .add(R.id.frame_container1, fragment2)
                .add(R.id.frame_container2, fragnent3).commitNow();


        Bundle bundle = new Bundle();
        String color;
        bundle.putString("colour", "#FFFFFF");


        mLoader = getSupportLoaderManager().initLoader(1999, bundle, this);
        mLoader.forceLoad();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    class MyTasl extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {

            Random rand = new Random();

            int n = rand.nextInt(50) + 1;
            publishProgress(n);
            return n;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Integer value = values[0];
            stringRandomNumberToFragment = value.toString();
            super.onProgressUpdate(values);

        }
    }


}