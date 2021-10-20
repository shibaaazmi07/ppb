package lat1.shibaaazmi.kdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Persegi extends AppCompatActivity {
    Button btnhasilP;
    EditText s1, s2;
    TextView tvluas ,tvkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        btnhasilP= (Button) findViewById(R.id.btn_persegi);
        s1 = (EditText) findViewById(R.id.panjang);
        s2= (EditText) findViewById(R.id.lebar);
        tvluas= (TextView) findViewById(R.id.luas1);
        tvkel= (TextView) findViewById(R.id.keliling1);

        btnhasilP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = s1.getText().toString();
                String nilai2 = s2.getText().toString();

                if(nilai1.isEmpty()){
                    s1.setError("Silahkan masukan data");
                    s1.requestFocus();
                }else if(nilai2.isEmpty()){
                    s2.setError("Silahkan masukan data");
                    s2.requestFocus();
                }else{
                    Integer panjang =Integer.parseInt(nilai1);
                    Integer lebar =Integer.parseInt(nilai2);

                    Integer luas= panjang * lebar;
                    Integer keliling = 4 * panjang;
                    String newluasp = String.valueOf(luas);
                    String newkelilingp =String.valueOf(keliling);
                    tvluas.setText(newluasp);
                    tvkel.setText(newkelilingp);
                }
            }
        });
    }
}