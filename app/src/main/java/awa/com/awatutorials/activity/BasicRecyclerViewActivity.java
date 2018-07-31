package awa.com.awatutorials.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.adapter.MyBasicRecyclerViewAdapter;

public class BasicRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyBasicRecyclerViewAdapter myBasicRecyclerViewAdapter;
    private List<String> mDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_recycler_view);
        initView();
        setRecyclerView();
    }

    private void setRecyclerView() {
        /* use this setting to improve performance if you know that changes
         in content do not change the layout size of the RecyclerView*/
        recyclerView.setHasFixedSize(true);
        /* use a  layout manager
        The RecyclerView fills itself with views provided by a layout manager that you provide.*/
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter
       /* The views in the list are represented by view holder objects. These objects are instances of a class you define by extending RecyclerView.ViewHolder.
                Each view holder is in charge of displaying a single item with a view. For example, if your list shows music collection, each view
        holder might represent a single album. The RecyclerView creates only as many view holders as are needed to display the on-screen portion of the dynamic content,
                plus a few extra. As the user scrolls through the list, the RecyclerView takes the off-screen views and rebinds them to the data which is
        scrolling onto the screen.*/
       mDataset = new ArrayList<>();
       mDataset.add("RecyclerView With Custom Click Listener");
       mDataset.add("RecyclerView with GridLayout manager");
        mDataset.add("RecyclerView With MultipleViewType ");
       mDataset.add("RecyclerView With Staggered Grid Layout Manager ");
        myBasicRecyclerViewAdapter = new MyBasicRecyclerViewAdapter(this, mDataset);
      /*  You can add the divider line between rows by using DividerItemDecoration provided by support library. Add item decoration on RecyclerView as shown below.*/
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(myBasicRecyclerViewAdapter);

    }

    private void initView() {
        recyclerView = findViewById(R.id.BasicRecyclerView);

    }
}
