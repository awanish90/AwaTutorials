package awa.com.awatutorials.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.interfaces.RecyclerViewMainClickListener;
import awa.com.awatutorials.model.RecyclerViewTypes;

/**
 * Created by ${Awanish} on 05/01/18.
 */

public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.ViewHolder> {

    private List<RecyclerViewTypes> mData ;
    private LayoutInflater mInflater;
    private Context mContext;
    private RecyclerViewMainClickListener mListener;


    // data is passed into the constructor
    public RecyclerViewMainAdapter(Context context, List<RecyclerViewTypes> data, RecyclerViewMainClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        mContext = context;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_view_row, parent, false);
        View view = mInflater.inflate(R.layout.main_recycler_view_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = mData.get(position).getRecyclerViewType();
        holder.rowText.setText(name);
        /*holder.rowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext," you clicked on item "+position,Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView rowText;
        public LinearLayout rowContainer;
        private RecyclerViewMainClickListener mRecyclerViewMainClickListener;
        public ViewHolder(View itemView, RecyclerViewMainClickListener clickListener) {
            super(itemView);
            mRecyclerViewMainClickListener = clickListener;
            rowContainer = (LinearLayout) itemView.findViewById(R.id.recyclerViewTypesContainer);
            rowText = (TextView)itemView.findViewById(R.id.recyclerViewTypes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           mRecyclerViewMainClickListener.onClick(view,getAdapterPosition());
        }
    }


}
