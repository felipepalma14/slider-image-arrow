package com.ninestack.sampleslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.felipepalma14.sliderimagearrow.listener.OnItemClickListener;
import com.felipepalma14.sliderimagearrow.view.SliderView;

import java.util.Arrays;
import java.util.List;

public class SliderSampleActivity extends AppCompatActivity {

    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_sample);

        sliderView = findViewById(R.id.sliderView);
        List<String> images =  Arrays.asList( getResources().getStringArray(R.array.user_photos));
        final SliderAdapterExample adapter  = new SliderAdapterExample(images);
        adapter.setOnImageClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(String item) {

            }
        });
        sliderView.setSliderAdapter(adapter);


    }
}
