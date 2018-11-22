package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    private static Main2Activity puntero;
    static Image winner,gameover,fondo;
    static Nave nave;
    static Nave invasor;
    static Nave invasor2;
    static Nave invasor3;
    static Nave invasor4;

    public Lienzo(Context context){
        super(context);
        puntero = (Main2Activity) context;
        fondo = new Image(R.drawable.fondo,720,1280,0,0,true,null,this);
        nave = new Nave( R.drawable.baseshipa,R.drawable.disparo,"n",8,150,150,
                285,900,true,this);
        nave.disparar();
        invasor = new Nave( R.drawable.saucer2b,R.drawable.disparo2,"i",7,150,150,
                10,0,true,this);
        invasor.disparar();
        invasor2 = new Nave( R.drawable.ufo,R.drawable.disparo1,"i",10,150,150,
                190,0,true,this);
        invasor2.disparar();
        invasor3 = new Nave( R.drawable.saucer3b,R.drawable.disparo3,"i",8,150,150,
                370,0,true,this);
        invasor3.disparar();
        invasor4 = new Nave( R.drawable.saucer1b,R.drawable.disparo4,"i",6,150,150,
                550,0,true,this);
        invasor4.disparar();
        gameover = new Image(R.drawable.gameover,720,1280,0,0,false,null,this);
        winner = new Image(R.drawable.winner,720,1280,0,0,false,null,this);

    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw( c );
        Paint p = new Paint();
        puntero.musicaf();
        fondo.pintar( c,p );
        nave.pintar( c,p );
        invasor.pintar( c,p );
        invasor2.pintar( c,p );
        invasor3.pintar( c,p );
        invasor4.pintar( c,p );
        gameover.pintar( c,p );
        winner.pintar( c,p );

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float px=e.getX();
        float py=e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                if (nave.enArea( px,py )){
                    nave.moverX(px);
                }
                if(gameover.enArea( px,py ))
                    gameover.visible( true );

        }
        invalidate();
        return true;
    }
}
