package ysn.com.multidrawable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        findViewById(R.id.main_activity_shadow_drawable).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_activity_shadow_drawable:
                startActivity(new Intent(this, ShadowDrawableActivity.class));
                break;
            default:
                break;
        }
    }
}
