package org.ellalee.ex5_2_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        String[] names = {"LEE","CHOI","KIM","JEONG","RHO"};
        ListView listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        */

        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this);

        listView.setAdapter(adapter);
    }
}
