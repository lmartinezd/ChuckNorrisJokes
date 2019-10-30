package com.lmf.chucknorrisjokes.ui.main

import com.lmf.chucknorrisjokes.data.model.Category
import com.lmf.chucknorrisjokes.data.repository.JokeApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(val api: JokeApi) : MainContract.Presenter {

    private lateinit var view: MainContract.View
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun detach() {
        compositeDisposable.dispose()
    }

    override fun loadResults() {
        var subscribe = api.fetchCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Any> ->
                val listCat = ArrayList<Category>()
                for (i in list){
                    listCat.add(Category(i.toString()))
                }
                view.showResults(listCat)
            }, { error ->
            })

        compositeDisposable.add(subscribe)
    }
}