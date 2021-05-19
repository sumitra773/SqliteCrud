package com.example.android.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class FetchDataActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<Modal> dataHolder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        recyclerview = (RecyclerView)findViewById(R.id.rec_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DbManager(this).readableData();

        try{
            while (cursor.moveToNext()){

                Modal obj = new Modal(cursor.getString(1),cursor.getString(2),cursor.getString(3));
                dataHolder.add(obj);

            }
            MyAdapter adapter = new MyAdapter(dataHolder);
            recyclerview.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

    }
}