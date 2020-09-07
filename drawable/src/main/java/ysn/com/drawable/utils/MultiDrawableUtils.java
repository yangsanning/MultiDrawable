package ysn.com.drawable.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;

import ysn.com.drawable.border.BorderDrawable;
import ysn.com.drawable.border.BorderDrawableBuilder;
import ysn.com.drawable.shadow.ShadowDrawableBuilder;
import ysn.com.drawable.shadow.ShadowDrawable;

/**
 * @Author yangsanning
 * @ClassName MultiDrawableUtils
 * @Description 调用此工具实现设置Drawable
 * @Date 2019/7/19
 * @History 2019/7/19 author: description:
 */
public class MultiDrawableUtils {

    public static void setBackground(View view, ShadowDrawableBuilder attrs) {
        setBackground(view, new ShadowDrawable(attrs));
    }

    public static void setBackground(View view, BorderDrawableBuilder attrs) {
        setBackground(view, new BorderDrawable(attrs));
    }

    /**
     * 建议使用该方法设置，避免错漏
     */
    public static void setBackground(View view, Drawable drawable) {
        ViewCompat.setBackground(view, drawable);
        // setShadowLayer只有文字绘制阴影支持硬件加速，其它都不支持硬件加速,故这里要关闭硬件加速
        ViewCompat.setLayerType(view, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }
}
