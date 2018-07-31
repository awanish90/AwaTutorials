package awa.com.awatutorials.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import awa.com.awatutorials.R;
import awa.com.awatutorials.adapter.MultiViewAdapter;
import awa.com.awatutorials.model.ViewTypeModel;

public class RecyclerviewmultipleViewActivity extends AppCompatActivity {
    ArrayList<ViewTypeModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewmultiple_view);
        setdata();
        MultiViewAdapter adapter = new MultiViewAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.multipleViewTypeRecyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private void setdata() {
      list= new ArrayList();
        list.add(new ViewTypeModel(ViewTypeModel.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new ViewTypeModel(ViewTypeModel.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",R.drawable.mumstips_sand_5));
        list.add(new ViewTypeModel(ViewTypeModel.AUDIO_TYPE,"Hey. Pressing the FAB button will playback an audio file on loop.",R.raw.sound));
        list.add(new ViewTypeModel(ViewTypeModel.IMAGE_TYPE,"Hi again. Another cool image here. Which one is better?",R.drawable.mumstips_sunscreen_1));
    }
}
