package pi.rs.handrifirdaus.rsdepok;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LatLng latLngRsud = new LatLng(-6.403975, 106.758493);
    private LatLng latLngBy = new LatLng(-6.397479, 106.805935);
    private LatLng latLngCmd = new LatLng(-6.427315, 106.823134);
    private LatLng latLngPc = new LatLng(-6.321900, 106.782645);
    private LatLng latLngKjd = new LatLng(-6.321866, 106.783201);
    private LatLng latLngSm = new LatLng(-6.480647, 106.864993);
    private LatLng latLngHd = new LatLng(-6.399772, 106.825262);
    private LatLng latLngBb = new LatLng(-6.354821, 106.849316);
    private LatLng latLngSd = new LatLng(-6.408584, 106.861636);
    private LatLng latLngHrd = new LatLng(-6.402749, 106.819972);
    private LatLng latLngTi = new LatLng(-6.356482, 106.860182);
    private LatLng latLngMkd = new LatLng(-6.394368, 106.824206);
    private LatLng latLngBm = new LatLng(-6.362880, 106.835023);
    private LatLng latLngMc = new LatLng(-6.376194, 106.92099);
    private LatLng latLngPd = new LatLng(-6.401607, 106.771139);
    private LocationManager mLocationManager = null;
    private String provider = null;
    private Marker mCurrentPosition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (isProviderAvailable() && (provider != null)) {
            locateCurrentPosition();
        }
    }

    private void locateCurrentPosition() {

        int status = getPackageManager().checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,
                getPackageName());

        if (status == PackageManager.PERMISSION_GRANTED) {
            Location location = mLocationManager.getLastKnownLocation(provider);
            updateWithNewLocation(location);
            //  mLocationManager.addGpsStatusListener(this);
            long minTime = 5000;// ms
            float minDist = 5.0f;// meter
            mLocationManager.requestLocationUpdates(provider, minTime, minDist,
                    (LocationListener) this);
        }
    }



    private boolean isProviderAvailable() {
        mLocationManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        provider = mLocationManager.getBestProvider(criteria, true);
        if (mLocationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;

            return true;
        }

        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
            return true;
        }

        if (provider != null) {
            return true;
        }
        return false;
    }

    private void updateWithNewLocation(Location location) {

        if (location != null && provider != null) {
            double lng = location.getLongitude();
            double lat = location.getLatitude();

            addBoundaryToCurrentPosition(lat, lng);

            CameraPosition camPosition = new CameraPosition.Builder()
                    .target(new LatLng(lat, lng)).zoom(10f).build();

            if (mMap != null)
                mMap.animateCamera(CameraUpdateFactory

                        .newCameraPosition(camPosition));
        } else {
            Log.d("Location error", "Something went wrong");
        }
    }


    private void addBoundaryToCurrentPosition(double lat, double lang) {

        MarkerOptions mMarkerOptions = new MarkerOptions();
        mMarkerOptions.position(new LatLng(lat, lang));
        mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMarkerOptions.title("Posisi Anda");
        mMarkerOptions.anchor(0.5f, 0.5f);

        CircleOptions mOptions = new CircleOptions()
                .center(new LatLng(lat, lang)).radius(10000)
                .strokeColor(0x110000FF).strokeWidth(1).fillColor(0x110000FF);
        mMap.addCircle(mOptions);
        if (mCurrentPosition != null)
            mCurrentPosition.remove();
        mCurrentPosition = mMap.addMarker(mMarkerOptions);
        mMap.addMarker(new MarkerOptions()
                .position(latLngRsud)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSUD KOTA DEPOK"));


        mMap.addMarker(new MarkerOptions()
                .position(latLngBy)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS BHAKTI YUDA"));


        mMap.addMarker(new MarkerOptions()
                .position(latLngCmd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS CITRA MEDIKA DEPOK"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngPc)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RSU Puri Cinere"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngKjd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS KHUSUS JANTUNG DIAGRAM"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngSm)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS SENTRA MEDIKA"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngHd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS HERMINA DEPOK"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngBb)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS BHAYANGKARA BRIMOB"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngSd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS SIMPANGAN DEPOK"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngHrd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS HARAPAN DEPOK"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngTi)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS TUGU IBU"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngMkd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS MITRA KELUARGA DEPOK"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngBm)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS BUNDA MARGONDA"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngMc)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS MEILIA CIBUBUR"));

        mMap.addMarker(new MarkerOptions()
                .position(latLngPd)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .title("RS PERMATA DEPOK"));

    }


    @Override
    public void onLocationChanged(Location location) {

        updateWithNewLocation(location);
    }

    @Override
    public void onProviderDisabled(String provider) {

        updateWithNewLocation(null);
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.OUT_OF_SERVICE:
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                break;
            case LocationProvider.AVAILABLE:
                break;
        }
    }
}