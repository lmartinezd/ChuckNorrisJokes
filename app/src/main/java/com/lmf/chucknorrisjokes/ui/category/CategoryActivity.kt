package com.lmf.chucknorrisjokes.ui.category

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lmf.chucknorrisjokes.R

fun Context.categoryIntent(category: String): Intent {
    return Intent(this, CategoryActivity::class.java).apply {
        putExtra(INTENT_CATEGORY, category)
    }
}

private const val INTENT_CATEGORY = "category"

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val category = intent.getStringExtra(INTENT_CATEGORY)
    }
}
