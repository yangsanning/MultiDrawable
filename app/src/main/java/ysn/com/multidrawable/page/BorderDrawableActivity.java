package ysn.com.multidrawable.page;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ysn.com.drawable.border.BorderDrawableBuilder;
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
        setTitle(R.string.text_border_drawable);

        new BorderDrawableBuilder()
                .setBackgroundColor(Color.WHITE)
                .setStrokeColor(getResources().getColor(R.color.app_storke))
                .setOvalX(8)
                .setOvalY(8)
                .setStrokeWidth(2)
                .into(findViewById(R.id.border_drawable_activity_text1));
    }
}
