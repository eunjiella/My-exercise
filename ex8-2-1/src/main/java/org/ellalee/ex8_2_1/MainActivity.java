package org.ellalee.ex8_2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MySQLiteOpenHelper(MainActivity.this,"person.db",null,1);
        insert("user1",18,"홍길동");
        insert("user2",28,"Tomas");
        insert("user3",28,"Smith");

        update("user1",58);
        delete("user2");
        select();
    }

    public void insert(String name,int age,String address){
        db = helper.getWriteableDatabase();
        contentValues values = new ContentValues();

        values.put("name",name);
        values.put("age",age);
        values.put("address",address);
        db.insert("student",null,values);
    }
    public void update(String name,int age){
        db= helper.getWritableDatabase();
        contentValues values = new ContentValues();
        values.put("age",age);
        db.update("student",values,"name=?",new String[]{name});
    }
    public void delete(String name){
        db = helper.getWritableDatabase();
        Cursor c = db.query("student",null,null,null,null,null,null);
        while (c.moveToNext()){
            int _id = c.getInt(c.getColumnIndex("_id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));
            Log.i("db1","id: "+_id+", name: "+name+", age: "+age+", address: "+address);
        }
    }
}
