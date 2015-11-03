package com.example.goodluck.backup3.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.goodluck.backup3.R;
import com.example.goodluck.backup3.adapters.RecyclerAdapter;


public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    RecyclerAdapter adapter;
    RecyclerView mainRecyclerView;
    CardView listItem;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        listItem = (CardView) findViewById(R.id.cardlist_item);
        mainRecyclerView = (RecyclerView) findViewById(R.id.home_recyclerview);

        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());

        if (adapter == null) {
            adapter = new RecyclerAdapter(this);
            mainRecyclerView.setAdapter(adapter);
        }

        final Context context = this;
        adapter.SetOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        intent = new Intent(getApplicationContext(), TestsActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), TeachersActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_setting:
                return true;
            case R.id.action_refresh:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
