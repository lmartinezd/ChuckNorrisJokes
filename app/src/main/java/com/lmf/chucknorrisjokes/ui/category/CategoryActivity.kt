package com.lmf.chucknorrisjokes.ui.category

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lmf.chucknorrisjokes.R
import com.lmf.chucknorrisjokes.data.model.ResponseJoke
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_category.*
import javax.inject.Inject

fun Context.categoryIntent(category: String): Intent {
    return Intent(this, CategoryActivity::class.java).apply {
        putExtra(INTENT_CATEGORY, category)
    }
}

private const val INTENT_CATEGORY = "category"

class CategoryActivity : AppCompatActivity(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val category = intent.getStringExtra(INTENT_CATEGORY)

        presenter.attach(this)

        tvTitleCategory.text = category
        presenter.fetchResults(category)
    }

    override fun showResults(results: ResponseJoke) {
        Picasso.get().load(results.iconUrl).into(ivIcon)
        tvJoke.text = results.value
        btLink.text = results.url
        btLink.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        btLink.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(results.url)
            startActivity(openURL)
        }
    }

    override fun showError(error: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
