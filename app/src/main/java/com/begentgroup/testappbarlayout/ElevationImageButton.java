package com.begentgroup.testappbarlayout;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Utitlity;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dongja94 on 2016-05-19.
 */
@CoordinatorLayout.DefaultBehavior(ElevationImageButton.Behavior.class)
public class ElevationImageButton extends AppCompatImageButton {
    public ElevationImageButton(Context context) {
        this(context, null);
    }

    public ElevationImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setElevation(getResources().getDimension(R.dimen.fab_margin));
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

    public static class Behavior extends CoordinatorLayout.Behavior<ElevationImageButton> {
        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, ElevationImageButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                updateVisibility(parent, (AppBarLayout)dependency, child);
            }
            return false;
        }

        Rect mTmpRect;
        private boolean updateVisibility(CoordinatorLayout parent, AppBarLayout appBarLayout, ElevationImageButton child) {
            final CoordinatorLayout.LayoutParams lp =
                    (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            if (lp.getAnchorId() != appBarLayout.getId()) {
                return false;
            }

            if (mTmpRect == null) {
                mTmpRect = new Rect();
            }

            final Rect rect = mTmpRect;
            Utitlity.getDescendantRect(parent, appBarLayout, rect);

            if (rect.bottom - 50 <= Utitlity.getMinimumHeightForVisibleOverlappingContent(appBarLayout)) {
                child.setVisibility(GONE);
            } else {
                child.setVisibility(VISIBLE);
            }
            return true;

        }
    }
}
