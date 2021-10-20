package lat1.shibaaazmi.kdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pindah_persegi(View view) {
        Intent intent = new Intent(MainActivity.this, Persegi.class);
        startActivity(intent);

    }

    public void pindah_segitiga(View view) {
        Intent intent= new Intent(MainActivity.this,Segitiga.class);
        startActivity(intent);
    }

    public void pindah_lingkaran(View view) {
        Intent intent= new Intent(MainActivity.this,Lingkaran.class);
        startActivity(intent);
    }
}