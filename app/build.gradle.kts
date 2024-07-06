plugins {
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.jetbrainsKotlinAndroid)
	id("kotlin-kapt")
	id("com.google.dagger.hilt.android")
	id("kotlin-parcelize")
}

android {
	namespace = "com.nandaiqbalh.weatherapp"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.nandaiqbalh.weatherapp"
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

	testOptions {
		unitTests.isIncludeAndroidResources = true
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)

	// material 3
	implementation("androidx.compose.material3:material3:1.2.0-rc01")

	//Splash Api
	implementation("androidx.core:core-splashscreen:1.0.1")

	//Compose Navigation
	val nav_version = "2.6.0"
	implementation("androidx.navigation:navigation-compose:$nav_version")

	//Dagger Hilt
	implementation("com.google.dagger:hilt-android:2.48")
	kapt("com.google.dagger:hilt-compiler:2.48")
	implementation("androidx.hilt:hilt-navigation-compose:1.0.0")


	//Retrofit
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

	//Coil
	implementation("io.coil-kt:coil-compose:2.4.0")

	// Location Services
	implementation("com.google.android.gms:play-services-location:20.0.0")

	// ViewModel Compose
	implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")

	//Accompanist
	implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

	// MockK untuk mocking dalam pengujian unit
	testImplementation("io.mockk:mockk:1.13.4")

	// Coroutines test library untuk pengujian kode dengan penggunaan coroutines
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

	// Core testing library untuk pengujian komponen arsitektur
	testImplementation("androidx.arch.core:core-testing:2.2.0")

	// Core ktx library untuk pengujian unit di Android
	testImplementation("androidx.test:core-ktx:1.5.0")

	// Mockito core library untuk mocking dalam pengujian unit
	testImplementation("org.mockito:mockito-core:4.6.0")

	// Mockito Kotlin support untuk pengujian unit dalam Kotlin
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

	// Mockito inline untuk pengujian unit
	testImplementation("org.mockito:mockito-inline:2.8.47")

	testImplementation("org.robolectric:robolectric:4.5.1")
	testImplementation("org.robolectric:shadows-framework:4.9.2")


}