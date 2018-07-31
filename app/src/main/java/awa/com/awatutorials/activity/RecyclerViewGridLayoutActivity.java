package awa.com.awatutorials.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.adapter.GridRecyclerViewAdapter;
import awa.com.awatutorials.model.GridDataModel;

public class RecyclerViewGridLayoutActivity extends AppCompatActivity implements GridRecyclerViewAdapter.ItemListener{
    private List<GridDataModel> mList;
    private RecyclerView mgridRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_grid_layout);
        mgridRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewGrid);
        setdata();
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mgridRecyclerView.setLayoutManager(manager);
        GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(this, mList, this);
        mgridRecyclerView.setAdapter(adapter);

    }

    private void setdata(){
        mList = new ArrayList();
        mList.add(new GridDataModel("Item 1", R.drawable.mumstips_sunscreen_1, "#09A9FF"));
        mList.add(new GridDataModel("Item 2", R.drawable.mumstips_sunscreen_2, "#3E51B1"));
        mList.add(new GridDataModel("Item 3", R.drawable.mumstips_hydration_3, "#673BB7"));
        mList.add(new GridDataModel("Item 4", R.drawable.mumstips_surprise_4, "#4BAA50"));
        mList.add(new GridDataModel("Item 5", R.drawable.mumstips_sand_5, "#F94336"));
        mList.add(new GridDataModel("Item 6", R.drawable.mumstips_sand_6, "#0A9B88"));
    }

    @Override
    public void onItemClick(GridDataModel item) {
        Toast.makeText(this, "u clicked on Item  "+item.getGridText(), Toast.LENGTH_SHORT).show();
    }
}
