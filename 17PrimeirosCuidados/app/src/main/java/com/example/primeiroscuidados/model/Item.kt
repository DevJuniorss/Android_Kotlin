package com.example.primeiroscuidados.model

import com.google.firebase.Timestamp


data class Item (
    val id: String = generated().toString(),
    val title: String,
    val description: String
) {
    companion object {
        private var currentId = 0

        fun generated(): Int {
            return currentId++
        }

    }

}