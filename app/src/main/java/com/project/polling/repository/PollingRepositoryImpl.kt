package com.project.polling.repository

import androidx.compose.runtime.rememberCoroutineScope
import com.project.polling.api.PollingApi
import com.project.polling.utils.Token
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class PollingRepositoryImpl(
    private val api: PollingApi
) : PollingRepository, KoinComponent {

    var tokensList: MutableList<Token> = mutableListOf()

    override fun getTokenFlow(): Flow<List<Token>> {
        return flow {
            while (true) {
                val token = getData()
                if (tokensList.size >= 50) {
                    tokensList.removeLast()
                }
                tokensList.add(index = 0, element = token)

                emit(tokensList.toList())
                kotlinx.coroutines.delay(1000L)
            }
        }
    }

    private suspend fun getData(): Token {
        return api.getData()
    }
}