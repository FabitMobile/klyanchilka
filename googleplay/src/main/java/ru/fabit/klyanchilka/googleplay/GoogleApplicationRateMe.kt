package ru.fabit.klyanchilka.googleplay

import android.app.Activity
import android.content.Context
import com.google.android.play.core.review.ReviewManagerFactory
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack

abstract class GoogleApplicationRateMe(context: Context) : ApplicationRateMe {

    private val manager = ReviewManagerFactory.create(context)

    override fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack) {
        manager.requestReviewFlow()
            .addOnSuccessListener { reviewInfo ->
                manager.launchReviewFlow(activity as Activity, reviewInfo)
                    .addOnSuccessListener {
                        rateMeInfoCallBack.onSuccess()
                    }
                    .addOnFailureListener { throwable ->
                        rateMeInfoCallBack.onFailure(throwable)
                    }
            }
            .addOnFailureListener { throwable ->
                rateMeInfoCallBack.onFailure(throwable)
            }
    }
}