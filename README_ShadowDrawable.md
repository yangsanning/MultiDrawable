# ShadowDrawable

## 效果预览
<img src="images/image1.png" height="512"/>

## 主要文件
| 名字             | 摘要           |
| ---------------- | -------------- |
|ShadowDrawable   | 阴影Drawable  |

### 1. 基本用法
#### 1.1 java代码设置
```java
ShadowAttribute attrs = new ShadowAttribute()
                .setShadowColor(getResources().getColor(R.color.valid_color))
                .setRadius(20)
                .setBackgroundColor(Color.TRANSPARENT)
                .setShadowType(ShadowType.LEFT, ShadowType.TOP, ShadowType.RIGHT);
ShadowDrawableUtils.setBackground(view, attrs);
```

### 2. 方法([Method])
|name|format|description|
|:---:|:---:|:---:|
| setShadowColor | int | 阴影颜色 |
| setBackgroundColor | int | 背景颜色 |
| setRadius | int | 阴影半径(模糊半径) |
| setOffsetX | int | 阴影x偏移 |
| setOffsetY | int | 阴影y偏移 |
| setOvalX | float | 椭圆X轴半径 |
| setOvalY |float | 椭圆y轴半径 |
| setShadowTypes |@ShadowType int[] | 阴影显示的位置 |

### 3. 注意事项
1. 由于 setShadowLayer只有文字绘制阴影支持硬件加速，其它都不支持硬件加速, 故这里要关闭硬件加速
2. 由于ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时当阴影颜色时需要加上alpha, 否则无效
3. 模糊半径为0是看不到阴影效果的


[Method]:https://github.com/yangsanning/MultiDrawable/blob/master/drawable/src/main/java/ysn/com/drawable/shadow/ShadowAttribute.java
