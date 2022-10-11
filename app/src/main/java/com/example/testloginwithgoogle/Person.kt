package com.example.testloginwithgoogle

import java.io.Serializable

class Person(nombre: String, email: String): Serializable {

    var nombre: String
    var email: String

    init {
        this.nombre = nombre!!
        this.email = email!!
    }
}