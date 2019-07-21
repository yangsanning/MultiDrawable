package ysn.com.multidrawable.page;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ysn.com.drawable.shadow.ShadowAttribute;
import ysn.com.drawable.shadow.ShadowDrawableUtils;
import ysn.com.drawable.shadow.ShadowType;
import ysn.com.multidrawable.R;

/**
 * @Author yangsanning
 * @ClassName ShadowDrawableActivity
 * @Description 一句话概括作用
 * @Date 2019/7/19
 * @History 2019/7/19 author: description:
 */
public class ShadowDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_drawable);
        setTitle(R.string.text_shadow_drawable);

        ShadowAttribute attrs = new ShadowAttribute()
                // 阴影颜色（ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时加上alpha, 否则无效）
                .setShadowColor(getResources().getColor(R.color.valid_color))
                .setRadius(20)
                .setBackgroundColor(Color.TRANSPARENT)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP, ShadowType.RIGHT);
        ShadowDrawableUtils.setBackground(findViewById(R.id.shadow_drawable_activity_layout), attrs);

        attrs = new ShadowAttribute()
                .setShadowColor(0x800000FF)
                .setRadius(15)
                .setOvalX(100f)
                .setOvalY(20f)
                .setShadowType(ShadowType.NONE);
        ShadowDrawableUtils.setBackground(findViewById(R.id.shadow_drawable_activity_image_view), attrs);

        attrs = new ShadowAttribute()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.LEFT, ShadowType.RIGHT);
        ShadowDrawableUtils.setBackground(findViewById(R.id.shadow_drawable_activity_text1), attrs);

        attrs = new ShadowAttribute()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP);
        ShadowDrawableUtils.setBackground(findViewById(R.id.shadow_drawable_activity_text2), attrs);

        attrs = new ShadowAttribute()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.RIGHT, ShadowType.BOTTOM);
        ShadowDrawableUtils.setBackground(findViewById(R.id.shadow_drawable_activity_text3), attrs);
    }
}
