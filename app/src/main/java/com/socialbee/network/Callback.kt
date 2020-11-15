package com.socialbee.network

import kotlin.Exception

interface Callback <T> {
    fun onSuccess (result: T?)

    fun onFailed (exception: Exception)
}