# RoundRectDrawable

## 效果预览
<img src="https://github.com/yangsanning/MultiDrawable/blob/master/images/RoundRectDrawable.jpg" height="512"/>

## 主要文件
| 名字             | 摘要           |
| ---------------- | -------------- |
|[RoundRectDrawable]   | 圆角矩形Drawable  |

### 1. 基本用法
#### 1.1 java代码设置
```java
new RoundRectDrawableBuilder()
                .setBackgroundColor(Color.WHITE)
                .setStrokeColor(getResources().getColor(R.color.app_storke))
                .setStrokeWidth(2)
                .setRadius(30, 30, 30, 30)
                .setMargin(15,15,15,15)
                .into(findViewById(R.id.border_drawable_activity_text2));
```

### 2. 方法([Method])
|name|format|description|
|:---:|:---:|:---:|
| setBackgroundColor | int | 背景颜色 |
| setStrokeColor | int | 边框颜色 |
| setStrokeWidth | int | 边框宽度 |
| setRadius | float[] | 圆角半径 |
| setMargin | float[] | 边距 |

### 3. 注意事项
1. 由于 setShadowLayer只有文字绘制阴影支持硬件加速，其它都不支持硬件加速, 故这里要关闭硬件加速
2. 由于ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时当阴影颜色时需要加上alpha, 否则无效
3. 模糊半径为0是看不到阴影效果的

[RoundRectDrawable]: https://github.com/yangsanning/MultiDrawable/blob/master/drawable/src/main/java/ysn/com/drawable/round_rect/RoundRectDrawable.java
[Method]:https://github.com/yangsanning/MultiDrawable/blob/master/drawable/src/main/java/ysn/com/drawable/round_rect/RoundRectDrawableBuilder.java
