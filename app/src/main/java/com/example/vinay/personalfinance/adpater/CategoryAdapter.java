package com.example.vinay.personalfinance.adpater;

/**
 * Created by Vinay on 25-01-2016.
 */


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinay.personalfinance.entity.Category;
import com.example.vinay.personalfinance.R;
import com.example.vinay.personalfinance.ViewAllTransaction;
import com.example.vinay.personalfinance.database.DatabaseHelper;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categoryList;
    private DatabaseHelper dbHelper;
    private Cursor cursor;
    private Context context;
    private String id;

    public CategoryAdapter(Context context, DatabaseHelper dbHelper , String id){
        this.dbHelper = dbHelper;
        this.context  = context;
        this.id = id;
        this.categoryList = dbHelper.getAllCategories(id);

    }

    public void updateList(){
        this.categoryList = dbHelper.getAllCategories(id);
        notifyDataSetChanged();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.account_category_layout, viewGroup, false);
        final String name = categoryList.get(i).getCategoryName();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllTransaction.class);
                intent.putExtra("CAT_NAME",name);
                context.startActivity(intent);
            }
        });
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder catViewHolder, int i) {

        Category cat = categoryList.get(i);
        catViewHolder.catName.setText(cat.getCategoryName());
        catViewHolder.expense.setText(cat.getSpentAmt() + "");
        catViewHolder.expenseText.setText("Amount Spent : ");


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    //Class for the view holder pattern
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        protected TextView catName;
        protected TextView expense;
        protected TextView expenseText;
        protected View divider;


        public CategoryViewHolder(View itemView) {
            super(itemView);
            catName = (TextView) itemView.findViewById(R.id.catNameTextView);
            expense = (TextView) itemView.findViewById(R.id.catAmountTextView);
            expenseText = (TextView) itemView.findViewById(R.id.catExpenseTextView);


        }
    }
}


