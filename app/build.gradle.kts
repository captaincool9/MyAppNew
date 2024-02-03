plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id ("kotlin-parcelize")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-android")
    id ("kotlin-kapt") // Make sure this line is present




}

android {
    namespace = "com.example.myappnew"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myappnew"
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.android.datatransport:transport-runtime:3.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("androidx.activity:activity-ktx:1.8.2")
    implementation ("androidx.compose.animation:animation-core:1.5.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")



    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.picasso:picasso:2.8")
    implementation ("io.coil-kt:coil-compose:1.3.2")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.33.2-alpha")
    // build.gradle (app module)
    implementation ("androidx.navigation:navigation-compose:2.7.6")
    // Room dependencies
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")



    // Coroutine support for Room
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Lifecycle components for ViewModel and LiveData support
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    ksp("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.navigation:navigation-compose:2.7.6")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.5")
    implementation ("androidx.compose.runtime:runtime:1.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.5.4")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation ("com.google.dagger:hilt-android:2.46")
    ksp ("com.google.dagger:hilt-compiler:2.44")
    implementation ("androidx.compose.material3:material3:1.1.2")
    implementation ("com.google.dagger:hilt-android:2.46")

    ksp ("com.google.dagger:hilt-android-compiler:2.46")




}