package com.project.polling.repository

import com.project.polling.utils.Token
import kotlinx.coroutines.flow.Flow

interface PollingRepository {

    fun getTokenFlow(): Flow<List<Token>>
}