package com.example.desafiocincoandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.desafiocincoandroid.modelo.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {


    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList =new ArrayList<>();
    private Context mContext;
    private OnItemClickOnListener listener;

    public AnimalAdapter(List<Animal> animalList, Context mContext, OnItemClickOnListener listener) {
        this.animalList = animalList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_animal,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal animal =animalList.get(position);
        holder.textView.setText(animal.getName());

        Glide.with(holder.imageView.getContext())
                .load(animal.getUrl())      //obtiene url
                .centerCrop()               //centra la imagen
                .into(holder.imageView);    //donde se muestra la imagen
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageViewListItem);
            textView=itemView.findViewById(R.id.textViewListItem);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            listener.onClick(this, getNameByPosition(getAdapterPosition())
                    ,getURLByPosition(getAdapterPosition()));

        }

        private String getNameByPosition(int position){

            if (position !=RecyclerView.NO_POSITION){

                return animalList.get(position).getName();

            }else{

                return "NO HAY NOMBRE";

            }
        }

        private String getURLByPosition(int position){

            if (position !=RecyclerView.NO_POSITION){

                return animalList.get(position).getUrl();

            }else{

                return "NO HAY URL";

            }
        }

    }//class view holder

    public interface OnItemClickOnListener{

        public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url);

    }

}//class animal adapter