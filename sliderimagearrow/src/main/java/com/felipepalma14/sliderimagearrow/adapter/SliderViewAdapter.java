package com.felipepalma14.sliderimagearrow.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public abstract class SliderViewAdapter <VH extends SliderViewAdapter.ViewHolder> extends PagerAdapter {
    protected List<String> imagesURL;

    //Default View holder class
    public static abstract class ViewHolder {
        public final View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }

    private Queue<VH> destroyedItems = new LinkedList<>();

    public List<String> getImages(){
        return this.imagesURL;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        VH viewHolder = destroyedItems.poll();

        if (viewHolder != null) {
            // Re-add existing view before rendering so that we can make change inside getView()
            container.addView(viewHolder.itemView);
            onBindViewHolder(viewHolder, position);
        } else {
            viewHolder = onCreateViewHolder(container);
            container.addView(viewHolder.itemView);
            onBindViewHolder(viewHolder, position);
        }

        return viewHolder;
    }

    @Override
    public final void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView(((VH) object).itemView);
        destroyedItems.add((VH) object);
    }

    @Override
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return ((VH) object).itemView == view;
    }

    /**
     * Create a new view holder
     * @param parent wrapper view
     * @return view holder
     */
    public abstract VH onCreateViewHolder(ViewGroup parent);

    /**
     * Bind data at position into viewHolder
     * @param viewHolder item view holder
     * @param position item position
     */
    public abstract void onBindViewHolder(VH viewHolder, int position);

    public List<String> getImagesURL() {
        return imagesURL;
    }

    public void setImagesURL(List<String> imagesURL) {
        this.imagesURL = imagesURL;
    }
}
