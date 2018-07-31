package awa.com.awatutorials.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.model.GridDataModel;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.GridViewHolder> {
 private List<GridDataModel> mList;
 private Context mContext;
 private ItemListener mItemListener;
    public GridRecyclerViewAdapter(Context context , List<GridDataModel> list, ItemListener itemListener){
        mList = list;
        mContext = context;
        mItemListener = itemListener;

    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_row_layout, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        setData(holder,position);

    }

    private void setData(GridViewHolder holder, int position) {
        holder.relativeLayout.setBackgroundColor(Color.parseColor(mList.get(position).getColorCode()));
        holder.imageView.setImageResource(mList.get(position).getDrawableId());
        holder.textView.setText(mList.get(position).getGridText());
        holder.item = mList.get(position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        GridDataModel item;


        public GridViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewGrid);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewGrid);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutGrid);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemListener != null) {
                mItemListener.onItemClick(item);
            }
        }
    }
    public interface ItemListener {
        void onItemClick(GridDataModel item);
    }
}
