package com.example.admin.lesson8;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;

public class MyLoaderFor3rdFragment extends AsyncTaskLoader<String> {
    private String mString;

    public MyLoaderFor3rdFragment(Context context, Bundle bundle) {
        super(context);
        this.mString = bundle.getString(MainActivity.STRING_KEY);
    }

    @Override
    public String loadInBackground() {

        return mString+"I'm HEllo";
    }
}