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

allprojects {
    repositories {
        maven("https://maven.google.com")
        jcenter()
        google()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}