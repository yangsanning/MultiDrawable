package ysn.com.multidrawable.page;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ysn.com.drawable.round_rect.RoundRectDrawableBuilder;
import ysn.com.multidrawable.R;

/**
 * @Author yangsanning
 * @ClassName BorderDrawableActivity
 * @Description 边框 Drawable
 * @Date 2020/9/7
 */
public class BorderDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_border_drawable);
        setTitle(R.string.text_round_rect_drawable);

        new RoundRectDrawableBuilder()
                .setBackgroundColor(Color.WHITE)
                .setStrokeColor(getResources().getColor(R.color.app_storke))
                .setStrokeWidth(2)
                .setRadius(30, 30, 30, 30)
                .into(findViewById(R.id.border_drawable_activity_text1));

        new RoundRectDrawableBuilder()
                .setBackgroundColor(Color.WHITE)
                .setRadius(30, 30, 30, 30)
                .into(findViewById(R.id.border_drawable_activity_text2));

        new RoundRectDrawableBuilder()
                .setBackgroundColor(Color.WHITE)
                .setStrokeColor(getResources().getColor(R.color.valid_color))
                .setStrokeWidth(2)
                .setRadius(30, 60, 90, 120)
                .into(findViewById(R.id.border_drawable_activity_text3));
    }
}
