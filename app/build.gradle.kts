plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kapt)
    id ("com.google.devtools.ksp")
    id ("dagger.hilt.android.plugin")
    id("kotlin-parcelize")

}

android {
    namespace = "com.dailyforecast.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dailyforecast.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding =  true
    }
    buildFeatures {
        dataBinding = true
    }

    packaging {
        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes +=  "META-INF/gradle/incremental.annotation.processors"
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    //Retrofit
    implementation(libs.square.retrofit)
    implementation(libs.square.adapter.rxjava2)
    implementation(libs.square.converter.moshi)
    implementation ("org.jsoup:jsoup:1.14.3")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //OkHttpClient
    implementation(libs.square.okhttp.logging.interceptor)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.google.gson)

//    implementation(libs.hilt.android.gradle.plugin)
//    implementation(libs.hilt.compiler.gradle.plugin)

    implementation ("com.google.dagger:hilt-android:2.48")
    ksp( "com.google.dagger:dagger-compiler:2.48") // Dagger compiler
    ksp ("com.google.dagger:hilt-compiler:2.48") // Hilt compiler
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidXVersion")


    implementation(libs.kotlinx.coroutines.play.services)

//    implementation(libs.androidx.navigation.safe.args.gradle.plugin)

    implementation(libs.androidx.runtime.livedata )
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//    implementation(libs.androidx.fragment.ktx)
//    implementation ("androidx.fragment:fragment-ktx:1.5.1")



    implementation(libs.timber)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Room Database
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version")



    val hilt_version = "2.38.1"

    // hilt
//    implementation ("com.google.dagger:hilt-android:$hilt_version")
//    kapt ("com.google.dagger:hilt-compiler:$hilt_version")

//    implementation ("androidx.hilt:hilt-compiler:$hiltAndroidXVersion")


}