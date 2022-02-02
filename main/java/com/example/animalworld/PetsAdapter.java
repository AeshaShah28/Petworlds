package com.example.animalworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.MyViewHolder>implements Filterable
{
    private List<PetResponse> mArrayList;
    // ArrayList<PaginationResponse> rowBeanList;
    ArrayList<PetResponse> petResponses;
    Context context;
    CustomFilter filter;


    public PetsAdapter(ArrayList<PetResponse> petResponses, Context context) {
        this.petResponses = petResponses;
        this.context = context;
        this.mArrayList = petResponses;
    }
   /* List<StaticResponseForTesting>  myListData;
    public PetsAdapter(List<StaticResponseForTesting>  myListData)
    {
        this.myListData = myListData;
    }
*/

    @Override
    public PetsAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PetsAdapter.MyViewHolder holder, int position)
    {
       /* holder.t_petname.setText(myListData.get(position).getPetName());
        holder.t_petage.setText(myListData.get(position).getPetAge());
       */
        holder.t_petname.setText(petResponses.get(position).getName());
        holder.t_petage.setText(petResponses.get(position).getBornAt());

    }

    @Override
    public int getItemCount() {
        return petResponses.size();
    }

    @Override
    public Filter getFilter() {
        if (filter==null) {
            filter=new CustomFilter((ArrayList<PetResponse>) mArrayList,this);

        }
        return filter;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView t_petname, t_petage;
        public MyViewHolder( View itemView)
        {
            super(itemView);
            this.t_petname = (TextView) itemView.findViewById(R.id.tv_petname);
            this.t_petage = (TextView) itemView.findViewById(R.id.tv_petage);



        }
    }
}
