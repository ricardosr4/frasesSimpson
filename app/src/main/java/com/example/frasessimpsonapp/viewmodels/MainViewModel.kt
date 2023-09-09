package com.example.frasessimpsonapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frasessimpsonapp.core.RetrofitClient
import com.example.frasessimpsonapp.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private var _listaPersonajes = MutableLiveData<List<Personaje>>()
    val listaPersonajes: LiveData<List<Personaje>> get()= _listaPersonajes

    fun obtenerPersonajes(){
        viewModelScope.launch(Dispatchers.IO) {
             val response = RetrofitClient.webService.obtenerPersonajes()
            withContext(Dispatchers.Main){
                _listaPersonajes.value = response.body()
            }
        }
    }
    fun obtenerPersonaje(persoanje:String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPersonaje(persoanje )
            withContext(Dispatchers.Main){
                _listaPersonajes.value = response.body()
            }
        }

    }
}