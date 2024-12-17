package com.opensource.di.holder

/**
 * Контейнер для хранения всех реализаций [Api] поставляемых модулями
 */
interface ApiContainer {

    /**
     * Получить [ApiHolder] модуля
     */
    fun <T : Api> getApiHolder(modelClass: Class<T>): ApiHolder<T>
}