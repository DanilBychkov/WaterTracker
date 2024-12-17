package com.opensource.di

import com.opensource.di.holder.Api
import com.opensource.di.holder.ApiContainer

/**
 * Объект для работы с DI
 */
object DI {

    private lateinit var _apiContainer: ApiContainer

    /**
     * Инициализировать DI, используя контейнер фич [apiContainer]
     */
    fun initialize(apiContainer: ApiContainer) {
        _apiContainer = apiContainer
    }

    /**
     * Получить фичу по ключу [classKey]
     */
    fun <T : Api> getApi(classKey: Class<T>): T {
        return _apiContainer.getApiHolder(classKey).getApi()
    }

}

/**
 * Функция для получения API
 */
inline fun <reified A : Api> api(): A = DI.getApi(A::class.java)

/**
 * Функция для получения внутреннего API
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified A : Api, InternalApi : Api> internalApi(): InternalApi = api<A>() as InternalApi