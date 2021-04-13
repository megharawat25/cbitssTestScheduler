package com.vikaskumar.examschedulercbitss.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.vikaskumar.examschedulercbitss.ScheduleActivity;

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
<<<<<<< HEAD
        Glide.with(context).load(cm.getUrl())
                .placeholder(R.drawable.cbitss)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
=======
        Glide.with(context).load(cm.getUrl()).into(holder.image);

<<<<<<< HEAD
        holder.next.setOnClickListener(new View.OnClickListener() {
=======
        holder.image.setOnClickListener(new View.OnClickListener() {
>>>>>>> 745906c0773128f130f1372a4c270b4f0ad5a0c5
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
            @Override
            public void onClick(View v) {
                Intent setIntent = new Intent(context, CourseActivity.class);
                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                setIntent.putExtra("title", cm.getTitle());
                context.startActivity(setIntent);
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

<<<<<<< HEAD
            image = itemView.findViewById(R.id.category_img_course);
=======
            image = itemView.findViewById(R.id.category_img);
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
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
