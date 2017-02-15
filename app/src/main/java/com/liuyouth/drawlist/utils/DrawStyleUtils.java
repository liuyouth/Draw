package com.liuyouth.drawlist.utils;


import com.liuyouth.drawlist.model.DrawXY;

/**
 * Created by liubo on 2017/2/11.
 */

public class DrawStyleUtils {
    int dox = 0;
    int doy = 0;
    int maxXY = 0;
    int direction = 0;
    int dox2 = 0;
    int doy2 = 0;
    int maxXY2 = 0;
    int direction2 = 0;
    int number = 0;
    /**
     * 炫光头像框 【方形】
     *        dox dox2
     *      --*-*--         -*---*-
     *      |     |   -- >  |     |
     *      |     |         |     |
     *      -------         -------
     */
    public DrawXY redAndBlue(){
        if (number==0){
            maxXY = 48;
            dox = (maxXY/2);
            doy = 0;
            direction = 0;
            maxXY2 = 48;
            dox2 = (maxXY/2);
            doy2 = 0;
            direction2 = 0;
            number = 1;
        }
        DrawXY drawXY = new DrawXY();
        switch (direction) {
            case 0:
                if (dox < maxXY && doy == 0) {
                    dox++;
                    dox++;
                    dox++;
                } else {
                    direction = 1;
                }
                break;
            case 1:
                if (dox == maxXY && doy < maxXY) {
                    doy++;
                    doy++;
                    doy++;
                } else {
                    direction = 2;
                }
                break;
            case 2:
                if (dox > (maxXY/2) && doy == maxXY) {
                    dox--;
                    dox--;
                    dox--;
                } else {
                    dox=(maxXY/2);
                    doy=0;
                    direction = 0;
                }
                break;
            case 3:
                if (dox == 0 && doy > 0) {
                    doy--;
                    doy--;
                    doy--;
                } else {
                    direction = 0;
                }
                break;
        }
        switch (direction2) {
            case 0:
                if (dox2 > 0 && doy2 == 0) {
                    dox2--;
                    dox2--;
                    dox2--;

                } else {
                    direction2 = 1;
                }
                break;
            case 1:
                if (dox2 == 0 && doy2 < maxXY) {
                    doy2++;
                    doy2++;
                    doy2++;
                } else {
                    direction2 = 2;
                }
                break;
            case 2:
                if (dox2 < (maxXY/2) && doy2 == maxXY) {
                    dox2++;
                    dox2++;
                    dox2++;
                } else {
                    dox2=(maxXY/2);
                    doy2=0;
                    direction2 = 0;
                }
                break;

        }
        drawXY.setX(dox);
        drawXY.setX2(dox2);
        drawXY.setY(doy);
        drawXY.setY2(doy2);
        return drawXY;
    }
    /**
     * 炫光头像框 【方形】
     *        dox dox2
     *      *------         -**-----
     *      |     |   -- >  |      |
     *      |     |         |      |
     *      ------*         -----**-
     */
    public DrawXY red2(){
        if (number==0){
            dox = 0;
            doy = 0;
            maxXY = 48;
            direction = 0;
            dox2 = 48;
            doy2 = 48;
            maxXY2 = 48;
            direction2 = 2;
            number = 1;
        }

        DrawXY drawXY = new DrawXY();
        switch (direction) {
            case 0:
                if (dox < maxXY && doy == 0) {
                    dox++;
                    dox++;
                    dox++;
                } else {
                    direction = 1;
                }
                break;
            case 1:
                if (dox == maxXY && doy < maxXY) {
                    doy++;
                    doy++;
                    doy++;
                } else {
                    direction = 2;
                }
                break;
            case 2:
                if (dox > 0 && doy == maxXY) {
                    dox--;
                    dox--;
                    dox--;
                } else {
                    direction = 3;
                }
                break;
            case 3:
                if (dox == 0 && doy > 0) {
                    doy--;
                    doy--;
                    doy--;
                } else {
                    direction = 0;
                }
                break;
        }

        switch (direction2) {
            case 0:
                if (dox2 < maxXY && doy2 == 0) {
                    dox2++;
                    dox2++;
                    dox2++;

                } else {
                    direction2 = 1;
                }
                break;
            case 1:
                if (dox2 == maxXY && doy2 < maxXY) {
                    doy2++;
                    doy2++;
                    doy2++;
                } else {
                    direction2 = 2;
                }
                break;
            case 2:
                if (dox2 > 0 && doy2 == maxXY) {
                    dox2--;
                    dox2--;
                    dox2--;
                } else {
                    direction2 = 3;
                }
                break;
            case 3:
                if (dox2 == 0 && doy2 > 0) {
                    doy2--;
                    doy2--;
                    doy2--;
                } else {
                    direction2 = 0;
                }
                break;
        }
        drawXY.setX(dox);
        drawXY.setX2(dox2);
        drawXY.setY(doy);
        drawXY.setY2(doy2);
        return drawXY;
    }
}
