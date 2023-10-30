package com.example.mvvm

class PersonRepository {

    //validação do login e senha, verificando se está vazio
    fun login(email: String, password: String): Boolean{
        return (email != "" && password != "")
    }
}