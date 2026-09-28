package com.rnmaps.maps;

import android.location.Location;
import android.os.Looper;
import android.os.WorkSource;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.location.zzbp;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.zzae;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Iterator;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public class FusedLocationSource implements LocationSource {

    /* renamed from: a, reason: collision with root package name */
    public final zzbp f46470a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationRequest f46471b;

    /* renamed from: c, reason: collision with root package name */
    public LocationCallback f46472c;

    public FusedLocationSource(ThemedReactContext themedReactContext) {
        int i2 = LocationServices.f38339a;
        this.f46470a = new zzbp(themedReactContext, zzbp.f36637a, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        LocationRequest locationRequest = new LocationRequest(102, DateUtils.MILLIS_PER_HOUR, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, DateUtils.MILLIS_PER_HOUR, 0, 0, null, false, new WorkSource(), null);
        this.f46471b = locationRequest;
        zzae.a(100);
        locationRequest.f38311a = 100;
        locationRequest.s(5000L);
    }

    @Override // com.google.android.gms.maps.LocationSource
    public final void a(final LocationSource.OnLocationChangedListener onLocationChangedListener) {
        zzbp zzbpVar = this.f46470a;
        try {
            zzbpVar.b().e(new OnSuccessListener<Location>() { // from class: com.rnmaps.maps.FusedLocationSource.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    Location location = (Location) obj;
                    if (location != null) {
                        onLocationChangedListener.onLocationChanged(location);
                    }
                }
            });
            LocationCallback locationCallback = new LocationCallback() { // from class: com.rnmaps.maps.FusedLocationSource.2
                @Override // com.google.android.gms.location.LocationCallback
                public final void b(LocationResult locationResult) {
                    Iterator it = locationResult.f38338a.iterator();
                    while (it.hasNext()) {
                        onLocationChangedListener.onLocationChanged((Location) it.next());
                    }
                }
            };
            this.f46472c = locationCallback;
            zzbpVar.d(this.f46471b, locationCallback, Looper.myLooper());
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public final void b(int i2) {
        this.f46471b.r(i2);
    }

    public final void c(int i2) {
        this.f46471b.s(i2);
    }

    public final void d(int i2) {
        LocationRequest locationRequest = this.f46471b;
        locationRequest.getClass();
        zzae.a(i2);
        locationRequest.f38311a = i2;
    }

    @Override // com.google.android.gms.maps.LocationSource
    public final void deactivate() {
        this.f46470a.c(this.f46472c);
    }
}
