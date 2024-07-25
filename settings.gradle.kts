pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://artifactory-external.vkpartner.ru/artifactory/maven")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://artifactory-external.vkpartner.ru/artifactory/maven")
    }
}

rootProject.name = "klyanchilka"
include(":core")
include(":googleplay")
include(":rustore")