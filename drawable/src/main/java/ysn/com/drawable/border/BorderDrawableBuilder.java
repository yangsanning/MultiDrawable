package ysn.com.drawable.border;

import android.graphics.drawable.Drawable;

import ysn.com.drawable.base.BaseDrawableBuilder;

/**
 * @Author yangsanning
 * @ClassName BorderDrawableBuilder
 * @Description 阴影Drawable
 * @Date 2020/9/7
 */
public class BorderDrawableBuilder extends BaseDrawableBuilder {

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

    public void setRadiusArray(float[] radiusArray) {
        this.radiusArray = radiusArray;
    }

    public float[] getRadiusArray() {
        return radiusArray;
    }

    /**
     * 设置四个角的圆角半径
     */
    public BorderDrawableBuilder setRadius(float leftTop, float rightTop, float rightBottom, float leftBottom) {
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
    public BorderDrawableBuilder setLeftTopRadius(float leftTop) {
        radiusArray[0] = leftTop;
        radiusArray[1] = leftTop;
        return this;
    }

    /**
     * 设置右上角的圆角半径
     */
    public BorderDrawableBuilder setRightTopRadius(float rightTop) {
        radiusArray[2] = rightTop;
        radiusArray[3] = rightTop;
        return this;
    }

    /**
     * 设置右下角的圆角半径
     */
    public BorderDrawableBuilder setRightBottomRadius(float rightBottom) {
        radiusArray[4] = rightBottom;
        radiusArray[5] = rightBottom;
        return this;
    }

    /**
     * 设置左下角的圆角半径
     */
    public BorderDrawableBuilder setLeftBottomRadius(float leftBottom) {
        radiusArray[6] = leftBottom;
        radiusArray[7] = leftBottom;
        return this;
    }

    /**
     * 创建 {@link BorderDrawable}
     */
    @Override
    public Drawable create() {
        return new BorderDrawable(this);
    }
}