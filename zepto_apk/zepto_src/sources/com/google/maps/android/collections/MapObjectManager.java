package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class MapObjectManager<O, C extends Collection> {

    /* renamed from: a, reason: collision with root package name */
    public final GoogleMap f45510a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f45511b;

    public class Collection {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f45513a = new LinkedHashSet();

        public Collection() {
        }

        public final void a(Object obj) {
            this.f45513a.add(obj);
            MapObjectManager.this.f45511b.put(obj, this);
        }

        public void b(Circle circle) {
            g(circle);
        }

        public void c(GroundOverlay groundOverlay) {
            g(groundOverlay);
        }

        public void d(Marker marker) {
            g(marker);
        }

        public void e(Polygon polygon) {
            g(polygon);
        }

        public void f(Polyline polyline) {
            g(polyline);
        }

        public final boolean g(Object obj) {
            if (!this.f45513a.remove(obj)) {
                return false;
            }
            MapObjectManager mapObjectManager = MapObjectManager.this;
            mapObjectManager.f45511b.remove(obj);
            mapObjectManager.h(obj);
            return true;
        }
    }

    public MapObjectManager(GoogleMap googleMap) {
        new HashMap();
        this.f45511b = new HashMap();
        this.f45510a = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            @Override // java.lang.Runnable
            public final void run() {
                MapObjectManager.this.i();
            }
        });
    }

    public abstract void h(Object obj);

    public abstract void i();
}
