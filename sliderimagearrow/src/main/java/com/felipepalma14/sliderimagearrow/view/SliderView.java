package com.felipepalma14.sliderimagearrow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.felipepalma14.sliderimagearrow.R;
import com.felipepalma14.sliderimagearrow.adapter.GalleryPagerAdapter;
import com.felipepalma14.sliderimagearrow.adapter.HorizontalAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public class SliderView extends FrameLayout {

    SliderPager mSliderPager;
    ImageButton leftBtn,rightBtn;
    RecyclerView myList;
    private List<String> _images;
    private PagerAdapter adapter;

    public SliderView(Context context) {
        super(context);
        setupView(context);
        setupSlideView(context);
    }

    public SliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
        setupSlideView(context);

    }

    public SliderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context);
        setupSlideView(context);
    }

    private void setupView(Context context){
        View wrapperView = LayoutInflater
                .from(context)
                .inflate(R.layout.slider_view, this, true);
        mSliderPager   = wrapperView.findViewById(R.id.pager);
        leftBtn  = wrapperView.findViewById(R.id.left_nav);
        rightBtn = wrapperView.findViewById(R.id.right_nav);
        myList   = wrapperView.findViewById(R.id.recyclerviewFrag);
        _images  = Arrays.asList( getResources().getStringArray(R.array.user_photos));
    }

    private void setupSlideView(Context context) {

        setupListeners();

    }
    public void setSliderAdapter(final PagerAdapter adapter){
        this.adapter = adapter;
        mSliderPager.setAdapter(adapter);
        mSliderPager.setOffscreenPageLimit(4); // how many images to load into memory
        this.adapter.notifyDataSetChanged();
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(this);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(mSliderPager.getContext(), LinearLayoutManager.HORIZONTAL, false);
        myList.setLayoutManager(horizontalLayoutManagaer);
        myList.setAdapter(horizontalAdapter);
        horizontalAdapter.notifyDataSetChanged();
    }

    private void setupListeners(){

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mSliderPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    mSliderPager.setCurrentItem(tab);
                } else if (tab == 0) {
                    mSliderPager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mSliderPager.getCurrentItem();
                tab++;
                mSliderPager.setCurrentItem(tab);
            }
        });
        // MenuScroll.setSmoothScrollingEnabled(true);

        mSliderPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //MenuScroll.smoothScrollTo(position*302, 0);
                /*int offset=(position*300)+(position+1)*4;
                if(offset<(304*_adapter.getCount()-2))
                MenuScroll.smoothScrollBy(offset, 0);*/

            }

            @Override
            public void onPageSelected(int position) {
                /*  int offset=(position*300)+(position+1)*4;
                if(offset<(304*_adapter.getCount()-4))
                MenuScroll.smoothScrollTo((position*300)+(position+1)*4, 0);
                */
                myList.scrollToPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public ViewPager getPager() {
        return mSliderPager;
    }

    public void setPager(SliderPager _pager) {
        this.mSliderPager = _pager;
    }

    public List<String> getImages() {
        return _images;
    }

    public void setImages(List<String> _images) {
        this._images = _images;
    }
}
