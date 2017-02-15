package com.liuyouth.drawlist.model;

/**
 * Created by liubo on 2017/2/10.
 */

public class DrawXYStyle {
    int x;
    int y;
    int type;
    int times = 20;
    boolean show = true;

    public DrawXYStyle(int x, int y, int type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }

    public int getTimes() {
        return times;
    }


    public int next() {
        if (times < 1) {
            show = false;
        }
        return times--;
    }

    public boolean isShow() {
        return show;
    }

    public int getY() {
        next();
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
