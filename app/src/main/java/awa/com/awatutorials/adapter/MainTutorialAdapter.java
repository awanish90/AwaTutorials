package awa.com.awatutorials.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.activity.BasicRecyclerViewActivity;
import awa.com.awatutorials.activity.ConstraintLayoutActivity;
import awa.com.awatutorials.activity.DialogDemoMainActivity;
import awa.com.awatutorials.activity.DrawablesMainActivity;
import awa.com.awatutorials.activity.JsonParsingFormAssetsActivity;
import awa.com.awatutorials.activity.LifecycleActivity;
import awa.com.awatutorials.activity.RecyclerViewMainActivity;
import awa.com.awatutorials.activity.SQLitePersistenceActivity;
import awa.com.awatutorials.activity.SharedPrefActivity;
import awa.com.awatutorials.interfaces.MainTutorialAdapterClickListener;
import awa.com.awatutorials.model.SimpleTextModel;

/**
 * Created by ${Awanish} on 03/01/18.
 */

public class MainTutorialAdapter extends RecyclerView.Adapter {
    List<SimpleTextModel> models;
    private MainTutorialAdapterClickListener mListener;
    Context context;
    public MainTutorialAdapter(List<SimpleTextModel> simpleTextModels , Context c) {
        models = simpleTextModels;
        context = c;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bindData(models.get(position), position);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    @Override
    public int getItemViewType(final int position) {
        return R.layout.simple_text;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        private TextView simpleTextView;
        private LinearLayout linearLayoutContainer;
        private MainTutorialAdapterClickListener mListener;
        public View mainLayout;

        public SimpleViewHolder(final View itemView) {
            super(itemView);
            mainLayout = itemView;
            simpleTextView = (TextView) itemView.findViewById(R.id.simple_text);
            linearLayoutContainer = (LinearLayout) itemView.findViewById(R.id.mainRowContainer);
        }

        public void bindData(final SimpleTextModel viewModel, final int position) {
            simpleTextView.setText(viewModel.getSimpleText());
            linearLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position == 0){
                        Intent intent = new Intent(context, RecyclerViewMainActivity.class);
                        context.startActivity(intent);
                    }

                }
            });
            simpleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, "you clicked on item "+position, Toast.LENGTH_SHORT).show();
                    if(position == 0){
                        Intent intent = new Intent(context, BasicRecyclerViewActivity.class);
                        context.startActivity(intent);
                    } else if(position == 1){
                        Intent intent = new Intent(context, LifecycleActivity.class);
                        context.startActivity(intent);
                    }
                    else if(position == 2) {
                        Intent intent = new Intent(context, SharedPrefActivity.class);
                        context.startActivity(intent);
                    }
                    else if(position == 3) {
                        Intent intent = new Intent(context, SQLitePersistenceActivity.class);
                        context.startActivity(intent);
                    }else if(position == 4) {
                        Intent intent = new Intent(context, DialogDemoMainActivity.class);
                        context.startActivity(intent);
                    }
                    else if(position == 5) {
                        Intent intent = new Intent(context, ConstraintLayoutActivity.class);
                        context.startActivity(intent);
                    }else if(position == 8 ){
                        Intent intent = new Intent(context, DrawablesMainActivity.class);
                        context.startActivity(intent);
                    }
                    else if(position == 9 ){
                        Intent intent = new Intent(context, JsonParsingFormAssetsActivity.class);
                        context.startActivity(intent);
                    }

                }
            });
        }
    }

}
