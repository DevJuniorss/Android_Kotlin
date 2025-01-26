package com.example.msgapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msgapp.data.local.database.Message
import com.example.msgapp.repository.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository): ViewModel() {

    private val _message = MutableStateFlow<List<Message>>(emptyList())
    val message: StateFlow<List<Message>> = _message.asStateFlow()

    init {
        viewModelScope.launch {
            repository.allMessage.collect{_message.value = it}
        }
    }

    fun addMessage(content: String){
        viewModelScope.launch {
            val newMessage = Message(content = content, timestamp = System.currentTimeMillis())

            _message.value += newMessage
             repository.addMessage(content)
        }
    }

}