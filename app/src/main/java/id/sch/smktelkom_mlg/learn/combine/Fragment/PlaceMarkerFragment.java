package id.sch.smktelkom_mlg.learn.combine.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import id.sch.smktelkom_mlg.learn.combine.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceMarkerFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition JTG = CameraPosition.builder()
            .target(new LatLng(48.8584, 2.2945))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions pasar;
    MarkerOptions kec;
    MarkerOptions koramil;
    MarkerOptions smp;

    public PlaceMarkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_marker, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int imageresources = getResources().getIdentifier("@drawable/ic_place", "drawable", getActivity().getPackageName());

        house = new MarkerOptions()
                .position(new LatLng(-7.689707, 112.617807))
                .title("Villa Duta Kasih")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        quba = new MarkerOptions()
                .position(new LatLng(-7.677471, 112.632378))
                .title("Masjid Lumbang Rejo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        pasar = new MarkerOptions()
                .position(new LatLng(-7.681503, 112.641159))
                .title("Pasar Prigen")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        kec = new MarkerOptions()
                .position(new LatLng(-7.756905, 112.664645))
                .title("Taman Safari Prigen")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        koramil = new MarkerOptions()
                .position(new LatLng(-7.677995, 112.634329))
                .title("MTs Negeri 3 Pasuruan")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        smp = new MarkerOptions()
                .position(new LatLng(-7.700071, 112.624484))
                .title("Air Terjun Kakek Bodo")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(pasar);
        m_map.addMarker(kec);
        m_map.addMarker(koramil);
        m_map.addMarker(smp);
        flyTo(JTG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}