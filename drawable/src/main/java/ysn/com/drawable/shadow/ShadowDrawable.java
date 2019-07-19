package ysn.com.drawable.shadow;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * @Author yangsanning
 * @ClassName ShadowDrawable
 * @Description 阴影Drawable
 * @Date 2019/7/16
 * @History 2019/7/16 author: description:
 */
public class ShadowDrawable extends Drawable {

    private ShadowAttribute attrs;

    private Paint paint;
    private RectF drawRect;

    /**
     * 绘制不相交区域
     */
    private PorterDuffXfermode srcOut = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);

    public ShadowDrawable() {
        this(null);
    }

    public ShadowDrawable(ShadowAttribute attrs) {
        if (attrs == null) {
            throw new NullPointerException("You have to create attributes!");
        }
        this.attrs = attrs;
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);

        // 解决旋转时的锯齿问题
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(attrs.getBackgroundColor());

        // 设置阴影
        paint.setShadowLayer(attrs.getRadius(), attrs.getOffsetX(), attrs.getOffsetY(), attrs.getShadowColor());

        drawRect = new RectF();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds.right - bounds.left > 0 && bounds.bottom - bounds.top > 0) {
            drawRect.left = 0;
            drawRect.top = 0;
            drawRect.right = (bounds.right - bounds.left);
            drawRect.bottom = (bounds.bottom - bounds.top);

            for (int shadowType : attrs.getShadowTypes()) {
                switch (shadowType) {
                    case ShadowType.LEFT:
                        drawRect.left = attrs.getShadowOffset();
                        break;
                    case ShadowType.TOP:
                        drawRect.top = attrs.getShadowOffset();
                        break;
                    case ShadowType.RIGHT:
                        drawRect.right -= attrs.getShadowOffset();
                        break;
                    case ShadowType.BOTTOM:
                        drawRect.bottom -= attrs.getShadowOffset();
                        break;
                    default:
                        drawRect.left = attrs.getShadowOffset();
                        drawRect.top = attrs.getShadowOffset();
                        drawRect.right -= attrs.getShadowOffset();
                        drawRect.bottom -= attrs.getShadowOffset();
                        break;
                }
            }

            // 调用实现了Drawable.Callback的invalidateDrawable(Drawable who)方法, 最终调用View的invalidate()
            invalidateSelf();
        }
    }


    @Override
    public void draw(Canvas canvas) {
        paint.setXfermode(null);
        canvas.drawRoundRect(drawRect, attrs.getOvalX(), attrs.getOvalY(), paint);

        // 设置图像混合模式, 此处用SRC_OUT, 绘制不相交区域
        paint.setXfermode(srcOut);
        canvas.drawRoundRect(drawRect, attrs.getOvalX(), attrs.getOvalY(), paint);
    }

    public ShadowDrawable setColor(int color) {
        paint.setColor(color);
        return this;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
