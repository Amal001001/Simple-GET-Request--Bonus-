package com.example.simplegetrequestbonus

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/people/?format=json") fun getNames(): Call<ArrayList<people.peopleItem>?>?
}