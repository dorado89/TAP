package com.example.tap;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ShowStackTrace extends AsyncTask<Void,Void,String> {
    private View mRootView;

    public ShowStackTrace(View rootView){
        this.mRootView=rootView;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        String allStackTrace = "";
        for (StackTraceElement[] value : allStackTraces.values()) {
            if (value.length != 0) {
                for (int i = 0; i < value.length; i++) {
                    allStackTrace+="Method from ["+value[i].getClassName()+"]: "+value[i].getMethodName()+"\n";
                }
            }
        }
        return allStackTrace;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        TextView stackTraceText = mRootView.findViewById(R.id.stack_trace_text_view);
        stackTraceText.setText(s);
    }
}
