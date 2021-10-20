package lat1.shibaaazmi.kdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lingkaran extends AppCompatActivity {
    Button hasillingkaran;
    EditText etD;
    TextView tvluas, tvkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        hasillingkaran= (Button) findViewById(R.id.btn_lingkaran);
        etD= (EditText) findViewById(R.id.diameter);
        tvluas=(TextView) findViewById(R.id.luasL1);
        tvkel=(TextView) findViewById(R.id.kelilingL1);

        hasillingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = etD.getText().toString();


                Integer diameter =Integer.parseInt(nilai1);


                    double luas1= (3.14 * diameter* diameter)/4;
                    String newluas1 = String.valueOf(luas1);
                    tvluas.setText(newluas1);
                    double keliling1 =(3.14*diameter) ;
                    String newkeliling1 =String.valueOf(keliling1);
                    tvkel.setText(newkeliling1);

            }
        });


    }
}