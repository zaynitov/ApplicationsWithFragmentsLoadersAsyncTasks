package com.example.admin.lesson8;

import android.os.AsyncTask;

import java.util.Random;

class MyAsyncTask extends AsyncTask<Void, Integer, Integer> {
    private MainActivity mainActivity;

    public MyAsyncTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Override
    protected Integer doInBackground(Void... voids) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(50) + 1;
        publishProgress(randomNumber);
        return randomNumber;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Integer value = values[0];
        mainActivity.stringRandomNumberToFragment = value.toString();
        super.onProgressUpdate(values);

    }
}
