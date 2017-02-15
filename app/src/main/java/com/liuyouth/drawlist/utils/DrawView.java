package com.liuyouth.drawlist.utils;

/**
 * Created by liubo on 2017/2/9.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.liuyouth.drawlist.model.DrawXYStyle;

import java.util.ArrayList;

public class DrawView extends View {
    private ArrayList<DrawXYStyle> dList = new ArrayList<>();//储存闪光点位置的list
    public DrawView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint p = new Paint();

        if (dList.size() > 0) {
            for (int i = 0; i < dList.size(); i++) {
                DrawXYStyle ds = dList.get(i);
                //判断是否该显示
                if (ds.isShow()) {
                    if (ds.getTimes() > 0) {
                        //画光点
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),ds.getType());
                        //根据光点存在的出现的次数来决定透明度
                        p.setAlpha(60+ds.getTimes());
                        canvas.drawBitmap(bitmap, ds.getX(),ds.getY(), p);
                    }
                }
            }

        }


 /*                 int size = ds.getTimes()/2;
                    int result = ds.getY() + size;
  SvgPathParser svgPathParser = new SvgPathParser();
                        Path path =null;
                        try {
                            path = svgPathParser.parsePath("M356.01,291.351 C348.293,305.73,336.684,315.079,324.454,316.351 L142.777,342.708\n" +
                                    "C72.7569,354.356,45.1222,441.661,95.0606,493.614 L225.696,625.135\n" +
                                    "C236.211,636.075,241.198,650.832,238.622,664.195 L206.994,850.645\n" +
                                    "C195.786,923.502,268.591,978.685,330.308,943.668 L491.866,856.362\n" +
                                    "C504.961,848.806,518.265,848.806,530.843,856.073 L693.295,943.876\n" +
                                    "C754.64,978.685,827.444,923.502,816.29,850.993 L784.69,664.683\n" +
                                    "C783.344,650.115,788.06,634.986,797.776,624.883 L927.922,493.871\n" +
                                    "C978.103,441.662,950.473,354.361,880.869,342.777 L699.589,316.459\n" +
                                    "C685.166,313.419,672.666,304.075,667.529,292.049 L587.302,120.699\n" +
                                    "C556.607,53.9423,466.616,53.9423,435.854,120.844 L356.01,291.351 L356.01,291.351\n" +
                                    "L356.01,291.351 Z M356.01,291.351");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        canvas.drawPath(path,p);*/

                       /* p.setColor(Color.argb(255-(31-ds.getTimes())*2,255,103,103));
                        Path path = new Path();
                        path.moveTo(ds.getX()-size, ds.getY());// 此点为多边形的起点
                        path.lineTo(ds.getX()+size, ds.getY()-size);
                        path.lineTo(ds.getX()+size, ds.getY());
                        path.lineTo(ds.getX()-size, ds.getY()+size);
                        path.close(); // 使这些点构成封闭的多边形
                        canvas.drawPath(path, p);*/

                        /*p.setColor(Color.argb(255-(31-ds.getTimes())*2,255,103,103));
                        Path path1 = new Path();
                        path.moveTo(ds.getX()-5+5, ds.getY()+15);// 此点为多边形的起点
                        path.lineTo(ds.getX()+5+5, ds.getY()-3+15);
                        path.lineTo(ds.getX()+10+5, ds.getY()+15);
                        path.lineTo(ds.getX()+2+5, ds.getY()+3+15);
                        path.close(); // 使这些点构成封闭的多边形
                        canvas.drawPath(path1, p);*/

                        /*
                        canvas.drawCircle(ds.getX()+size, result, size, p);// 大圆*/


/*

        canvas.drawText("画线及弧线：", 10, 60, p);
        p.setColor(Color.GREEN);// 设置绿色
        canvas.drawLine(60, 40, 100, 40, p);// 画线
        canvas.drawLine(110, 40, 190, 80, p);// 斜线
        //画笑脸弧线
        p.setStyle(Paint.Style.STROKE);//设置空心
        RectF oval1=new RectF(150,20,180,40);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(190, 20, 220, 40);
        canvas.drawArc(oval1, 180, 180, false, p);//小弧形
        oval1.set(160, 30, 210, 60);
        canvas.drawArc(oval1, 0, 180, false, p);//小弧形

        canvas.drawText("画矩形：", 10, 80, p);
        p.setColor(Color.GRAY);// 设置灰色
        p.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(60, 60, 80, 80, p);// 正方形
        canvas.drawRect(60, 90, 160, 100, p);// 长方形

        canvas.drawText("画扇形和椭圆:", 10, 120, p);
        */
/* 设置渐变色 这个正方形的颜色是改变的 *//*

        Shader mShader = new LinearGradient(0, 0, 100, 100,
                new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                        Color.LTGRAY }, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。
        p.setShader(mShader);
        // p.setColor(Color.BLUE);
        RectF oval2 = new RectF(60, 100, 200, 240);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 200, 130, true, p);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线
        //画椭圆，把oval改一下
        oval2.set(210,100,250,130);
        canvas.drawOval(oval2, p);

        canvas.drawText("画三角形：", 10, 200, p);
        // 绘制这个三角形,你可以绘制任意多边形
        Path path = new Path();
        path.moveTo(80, 200);// 此点为多边形的起点
        path.lineTo(120, 250);
        path.lineTo(80, 250);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p);

        // 你可以绘制很多任意多边形，比如下面画六连形
        p.reset();//重置
        p.setColor(Color.LTGRAY);
        p.setStyle(Paint.Style.STROKE);//设置空心
        Path path1=new Path();
        path1.moveTo(180, 200);
        path1.lineTo(200, 200);
        path1.lineTo(210, 210);
        path1.lineTo(200, 220);
        path1.lineTo(180, 220);
        path1.lineTo(170, 210);
        path1.close();//封闭
        canvas.drawPath(path1, p);
        */
/*
         * Path类封装复合(多轮廓几何图形的路径
         * 由直线段*、二次曲线,和三次方曲线，也可画以油画。drawPath(路径、油漆),要么已填充的或抚摸
         * (基于油漆的风格),或者可以用于剪断或画画的文本在路径。
         *//*


        //画圆角矩形
        p.setStyle(Paint.Style.FILL);//充满
        p.setColor(Color.LTGRAY);
        p.setAntiAlias(true);// 设置画笔的锯齿效果
        canvas.drawText("画圆角矩形:", 10, 260, p);
        RectF oval3 = new RectF(80, 260, 200, 300);// 设置个新的长方形
        canvas.drawRoundRect(oval3, 20, 15, p);//第二个参数是x半径，第三个参数是y半径

        //画贝塞尔曲线
        canvas.drawText("画贝塞尔曲线:", 10, 310, p);
        p.reset();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.GREEN);
        Path path2=new Path();
        path2.moveTo(100, 320);//设置Path的起点
        path2.quadTo(150, 310, 170, 400); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, p);//画出贝塞尔曲线

        //画点
        p.setStyle(Paint.Style.FILL);
        canvas.drawText("画点：", 10, 390, p);
        canvas.drawPoint(60, 390, p);//画一个点
        canvas.drawPoints(new float[]{60,400,65,400,70,400}, p);//画多个点
*/

        //画图片，就是贴图
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        // canvas.drawBitmap(bitmap, 250,360, p);
    }

    public void setDrawStyle(ArrayList<DrawXYStyle> list) {
        dList = list;
    }
}