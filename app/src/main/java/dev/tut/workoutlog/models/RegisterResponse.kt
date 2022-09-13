package dev.tut.workoutlog.models

import dev.tut.workoutlog.repository.UserRepository

data class RegisterResponse(
    var message:String,
    var user:UserRepository

)
