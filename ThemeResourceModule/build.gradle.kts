plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("maven-publish")
}

android {
    namespace = "com.mobillor.themeresourcemodule"
    compileSdk = 35

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation("com.intuit.sdp:sdp-android:1.0.5")
    implementation("com.google.android.gms:play-services-vision:20.1.3")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation ("androidx.compose.ui:ui:1.3.2")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.2")
    implementation ("com.airbnb.android:lottie-compose:5.2.0")
    implementation ("androidx.compose.material3:material3:1.0.0-alpha01")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.3.2")

    debugImplementation ("androidx.compose.ui:ui-tooling:1.3.2")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.3.2")

    //retro
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")
    //http3
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.google.code.gson:gson:2.10.1")

    implementation("com.fasterxml.jackson.core:jackson-core:2.11.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")


    compileOnly("com.google.android.wearable:wearable:2.8.1")

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.apache.commons:commons-text:1.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-alpha01")

    //scanner
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("com.github.yuriy-budiyev:code-scanner:2.3.0")


    //viewmodel
    //  implementation ("androidx.lifecycle:lifecycle-extensions-ktx:2.2.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    implementation("com.github.leoncydsilva:SearchableSpinner:1.0.1")

    //lottie
    implementation("com.airbnb.android:lottie:6.4.0")
    implementation("com.airbnb.android:lottie-compose:4.0.0")


    //compose
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.0")
    implementation ("androidx.compose.material:material:1.3.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")


//    pagination

    val paging_version = "3.3.0"

    implementation("androidx.paging:paging-runtime:$paging_version")

    // alternatively - without Android dependencies for tests
    testImplementation("androidx.paging:paging-common:$paging_version")

    // optional - RxJava2 support
    implementation("androidx.paging:paging-rxjava2:$paging_version")

    // optional - RxJava3 support
    implementation("androidx.paging:paging-rxjava3:$paging_version")

    // optional - Guava ListenableFuture support
    implementation("androidx.paging:paging-guava:$paging_version")

    // Compose dependencies
    implementation ("androidx.compose.ui:ui:1.4.3")
    implementation ("androidx.compose.material3:material3:1.1.0-beta01")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")
    implementation ("androidx.activity:activity-compose:1.8.0")

    // Optional - for observing live data in Compose
    implementation ("androidx.compose.runtime:runtime-livedata:1.4.3")

    // optional - Jetpack Compose integration
    implementation("androidx.paging:paging-compose:3.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose-android:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    implementation("androidx.compose.material3:material3:1.2.1")

    implementation ("androidx.compose.runtime:runtime-livedata:1.6.8") // Add this line for LiveData


    // tab layout
    implementation ("com.google.accompanist:accompanist-pager:0.23.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.23.0")
    implementation("com.airbnb.android:lottie-compose:4.0.0")

    //compose
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.0")
    implementation ("androidx.compose.material:material:1.3.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")

    // JUnit 5 core library
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // JUnit 5 support for Kotlin
    testImplementation ("org.jetbrains.kotlin:kotlin-test:1.9.0")
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit5:1.9.0")

    // Mockito core library
    testImplementation ("org.mockito:mockito-core:5.5.0")

    // Mockito with Kotlin support
    testImplementation ("org.mockito.kotlin:mockito-kotlin:5.1.0")

    // Optional: Mockito for Android instrumentation tests (if needed)
    androidTestImplementation ("org.mockito:mockito-android:5.5.0")

    // JUnit 5 extension for Mockito (if using JUnit 5)
    testImplementation ("org.mockito:mockito-junit-jupiter:5.5.0")
}
publishing{
    publications{
        register<MavenPublication>("release"){
            afterEvaluate{
                from (components["release"])
                groupId ="com.github.subharanjann" // GitHub username
                artifactId = "MobillorThemeResourceModule"      // GitHub repository name
//                                version = "1.0.0"
            }
        }
    }
}
