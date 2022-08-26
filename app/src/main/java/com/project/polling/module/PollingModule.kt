package com.project.polling.module

import com.project.polling.api.PollingApi
import com.project.polling.api.PollingApiImpl
import com.project.polling.repository.PollingRepository
import com.project.polling.repository.PollingRepositoryImpl
import com.project.polling.viewmodels.MainScreenViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.HttpHeaders.ContentType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pollingModule = module {

    single {
        HttpClient(Android) {
            install(Logging)

            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
                acceptContentTypes = acceptContentTypes + io.ktor.http.ContentType.Any
            }
        }
    }

    single<PollingApi> { PollingApiImpl(client = get()) }

    single<PollingRepository> { PollingRepositoryImpl(api = get()) }

    viewModel { MainScreenViewModel(repository = get()) }
}