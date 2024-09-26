package ru.fabit.klyanchilka.rustore

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes

fun openStore(context: Context, @StringRes urlFormat: Int, appId: String) {
    val url = context.getString(urlFormat, appId)
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}