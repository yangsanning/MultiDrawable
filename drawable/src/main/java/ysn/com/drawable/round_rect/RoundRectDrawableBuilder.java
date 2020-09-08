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

    /**
     * 创建 {@link RoundRectDrawable}
     */
    @Override
    public Drawable create() {
        return new RoundRectDrawable(this);
    }
}