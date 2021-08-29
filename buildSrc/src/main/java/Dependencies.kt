object ApplicationId {
    const val id = "com.example.githubrepository"
}

object Modules {
    const val app = ":app"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val gradle = "4.2.0"

    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30

    const val googleServices = "4.3.10"

    const val fabric = "1.28.1"

    const val appcompat = "1.3.1"
    const val design = "1.4.0"
    const val cardview = "1.0.0"
    const val recyclerview = "1.2.1"
    const val maps = "15.0.1"
    const val constrain = "2.1.0"

    const val ktx = "1.7.0-alpha01"
    const val coroutine = "1.3.9"

    const val kotlin = "1.5.30"
    const val timber = "5.0.1"
    const val retrofit = "2.9.0"
    const val loggingInterceptor = "4.9.1"
    const val coil = "1.3.2"
    const val lifecycle = "2.2.0"
    const val lifecycleVm = "2.3.1"
    const val room = "2.2.6"
    const val leakCanary = "2.0-alpha-2"
    const val crashlytics = "2.9.9"
    const val koin = "3.1.2"
    const val gson = "2.8.8"
    const val stetho = "1.5.1"

    const val playCore = "1.4.1"
    const val lottieVersion = "4.1.0"

    const val junit = "4.12"
    const val testCore = "1.1.3"
    const val testExt = "1.4.0"
    const val assertjCore = "3.12.2"
    const val mockitoKotlin = "2.1.0"
    const val mockitoInline = "2.27.0"
    const val mockitocore = "2.23.0"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofitGsonAdapter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVm}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val leakCanaryAndroid =
        "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"

    const val lottieVersion = "com.airbnb.android:lottie:${Versions.lottieVersion}"
}

object SupportLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.design}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val constrainLayout = "androidx.constraintlayout:constraintlayout:${Versions.constrain}"
}

object GoogleLibraries {
    const val playCore = "com.google.android.play:core:${Versions.playCore}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val junitAndroid = "androidx.test.ext:junit:${Versions.testExt}"
    const val junitExt = "androidx.test.ext.junit-ktx:${Versions.testExt}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitocore}"
    const val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    const val coroutineTesting =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
}
