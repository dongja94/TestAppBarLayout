package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dongja94 on 2016-05-24.
 */
public class Utitlity {
    public static void getDescendantRect(ViewGroup parent, View descendant, Rect out) {
        ViewGroupUtils.getDescendantRect(parent, descendant, out);
    }

    public static int getMinimumHeightForVisibleOverlappingContent(AppBarLayout appBarLayout) {
        return appBarLayout.getMinimumHeightForVisibleOverlappingContent();
    }
}
