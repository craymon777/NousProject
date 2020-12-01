package com.example.nous;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class HomeCardAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<HomeCardModel> modelArrayList;

    //constructor
    public HomeCardAdapter(Context context, ArrayList<HomeCardModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    //return number of element in modelArrayList.
    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate the layout card_items_skills
        View view = LayoutInflater.from(context).inflate(R.layout.card_items_skills,container,false);


        //initiate the item from layout card_items_skills
        ImageView ivSkills = view.findViewById(R.id.ivSkills);
        //ImageView ivDialog = view.findViewById(R.id.ivDialog);
        TextView tvDialog = view.findViewById(R.id.tvDialog);
        TextView tvSkills = view.findViewById(R.id.tvSkills);
        TextView tvDescription = view.findViewById(R.id.tvDescription);

        //get data from modelArrayList
        HomeCardModel cardModel = modelArrayList.get(position);
        String dialog = cardModel.getDialog();
        String skill = cardModel.getSkill();
        String description = cardModel.getDescription();
        int imageSkill = cardModel.getImageSkill();

        //set data
        ivSkills.setImageResource(imageSkill);
        tvDialog.setText(dialog);
        tvDescription.setText(description);
        tvSkills.setText(skill);


        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,AnimalSkillsActivity.class);
                context.startActivity(intent);
            }
        });


        //add view to container
        container.addView(view, position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
