package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( new Lienzo( this ) );
    }
    public void finalizar(){
        finish();
    }
}
