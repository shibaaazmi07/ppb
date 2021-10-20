package lat1.shibaaazmi.kdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity {
    Button btnhasilS;
    EditText etalas1, etalas2, etalas3, ettinggi;
    TextView tvluasS, tvkelS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        btnhasilS= (Button) findViewById(R.id.btn_segitiga);
        etalas1= (EditText) findViewById(R.id.alas1);
        etalas2= (EditText) findViewById(R.id.alas2);
        etalas3= (EditText) findViewById(R.id.alas3);
        ettinggi= (EditText) findViewById(R.id.tinggi);
        tvluasS= (TextView) findViewById(R.id.luasS1);
        tvkelS=(TextView) findViewById(R.id.kelilingS1);

        btnhasilS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1=etalas1.getText().toString();
                String nilai2= etalas2.getText().toString();
                String nilai3= etalas3.getText().toString();
                String nilai_tinggi= ettinggi.getText().toString();

                if(nilai1.isEmpty()){
                    etalas1.setError("Silahkan masukan data");
                    etalas1.requestFocus();
                }else if(nilai_tinggi.isEmpty()){
                    ettinggi.setError("Silahkan masukan data");
                    ettinggi.requestFocus();
                }else {
                    Integer angka1 = Integer.parseInt(nilai1);
                    Integer angka2 = Integer.parseInt(nilai2);
                    Integer angka3 = Integer.parseInt(nilai3);
                    Integer angka_tinggi = Integer.parseInt(nilai_tinggi);

                    Integer luas = (angka1 * angka_tinggi) / 2;
                    Integer keliling = (angka1 + angka2 + angka3);
                    String newluasp = String.valueOf(luas);
                    String newkelilingp = String.valueOf(keliling);
                    tvluasS.setText(newluasp);
                    tvkelS.setText(newkelilingp);
                }
            }
        });

    }
}