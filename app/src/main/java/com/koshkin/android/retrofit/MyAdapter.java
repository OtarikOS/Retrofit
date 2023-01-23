package com.koshkin.android.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetroMessage> dataList;

    public MyAdapter(List<RetroMessage> dataList){

        this.dataList = dataList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {


        public final View myView;

        TextView textId;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            textId = myView.findViewById(R.id.tvId);

        }
    }



    @Override

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override

    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textId.setText(dataList.get(position).getId().toString()+"\n"+dataList.get(position).getTime().toString()+"\n"+dataList.get(position).getText());
     //   holder.textId.setText(dataList.get(position).getTime().toString());
      //  holder.textId.setText(dataList.get(position).getText());


    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
