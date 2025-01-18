package com.example.requisitionapp.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.requisitionapp.data.models.CreatePost
import com.example.requisitionapp.data.models.Post
import com.example.requisitionapp.data.models.RetrofitInstace
import com.example.requisitionapp.data.models.User
import com.example.requisitionapp.data.models.UserCreateRequest
import kotlinx.coroutines.launch

class PostViewModel:ViewModel() {
    var post: List<Post> by mutableStateOf(listOf())
    var user: List<User> by mutableStateOf(listOf())
    private val userId = 1

    fun fetchUsers(){
        viewModelScope.launch {
            try {
                user = RetrofitInstace.api.getUsers()
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
    }
    fun fetchPost(){
        viewModelScope.launch {
            try {
                post = RetrofitInstace.api.getPosts(userId)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    fun createUser(name: String, email: String, onSucess:() ->Unit, onError:() ->Unit){
        viewModelScope.launch {
            try {
                val newUser=UserCreateRequest(name, email)
                RetrofitInstace.api.createUser(newUser)
                fetchUsers()
                onSucess()
            }catch (e: Exception){
                e.printStackTrace()
                onError()
            }
        }
    }
    fun createPost(title: String, context: String, onSucess: () -> Unit, onError: () -> Unit){
        viewModelScope.launch {
            try {
                val newPost= CreatePost(title,context)
                RetrofitInstace.api.createPost(userId, newPost)
                fetchPost()
                onSucess()
            }catch (e:Exception){
                e.printStackTrace()
                onError()
            }
        }
    }

    fun deletePost(postId: Int){
        viewModelScope.launch {
            try {
                RetrofitInstace.api.deletePost(postId)
                fetchPost()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    fun updatePost(postId: Int, title: String, content: String){
        viewModelScope.launch {
            try {
                val updatePost = CreatePost(title,content)
                RetrofitInstace.api.updatePost(postId,updatePost)
                fetchPost()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}