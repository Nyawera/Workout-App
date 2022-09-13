package dev.tut.workoutlog.repository

import dev.tut.workoutlog.api.ApiClient
import dev.tut.workoutlog.api.ApiInterface
import dev.tut.workoutlog.models.LoginRequest
import dev.tut.workoutlog.models.RegisterRequest
import dev.tut.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface.ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest) = withContext(Dispatchers.IO) {
        val response = apiClient.login(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> =
        withContext(Dispatchers.IO) {
            val response = apiClient.registerUser(registerRequest)
            return@withContext response
        }
}