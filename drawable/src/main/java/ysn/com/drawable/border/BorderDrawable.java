package ysn.com.drawable.border;

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
 * @ClassName BorderDrawable
 * @Description 边框 Drawable
 * @Date 2020/9/7
 */
public class BorderDrawable extends Drawable {

    private BorderDrawableBuilder attrs;

    private Paint paint;
    private RectF backgroundDrawRect;
    private RectF strokeDrawRect;

    /**
     * 在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
     */
    private PorterDuffXfermode srcOut = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);

    public BorderDrawable() {
        this(null);
    }

    public BorderDrawable(BorderDrawableBuilder attrs) {
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

        backgroundDrawRect = new RectF();
        strokeDrawRect = new RectF();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds.right - bounds.left > 0 && bounds.bottom - bounds.top > 0) {
            strokeDrawRect.left = 0;
            strokeDrawRect.top = 0;
            strokeDrawRect.right = (bounds.right - bounds.left);
            strokeDrawRect.bottom = (bounds.bottom - bounds.top);

            backgroundDrawRect.left = strokeDrawRect.left + attrs.getStrokeWidth();
            backgroundDrawRect.top = strokeDrawRect.top + attrs.getStrokeWidth();
            backgroundDrawRect.right = strokeDrawRect.right - attrs.getStrokeWidth();
            backgroundDrawRect.bottom = strokeDrawRect.bottom - attrs.getStrokeWidth();

            // 调用实现了Drawable.Callback的invalidateDrawable(Drawable who)方法, 最终调用View的invalidate()
            invalidateSelf();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setXfermode(null);
        paint.setColor(attrs.getStrokeColor());
        canvas.drawRoundRect(strokeDrawRect, attrs.getOvalX(), attrs.getOvalY(), paint);

        paint.setColor(attrs.getBackgroundColor());
        // 设置图像混合模式, 在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
        paint.setXfermode(srcOut);
        canvas.drawRoundRect(backgroundDrawRect, attrs.getOvalX(), attrs.getOvalY(), paint);
    }

    public BorderDrawable setColor(int color) {
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