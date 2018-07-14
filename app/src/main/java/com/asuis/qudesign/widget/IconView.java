package com.asuis.qudesign.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by 15988440973 on 2017/11/29.
 * desciption:
 */

public class IconView extends android.support.v7.widget.AppCompatTextView  {
    public static final String FONT_PATH = "iconfont.ttf";

    public static Typeface mTypeface;

    public IconView(Context context) {
        this(context, null);
    }

    public IconView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs){
        if(mTypeface == null){
            mTypeface = Typeface.createFromAsset(getContext().getAssets(), FONT_PATH);
        }
        setTypeface(mTypeface);
    }
}
