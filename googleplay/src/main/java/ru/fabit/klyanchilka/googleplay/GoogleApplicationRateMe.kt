package ru.fabit.klyanchilka.googleplay

import android.app.Activity
import android.content.Context
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status.*
import com.google.android.play.core.review.ReviewManagerFactory
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack

open class GoogleApplicationRateMe(private val context: Context) : ApplicationRateMe {

    private val manager = ReviewManagerFactory.create(context)

    override fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack) {
        val timeStart = System.currentTimeMillis()
        manager.requestReviewFlow()
            .addOnSuccessListener { reviewInfo ->
                manager.launchReviewFlow(activity as Activity, reviewInfo)
                    .addOnSuccessListener {
                        val timeEnd = System.currentTimeMillis()
                        if (timeEnd - timeStart >= 300) {
                            rateMeInfoCallBack.onSuccess()
                        } else {
                            rateMeInfoCallBack.onFailure(ApiException(RESULT_CANCELED))
                        }
                    }
                    .addOnFailureListener { throwable ->
                        rateMeInfoCallBack.onFailure(throwable)
                    }
            }
            .addOnFailureListener { throwable ->
                rateMeInfoCallBack.onFailure(throwable)
            }
    }

    override fun openStore() {
        openStore(context, R.string.klyanchilka_google_url_format, context.packageName)
    }
}