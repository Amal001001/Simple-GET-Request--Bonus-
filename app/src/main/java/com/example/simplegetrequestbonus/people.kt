package com.example.simplegetrequestbonus

import com.google.gson.annotations.SerializedName

class people : ArrayList<people.peopleItem>(){

    data class peopleItem (
        @SerializedName("name")
        var name: String? = null
    )
}