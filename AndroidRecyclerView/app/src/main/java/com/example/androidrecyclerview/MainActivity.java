package com.example.androidrecyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.onItemClickListener {

    MyRecyclerViewAdapter adapter;
    private List<IBaseItemType> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        RecyclerView recyclerView = binding.recyclerView;
        initView();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

//      自定义符
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.color_view));
        recyclerView.addItemDecoration(decoration);


        adapter = new MyRecyclerViewAdapter(this,mList);
        adapter.setOnItemClickListenet(this);
        recyclerView.setAdapter(adapter);
    }

    public void initView()
    {
        for(int i = 0; i < 20; i ++){
            mList.add(new DataBean(i));
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,position + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("确认删除？")
                .setNegativeButton("取消",null)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.removeData(position);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
