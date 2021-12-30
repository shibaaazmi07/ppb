package lat1.shibaaazmi.kalkulator_uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    TextView Judul, Hasil;
    EditText Angka1, Angka2;
    RadioButton Tambah, Kali, Kurang, Bagi;
    Button btHitung, btSimpan, btHapus;
    RecyclerView rvHistory;

    private AdapterHistory adapterHistory;
    private ArrayList<Hitung> listHitung = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Judul = (TextView) findViewById(R.id.judul);
        Hasil = (TextView) findViewById(R.id.hasil);
        Angka1 = (EditText) findViewById(R.id.angka1);
        Angka2 = (EditText) findViewById(R.id.angka2);
        Tambah = (RadioButton) findViewById(R.id.tambah);
        Kurang = (RadioButton) findViewById(R.id.kurang);
        Kali = (RadioButton) findViewById(R.id.kali);
        Bagi = (RadioButton) findViewById(R.id.bagi);
        btHitung = (Button) findViewById(R.id.hitung);
        btSimpan = (Button) findViewById(R.id.simpan);
        btHapus = (Button) findViewById(R.id.hapus);
        rvHistory = findViewById(R.id.rv_history);

        loadData();
        buildRecyclerView();

        btHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = Angka1.getText().toString();
                String nilai2 = Angka2.getText().toString();

                if (nilai1.isEmpty()) {
                    Angka1.setError("Silahkan masukan angka yang diinginkan");
                    Angka1.requestFocus();
                } else if (nilai2.isEmpty()) {
                    Angka2.setError("Silahkan masukan angka yang diinginkan");
                    Angka2.requestFocus();
                } else {
                    Integer akhir = 0;
                    Integer angka1 = Integer.parseInt(nilai1);
                    Integer angka2 = Integer.parseInt(nilai2);
                    if (Tambah.isChecked()) {
                        akhir = angka1 + angka2;
                    } else if (Kurang.isChecked()) {
                        akhir = angka1 - angka2;
                    } else if (Kali.isChecked()) {
                        akhir = angka1 * angka2;
                    } else if (Bagi.isChecked()) {
                        akhir = angka1 / angka2;
                    }
                    Hasil.setText("Hasil : " + akhir);
                }
            }
        });

        btHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= Angka1.getText().toString();
                if(s.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Masukan Angka!!", Toast.LENGTH_SHORT).show();
                }else {
                    Angka1.setText("");
                }
                String v= Angka2.getText().toString();
                if(v.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Masukan Angka!!", Toast.LENGTH_SHORT).show();
                }else {
                    Angka2.setText("");
                }
                Hasil.setText(" ");
            }
        });

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nilai1 = Angka1.getText().toString();
                String nilai2 = Angka2.getText().toString();
                String simbol = "" ;
                int akhir = 0 ;

                if (nilai1.isEmpty()) {
                    Angka1.setError("Silahkan masukan angka yang diinginkan");
                    Angka1.requestFocus();
                } else if (nilai2.isEmpty()) {
                    Angka2.setError("Silahkan masukan angka yang diinginkan");
                    Angka2.requestFocus();
                } else {
                    int angka1 = Integer.parseInt(nilai1);
                    int angka2 = Integer.parseInt(nilai2);
                    if (Tambah.isChecked()) {
                        akhir = angka1 + angka2;
                        simbol = "+";
                    } else if (Kurang.isChecked()) {
                        akhir = angka1 - angka2;
                        simbol = "-";
                    } else if (Kali.isChecked()) {
                        akhir = angka1 * angka2;
                        simbol = "*";
                    } else if (Bagi.isChecked()) {
                        akhir = angka1 / angka2;
                        simbol = "/";
                    }
                    Hitung hitung = new Hitung(angka1,angka2,akhir,simbol);
                    listHitung.add(hitung);
                    saveData();
                }
            }
        });
    }

    private void buildRecyclerView() {
        adapterHistory = new AdapterHistory(listHitung);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        rvHistory.setHasFixedSize(true);
        rvHistory.setLayoutManager(manager);
        adapterHistory.setOnItemClickCallback(new AdapterHistory.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hitung hitung) {
                listHitung.remove(hitung);
                adapterHistory.notifyDataSetChanged();
                saveData();
            }
        });

        rvHistory.setAdapter(adapterHistory);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences",MODE_PRIVATE);

        Gson gson = new Gson();

        String json = sharedPreferences.getString("history", null);

        Type type = new TypeToken<ArrayList<Hitung>>() {}.getType();

        if(gson.fromJson(json,type)!= null){
            listHitung.addAll(gson.fromJson(json,type));
        }

    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        String json = gson.toJson(listHitung);

        editor.putString("history",json);

        editor.apply();
    }
}
