package com.felipepalma14.sliderimagearrow.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.felipepalma14.sliderimagearrow.R;
import com.felipepalma14.sliderimagearrow.view.SliderView;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
    private SliderView mSliderView;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCards;
        MyViewHolder(View view) {
            super(view);
            imgCards = (ImageView) view.findViewById(R.id.imgDisplay);
        }
    }

    public HorizontalAdapter(SliderView sliderView) {
        this.mSliderView = sliderView;
    }

    @NonNull
    @Override
    public HorizontalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_thumb_image , parent, false);

            /*LinearLayout l2 = (LinearLayout) itemView.findViewById(R.id.mainLin);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth-90, ViewGroup.LayoutParams.WRAP_CONTENT );
            //  layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(8,4,0,0);
            l2.setLayoutParams(layoutParams);*/
        return new HorizontalAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HorizontalAdapter.MyViewHolder holder, final int position) {

        Glide.with(mSliderView.getContext()).load(this.mSliderView.getImages().get(position))
                .placeholder( R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgCards);

        holder.imgCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalAdapter.this.mSliderView.getPager().setCurrentItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mSliderView.getImages().size() ;
    }
}

