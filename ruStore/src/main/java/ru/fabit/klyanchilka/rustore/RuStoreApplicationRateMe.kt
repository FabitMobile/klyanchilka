package ru.fabit.klyanchilka.rustore

import android.content.Context
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack
import ru.rustore.sdk.review.RuStoreReviewManagerFactory

abstract class RuStoreApplicationRateMe(context: Context) : ApplicationRateMe {

    private val manager = RuStoreReviewManagerFactory.create(context)

    override fun rateMe(activity: Any, rateMeInfoCallBack: RateMeInfoCallBack) {
        manager.requestReviewFlow()
            .addOnSuccessListener { reviewInfo ->
                manager.launchReviewFlow(reviewInfo)
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