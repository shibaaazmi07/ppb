package lat1.shibaaazmi.kalkulator_uas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder> {
    private ArrayList<Hitung> hitungArrayList;
    private OnItemClickCallback onItemClickCallback;

    public AdapterHistory(ArrayList<Hitung> hitungArrayList) {
        this.hitungArrayList = hitungArrayList;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AdapterHistory.ViewHolder holder, int position) {
        Hitung hitung = hitungArrayList.get(position);

        holder.tvAngka1.setText(String.valueOf(hitung.getAngka1()));
        holder.tvAngka2.setText(String.valueOf(hitung.getAngka2()));
        holder.tvSimbol.setText(hitung.getSimbol());
        holder.tvHasil.setText(String.valueOf(hitung.getHasil()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(hitungArrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return hitungArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAngka1, tvAngka2, tvHasil, tvSimbol;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            tvAngka1 = itemView.findViewById(R.id.tv_angka1);
            tvAngka2 = itemView.findViewById(R.id.tv_angka2);
            tvHasil = itemView.findViewById(R.id.tv_hasil);
            tvSimbol = itemView.findViewById(R.id.tv_simbol);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback ;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hitung hitung);
    }
}
