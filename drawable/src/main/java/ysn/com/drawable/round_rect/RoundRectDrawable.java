package ysn.com.drawable.round_rect;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * @Author yangsanning
 * @ClassName RoundRectDrawable
 * @Description 圆角矩形 Drawable
 * @Date 2020/9/7
 */
public class RoundRectDrawable extends Drawable {

    private RoundRectDrawableBuilder builder;

    private Paint paint;
    private Path path;
    private RectF backgroundDrawRect;
    private RectF strokeDrawRect;

    /**
     * 在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
     */
    private PorterDuffXfermode srcOut = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);

    public RoundRectDrawable() {
        this(null);
    }

    public RoundRectDrawable(RoundRectDrawableBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("You have to create builder!");
        }
        this.builder = builder;
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);

        // 解决旋转时的锯齿问题
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);

        path = new Path();

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

            backgroundDrawRect.left = strokeDrawRect.left + builder.getStrokeWidth();
            backgroundDrawRect.top = strokeDrawRect.top + builder.getStrokeWidth();
            backgroundDrawRect.right = strokeDrawRect.right - builder.getStrokeWidth();
            backgroundDrawRect.bottom = strokeDrawRect.bottom - builder.getStrokeWidth();

            // 调用实现了Drawable.Callback的invalidateDrawable(Drawable who)方法, 最终调用View的invalidate()
            invalidateSelf();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setXfermode(null);
        // 没有边框时不绘制边框
        if (builder.getStrokeWidth() != 0) {
            path.addRoundRect(strokeDrawRect, builder.getRadiusArray(), Path.Direction.CCW);
            paint.setColor(builder.getStrokeColor());
            canvas.drawPath(path, paint);
            path.reset();

            // 设置图像混合模式, 在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
            paint.setXfermode(srcOut);
        }
        paint.setColor(builder.getBackgroundColor());
        path.addRoundRect(backgroundDrawRect, builder.getRadiusArray(), Path.Direction.CCW);
        canvas.drawPath(path, paint);
        path.reset();
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