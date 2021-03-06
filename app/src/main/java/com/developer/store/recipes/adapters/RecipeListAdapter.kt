package com.developer.store.recipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.store.recipes.R
import com.developer.store.recipes.callbacks.ClickCategory
import com.developer.store.recipes.utils.GlideApp
import kotlinx.android.synthetic.main.single_category_preview.view.*

class RecipeListAdapter(
    private val images: List<Int>,
    private val category: List<String>,
    private val clickCategory: ClickCategory
): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    class RecipeViewHolder( val card: View ): RecyclerView.ViewHolder( card )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from( parent.context ).inflate(R.layout.single_category_preview, parent, false)
        return RecipeViewHolder( view )
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: RecipeViewHolder, i: Int) {
        with ( holder ) {
            with ( card ) {
                GlideApp.with(categoryImage.context).load(images[i]).into(categoryImage)
                categoryTitle.text = category[i]
            }
        }

        holder.card.setOnClickListener {
            clickCategory.categoryClicked( category[i] )
        }
    }

}