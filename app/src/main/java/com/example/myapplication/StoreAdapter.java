package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.API.Example;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {
    ArrayList<Example> examples;
    Context context;

    public StoreAdapter(ArrayList<Example> examples, Context context) {
        this.examples = examples;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreAdapter.StoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.store_list_items, viewGroup, false);

        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.StoreViewHolder storeViewHolder, int i) {
//        storeViewHolder.imageView.setImageResource(models.get(i).getImage());
//        storeViewHolder.title.setText(models.get(i).getTitle());
//        storeViewHolder.info.setText(models.get(i).getInfo());
        final Example example = examples.get(i);

        Glide.with(context)
                .load(example.getImgs())
                .into(storeViewHolder.imageView);

        storeViewHolder.title.setText(example.getName());
        storeViewHolder.info.setText(example.getInfo());
        storeViewHolder.vtxt.setText(example.getVtxt());
        storeViewHolder.vamt.setText(example.getVamt());
        storeViewHolder.vtxt1.setText(example.getVtxt1());
        storeViewHolder.vamt1.setText(example.getVamt1());

        storeViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetails.class);
                intent.putExtra("Image_Url", example.getImgs());
                intent.putExtra("Image_Name", example.getName());
                intent.putExtra("info", example.getInfo());
                intent.putExtra("vtxt", example.getVtxt());
                intent.putExtra("vamt", example.getVamt());
                intent.putExtra("vtxt1", example.getVtxt1());
                intent.putExtra("vamt1", example.getVamt1());
                intent.putExtra("vtxt2", example.getVtxt2());
                intent.putExtra("vamt2", example.getVamt2());
                intent.putExtra("vtxt3", example.getVtxt3());
                intent.putExtra("vamt3", example.getVamt3());
                intent.putExtra("map", example.getMap());
                intent.putExtra("addr", example.getAddr());
                intent.putExtra("detail", example.getDet());
                intent.putExtra("desc", example.getDesc());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, info, vtxt, vamt, vtxt1, vamt1;
        RelativeLayout relativeLayout;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_str);
            title = itemView.findViewById(R.id.title_str);
            info = itemView.findViewById(R.id.info_str);
            vtxt = itemView.findViewById(R.id.str_vtxt);
            vamt = itemView.findViewById(R.id.str_vamt);
            vtxt1 = itemView.findViewById(R.id.str_vtxt1);
            vamt1 = itemView.findViewById(R.id.str_vamt1);
            relativeLayout = itemView.findViewById(R.id.str_rel);
        }
    }
}
