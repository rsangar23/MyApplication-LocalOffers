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

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder> {

    ArrayList<Example> examples;
    Context context;

    public ExploreAdapter(ArrayList<Example> examples, Context context) {
        this.examples = examples;
        this.context = context;
    }

    @NonNull
    @Override
    public ExploreAdapter.ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.explore_list_items, viewGroup, false);

        return new ExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreAdapter.ExploreViewHolder exploreViewHolder, int i) {
//        exploreViewHolder.imageView.setImageResource(models.get(i).getImage());
//        exploreViewHolder.title.setText(models.get(i).getTitle());
//        exploreViewHolder.info.setText(models.get(i).getInfo());
        final Example example = examples.get(i);

        Glide.with(context)
                .load(example.getImgs())
                .into(exploreViewHolder.imageView);

        exploreViewHolder.title.setText(example.getName());
        exploreViewHolder.info.setText(example.getInfo());
        exploreViewHolder.vtxt.setText(example.getVtxt());
        exploreViewHolder.vamt.setText(example.getVamt());
        exploreViewHolder.vtxt1.setText(example.getVtxt1());
        exploreViewHolder.vamt1.setText(example.getVamt1());

        exploreViewHolder.layout.setOnClickListener(new View.OnClickListener() {
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

    public static class ExploreViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, info, vtxt, vamt, vtxt1, vamt1;
        RelativeLayout layout;


        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_exp);
            title = itemView.findViewById(R.id.title_exp);
            info = itemView.findViewById(R.id.info_exp);
            vtxt = itemView.findViewById(R.id.exp_vtxt);
            vamt = itemView.findViewById(R.id.exp_vamt);
            vtxt1 = itemView.findViewById(R.id.exp_vtxt1);
            vamt1 = itemView.findViewById(R.id.exp_vamt1);
            layout = itemView.findViewById(R.id.exp_rel);
        }
    }
}
