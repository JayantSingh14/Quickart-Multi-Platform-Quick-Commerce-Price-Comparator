package com.google.maps.android.clustering;

import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Set;

/* loaded from: classes4.dex */
public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    public class ClusterTask extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        @Override // android.os.AsyncTask
        public final Object doInBackground(Float[] fArr) {
            throw null;
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object obj) {
            throw null;
        }
    }

    public interface OnClusterClickListener<T extends ClusterItem> {
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
    }

    public interface OnClusterInfoWindowLongClickListener<T extends ClusterItem> {
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
    }

    public interface OnClusterItemInfoWindowLongClickListener<T extends ClusterItem> {
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public final void a(Marker marker) {
        throw null;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public final void b() {
        throw null;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public final boolean g(Marker marker) {
        throw null;
    }
}
