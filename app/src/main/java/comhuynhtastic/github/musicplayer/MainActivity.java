package comhuynhtastic.github.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private Button btnPlay;
    private Button btnPause;
    private Button btnSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.miraisekai);

        btnPlay = (Button) findViewById(R.id.button_play);
        btnPause = (Button) findViewById(R.id.button_pause);
        btnSeek = (Button) findViewById(R.id.button_seek_five);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        btnSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
            }
        });


    }


}
