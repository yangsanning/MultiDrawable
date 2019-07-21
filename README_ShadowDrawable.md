# ShadowDrawable

## 效果预览

| [ShadowDrawable]                      |
| ------------------------------- |
| [<img src="images/image1.png" height="512"/>][ShadowDrawable]   | |


## 基本用法
#### 1.java代码设置
```java
ShadowAttribute attrs = new ShadowAttribute()
                .setShadowColor(getResources().getColor(R.color.valid_color))
                .setRadius(20)
                .setBackgroundColor(Color.TRANSPARENT)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP, ShadowType.RIGHT);
ShadowDrawableUtils.setBackground(view, attrs);
```


## 注意事项
1. 由于 setShadowLayer只有文字绘制阴影支持硬件加速，其它都不支持硬件加速, 故这里要关闭硬件加速
2. 由于ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时当阴影颜色时需要加上alpha, 否则无效
3. 模糊半径为0是看不到阴影效果的



[ShadowDrawable]:https://github.com/yangsanning/MultiDrawable/blob/master/README_ShadowDrawable.md
