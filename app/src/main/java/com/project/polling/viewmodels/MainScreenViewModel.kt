package com.project.polling.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.polling.repository.PollingRepository
import com.project.polling.utils.Token
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class MainScreenViewModel(
    private val repository: PollingRepository
) : ViewModel(), KoinComponent {

    fun getData(): Flow<List<Token>> {
        return repository.getTokenFlow()
    }
}