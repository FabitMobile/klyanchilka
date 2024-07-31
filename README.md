# klyanchilka

[![](https://www.jitpack.io/v/FabitMobile/klyanchilka.svg)](https://www.jitpack.io/#FabitMobile/klyanchilka)

### Библиотека для проверки и инициации встроенной оценки приложения из разных источников.

содержит базовые классы для упрощения работы с обновлениями

* `ApplicationRateMe` с четырьмя
  реализациями: `GoogleApplicationRateMe`, `GoogleApplicationRateMeForTest`, `HuaweiApplicationRateMe`
  и `RuStoreApplicationRateMe`
* `InstallerVendor` и функиця `getInstallerVendor()`

## Использование

Добавить реализации `ApplicationRateMe`, воспользовавшись готовыми классами

```kotlin
class MaiActivity : AppCompatActivity() {
    private val applicationRateMe : ApplicationRateMe = GoogleApplicationRateMe(this)

    private val listener = object : RateMeInfoCallBack {
        override fun onFailure(throwable: Throwable){ /* do something */ }
        override fun onSuccess(){ /* do something */ }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applicationRateMe.rateMe(this, listener)
    }
}
```

Выбрать необходимый источник обновлений используя функцию библиотеки

```kotlin
val installerPackage =
    context.packageManager.getInstallerPackageName(context.applicationInfo.packageName) ?: ""
when (getInstallerVendor(installerPackage)) {
    InstallerVendor.googlePlay -> GoogleApplicationRateMe(...)
    else -> RuStoreApplicationRateMe(...)
}
```

## Подключение зависимостей

Библиотека распространяется средствами JitPack

#### Доступны несколько модулей для подключения

* Сore - чистые kotlin классы

`implementation("com.github.FabitMobile.klyanchilka:core:{latest-version}")`

* GooglePlay

`implementation("com.github.FabitMobile.klyanchilka:googleplay:{latest-version}")`

* RuStore

`implementation("com.github.FabitMobile.klyanchilka:rustore:{latest-version}")`
