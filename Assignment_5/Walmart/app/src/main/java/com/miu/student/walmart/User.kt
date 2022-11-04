package com.miu.student.walmart

import java.io.Serializable

class User(var firstName: String, var lastName: String, var email: String, var password: String) :
    Serializable {
    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', email='$email', password='$password')"
    }
}