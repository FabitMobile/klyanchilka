package ru.fabit.klyanchilka.googleplay

import android.app.Activity
import android.content.Context
import com.google.android.play.core.review.testing.FakeReviewManager
import ru.fabit.klyanchilka.core.ApplicationRateMe
import ru.fabit.klyanchilka.core.RateMeInfoCallBack

open class GoogleApplicationRateMeForTest(private val context: Context) : ApplicationRateMe {

    private val manager = FakeReviewManager(context)

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

    override fun openStore() {
        openStore(context, R.string.klyanchilka_google_url_format, context.packageName)
    }
}