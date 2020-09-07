package ysn.com.multidrawable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import ysn.com.multidrawable.page.BorderDrawableActivity;
import ysn.com.multidrawable.page.ShadowDrawableActivity;

/**
 * @Author yangsanning
 * @ClassName ShadowAttribute
 * @Description 一句话概括作用
 * @Date 2019/7/16
 * @History 2019/7/16 author: description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout rootLayout = findViewById(R.id.main_activity_root);
        int childCount = rootLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            rootLayout.getChildAt(i).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_shadow_drawable:
                startActivity(ShadowDrawableActivity.class);
                break;
            case R.id.main_activity_border_drawable:
                startActivity(BorderDrawableActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
