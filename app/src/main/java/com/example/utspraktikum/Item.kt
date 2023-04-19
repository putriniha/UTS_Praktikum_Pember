package com.example.utspraktikum

class Item(private val imgResId: Int,
           private val title: String,
           private val likes: String,
           private val comments: Int) {
    fun getImgResId(): Int {
        return imgResId
    }

    fun getTitle(): String {
        return title
    }

    fun getLikes(): String {
        return likes
    }

    fun getComments(): Int {
        return comments
    }
}
