package com.lmf.chucknorrisjokes.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lmf.chucknorrisjokes.R
import com.lmf.chucknorrisjokes.data.model.Category
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View  {

    @Inject lateinit var presenter: MainContract.Presenter

    private lateinit var mAdapter: MainCategoryAdapter


    override fun showResults(results: List<Category>) {
        mAdapter = MainCategoryAdapter(results)

        rvCategory.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter  = mAdapter
        }
    }

    override fun showError(error: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)
        presenter.loadResults()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

}
