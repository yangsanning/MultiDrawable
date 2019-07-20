# ShadowDrawable

#### 使用说明
1. 由于 setShadowLayer只有文字绘制阴影支持硬件加速，其它都不支持硬件加速, 故这里要关闭硬件加速
2. 由于ALPHA_8只记录颜色的alpha值, 故使用xml颜色值时当阴影颜色时需要加上alpha, 否则无效
3. 模糊半径为0是看不到阴影效果的