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
import awa.com.awatutorials.activity.RecyclerViewGridLayoutActivity;
import awa.com.awatutorials.activity.RecyclerViewMainActivity;
import awa.com.awatutorials.activity.RecyclerviewmultipleViewActivity;


public class MyBasicRecyclerViewAdapter extends RecyclerView.Adapter<MyBasicRecyclerViewAdapter.BasicViewHolder> {
    private List<String> mDataSet;
    private Context mContext ;
    public MyBasicRecyclerViewAdapter(Context context,List<String> dataSet){
          mDataSet = dataSet;
          mContext = context;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_basic_recycler_view, parent, false);
        BasicViewHolder vh = new BasicViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BasicViewHolder holder, final int position) {
        holder.mTextView.setText(mDataSet.get(position));
        holder.rowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    Intent in = new Intent(mContext, RecyclerViewMainActivity.class);
                 mContext.startActivity(in);
                }
                else if(position == 1){
                    Intent in = new Intent(mContext, RecyclerViewGridLayoutActivity.class);
                    mContext.startActivity(in);
                }  else if(position == 2){
                    Intent in = new Intent(mContext, RecyclerviewmultipleViewActivity.class);
                    mContext.startActivity(in);
                }
               // Toast.makeText(mContext,"you clicked on item "+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class BasicViewHolder  extends  RecyclerView.ViewHolder{
        public TextView mTextView;
        public LinearLayout rowContainer;
        public BasicViewHolder(View itemView) {
            super(itemView);
            rowContainer = (LinearLayout) itemView.findViewById(R.id.basicRecyclerViewContainer);
            mTextView = (TextView) itemView.findViewById(R.id.BasicRowText);
        }
    }
}
