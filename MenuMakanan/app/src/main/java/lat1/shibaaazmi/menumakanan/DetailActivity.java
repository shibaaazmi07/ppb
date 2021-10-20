package lat1.shibaaazmi.menumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView gambarmakanan_detail;
    TextView tv_namamakanan_detail,tv_hargamakanan_detail, tv_ketmakanan_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        gambarmakanan_detail= findViewById(R.id.gambarmakanan_detail);
        tv_namamakanan_detail= findViewById(R.id.tv_namamakanan_detail);
        tv_hargamakanan_detail= findViewById(R.id.tv_hargamakanan_detail);
        tv_ketmakanan_detail= findViewById(R.id.tv_ketmakanan_detail);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("gambar_makanan")&& getIntent().hasExtra("nama_makanan")&& getIntent().hasExtra("harga_makanan")&& getIntent().hasExtra("keterangan")){

            String gambarmakanan= getIntent().getStringExtra("gambar_makanan");
            String namamakanan= getIntent().getStringExtra("nama_makanan");
            String hargamakanan= getIntent().getStringExtra("harga_makanan");
            String ketmakanan= getIntent().getStringExtra("keterangan");

            setactivity(gambarmakanan, namamakanan,hargamakanan, ketmakanan);
        }
    }

    private void setactivity(String gambarmakanan, String namamakanan, String hargamakanan, String ketmakanan){
        Glide.with(this).asBitmap().load(gambarmakanan).into(gambarmakanan_detail);
        tv_namamakanan_detail.setText(namamakanan);
        tv_hargamakanan_detail.setText(hargamakanan);
        tv_ketmakanan_detail.setText(ketmakanan);

    }
}