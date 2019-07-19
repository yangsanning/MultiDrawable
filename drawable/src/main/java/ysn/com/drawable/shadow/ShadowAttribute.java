package ysn.com.drawable.shadow;

/**
 * @Author yangsanning
 * @ClassName ShadowAttribute
 * @Description ShadowDrawable的属性
 * @Date 2019/7/16
 * @History 2019/7/16 author: description:
 */
public class ShadowAttribute {

    /**
     * shadowColor: 阴影颜色
     * backgroundColor: 背景颜色
     */
    private int shadowColor;
    private int backgroundColor;

    /**
     * 阴影半径
     */
    private int radius;

    /**
     * 阴影x偏移以及y偏移
     */
    private int offsetX;
    private int offsetY;

    /**
     * 椭圆X轴以及y轴半径
     */
    private float ovalX;
    private float ovalY;

    /**
     * 阴影显示的位置
     */
    private int[] shadowTypes = new int[ShadowType.NONE];

    public int getShadowColor() {
        return shadowColor;
    }

    public ShadowAttribute setShadowColor(int shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public ShadowAttribute setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public ShadowAttribute setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public int getShadowOffset() {
        return getShadowOffsetHalf() * 2;
    }

    public int getShadowOffsetHalf() {
        return 0 >= radius ? 0 : Math.max(offsetX, offsetY) + radius;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public ShadowAttribute setOffsetX(int offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public ShadowAttribute setOffsetY(int offsetY) {
        this.offsetY = offsetY;
        return this;
    }

    public float getOvalX() {
        return ovalX;
    }

    public ShadowAttribute setOvalX(float ovalX) {
        this.ovalX = ovalX;
        return this;
    }

    public float getOvalY() {
        return ovalY;
    }

    public ShadowAttribute setOvalY(float ovalY) {
        this.ovalY = ovalY;
        return this;
    }

    public int[] getShadowTypes() {
        return shadowTypes;
    }

    public void setShadowTypes(@ShadowType int[] shadowTypes) {
        this.shadowTypes = shadowTypes;
    }

    public ShadowAttribute setShadowType(@ShadowType int... shadowTypes) {
        this.shadowTypes = shadowTypes;
        return this;
    }
}