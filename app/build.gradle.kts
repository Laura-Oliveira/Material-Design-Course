plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.ecommerce"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ecommerce"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    viewBinding { enable = true }
    buildFeatures { dataBinding = true }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.car.ui.lib)
    implementation(libs.volley)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.constraintlayout.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api (libs.material.v110alpha06)

    //View Model & Data Binding
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.databinding.runtime)

    //Glide (Images)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)

}