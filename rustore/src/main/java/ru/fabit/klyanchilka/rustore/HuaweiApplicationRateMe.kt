package ru.fabit.klyanchilka.rustore

import android.content.Context
import android.content.Intent
import android.net.Uri
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack

open class HuaweiApplicationRateMe(
    private val context: Context,
    private val huaweiAppID: String
) : ApplicationRateMe {

    override fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack) {
        val url = context.getString(R.string.klyanchilka_huawei_url_format, huaweiAppID)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}