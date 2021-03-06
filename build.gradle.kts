buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.android.tools.build:gradle:7.0.3")
    }
}

group = "ru.wilddisk"
version = "1.0"

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}