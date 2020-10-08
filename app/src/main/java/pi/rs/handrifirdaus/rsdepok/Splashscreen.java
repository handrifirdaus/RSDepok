package pi.rs.handrifirdaus.rsdepok;

/**
 * Created by HANDRI FIRDAUS on 6/14/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread splashThread =  new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                }
                catch (InterruptedException ie ) {}
                finally {
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        splashThread.start();
    }
}
