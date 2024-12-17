package com.opensource.di.holder

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Ключ для сбора всех [ApiHolder]-ов в мапу
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiHolderKey(val value: KClass<out Api>)
