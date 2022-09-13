package dev.tut.workoutlog.api

import dev.tut.workoutlog.models.LoginRequest
import dev.tut.workoutlog.models.LoginResponse
import dev.tut.workoutlog.models.RegisterRequest
import dev.tut.workoutlog.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    interface ApiInterface {
        @POST("/register")
        fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
        @POST("/Login")
        suspend fun login (@Body LoginRequest: LoginRequest): Response<LoginResponse>
    }
}