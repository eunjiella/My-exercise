package com.ellalee.ex4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main3Activity extends AppCompatActivity {
    String tag ="Life Cycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d(tag,"In the onCreate() event");
    }
    public void onStart(){
        super.onStart();
        Log.d(tag,"In the onStart() event");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(tag,"In the onStart() event");
    }
    public void onResume(){
        super.onResume();
        Log.d(tag,"In the onResume() event");
    }
    public void onPause(){
        super.onPause();
        Log.d(tag,"In the onPause() event");
    }
    public void onStop(){
        super.onStop();
        Log.d(tag,"In the onStop() event");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"In the onDestroy() event");
    }

}
