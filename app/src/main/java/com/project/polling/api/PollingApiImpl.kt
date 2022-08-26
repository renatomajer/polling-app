package com.project.polling.api

import android.util.Log
import com.project.polling.utils.Token
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

class PollingApiImpl(
    private val client: HttpClient
) : PollingApi, KoinComponent {

    override suspend fun getData(): Token {
        return client.get<Token>("https://api.coindesk.com/v1/bpi/currentprice.json")
    }
}