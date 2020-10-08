package pi.rs.handrifirdaus.rsdepok;

/**
 * Created by HANDRI FIRDAUS on 6/14/2017.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    private Button MAP, DaftarRS, About, Exit;
    MediaPlayer music;

    @Override
    protected void onPause() {
        super.onPause();
        music.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.musik);
        music.setLooping(true);
        music.setVolume(1, 1);
        music.start();

        Exit=(Button)findViewById(R.id.Exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Apakah kamu yakin ingin keluar?")
                        .setCancelable(false)//tidak bisa tekan tombol back
                        //jika pilih yess
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                onDestroy();
                                System.exit(0);
                            }
                        })
                        //jika pilih no
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).show();
            }
        });
        About=(Button)findViewById(R.id.About);
        About.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
        MAP=(Button)findViewById(R.id.MAP);
        MAP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        DaftarRS=(Button)findViewById(R.id.DaftarRS);
        DaftarRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListView.class);
                startActivity(i);
            }
        });}
        }
