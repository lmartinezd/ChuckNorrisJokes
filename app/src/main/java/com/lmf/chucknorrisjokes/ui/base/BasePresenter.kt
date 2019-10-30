package com.lmf.chucknorrisjokes.ui.base

interface BasePresenter<in T : BaseView> {
    fun attach(view: T)
    fun detach()
}