package com.lmf.chucknorrisjokes.ui.category

import com.lmf.chucknorrisjokes.data.model.ResponseJoke
import com.lmf.chucknorrisjokes.ui.base.BasePresenter
import com.lmf.chucknorrisjokes.ui.base.BaseView

class CategoryContract {
    interface View : BaseView {
        fun showResults(results: ResponseJoke)
    }

    interface Presenter : BasePresenter<View> {
        fun fetchResults(cateogry: String)
    }
}