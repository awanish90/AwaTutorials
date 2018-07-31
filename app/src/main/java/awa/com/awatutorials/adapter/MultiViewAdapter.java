package awa.com.awatutorials.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import awa.com.awatutorials.R;
import awa.com.awatutorials.model.ViewTypeModel;

public class MultiViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ViewTypeModel>dataSet;
    Context mContext;
    int total_types;
    MediaPlayer mPlayer;
    private boolean fabStateVolume = false;
    public MultiViewAdapter(ArrayList<ViewTypeModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){

            case  ViewTypeModel.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
                case ViewTypeModel.IMAGE_TYPE:
                     view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
                    return new ImageTypeViewHolder(view);
            case ViewTypeModel.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_type, parent, false);
                return new AudioTypeViewHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ViewTypeModel object = dataSet.get(position);
        if (object != null) {
            switch (object.type) {
                case ViewTypeModel.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtType.setText(object.text);
                    break;
                case ViewTypeModel.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).txtType.setText(object.text);
                    ((ImageTypeViewHolder) holder).image.setImageResource(object.data);
                    break;
                case ViewTypeModel.AUDIO_TYPE:

                    ((AudioTypeViewHolder) holder).txtType.setText(object.text);

                    ((AudioTypeViewHolder) holder).fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (fabStateVolume) {
                                if (mPlayer.isPlaying()) {
                                    mPlayer.stop();

                                }
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.drawable.back_arrow);
                                fabStateVolume = false;

                            } else {
                               /* mPlayer = MediaPlayer.create(mContext, R.raw.sound);
                                mPlayer.setLooping(true);
                                mPlayer.start();
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.drawable.mute);
                                fabStateVolume = true;*/

                            }
                        }
                    });
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public class TextTypeViewHolder extends RecyclerView.ViewHolder{
        TextView txtType;
        CardView cardView;
        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.textTypeText);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view_text);
        }

    }
    public class ImageTypeViewHolder extends RecyclerView.ViewHolder{
        TextView txtType;
        ImageView image;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.imageTypeText);
            this.image = (ImageView) itemView.findViewById(R.id.imageTypeBackground);
        }
    }
    public class AudioTypeViewHolder extends RecyclerView.ViewHolder{
        TextView txtType;
        FloatingActionButton fab;
        public AudioTypeViewHolder(View itemView) {
            super(itemView);
            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.fab = (FloatingActionButton) itemView.findViewById(R.id.fab);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).type){
            case 0:
                return ViewTypeModel.TEXT_TYPE;
            case 1:
                return ViewTypeModel.IMAGE_TYPE;
            case 2:
                return ViewTypeModel.AUDIO_TYPE;
             default:
                return -1;
        }
    }
}
