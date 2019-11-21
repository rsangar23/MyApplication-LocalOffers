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

public class FragmentExplore extends Fragment {
    View view;
    ArrayList<Example> examples;
    RecyclerView explore_list;
    ExploreAdapter exploreAdapter;

    public FragmentExplore() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.explore_fragment, container, false);

        explore_list = view.findViewById(R.id.recycler_exp);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        explore_list.setLayoutManager(layoutManager);

//        exploreAdapter = new ExploreAdapter(models, getActivity());
//
//        explore_list.setAdapter(exploreAdapter);
        getFood();

        return view;
    }
    public void getFood(){

//        ArrayList<Model> models = new ArrayList<>(0);
//
//        models.add(new Model(R.drawable.food1, "Special Discounts on Food...!", "Click Here"));
//        models.add(new Model(R.drawable.food2, "Best Deals on Ice-Creams & Cold Drinks...!", "Click Here"));
//
//        exploreAdapter = new ExploreAdapter(models);

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ArrayList<Example>> listCall = apiInterface.getExample();

        listCall.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {

                examples = response.body();

                exploreAdapter = new ExploreAdapter(examples, getActivity());

                explore_list.setAdapter(exploreAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {

            }
        });


    }


}
