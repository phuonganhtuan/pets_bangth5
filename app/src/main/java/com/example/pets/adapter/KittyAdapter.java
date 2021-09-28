package com.example.pets.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pets.KittyDetailFragment;
import com.example.pets.MainActivity;
import com.example.pets.R;
import com.example.pets.listener.ItemClickListener;
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

        kittyViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                    Toast.makeText(mContext, " "+mListKitty.get(position), Toast.LENGTH_SHORT).show();
                    //
//                KittyDetailFragment nextFrag= new KittyDetailFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.layout_container, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListKitty != null) {
            return mListKitty.size();
        }
        return 0;
    }

    public class KittyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgKiity;
        private TextView tvKitty;

        public TextView txt_name;
        public TextView txt_weight;
        public TextView txt_lifespan;
        public TextView txt_temperament;
        public TextView txt_description;
        public ImageView img_description;
        private ItemClickListener itemClickListener;

        public KittyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgKiity = itemView.findViewById(R.id.img_kitty);
            tvKitty = itemView.findViewById(R.id.tv_kitty);

            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}
