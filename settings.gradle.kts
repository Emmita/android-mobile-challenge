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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android(Challenge"
include(":app")
include(":library")
include(":core")
include(":core:domain")
include(":library:gallery")
include(":library:gallery:api")
include(":library:gallery:impl")
include(":feature")
include(":feature:home")
include(":feature:home:impl")
include(":core:design-system")
include(":feature:detail")
include(":feature:detail:impl")
