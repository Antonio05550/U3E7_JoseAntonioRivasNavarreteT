package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    private static MainActivity puntero;
    static Image gameover;
    static Nave nave;
    static Nave invasor;
    static Nave invasor2;
    static Nave invasor3;
    static Nave invasor4;

    public Lienzo(Context context){
        super(context);
        puntero = (MainActivity) context;
        nave = new Nave( R.drawable.baseshipa,R.drawable.disparo,"n",8,150,150,
                285,900,true,this);
        nave.disparar();
        invasor = new Nave( R.drawable.ufo,R.drawable.disparo1,"i",7,150,150,
                10,0,true,this);
        invasor.disparar();
        invasor2 = new Nave( R.drawable.ufo,R.drawable.disparo1,"i",10,150,150,
                190,0,true,this);
        invasor2.disparar();
        invasor3 = new Nave( R.drawable.ufo,R.drawable.disparo1,"i",8,150,150,
                370,0,true,this);
        invasor3.disparar();
        invasor4 = new Nave( R.drawable.ufo,R.drawable.disparo1,"i",6,150,150,
                550,0,true,this);
        invasor4.disparar();
        gameover = new Image(R.drawable.gameover,720,1280,0,0,false,this);
    }

    public static void finish() {
        puntero.finalizar();
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw( c );
        Paint p = new Paint();
        nave.pintar( c,p );
        invasor.pintar( c,p );
        invasor2.pintar( c,p );
        invasor3.pintar( c,p );
        invasor4.pintar( c,p );
        gameover.pintar( c,p );
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
                
        }
        invalidate();
        return true;
    }
}
