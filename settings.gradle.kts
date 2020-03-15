
include(":app")
include(":common")



pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
}