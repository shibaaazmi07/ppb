package lat1.shibaaazmi.biodata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnalamat, btnno_telp, btnemail;
    TextView tvnim, tvhobi, tvdeskripsi, tvbiodata, tvnama, tvnama2, tvnim2, tvkomik, tvmahasiswi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnalamat = (Button) findViewById(R.id.button2);
        btnno_telp = (Button) findViewById(R.id.button);
        btnemail =(Button) findViewById(R.id.button3);

        tvnim =(TextView) findViewById(R.id.textnim);
        tvhobi = (TextView)findViewById(R.id.texthobi);
        tvdeskripsi =(TextView) findViewById(R.id.textdes);
        tvbiodata =(TextView) findViewById(R.id.textbio);
        tvnama = (TextView)findViewById(R.id.Nama);
        tvnama2 = (TextView)findViewById(R.id.nama1);
        tvnim2 = (TextView)findViewById(R.id.nim);
        tvkomik =(TextView) findViewById(R.id.hobi);
        tvmahasiswi =(TextView) findViewById(R.id.desc);


        btnno_telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 085523525097"));
                startActivity(intent);
            }
        });

        btnalamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent, chooser;
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://goo.gl/maps/dy4yyrPDQJtFyZ7P8"));
                chooser = Intent.createChooser(intent, "Launch Map");
                startActivity(chooser);
            }
        });

        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rtc8222");
                String[] to = {"111202012662@mhs.dinus.ac.id"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
                startActivity(emailIntent);
            }
        });
    }
}








