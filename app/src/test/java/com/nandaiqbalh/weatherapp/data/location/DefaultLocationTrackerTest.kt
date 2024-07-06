package com.nandaiqbalh.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.doAnswer
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@Suppress("DEPRECATION")
@ExperimentalCoroutinesApi
class DefaultLocationTrackerTest {

	private lateinit var locationClient: FusedLocationProviderClient
	private lateinit var application: Application
	private lateinit var locationManager: LocationManager
	private lateinit var locationTracker: DefaultLocationTracker

	@Before
	fun setUp() {
		MockitoAnnotations.openMocks(this)
		locationClient = mock()
		application = mock()
		locationManager = mock()
		locationTracker = DefaultLocationTracker(locationClient, application)

		// Mock the application to return the mock locationManager
		whenever(application.getSystemService(Context.LOCATION_SERVICE)).thenReturn(locationManager)
	}

	@Test
	fun `getCurrentLocation returns null when permissions are not granted`() = runBlockingTest {
		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_FINE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_DENIED)
		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_COARSE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_DENIED)

		val location = locationTracker.getCurrentLocation()
		assertNull(location)
	}

	@Test
	fun `getCurrentLocation returns null when GPS is not enabled`() = runBlockingTest {
		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_FINE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_GRANTED)
		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_COARSE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_GRANTED)
		whenever(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(false)
		whenever(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(false)

		val location = locationTracker.getCurrentLocation()
		assertNull(location)
	}

	@Test
	fun `getCurrentLocation returns location when permissions are granted and GPS is enabled`() = runBlockingTest {
		val mockLocation = mock<Location>()

		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_FINE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_GRANTED)
		whenever(ContextCompat.checkSelfPermission(application, Manifest.permission.ACCESS_COARSE_LOCATION))
			.thenReturn(PackageManager.PERMISSION_GRANTED)
		whenever(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(true)
		whenever(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(true)
		whenever(locationClient.lastLocation).thenAnswer {
			mockTaskWithResult(mockLocation)
		}

		val location = locationTracker.getCurrentLocation()
		assertEquals(mockLocation, location)
	}

	private fun <T> mockTaskWithResult(result: T): Task<T> {
		val task = mock<Task<T>>()

		whenever(task.isComplete).thenReturn(true)
		whenever(task.isSuccessful).thenReturn(true)

		doAnswer { result }.whenever(task).result

		return task
	}
}
