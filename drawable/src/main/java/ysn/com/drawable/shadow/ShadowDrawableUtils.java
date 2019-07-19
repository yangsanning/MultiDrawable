package ysn.com.drawable.shadow;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * @Author yangsanning
 * @ClassName ShadowDrawableUtils
 * @Description 调用此工具实现阴影
 * @Date 2019/7/19
 * @History 2019/7/19 author: description:
 */
public class ShadowDrawableUtils {

    public static void setBackground(View view, ShadowAttribute attrs) {
        setBackground(view, new ShadowDrawable(attrs));
    }

    public static void setBackground(View view, Drawable drawable) {
        ViewCompat.setBackground(view, drawable);
        ViewCompat.setLayerType(view, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }
}
