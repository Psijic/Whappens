plugins {
    id("com.android.application")
    id("kotlin-android")
//    id ("org.jetbrains.kotlin.plugin.serialization") version kotlin_version
    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

apply("passwords.gradle")

val googleMapsKey: String by project
val kotlinVersion: String by project
val roomVersion: String by project
val lifecycleVersion: String by project
val fragmentVersion: String by project
val timberVersion: String by project
val coroutinesVersion: String by project
val navigation: String by project
val composeVersion: String by project

android {
    signingConfigs {
        create("release") {
        }
    }
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    defaultConfig {
        applicationId = "com.psvoid.whappens"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        manifestPlaceholders["google_maps_key"] = googleMapsKey
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {

        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = "11"
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Tests
    testImplementation(kotlin("test"))
    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("androidx.multidex:multidex:2.0.1")

    // Data binding
    kapt("androidx.databinding:databinding-compiler:7.0.0")

    // Material
    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.core:core-ktx:1.6.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Maps
    implementation("com.google.maps.android:android-maps-utils:2.2.5")
//    implementation ("com.google.maps.android:android-maps-utils-v3:2.2.5")
    implementation("com.google.android.gms:play-services-maps:17.0.1")
    //implementation 'com.google.android.gms:play-services-location:17.0.0'

    // Firebase
//    implementation 'com.google.firebase:firebase-analytics:17.4.0'
//    implementation 'com.google.firebase:firebase-storage:19.1.1'
//    implementation 'com.google.firebase:firebase-messaging:20.1.6'
    implementation("com.google.firebase:firebase-database-ktx:20.0.1")
//    implementation 'com.google.firebase:firebase-auth:19.3.1'
//    implementation 'com.google.firebase:firebase-config:19.1.4'
//    implementation 'com.firebaseui:firebase-ui-auth:6.2.1'

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

    implementation("com.jakewharton.timber:timber:$timberVersion")
    implementation("com.github.bumptech.glide:glide:4.12.0")

    // Compose
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("com.google.android.material:compose-theme-adapter:$composeVersion")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta01")
    implementation("com.google.accompanist:accompanist-insets:0.14.0")

}