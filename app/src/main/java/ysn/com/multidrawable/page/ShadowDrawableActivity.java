package ysn.com.multidrawable.page;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ysn.com.drawable.shadow.ShadowDrawableBuilder;
import ysn.com.drawable.shadow.ShadowType;
import ysn.com.multidrawable.R;

/**
 * @Author yangsanning
 * @ClassName ShadowDrawableActivity
 * @Description 阴影 Drawable
 * @Date 2019/7/19
 * @History 2019/7/19 author: description:
 */
public class ShadowDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_drawable);
        setTitle(R.string.text_shadow_drawable);

        new ShadowDrawableBuilder()
                // 阴影颜色（ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时加上alpha, 否则无效）
                .setShadowColor(getResources().getColor(R.color.valid_color))
                .setRadius(20)
                .setBackgroundColor(Color.TRANSPARENT)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP, ShadowType.RIGHT)
                .into(findViewById(R.id.shadow_drawable_activity_layout));

        new ShadowDrawableBuilder()
                .setShadowColor(0x800000FF)
                .setRadius(15)
                .setOvalX(100f)
                .setOvalY(20f)
                .setShadowType(ShadowType.NONE)
                .into(findViewById(R.id.shadow_drawable_activity_image_view));

        new ShadowDrawableBuilder()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.LEFT, ShadowType.RIGHT)
                .into(findViewById(R.id.shadow_drawable_activity_text1));

        new ShadowDrawableBuilder()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP)
                .into(findViewById(R.id.shadow_drawable_activity_text2));

        new ShadowDrawableBuilder()
                .setShadowColor(0x800000FF)
                .setRadius(10)
                .setShadowType(ShadowType.RIGHT, ShadowType.BOTTOM)
                .into(findViewById(R.id.shadow_drawable_activity_text3));
    }
}
