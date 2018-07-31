package awa.com.awatutorials.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import awa.com.awatutorials.adapter.RecyclerViewMainAdapter;
import awa.com.awatutorials.R;
import awa.com.awatutorials.interfaces.RecyclerViewMainClickListener;
import awa.com.awatutorials.model.RecyclerViewTypes;

public class RecyclerViewMainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerViewMainAdapter mRecyclerViewMainAdapter;
    private List<RecyclerViewTypes> recyclerViewTypesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      mRecyclerView.setLayoutManager(linearLayoutManager);
       // mRecyclerView.hasFixedSize();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        RecyclerViewMainClickListener mainClickListener = new RecyclerViewMainClickListener() {
            @Override
            public void onClick(View v, int position) {
               switch (position){
                   case 0:
                       Toast.makeText(getBaseContext()," you clicked on throug custom Click Listener  "+position,Toast.LENGTH_LONG).show();
                       break;
                       default:
                           break;
               }
            }
        };
        mRecyclerViewMainAdapter = new RecyclerViewMainAdapter(this, prepareListData(),mainClickListener);
       // mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mRecyclerViewMainAdapter);


    }

    public List<RecyclerViewTypes> prepareListData(){

       recyclerViewTypesList.add(new RecyclerViewTypes("Item 1"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 2"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 3"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 4"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 5"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 6"));
        recyclerViewTypesList.add(new RecyclerViewTypes("Item 7"));

        return recyclerViewTypesList;

    }
}
