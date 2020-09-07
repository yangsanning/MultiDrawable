package ysn.com.drawable.base;

import android.graphics.drawable.Drawable;
import android.view.View;

import ysn.com.drawable.utils.MultiDrawableUtils;

/**
 * @Author yangsanning
 * @ClassName BaseDrawableBuilder
 * @Description 一句话概括作用
 * @Date 2020/9/7
 */
public abstract class BaseDrawableBuilder {

    /**
     * 创建Drawable
     */
    public abstract Drawable create();

    /**
     * 直接设置背景
     */
    public void into(View... views) {
        Drawable drawable = create();
        for (View view : views) {
            MultiDrawableUtils.setBackground(view, drawable);
        }
    }
}