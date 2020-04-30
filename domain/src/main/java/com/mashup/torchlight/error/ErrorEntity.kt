package com.mashup.torchlight.error

open class ErrorEntity(throwable: Throwable?) : Throwable(throwable) {

    class NetworkException(throwable: Throwable? = null) : ErrorEntity(throwable)

    class Unknown(throwable: Throwable? = null) : ErrorEntity(throwable)
}