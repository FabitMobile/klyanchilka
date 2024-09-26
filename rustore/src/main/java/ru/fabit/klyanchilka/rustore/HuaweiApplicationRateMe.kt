package ru.fabit.klyanchilka.rustore

import android.content.Context
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack

open class HuaweiApplicationRateMe(
    private val context: Context,
    private val huaweiAppID: String
) : ApplicationRateMe {

    override fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack) {
        openStore()
        rateMeInfoCallBack.onSuccess()
    }

    override fun openStore() {
        openStore(context, R.string.klyanchilka_huawei_url_format, huaweiAppID)
    }
}