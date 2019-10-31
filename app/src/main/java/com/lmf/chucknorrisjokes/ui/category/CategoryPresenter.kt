package com.lmf.chucknorrisjokes.ui.category

import com.lmf.chucknorrisjokes.data.model.ResponseJoke
import com.lmf.chucknorrisjokes.data.repository.JokeApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryPresenter(val api: JokeApi) : CategoryContract.Presenter {
    private lateinit var view: CategoryContract.View
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attach(view: CategoryContract.View) {
        this.view = view
    }

    override fun detach() {
        compositeDisposable.dispose()
    }

    override fun fetchResults(category: String) {
        var subscribe = api.fetchJokexCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result: ResponseJoke ->
                view.showResults(result)
            }, { error ->
            })

        compositeDisposable.add(subscribe)
    }
}
