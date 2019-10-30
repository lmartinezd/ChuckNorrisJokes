package com.lmf.chucknorrisjokes.data.repository

import com.lmf.chucknorrisjokes.data.model.ResponseJoke
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface JokeApi {

    @GET("jokes/categories")
    fun fetchCategories(): Observable<List<Any>>

    @GET("jokes/random")
    fun fetchJokexCategory(@Query("category") category: String ): Observable<ResponseJoke>
}