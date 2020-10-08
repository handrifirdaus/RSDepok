package pi.rs.handrifirdaus.rsdepok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DaftarRSActivity extends AppCompatActivity {

    private TextView textNama, textAlamat, textTelepon, textJam, textBpjs;
    private ImageView imageGambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infors);

        textNama = (TextView) findViewById(R.id.tvNama);
        textAlamat = (TextView) findViewById(R.id.tvAlamat);
        textTelepon = (TextView) findViewById(R.id.tvTelepon);
        textJam = (TextView) findViewById(R.id.tvJam);
        textBpjs = (TextView) findViewById(R.id.tvBpjs);
        imageGambar = (ImageView) findViewById(R.id.ivGambar);


        Intent intent = getIntent();
        String nama = intent.getStringExtra("dataNama");
        String alamat = intent.getStringExtra("dataAlamat");
        String telepon = intent.getStringExtra("dataTelepon");
        String jam = intent.getStringExtra("dataJam");
        String bpjs = intent.getStringExtra("dataBpjs");
        int gambar = intent.getIntExtra("dataGambar", 0);

        textNama.setText(nama);
        textAlamat.setText(alamat);
        textTelepon.setText(telepon);
        textJam.setText(jam);
        textBpjs.setText(bpjs);
        imageGambar.setImageResource(gambar);

    }
}

