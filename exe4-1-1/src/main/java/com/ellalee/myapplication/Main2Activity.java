package com.ellalee.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button0 = findViewById(R.id.button2);
        button0.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Toast.makeText(getApplication(), "돌아가기 버튼이 눌렸어요", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("name","mike");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
