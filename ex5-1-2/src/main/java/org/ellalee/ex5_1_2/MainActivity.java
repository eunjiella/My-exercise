package org.ellalee.ex5_1_2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button btnBegin;
    Button btnPay;
    CheckBox chkCream;
    CheckBox chkSugar;
    RadioGroup radCoffeeType;
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombian;

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        labelUserName = findViewById(R.id.textView1);
        txtUserName = findViewById(R.id.txtUserName);
        btnBegin = findViewById(R.id.btn1);

        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtUserName.getText().toString();
                if(userName.compareTo("Eunji")==0){
                    labelUserName.setText("OK, please wait");
                    Toast.makeText(context,"Hi "+userName,duration).show();
                }
                else{
                    Toast.makeText(context,userName+" is not a valid user",duration).show();
                }

            }
        });

        radCoffeeType = findViewById(R.id.radGroupCoffeeType);
        radDecaf = findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id.radEspresso);
        radColombian = findViewById(R.id.radColombian);

        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "coffee";
                if(chkCream.isChecked())
                    msg += "& Cream";
                if(chkSugar.isChecked())
                    msg += "& Sugar";

                int radioId = radCoffeeType.getCheckedRadioButtonId();
                if(radDecaf.getId()==radioId)
                    msg = "Decaf "+msg;
                if(radEspresso.getId()==radioId)
                    msg = "Espresso "+msg;
                if(radColombian.getId() == radioId)
                    msg = "Colombian "+msg;

                Toast.makeText(context,msg,duration).show();
            }
        });

    }
}
