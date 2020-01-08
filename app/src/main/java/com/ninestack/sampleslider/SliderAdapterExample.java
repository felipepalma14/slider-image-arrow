package com.ninestack.sampleslider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.felipepalma14.sliderimagearrow.adapter.SliderViewAdapter;

import java.util.List;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterViewHolder> {

    private List<String> photoList;

    public SliderAdapterExample(List<String> photoList) {
        this.photoList = photoList;
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
    }

    @Override
    public int getCount() {
        return photoList.size();
    }


    class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView backgroundImageView;

        SliderAdapterViewHolder(View itemView) {
            super(itemView);
            backgroundImageView = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}