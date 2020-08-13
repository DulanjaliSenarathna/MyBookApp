package com.example.mybookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mybookapp.Adapter.TitleAdapter;
import com.example.mybookapp.Interface.TitleClickListener;
import com.example.mybookapp.Model.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        titleList = new ArrayList<>();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        recyclerView =findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        TitleAdapter titleAdapter = new TitleAdapter(mContext, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("titles",titleList.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(titleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_share){
            Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.menu_about){
            Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.menu_exit){
            finish();
        }
        return onOptionsItemSelected(item);

    }
}
