package com.example.admin.lesson8;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, IActivityCallBack {
    private MyAsyncTask myAsyncTask = new MyAsyncTask(this);
    private Loader<String> mLoader;
    private String resultColor;
    String stringRandomNumberToFragment;
    public static final String STRING_KEY = "String-key";
    public static final Integer idLoaderFragment1 = 1999;


    @Override
    public String getData() {
        return stringRandomNumberToFragment;
    }

    @Override
    public String getColor() {
        return resultColor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAsyncTask.execute();

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragnent3 fragnent3 = new Fragnent3();

        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.frame_container, fragment1)
                .add(R.id.frame_container1, fragment2)
                .add(R.id.frame_container2, fragnent3).commit();

        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, "#FF00F0");
        mLoader = getSupportLoaderManager().initLoader(idLoaderFragment1, bundle, this);
        mLoader.forceLoad();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle bundle) {
        Loader<String> mLoader = null;
        if (id == idLoaderFragment1) {
            mLoader = new MyLoaderFor1rdFragment(this, bundle);
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        loader.forceLoad();
        resultColor = s;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
    }

}