package com.zeptoconsumerapp.FusedLocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.location.zzbp;
import com.google.android.gms.internal.location.zzcd;
import com.google.android.gms.internal.location.zzce;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.zzae;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FusedLocationProvider implements LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47432a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbp f47433b;

    /* renamed from: c, reason: collision with root package name */
    public final FusedLocationModule f47434c;

    /* renamed from: d, reason: collision with root package name */
    public final zzce f47435d;

    /* renamed from: e, reason: collision with root package name */
    public LocationOptions f47436e;

    /* renamed from: f, reason: collision with root package name */
    public LocationRequest f47437f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47438g = false;

    /* renamed from: h, reason: collision with root package name */
    public final LocationCallback f47439h = new LocationCallback() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.1
        @Override // com.google.android.gms.location.LocationCallback
        public final void a(LocationAvailability locationAvailability) {
            if (locationAvailability.f38309d < 1000) {
                return;
            }
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            if (LocationUtils.a(fusedLocationProvider.f47432a)) {
                return;
            }
            fusedLocationProvider.f47434c.d(fusedLocationProvider, LocationError.POSITION_UNAVAILABLE, "Unable to retrieve location.");
        }

        @Override // com.google.android.gms.location.LocationCallback
        public final void b(LocationResult locationResult) {
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            fusedLocationProvider.f47434c.c(fusedLocationProvider, locationResult.b());
            if (fusedLocationProvider.f47438g) {
                fusedLocationProvider.f47440i.removeCallbacks(fusedLocationProvider.f47441j);
                fusedLocationProvider.f47433b.c(fusedLocationProvider.f47439h);
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public final Handler f47440i = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f47441j = new Runnable() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.2
        @Override // java.lang.Runnable
        public final void run() {
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            fusedLocationProvider.f47434c.d(fusedLocationProvider, LocationError.TIMEOUT, null);
            fusedLocationProvider.f47433b.c(fusedLocationProvider.f47439h);
        }
    };

    /* renamed from: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47449a;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            f47449a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47449a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47449a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47449a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FusedLocationProvider(Context context, FusedLocationModule fusedLocationModule) {
        this.f47432a = context;
        int i2 = LocationServices.f38339a;
        Api.ApiOptions.NoOptions noOptions = Api.ApiOptions.NO_OPTIONS;
        GoogleApi.Settings settings = GoogleApi.Settings.DEFAULT_SETTINGS;
        Api api = zzbp.f36637a;
        this.f47433b = new zzbp(context, api, noOptions, settings);
        this.f47434c = fusedLocationModule;
        this.f47435d = new zzce(context, api, noOptions, settings);
    }

    public static void c(FusedLocationProvider fusedLocationProvider) {
        fusedLocationProvider.getClass();
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        LocationRequest locationRequest = fusedLocationProvider.f47437f;
        ArrayList arrayList = builder.f38343a;
        if (locationRequest != null) {
            arrayList.add(locationRequest);
        }
        LocationSettingsRequest locationSettingsRequest = new LocationSettingsRequest(arrayList, false, false);
        zzce zzceVar = fusedLocationProvider.f47435d;
        zzceVar.getClass();
        zzceVar.doRead(TaskApiCall.builder().run(new zzcd(locationSettingsRequest)).setMethodKey(2426).build()).e(new OnSuccessListener<LocationSettingsResponse>() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.6
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FusedLocationProvider.this.d();
            }
        }).c(new OnFailureListener() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                int statusCode = ((ApiException) exc).getStatusCode();
                LocationError locationError = LocationError.SETTINGS_NOT_SATISFIED;
                FusedLocationProvider fusedLocationProvider2 = FusedLocationProvider.this;
                if (statusCode != 6) {
                    if (statusCode == 8502) {
                        boolean zIsProviderEnabled = false;
                        if (Settings.Global.getInt(fusedLocationProvider2.f47432a.getContentResolver(), "airplane_mode_on", 0) != 0) {
                            try {
                                zIsProviderEnabled = ((LocationManager) fusedLocationProvider2.f47432a.getSystemService("location")).isProviderEnabled("gps");
                            } catch (Exception unused) {
                            }
                            if (zIsProviderEnabled) {
                                fusedLocationProvider2.d();
                                return;
                            }
                        }
                    }
                    fusedLocationProvider2.f47434c.d(fusedLocationProvider2, locationError, null);
                    return;
                }
                LocationOptions locationOptions = fusedLocationProvider2.f47436e;
                boolean z = locationOptions.f47475g;
                boolean zA = LocationUtils.a(fusedLocationProvider2.f47432a);
                if (z) {
                    return;
                }
                if (locationOptions.f47476h && zA) {
                    fusedLocationProvider2.d();
                    return;
                }
                if (!zA) {
                    locationError = LocationError.POSITION_UNAVAILABLE;
                }
                fusedLocationProvider2.f47434c.d(fusedLocationProvider2, locationError, null);
            }
        });
    }

    @Override // com.zeptoconsumerapp.FusedLocation.LocationProvider
    public final boolean a(int i2, int i3) {
        if (i2 != 0) {
            return false;
        }
        if (i3 == -1) {
            d();
            return true;
        }
        boolean z = this.f47436e.f47476h;
        boolean zA = LocationUtils.a(this.f47432a);
        if (z && zA) {
            d();
            return true;
        }
        this.f47434c.d(this, zA ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, null);
        return true;
    }

    @Override // com.zeptoconsumerapp.FusedLocation.LocationProvider
    public final void b(final LocationOptions locationOptions) {
        int i2;
        this.f47438g = true;
        this.f47436e = locationOptions;
        LocationRequest locationRequest = new LocationRequest();
        LocationAccuracy locationAccuracy = locationOptions.f47469a;
        int iOrdinal = locationAccuracy.ordinal();
        if (iOrdinal == 0) {
            i2 = 100;
        } else if (iOrdinal == 1) {
            i2 = 102;
        } else if (iOrdinal == 2) {
            i2 = 104;
        } else {
            if (iOrdinal != 3) {
                throw new IllegalStateException("Unexpected value: " + locationAccuracy);
            }
            i2 = 105;
        }
        zzae.a(i2);
        locationRequest.f38311a = i2;
        locationRequest.s(locationOptions.f47470b);
        locationRequest.r(locationOptions.f47471c);
        float f2 = this.f47438g ? 0.0f : locationOptions.f47472d;
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f2);
        }
        locationRequest.f38317g = f2;
        this.f47437f = locationRequest;
        this.f47433b.b().e(new OnSuccessListener<Location>() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Location location = (Location) obj;
                FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
                if (location == null || (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000 >= locationOptions.f47474f) {
                    FusedLocationProvider.c(fusedLocationProvider);
                } else {
                    fusedLocationProvider.f47434c.c(fusedLocationProvider, location);
                }
            }
        }).c(new OnFailureListener() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationProvider.3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FusedLocationProvider.c(FusedLocationProvider.this);
            }
        });
    }

    public final void d() {
        this.f47433b.d(this.f47437f, this.f47439h, Looper.getMainLooper());
        if (this.f47438g) {
            long j2 = this.f47436e.f47473e;
            if (j2 <= 0 || j2 == Long.MAX_VALUE) {
                return;
            }
            this.f47440i.postDelayed(this.f47441j, j2);
        }
    }
}
