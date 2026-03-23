package com.practicum.films.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.practicum.films.data.NetworkClient
import com.practicum.films.data.dto.FilmRequest
import com.practicum.films.data.dto.Response

class RetrofitNetworkClient(
    private val context: Context,
    private val filmService: FilmApi): NetworkClient {
    private val token = "k_zcuw1ytf"

    override fun doRequest(dto: Any): Response {
        if (isConnected() == false) {
            return Response().apply { resultCode = -1 }
        }

        if (dto !is FilmRequest) {
            return Response().apply { resultCode = 400 }
        }
        return try {
            val resp = filmService.getFilmsDescription(token, dto.expression).execute()

            val body = resp.body()
            Log.d("13d", resp.body().toString())
            body?.apply { resultCode = resp.code() } ?: Response().apply { resultCode = resp.code() }
        } catch (e: Exception) {
            Response().apply {
                resultCode = -2
            }
        }
    }

    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if(capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }
        return false
    }
}