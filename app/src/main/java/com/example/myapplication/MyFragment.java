package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.API.FinalResult;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {
    View view;
    FinalResult results;
    RecyclerView model_list;
    ModelAdapter modelAdapter;
//    String title;


    public MyFragment(FinalResult finalResult) {
        this.results = finalResult;
//        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.list_contents, container, false);

        model_list = view.findViewById(R.id.recycler_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        model_list.setLayoutManager(layoutManager);

        model_list.setHasFixedSize(true);

        model_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy < 0){
                    Main2Activity.btmTabLayout.setVisibility(View.GONE);
                    Main2Activity.tabView.setVisibility(View.GONE);
                }else if(dy > 0){
                    Main2Activity.btmTabLayout.setVisibility(View.VISIBLE);
                    Main2Activity.tabView.setVisibility(View.VISIBLE);
                }
            }
        });
//        modelAdapter = new ModelAdapter(images, getActivity());
//
//        model_list.setAdapter(modelAdapter);
        getFile();

        return view;
    }

//        public void getList(){
//
//        ArrayList<Model> models = new ArrayList<>(0);
//
//        models.add(new Model(R.drawable.sploffers, "Special Offer", "Discount Upto 50% off..."));
//        models.add(new Model(R.drawable.sploffers1, "Best Deals", "Know More Click Here..."));
//
//        modelAdapter = new ModelAdapter(models);
//
//        model_list.setAdapter(modelAdapter);
//    }

    public void getFile() {
//
//        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        Call<ArrayList<FinalResult>> listCall = apiInterface.getList();
//
//        listCall.enqueue(new Callback<ArrayList<FinalResult>>() {
//            @Override
//            public void onResponse(Call<ArrayList<FinalResult>> call, Response<ArrayList<FinalResult>> response) {
////                ArrayList<Image> images = new ArrayList<>(0);
////
////                Image img = response.body();
////
////                images.add(img);
//                results = response.body();
//
//                modelAdapter = new ModelAdapter(results, getActivity());
//
//                model_list.setAdapter(modelAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<FinalResult>> call, Throwable t) {
//
//            }
//        });

        modelAdapter = new ModelAdapter(results, getActivity());

        model_list.setAdapter(modelAdapter);

//        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        Call<ArrayList<Example>> resultCall = apiInterface.getExample();
//
//        resultCall.enqueue(new Callback<ArrayList<Example>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {
//
//                    ArrayList<Example> examples = response.body();
//
//                    modelAdapter = new ModelAdapter(examples, getActivity());
//
//                    model_list.setAdapter(modelAdapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {
//
//            }
//        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
        }

    }
}


