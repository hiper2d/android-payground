buildscript {
    val kotlinVersion = "1.4.10"

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

plugins {
    base
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}

tasks {
    named<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}

