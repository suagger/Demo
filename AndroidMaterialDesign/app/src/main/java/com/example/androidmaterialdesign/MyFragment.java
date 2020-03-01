package com.example.androidmaterialdesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Fruit> fruitList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        mRecyclerView = view.findViewById(R.id.recycler);
        initFruits();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        FruitAdapter adapter = new FruitAdapter(fruitList);
        mRecyclerView.setAdapter(adapter);
        return view;
    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.ic_launcher_background);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.ic_launcher_background);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.ic_launcher_background);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.ic_launcher_background);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.ic_launcher_background);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.ic_launcher_background);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.ic_launcher_background);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.ic_launcher_background);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.ic_launcher_background);
            fruitList.add(mango);

        }
    }
}
