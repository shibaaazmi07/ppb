package lat1.shibaaazmi.menumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> gambarmakanan= new ArrayList<>();
    private ArrayList<String> namamakanan= new ArrayList<>();
    private ArrayList<String> hargamakanan= new ArrayList<>();
    private ArrayList<String> ketmakanan= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDatafrom_internet();
    }

    private void proses_rv_adapter(){
        RecyclerView recyclerView= findViewById(R.id.recycler_makanan);
        rv_adapter adapter = new rv_adapter(gambarmakanan,namamakanan,hargamakanan,ketmakanan,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDatafrom_internet(){
        gambarmakanan.add("https://img.inews.co.id/files/inews_new/2020/09/03/rawon.jpg");
        namamakanan.add("Rawon");
        hargamakanan.add("Harga: 12.000");
        ketmakanan.add("Makanan khas Indonesia di urutan berikutnya adalah rawon. Masakan berkuah asal Surabaya ini belum lama ini meraih prestasi sebagai hidangan sup terenak se-Asia. Rawon, seperti yang kita tahu adalah sup daging berkuah hitam dengan campuran bumbu khas yang menggunakan kluwek. Makanan ini terkenal di Pulau Jawa, khususnya Jawa Timur.");

        gambarmakanan.add("https://img.inews.co.id/files/inews_new/2021/03/23/mencicipi_soto_kudus.jpg");
        namamakanan.add("Soto");
        hargamakanan.add("Harga: 10.000");
        ketmakanan.add("Makanan khas Indonesia selanjutnya adalah soto. Walau banyak variasinya, soto pada umumnya adalah hidangan berkuah seperti sup yang terbuat dari kaldu daging dan sayuran. Berbagai daerah di Indonesia memiliki soto khas daerahnya masing-masing dengan komposisi yang berbeda-beda, misalnya soto Madura, soto Kediri, soto Pemalang, soto Lamongan, soto Jepara, soto Semarang, soto Kudus, soto Betawi, soto Padang, soto Bandung, sroto Sokaraja, soto Banjar, soto Medan,dll.");

        gambarmakanan.add("https://img.inews.co.id/files/inews_new/2021/01/26/Nasi_Goreng.jpg");
        namamakanan.add("Nasi Goreng");
        hargamakanan.add("Harga: 20.000");
        ketmakanan.add("Nasi goreng dikenal sebagai masakan nasional Indonesia. Sesuai namanya, nasi goreng adalah hidangan nasi yang digoreng. Umumnya, nasi digoreng bersama kecap manis, bawang merah, bawang putih, lada dan bumbu-bumbu lainnya. Kemudian disajikan bersama telur, ayam, dan kerupuk.");

        gambarmakanan.add("https://img.inews.co.id/files/inews_new/2021/04/28/pempek.jpg");
        namamakanan.add("Pempek");
        hargamakanan.add("Harga: 15.000");
        ketmakanan.add("Berasal dari Palembang, Sumatera Selatan. Makanan ini terbuat dari daging ikan yang digiling lembut, dicampur tepung kanji atau tepung sagu, serta komposisi beberapa bahan lain. Misalnya, telur, bawang putih yang dihaluskan, penyedap rasa, dan garam. Pempek biasanya disajikan dengan kuah cuka yang memiliki rasa asam, manis, dan pedas.");

        gambarmakanan.add("https://img.inews.co.id/files/inews_new/2020/08/31/Resep_Bubur_Ayam.jpg");
        namamakanan.add("Bubur Ayam");
        hargamakanan.add("Harga: 10.000");
        ketmakanan.add("Mempunyai ragam variasi tergantung dari daerah asalnya. Pada umumnya, bubur disajikan dengan irisan daging ayam dengan beberapa bumbu, seperti kecap asin dan kecap manis, merica, garam, dan kadang-kadang diberi kaldu ayam. Hidangan ini juga dilengkapi dengan taburan daun bawang cincang, bawang goreng, seledri, tongcai (sayur asin), cakwe, dan kerupuk.");

        proses_rv_adapter();

    }
}