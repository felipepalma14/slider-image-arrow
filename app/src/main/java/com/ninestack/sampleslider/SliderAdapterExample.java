package com.ninestack.sampleslider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.felipepalma14.sliderimagearrow.adapter.SliderViewAdapter;
import com.felipepalma14.sliderimagearrow.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterViewHolder> {

    private List<String> photoList;
    private OnItemClickListener listener;

    SliderAdapterExample(List<String> photoList) {
        this.photoList = photoList;
    }

    SliderAdapterExample(List<String> photoList, OnItemClickListener listener) {
        this.photoList = photoList;
        this.listener = listener;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {

        Glide.with(viewHolder.itemView)
                .load(photoList.get(position))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.backgroundImageView);
        viewHolder.bind(photoList.get(position), listener);
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    public void setOnImageClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView backgroundImageView;

        SliderAdapterViewHolder(View itemView) {
            super(itemView);
            backgroundImageView = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }

        void bind(final String item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    if(listener!=null) {
                        listener.onItemClick(item);
                        Intent intent = new Intent(itemView.getContext(),MediaSliderSampleActivity.class);
                        intent.putStringArrayListExtra("LIST_ITEMS",new ArrayList<String>(photoList));
                        intent.putExtra("ITEM_SELECTED", photoList.indexOf(item));
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}