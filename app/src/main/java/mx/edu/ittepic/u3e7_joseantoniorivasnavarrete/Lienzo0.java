package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo0 extends View {
    Image logo, puntos, play,fondo;
    MainActivity puntero;
    public Lienzo0(Context context){
        super(context);
        puntero = (MainActivity) context;
        fondo = new Image(R.drawable.fondo,720,1280,0,0,true,this,null);
        logo = new Image(R.drawable.logo,700,188,10,75,true,this, null);
        puntos = new Image(R.drawable.puntos, 250,269,235,300,true,this,null);
        play = new Image(R.drawable.play, 300,116,210,600,true,this, null);
    }
    @Override
    public void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();
        fondo.pintar( c,p );
        puntero.musicaf();
        c.drawColor(R.drawable.fondo);
        logo.pintar(c,p);
        puntos.pintar(c,p);
        play.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e) {
        float px=e.getX();
        float py=e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (play.enArea(px,py))
                    puntero.ventana2();
                break;
        }
        return true;
    }
}
