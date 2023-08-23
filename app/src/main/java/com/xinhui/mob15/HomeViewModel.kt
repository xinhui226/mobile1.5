package com.xinhui.mob15

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xinhui.mob15.data.model.Person
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    val fName:MutableStateFlow<String> = MutableStateFlow("")
    val lName:MutableStateFlow<String> = MutableStateFlow("")
    val finish1:MutableStateFlow<String> = MutableStateFlow("Finish initial value")
    val finish2:MutableSharedFlow<String> = MutableSharedFlow()

    init {
//        viewModelScope.launch {
//            delay(3000)
//            finish2.emit("Hello there")
//        }
    }

    fun onCreate(){
        viewModelScope.launch {
            finish2.emit("Hello there")
        }
    }

    fun submit(){
        val person = Person(fName.value,lName.value)

        finish1.value=person.toString()
        viewModelScope.launch {
            finish2.emit(person.toString())
        }
    }
}