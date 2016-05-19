package com.begentgroup.testappbarlayout;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

/**
 * Created by dongja94 on 2016-05-19.
 */
public class ElevationImageButton extends AppCompatImageButton {
    public ElevationImageButton(Context context) {
        super(context);
    }

    public ElevationImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    float elevation = 0;

    public float getElevation() {
        if (Build.VERSION.SDK_INT < 21) {
            return elevation;
        } else {
            return super.getElevation();
        }
    }

    public void setElevation(float elevation) {
        if (Build.VERSION.SDK_INT < 21) {
            this.elevation = elevation;
        } else {
            super.setElevation(elevation);
        }
    }

}
