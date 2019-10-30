package com.lmf.chucknorrisjokes.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lmf.chucknorrisjokes.R
import com.lmf.chucknorrisjokes.data.model.Category
import com.lmf.chucknorrisjokes.ui.category.categoryIntent
import kotlinx.android.synthetic.main.cardview_item.view.*

class MainCategoryAdapter(
    private val lsCategory: List<Category>
) :
    RecyclerView.Adapter<MainCategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item, parent, false)

        return CategoryHolder(itemView)
    }

    override fun getItemCount() = lsCategory.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindView(lsCategory[position])
    }

    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(cat: Category) {
            itemView.tvCategory.text = cat.category
            itemView.setOnClickListener { v: View ->
                v.context.startActivity(v.context.categoryIntent(cat.category))
            }
        }
    }
}