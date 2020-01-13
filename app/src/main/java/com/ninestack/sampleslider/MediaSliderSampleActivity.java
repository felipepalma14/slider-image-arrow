package com.ninestack.sampleslider;

import android.os.Bundle;

import com.zeuskartik.mediaslider.MediaSliderActivity;

import java.util.ArrayList;

public class MediaSliderSampleActivity extends MediaSliderActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra("LIST_ITEMS")){

            ArrayList<String> list = getIntent().getStringArrayListExtra("LIST_ITEMS");
            int itemSelected = getIntent().getIntExtra("ITEM_SELECTED",0);

            loadMediaSliderView(list,"image",false,true,false,"","#000000",null,itemSelected);
        }else{
            finish();
        }
    }
}
