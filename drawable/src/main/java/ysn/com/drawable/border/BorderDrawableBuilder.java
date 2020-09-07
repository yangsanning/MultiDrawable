package ysn.com.drawable.border;

import android.view.View;

import ysn.com.drawable.shadow.MultiDrawableUtils;

/**
 * @Author yangsanning
 * @ClassName BorderDrawableBuilder
 * @Description 边框Drawable
 * @Date 2020/9/7
 */
public class BorderDrawableBuilder {

    /**
     * backgroundColor: 背景颜色
     */
    private int backgroundColor;

    /**
     * strokeColor: 边框颜色
     */
    private int strokeColor;

    /**
     * 边框宽度
     */
    private int strokeWidth;

    /**
     * 椭圆X轴以及y轴半径
     */
    private float ovalX;
    private float ovalY;

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public BorderDrawableBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public BorderDrawableBuilder setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public BorderDrawableBuilder setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public float getOvalX() {
        return ovalX;
    }

    public BorderDrawableBuilder setOvalX(float ovalX) {
        this.ovalX = ovalX;
        return this;
    }

    public float getOvalY() {
        return ovalY;
    }

    public BorderDrawableBuilder setOvalY(float ovalY) {
        this.ovalY = ovalY;
        return this;
    }

    /**
     * 创建 {@link BorderDrawable}
     */
    public BorderDrawable create() {
        return new BorderDrawable(this);
    }

    /**
     * 直接设置背景
     */
    public void into(View... views) {
        BorderDrawable borderDrawable = create();
        for (View view : views) {
            MultiDrawableUtils.setBackground(view, borderDrawable);
        }
    }
}