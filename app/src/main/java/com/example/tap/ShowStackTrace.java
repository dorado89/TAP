package com.example.tap;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

public class ShowStackTrace extends AsyncTask<Void,Void,String> {
    private View mRootView;

    public ShowStackTrace(View rootView){
        this.mRootView=rootView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[1].getMethodName();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        TextView stackTraceText = mRootView.findViewById(R.id.stack_trace_text_view);
        stackTraceText.setText(s);
    }
}
