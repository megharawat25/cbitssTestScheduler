package com.vikaskumar.examschedulercbitss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vikaskumar.examschedulercbitss.CourseActivity;
import com.vikaskumar.examschedulercbitss.Models.CategoryModel;
import com.vikaskumar.examschedulercbitss.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>
{
    private List<CategoryModel> catagoryModelList;
    private Context context;

    public CategoryAdapter(List<CategoryModel> catagoryModelList, Context context) {
        this.catagoryModelList = catagoryModelList;
        this.context = context;
    }

    @NotNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NotNull CategoryAdapter.MyViewHolder holder, int position) {
        CategoryModel cm = catagoryModelList.get(position);
        holder.title.setText(cm.getTitle());
        Glide.with(context).load(cm.getUrl()).into(holder.image);

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return catagoryModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView next;
        private CircleImageView image;
        private TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.category_img);
            next = itemView.findViewById(R.id.category_next);
            title = itemView.findViewById(R.id.text_view_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), CourseActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
