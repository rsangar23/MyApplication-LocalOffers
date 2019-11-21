package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.API.APIClient;
import com.example.myapplication.API.APIInterface;
import com.example.myapplication.API.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentStore extends Fragment {
    View view;
    ArrayList<Example> examples;
    RecyclerView store_list;
    StoreAdapter storeAdapter;

    public FragmentStore() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.store_fragment, container, false);

        store_list = view.findViewById(R.id.recycler_str);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        store_list.setLayoutManager(layoutManager);

//        storeAdapter = new StoreAdapter(models, getActivity());
//
//        store_list.setAdapter(storeAdapter);
        getStore();
        return view;
    }

    public void getStore(){

//        ArrayList<Model> models = new ArrayList<>(0);
//
//        models.add(new Model(R.drawable.clothes1, "Special Discounts on New Arrivals...!", "Click Here"));
//        models.add(new Model(R.drawable.clothes2, "Special Discounts on Children's Arrivals...!", "Click Here"));
//
//        storeAdapter = new StoreAdapter(models);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<Example>> listCall = apiInterface.getExample();

        listCall.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {
                examples = response.body();

                storeAdapter = new StoreAdapter(examples, getActivity());

                store_list.setAdapter(storeAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {

            }
        });


    }


}

