package com.example.admin.lesson8;

import android.app.Fragment;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private Loader<String> mLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}