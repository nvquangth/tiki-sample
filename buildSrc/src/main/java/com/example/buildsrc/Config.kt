package com.example.buildsrc

object Versions {
    const val kotlin = "1.3.72"
    const val androidGradlePlugin = "4.0.0"

    // ConstraintLayout
    const val constraintLayout = "1.1.3"

    // Appcompat
    const val appcompat = "1.1.0"

    // Android Core
    const val coreKtx = "1.3.0"

    // ViewModel + LiveData Lifecycle
    const val lifecycle = "2.2.0"

    // Multidex
    const val multidex = "2.0.1"

    // Navigation
    const val navigation = "2.2.2"

    // RecyclerView
    const val recyclerView = "1.1.0"

    // Room
    const val room = "2.2.5"

    // ViewPager2
    const val viewPager2 = "1.0.0"

    // Koin
    const val koin = "2.1.5"

    // Retrofit
    const val retrofit = "2.9.0"

    // OkHttp
    const val okHttp = "4.7.2"

    // Glide
    const val glide = "4.11.0"

    // JUnit
    const val jUnit = "4.12"
    const val jUnitExt = "1.1.1"
    const val espresso = "3.2.0"

    // Mockito
    const val mockito = "3.3.3"

    // Material Design
    const val material = "1.1.0"

    // CardView
    const val cardView = "1.0.0"

    // Preference
    const val preference = "1.1.1"

    // SwipeRefreshLayout
    const val swipeRefreshLayout = "1.1.0"
}

object Libs {

    // ConstraintLayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Appcompat
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    // Android Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // ViewModel
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // LiveData
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Annotation Processor Lifecycle for Java 8
    const val lifecycleProcessor = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    // Multidex
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // RecyclerView
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomProcessor = "androidx.room:room-compiler:${Versions.room}"
    // Room extension and Coroutines support
    const val roomExt = "androidx.room:room-ktx:${Versions.room}"

    // ViewPager2
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"

    // Koin
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // OkHttp
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // for testing
    const val okHttpMockServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // JUnit
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Mockito
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"

    // Material Design
    const val material = "com.google.android.material:material:${Versions.material}"

    // CardView
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"

    // Preference
    const val preference =  "androidx.preference:preference-ktx:${Versions.preference}"

    // SwipeRefreshLayout
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
}

object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val koinPlugin = "org.koin:koin-gradle-plugin:${Versions.koin}"
    const val navSafeArg = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object GradlePlugins {
    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin-android"
    const val kotlinExt = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val navSafeArg = "androidx.navigation.safeargs.kotlin"
}

object Android {
    const val applicationId = "com.example.tikisample"
    const val compileSdk = 29
    const val buildTools = "29.0.3"
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 100
    const val versionNam = "1.0.0"
}

object AndroidJUnit {
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val minifyDebug = false
    const val proguardDebug = "proguard-rule.pro"

    const val release = "release"
    const val minifyRelease = false
    const val proguardRelease = "proguard-release.pro"
}

object ProductFlavor {
    const val develop = "develop"
    const val applicationIdDevelop = "com.example.tikisample.dev"
    const val versionCodeDevelop = 201
    const val versionNameDevelop = "2.0.1"
    const val baseUrlDevelop = "\"https://api.tiki.vn/\""

    const val staging = "staging"
    const val applicationIdStaging = "com.example.tikisample.stg"
    const val versionCodeStaging = 115
    const val versionNameStaging = "1.1.5"
    const val baseUrlStaging = "\"https://api.tiki.vn/\""

    const val production = "production"
    const val applicationIdProduction = "com.example.tikisample.pro"
    const val versionCodeProduction = 100
    const val versionNameProduct = "1.0.0"
    const val baseUrlProduction = "\"https://api.tiki.vn/\""

    const val baseUrlParam = "BASE_URL"
}