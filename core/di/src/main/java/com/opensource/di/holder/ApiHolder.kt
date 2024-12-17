package com.opensource.di.holder

/**
 * Холдер для хранения [Api], поставляемого модулем
 */
abstract class ApiHolder<out T : Api> {

    private var api: T? = null

    protected abstract fun buildApi(): T

    /**
     * Получить Api модуля
     */
    fun getApi(): T {
        if (api == null) {
            synchronized(this) {
                if (api == null) {
                    api = buildApi()
                }
            }
        }
        return api ?: throw RuntimeException("Could not create Feature")
    }
}