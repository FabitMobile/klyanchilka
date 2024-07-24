package ru.fabit.klyanchilka.core

interface ApplicationRateMe {
    fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack)
}

interface RateMeInfoCallBack {
    fun onFailure(throwable: Throwable)
    fun onSuccess()
}