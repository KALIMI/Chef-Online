package com.developer.store.recipes.viewmodels

import androidx.lifecycle.ViewModel
import com.developer.store.recipes.services.RecipeListService

class MainViewModel( service: RecipeListService ): ViewModel() {

    val data = service.getCategoryInfo()
}