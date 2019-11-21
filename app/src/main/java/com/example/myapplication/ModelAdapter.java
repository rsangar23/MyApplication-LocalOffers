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
import com.example.myapplication.API.FinalResult;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

//    ArrayList<Example> examples;
//    ArrayList<Lst> lsts;
    FinalResult results;
    Context context;

//    public ModelAdapter(ArrayList<Example> examples, Context context) {
//        this.examples = examples;
//        this.context = context;
//    }
//    public ModelAdapter(ArrayList<Lst> lsts, Context context) {
//        this.lsts = lsts;
//        this.context = context;
//    }

    public ModelAdapter(FinalResult results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public ModelAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_items, viewGroup, false);

        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ModelViewHolder modelViewHolder, final int i) {
//       final Lst lst = lsts.get(i);
//        final FinalResult finalResult = results.getLst().get(i);
//        final Example example = examples.get(i);

        Glide.with(context)
                .load(results.getLst().get(i).getImgs())
                .into(modelViewHolder.imageView);

        modelViewHolder.title.setText(results.getLst().get(i).getName());
        modelViewHolder.info.setText(results.getLst().get(i).getInfo());
        modelViewHolder.vtxt.setText(results.getLst().get(i).getVtxt());
        modelViewHolder.vamt.setText(results.getLst().get(i).getVamt());
        modelViewHolder.vtxt1.setText(results.getLst().get(i).getVtxt1());
        modelViewHolder.vamt1.setText(results.getLst().get(i).getVamt1());

        modelViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetails.class);
                intent.putExtra("Image_Url", results.getLst().get(i).getImgs());
                intent.putExtra("Image_Name", results.getLst().get(i).getName());
                intent.putExtra("info", results.getLst().get(i).getInfo());
                intent.putExtra("vtxt", results.getLst().get(i).getVtxt());
                intent.putExtra("vamt", results.getLst().get(i).getVamt());
                intent.putExtra("vtxt1", results.getLst().get(i).getVtxt1());
                intent.putExtra("vamt1", results.getLst().get(i).getVamt1());
                intent.putExtra("vtxt2", results.getLst().get(i).getVtxt2());
                intent.putExtra("vamt2", results.getLst().get(i).getVamt2());
                intent.putExtra("vtxt3", results.getLst().get(i).getVtxt3());
                intent.putExtra("vamt3", results.getLst().get(i).getVamt3());
                intent.putExtra("map", results.getLst().get(i).getMap());
                intent.putExtra("addr", results.getLst().get(i).getAddr());
                intent.putExtra("detail", results.getLst().get(i).getDet());
                intent.putExtra("desc", results.getLst().get(i).getDesc());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(results.getLst() != null){
            return results.getLst().size();
        }else{
            return 0;
        }
    }

    public static class ModelViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, info, vtxt, vamt, vtxt1, vamt1;
        RelativeLayout relativeLayout;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.offer_title);
            info = itemView.findViewById(R.id.offer_info);
            vtxt = itemView.findViewById(R.id.offer_vtxt);
            vamt = itemView.findViewById(R.id.offer_vamt);
            vtxt1 = itemView.findViewById(R.id.offer_vtxt1);
            vamt1 = itemView.findViewById(R.id.offer_vamt1);
            relativeLayout = itemView.findViewById(R.id.myfrag_rl);
        }
    }
}
