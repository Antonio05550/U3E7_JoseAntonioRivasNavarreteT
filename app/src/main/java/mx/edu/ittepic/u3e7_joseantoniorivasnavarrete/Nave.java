package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;


public class Nave {

    private Lienzo lienzo;
    private Bitmap nave, bala;
    private float pxn,pyn,pxb,pyb;
    private boolean visiblen,visibleb;
    private int vidas,puntos;
    private CountDownTimer timer;

    public Nave(int nav, int bal,final String tipo, final int des, int w, int h, float px, float py, boolean v, final Lienzo l){
        lienzo=l;
        nave = Bitmap.createScaledBitmap( BitmapFactory.decodeResource( l.getResources(),nav ),w,h,true );
        bala = Bitmap.createScaledBitmap( BitmapFactory.decodeResource( l.getResources(),bal ),14,40,true );
        pxn=px;
        pyn=py;
        pxb=pxn+nave.getWidth()/2;
        if(tipo=="i")
            pyb=pyn+151;
        if (tipo=="n")
            pyb=pyn-1;
        visiblen=v;
        visibleb=v;
        timer = new CountDownTimer(1000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(tipo=="n"){
                    pyb-=des;
                    if (visiblen){
                        coalision( pxb,pyb);
                        ganar();
                    }
                    if (pyb<-40){
                        pyb=pyn-1;
                        pxb=pxn+nave.getWidth()/2;
                    }
                }
                if(tipo=="i"){
                    pyb+=des;
                    pyn+=(des/2);
                    if(visiblen)
                        coalision( pxb,pyb );
                    if (pyb>1320){
                        pyb=pyn+151;
                    }
                    if(pyn>1320){
                        pyn=-150;
                    }
                }
                l.invalidate();
            }
            @Override
            public void onFinish() {
                start();
            }
        };
    }
    public void disparar(){
        timer.start();
    }
    public void pintar(Canvas c, Paint p){
        p.setColor( Color.WHITE );
        p.setTextSize( 50);
        c.drawText( "Puntos: " + puntos,10,60,p );
        if(visiblen){
            c.drawBitmap( nave,pxn,pyn,p );
            if(visibleb)
                c.drawBitmap( bala,pxb,pyb,p );
        }
    }
    public boolean enArea(float px, float py) {
        if(!visiblen) return false;
        if (py >= pyn && py<=pyn+nave.getHeight() && px>=pxn && px<= (pxn + nave.getWidth()))
            return true;
        return false;
    }
    public void moverX(float px) {
        pxn = px - (nave.getWidth() / 2);
    }
    public void moverY(float py){
        pyn = py - (nave.getWidth() / 2);
    }
    public void setVisibleN(boolean v){
        visiblen = v;
    }
    public void setVisibleB(boolean v){
        visibleb = v;
    }
    public boolean estadoB(){
        return visibleb;
    }

    public boolean estadoN(){
        return visiblen;
    }

    public float getX() {
        return pxn;
    }

    public float getY() {
        return pyn;
    }
    public void coalision(float px,float py){
        if(Lienzo.nave.enArea( px,py)){
            Lienzo.nave.visiblen=false;
            Lienzo.gameover.visible=true;
        }
        if (Lienzo.invasor.enArea( px,py )){
            puntos=puntos+20;
            Lienzo.invasor.visiblen=false;
        }
        if (Lienzo.invasor2.enArea( px,py )){
            puntos=puntos+100;
            Lienzo.invasor2.visiblen=false;
        }
        if (Lienzo.invasor3.enArea( px,py )){
            puntos=puntos+40;
            Lienzo.invasor3.visiblen=false;
        }
        if (Lienzo.invasor4.enArea( px,py )){
            puntos=puntos+10;
            Lienzo.invasor4.visiblen=false;
            
        }
    }
    public void ganar(){
        if(!Lienzo.invasor4.visiblen&&!Lienzo.invasor3.visiblen&&!Lienzo.invasor2.visiblen&&!Lienzo.invasor.visiblen)
        Lienzo.winner.visible=true;
    }


}
