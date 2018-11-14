package com.swa.swamobileteam.data.deliveries;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.util.SortedList;
import android.widget.Toast;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEnginePriority;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.geojson.Point;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.swa.swamobileteam.ui.MainActivity;

import java.text.SimpleDateFormat;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RouteRepositoryImpl implements RouteRepository {

    Context context;
    SimpleDateFormat df;

    public RouteRepositoryImpl(Context context) {
        this.context = context;
        this.df = new SimpleDateFormat("HH:mm:ss");
    }


    @Override
    public Single<Double> getETA(@NonNull Location location) {

        // For getting current location
        LocationEngine locationEngine = new LocationEngineProvider(context).obtainBestLocationEngineAvailable();
        locationEngine.setPriority(LocationEnginePriority.HIGH_ACCURACY);
        locationEngine.setInterval(5000);
        locationEngine.activate();
        // Problems with automatically checking permissions (even with special row in Manifest)
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        android.location.Location currentLocation = locationEngine.getLastLocation();


        Point origin = Point.fromLngLat(currentLocation.getLongitude(), currentLocation.getLatitude());
        Point destination = Point.fromLngLat(location.getLongitude(), location.getLatitude());

        NavigationRoute.builder(context)
                .accessToken("pk.eyJ1Ijoicm96YWxpeWEiLCJhIjoiY2pvaGN6dW8xMG9qdTNxcGhhcHFmaGViaSJ9.1i_ZdIJn1tVO8H4Nht8zEg")
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        String time = df.format(response.body().routes().get(0).duration());


                        
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                    }
                });

        return Single.just(25.0);
    }
}
