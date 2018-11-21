package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Image {
    private Bitmap imagen;
    private float x,y;
    boolean visible;

    public Image(int recurso, int w, int h, float px, float py, boolean v, Lienzo l){
        imagen = Bitmap.createScaledBitmap( BitmapFactory.decodeResource( l.getResources(),recurso),w,h,true );
        x=px;
        y=py;
        visible=v;
    }
    public void pintar(Canvas c, Paint p){
        if(visible)
            c.drawBitmap( imagen,x,y,p );
    }
    public boolean enArea(float px, float py) {
        if(!visible) return false;
        if (py >= y && py<=y+imagen.getHeight() && px>=x && px<= (x + imagen.getWidth()))
            return true;
        return false;
    }
    public void moverX(float px) {
        x = px - (imagen.getWidth() / 2);
    }
    public void moverY(float py){
        y = py - (imagen.getWidth() / 2);
    }
    public void visible(boolean v){
        visible = v;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
