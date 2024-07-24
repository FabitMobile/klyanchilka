package ru.fabit.klyanchilka.core

@JvmInline
value class InstallerVendor private constructor(val installerPackage: String) {
    companion object {
        val googlePlay = InstallerVendor("com.android.vending")
        val ruStore = InstallerVendor("ru.vk.store")
        val other = InstallerVendor("")
    }
}

fun getInstallerVendor(
    installerPackage: String
) = when (installerPackage) {
    InstallerVendor.googlePlay.installerPackage -> InstallerVendor.googlePlay
    InstallerVendor.ruStore.installerPackage -> InstallerVendor.ruStore

    else -> InstallerVendor.other
}