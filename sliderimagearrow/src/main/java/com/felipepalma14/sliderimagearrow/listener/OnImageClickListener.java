package com.felipepalma14.sliderimagearrow.listener;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Felipe Cunha on 08/01/20.
 * Email: felipe.cunha@itriad.org.br
 * Empresa: Instituto Triad
 */
public class OnImageClickListener implements View.OnClickListener {
    int _postion;
    // constructor
    public OnImageClickListener(int position) {
        this._postion = position;
    }

    @Override
    public void onClick(View v) {
        Log.d("CLICK", "clicado!!!");
        // on selecting grid view image
        // launch full screen activity
        //ArrayList<String> list = new ArrayList<>( _images);
           /* Intent i = new Intent(BoligerDetailsActivity.this, FullScreenViewActivity.class);
            i.putExtra("position", _postion);
            i.putStringArrayListExtra("stock_list",list);
            startActivity(i);*/
    }
}
