package com.example.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.API.Example;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderViewHolder> {

    ArrayList<Example> examples;
    Context context;

    public OrderDetailsAdapter(ArrayList<Example> examples, Context context) {
        this.examples = examples;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderDetailsAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);

        return new OrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsAdapter.OrderViewHolder holder, int position) {
//        HeadingBanner headingBanner = headingBanners.get(position);
        Example example = examples.get(position);

        holder.title.setText(example.getName());
        holder.info.setText(example.getInfo());
        holder.det.setText(example.getDet());
        holder.desc.setText(example.getDesc());
        holder.vtxt.setText(example.getVtxt());
        holder.vamt.setText(example.getVamt());
        holder.vtxt1.setText(example.getVtxt1());
        holder.vamt1.setText(example.getVamt1());
        holder.vtxt2.setText(example.getVtxt2());
        holder.vamt2.setText(example.getVamt2());
        holder.vtxt3.setText(example.getVtxt3());
        holder.vamt3.setText(example.getVamt3());
        holder.addr.setText(example.getAddr());

        Glide.with(context)
                .load(example.getMap())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, info, det, desc, vtxt, vamt, vtxt1, vamt1, vtxt2, vamt2, vtxt3, vamt3, addr;

        public OrderViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.order_title);
            info = itemView.findViewById(R.id.order_info);
            det = itemView.findViewById(R.id.ord_detail);
            desc = itemView.findViewById(R.id.ord_desc);
            vtxt = itemView.findViewById(R.id.ord_vtxt);
            vamt = itemView.findViewById(R.id.ord_vamt);
            vtxt1 = itemView.findViewById(R.id.ord_vtxt1);
            vamt1 = itemView.findViewById(R.id.ord_vamt1);
            vtxt2 = itemView.findViewById(R.id.ord_vtxt2);
            vamt2 = itemView.findViewById(R.id.ord_vamt2);
            vtxt3 = itemView.findViewById(R.id.ord_vtxt3);
            vamt3 = itemView.findViewById(R.id.ord_vamt3);
            addr = itemView.findViewById(R.id.ord_vaddr);
            imageView = itemView.findViewById(R.id.addr_img);

        }
    }
}

