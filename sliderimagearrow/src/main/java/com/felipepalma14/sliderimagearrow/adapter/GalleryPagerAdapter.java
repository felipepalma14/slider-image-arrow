package com.felipepalma14.sliderimagearrow.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.felipepalma14.sliderimagearrow.R;
import com.felipepalma14.sliderimagearrow.listener.OnImageClickListener;
import com.felipepalma14.sliderimagearrow.view.SliderView;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public class GalleryPagerAdapter extends PagerAdapter {
    private LayoutInflater _inflater;
    private SliderView mSliderView;

    public GalleryPagerAdapter(SliderView sliderView) {
        this._inflater = (LayoutInflater) sliderView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mSliderView = sliderView;
    }

    @Override
    public int getCount() {
        return mSliderView.getImages().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = _inflater.inflate(R.layout.pager_gallery_item, container, false);
        container.addView(itemView);

        // Get the border size to show around each image
        //int borderSize = _thumbnails.getPaddingTop();

        // Get the size of the actual thumbnail image
        // int thumbnailSize = ((RelativeLayout.LayoutParams)
        //        _pager.getLayoutParams()).bottomMargin - (borderSize*2);

        // Set the thumbnail layout parameters. Adjust as required
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300,260);
        params.setMargins(3,3,3,3);

        // You could also set like so to remove borders
           /* ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                   ViewGroup.LayoutParams.WRAP_CONTENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT);*/
        //   bmArray = new ArrayList<Bitmap>();
        final ImageView thumbView = new ImageView(mSliderView.getContext());
        thumbView.setTag(position);
        thumbView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        thumbView.setLayoutParams(params);
        thumbView.setMinimumHeight(260);

        thumbView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "Thumbnail clicked");
                // Set the pager position when thumbnail clicked
                //v.setSelected(true);
                   /* for (int j=0;j<_thumbnails.getChildCount();j++)
                    {
                        if (_thumbnails.getChildAt(j).getBackground()!=null) {
                            _thumbnails.getChildAt(j).setBackground(null);
                        }
                    }

                    Drawable highlight = getResources().getDrawable( R.drawable.border);
                    _thumbnails.getChildAt(position).setPadding(4,4,4,4);
                    _thumbnails.getChildAt(position).setBackground(highlight);*/
                mSliderView.getPager().setCurrentItem(position);
                //int offset=(position*300)+(position+1)*4;
                //if(offset<(304*_adapter.getCount()-2))
                //MenuScroll.smoothScrollTo(offset, 0);
            }
        });

        //  _thumbnails.addView(thumbView);

        final ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            /*final ImageView myCustomIcon = (ImageView) LayoutInflater.
                    from(tabL.getContext()).inflate(R.layout.my_custom_tab, null);
            myCustomIcon.setLayoutParams(params);
            myCustomIcon.setPadding(0,0,0,0);*/
        // Asynchronously load the image and set the thumbnail and pager view
        // final View view = getLayoutInflater().inflate(R.layout.my_custom_tab,null);
        // _thumbnails.addView(imageView);
        Glide.with(mSliderView.getContext())
                .load(mSliderView.getImages().get(position))
                .placeholder( R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imageView);

        imageView.setOnClickListener(new OnImageClickListener(position));

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
