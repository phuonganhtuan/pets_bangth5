package com.example.pets.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pets.MainActivity;
import com.example.pets.R;
import com.example.pets.model.Kitty;
import com.example.pets.model.Photo;

import java.util.List;

public class KittyAdapter extends RecyclerView.Adapter<KittyAdapter.KittyViewHolder> {

    private Context mContext;
    private List<Kitty> mListKitty;

    public KittyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData (List<Kitty> list){
        this.mListKitty = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KittyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kitty, parent, false);
        return new KittyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KittyViewHolder kittyViewHolder, int position) {

        // set dữ liệu để hiển thị lên tại đây

        Kitty kitty = mListKitty.get(position);
        if (kitty==null){
            return;
        }

        kittyViewHolder.imgKiity.setImageResource(kitty.getResourceImage());
        kittyViewHolder.tvKitty.setText(kitty.getName());

        Glide.with(kittyViewHolder.itemView.getContext())
                .load(kitty.getImage().getUrl())
                .into(kittyViewHolder.imgKiity);
    }

    @Override
    public int getItemCount() {
        if (mListKitty != null) {
            return mListKitty.size();
        }
        return 0;
    }

    public class KittyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgKiity;
        private TextView tvKitty;

        public KittyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgKiity = itemView.findViewById(R.id.img_kitty);
            tvKitty = itemView.findViewById(R.id.tv_kitty);
        }
    }
}
