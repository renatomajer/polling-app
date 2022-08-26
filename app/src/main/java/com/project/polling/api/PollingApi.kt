package com.project.polling.api

import com.project.polling.utils.Token

interface PollingApi {
    suspend fun getData(): Token
}