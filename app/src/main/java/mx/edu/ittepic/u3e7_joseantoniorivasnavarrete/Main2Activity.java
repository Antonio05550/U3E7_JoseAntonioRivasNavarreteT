package mx.edu.ittepic.u3e7_joseantoniorivasnavarrete;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
        audio = MediaPlayer.create(this, R.raw.musicaf);
        audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                audio.start();
            }
        });
    }
    public void musicaf(){
        audio.start();
    }
    @Override
    public void onBackPressed() {
        audio.stop();
        super.onBackPressed();
    }

}