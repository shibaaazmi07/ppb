package lat1.shibaaazmi.menumakanan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class rv_adapter extends  RecyclerView.Adapter<rv_adapter.ViewHolder>{

    private ArrayList<String> gambarmakanan= new ArrayList<>();
    private ArrayList<String> namamakanan= new ArrayList<>();
    private ArrayList<String> hargamakanan= new ArrayList<>();
    private ArrayList<String> ketmakanan= new ArrayList<>();
    private Context context;

    public rv_adapter(ArrayList<String> gambarmakanan, ArrayList<String> namamakanan,ArrayList<String> hargamakanan,ArrayList<String> ketmakanan, Context context) {
        this.gambarmakanan = gambarmakanan;
        this.namamakanan = namamakanan;
        this.ketmakanan= ketmakanan;
        this.hargamakanan= hargamakanan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutadapter_makanan,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).asBitmap().load(gambarmakanan.get(position)).into(holder.ivfoto_makanan);
        holder.nama_makanan.setText(namamakanan.get(position));
        holder.harga_makanan.setText(hargamakanan.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //percobaan
                //Toast.makeText(context,namamakanan.get(position) , Toast.LENGTH_LONG).show();

                Intent intent= new Intent(context,DetailActivity.class);
                intent.putExtra("gambar_makanan",gambarmakanan.get(position));
                intent.putExtra("nama_makanan",namamakanan.get(position));
                intent.putExtra("harga_makanan",hargamakanan.get(position));
                intent.putExtra("keterangan",ketmakanan.get(position));

                context.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return namamakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView ivfoto_makanan;
        TextView nama_makanan;
        TextView harga_makanan;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfoto_makanan= itemView.findViewById(R.id.ivfoto_makanan);
            nama_makanan= itemView.findViewById(R.id.nama_makanan);
            harga_makanan= itemView.findViewById(R.id.harga_makanan);
            constraintLayout= itemView.findViewById(R.id.layout1);
        }
    }
}
