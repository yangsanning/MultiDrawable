package ysn.com.drawable.shadow;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author yangsanning
 * @ClassName ShadowType
 * @Description 阴影显示的位置
 * @Date 2019/7/16
 * @History 2019/7/16 author: description:
 */
@IntDef({ShadowType.NONE, ShadowType.LEFT, ShadowType.TOP, ShadowType.RIGHT, ShadowType.BOTTOM})
@Retention(RetentionPolicy.SOURCE)
public @interface ShadowType {

    int NONE = 0;

    int LEFT = 1;

    int TOP = 2;

    int RIGHT = 3;

    int BOTTOM = 4;
}