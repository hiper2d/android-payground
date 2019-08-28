buildscript {
    val kotlinVersion = "1.3.50"

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

plugins {
    base
}

allprojects {
    repositories {
        maven("https://maven.google.com")
        jcenter()
        google()
    }
}

tasks {
    named<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}

