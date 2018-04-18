package org.ellalee.ex4_1_2;

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

        Button button = findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "The back button is clicked.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("name","mike");
                setResult(RESULT_OK,intent);

                finish();
            }
        });
    }
}
