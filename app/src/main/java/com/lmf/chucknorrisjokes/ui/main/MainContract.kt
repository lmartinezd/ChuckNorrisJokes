package com.lmf.chucknorrisjokes.ui.main

import com.lmf.chucknorrisjokes.data.model.Category
import com.lmf.chucknorrisjokes.ui.base.BasePresenter
import com.lmf.chucknorrisjokes.ui.base.BaseView

class MainContract {
    interface View : BaseView {
        fun showResults(results: List<Category>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadResults()
    }
}