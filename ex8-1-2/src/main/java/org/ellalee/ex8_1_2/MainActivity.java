package org.ellalee.ex8_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private final static String NOTES = "notes.txt";
    private EditText txtUIIData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUIIData = findViewById(R.id.txtUIData);
        Button btn = findViewById(R.id.close);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        try{
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTES,MODE_PRIVATE));
            out.write(txtUIIData.getText().toString());
            out.close();
        }catch (Throwable t){
            Toast.makeText(this, "Exception "+t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            InputStream in = openFileInput(NOTES);
            if(in != null){
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String str = "";
                StringBuffer buf = new StringBuffer();

                while((str = reader.readLine()) != null){
                    buf.append(str+"\n");
                }
                in.close();
                txtUIIData.setText(buf.toString());
            }
        }catch (java.io.FileNotFoundException e){
        }catch (Throwable t){
            Toast.makeText(this, "Exception "+t.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
