# klyanchilka

### Библиотека для проверки и инициации встроенной оценки приложения из разных источников.

содержит базовые классы для упрощения работы с обновлениями

* `ApplicationRateMe` с тремя
  реализациями: `GoogleApplicationRateMe`, `GoogleApplicationRateMeForTest`, `HuaweiApplicationRateMe`
  и `RuStoreApplicationRateMe`
* `InstallerVendor` и функиця `getInstallerVendor()`

## Использование

Добавить реализации `ApplicationRateMe`, воспользовавшись готовыми классами

Выбрать необходимый источник обновлений используя функцию библиотеки

```kotlin
val installerPackage =
    context.packageManager.getInstallerPackageName(context.applicationInfo.packageName) ?: ""
when (getInstallerVendor(installerPackage)) {
    InstallerVendor.googlePlay -> GoogleApplicationRateMe(...)
    else -> NoOpRateMe(UpdateStatus.actual)
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
