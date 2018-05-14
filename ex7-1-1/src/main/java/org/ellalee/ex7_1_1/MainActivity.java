package org.ellalee.ex7_1_1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar bar;
    ProgressHandler handler;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView01);
        bar = findViewById(R.id.progress);
        handler = new ProgressHandler();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning=false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<20&&isRunning;i++){
                        Thread.sleep(1000);
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                }catch (Exception ex){
                    Log.e("MainActivity","Exception in progress message",ex);
                }
            }
        });
        isRunning = true;
        thread1.start();
    }
    public class ProgressHandler extends Handler{
        public void handleMessage(Message msg){
            bar.incrementProgressBy(5);
            if(bar.getProgress()==bar.getMax()){
                textView.setText("Done");
            }else{
                textView.setText("Working..."+bar.getProgress());
            }
        }
    }
}
 