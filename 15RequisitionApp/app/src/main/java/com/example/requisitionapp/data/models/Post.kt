package com.example.requisitionapp.data.models

data class Post(
    val id:Int,
    val title:String,
    val contet:String,
    val owner_id: Int
)
data class CreatePost(
    val title: String,
    val contet: String
)