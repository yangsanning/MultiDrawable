package ysn.com.drawable.round_rect;

import android.graphics.drawable.Drawable;

import ysn.com.drawable.base.BaseDrawableBuilder;

/**
 * @Author yangsanning
 * @ClassName RoundRectDrawableBuilder
 * @Description 圆角矩形 DrawableBuilder
 * @Date 2020/9/7
 */
public class RoundRectDrawableBuilder extends BaseDrawableBuilder {

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
     * 圆角半径
     * leftTop, leftTop, rightTop,, rightTop,  rightBottom,  rightBottom,  leftBottom,  leftBottom
     */
    private float[] radiusArray = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

    /**
     * 边距
     * left, top,  right, bottom
     */
    private float[] marginArray = {0f, 0f, 0f, 0f};

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public RoundRectDrawableBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public RoundRectDrawableBuilder setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public RoundRectDrawableBuilder setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public void setRadiusArray(float[] radiusArray) {
        this.radiusArray = radiusArray;
    }

    public float[] getRadiusArray() {
        return radiusArray;
    }

    /**
     * 设置四个角的圆角半径
     */
    public RoundRectDrawableBuilder setRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
        radiusArray[0] = leftTop;
        radiusArray[1] = leftTop;
        radiusArray[2] = rightTop;
        radiusArray[3] = rightTop;
        radiusArray[4] = rightBottom;
        radiusArray[5] = rightBottom;
        radiusArray[6] = leftBottom;
        radiusArray[7] = leftBottom;
        return this;
    }

    /**
     * 设置左上角的圆角半径
     */
    public RoundRectDrawableBuilder setLeftTopRadius(float leftTop) {
        radiusArray[0] = leftTop;
        radiusArray[1] = leftTop;
        return this;
    }

    /**
     * 设置右上角的圆角半径
     */
    public RoundRectDrawableBuilder setRightTopRadius(float rightTop) {
        radiusArray[2] = rightTop;
        radiusArray[3] = rightTop;
        return this;
    }

    /**
     * 设置右下角的圆角半径
     */
    public RoundRectDrawableBuilder setRightBottomRadius(float rightBottom) {
        radiusArray[4] = rightBottom;
        radiusArray[5] = rightBottom;
        return this;
    }

    /**
     * 设置左下角的圆角半径
     */
    public RoundRectDrawableBuilder setLeftBottomRadius(float leftBottom) {
        radiusArray[6] = leftBottom;
        radiusArray[7] = leftBottom;
        return this;
    }

    public void setMarginArray(float[] marginArray) {
        this.marginArray = marginArray;
    }

    public float[] getMarginArray() {
        return marginArray;
    }

    /**
     * 设置边距
     */
    public RoundRectDrawableBuilder setMargin(float left, float top, float right, float bottom) {
        marginArray[0] = left;
        marginArray[1] = top;
        marginArray[2] = right;
        marginArray[3] = bottom;
        return this;
    }

    /**
     * 设置左边距
     */
    public RoundRectDrawableBuilder setMarginLeft(float left) {
        marginArray[0] = left;
        return this;
    }

    public float getMarginLeft() {
        return marginArray[0];
    }

    /**
     * 设置上边距
     */
    public RoundRectDrawableBuilder setMarginTop(float top) {
        marginArray[1] = top;
        return this;
    }

    public float getMarginTop() {
        return marginArray[1];
    }

    /**
     * 设置右边距
     */
    public RoundRectDrawableBuilder setMarginRight(float right) {
        marginArray[2] = right;
        return this;
    }

    public float getMarginRight() {
        return marginArray[2];
    }

    /**
     * 设置下边距
     */
    public RoundRectDrawableBuilder setMarginBottom(float bottom) {
        marginArray[3] = bottom;
        return this;
    }

    public float getMarginBottom() {
        return marginArray[3];
    }

    /**
     * 创建 {@link RoundRectDrawable}
     */
    @Override
    public Drawable create() {
        return new RoundRectDrawable(this);
    }
}