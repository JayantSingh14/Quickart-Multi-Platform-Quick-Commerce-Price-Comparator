package com.agontuk.RNFusedLocation;

import android.app.Activity;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.ResolvableApiException;
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
import java.util.Random;

/* loaded from: classes3.dex */
public class FusedLocationProvider implements LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f14024a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbp f14025b;

    /* renamed from: c, reason: collision with root package name */
    public final RNFusedLocationModule f14026c;

    /* renamed from: d, reason: collision with root package name */
    public final zzce f14027d;

    /* renamed from: e, reason: collision with root package name */
    public int f14028e;

    /* renamed from: f, reason: collision with root package name */
    public LocationOptions f14029f;

    /* renamed from: g, reason: collision with root package name */
    public LocationRequest f14030g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14031h = false;

    /* renamed from: i, reason: collision with root package name */
    public final LocationCallback f14032i = new LocationCallback() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.1
        @Override // com.google.android.gms.location.LocationCallback
        public final void a(LocationAvailability locationAvailability) {
            if (locationAvailability.f38309d < 1000) {
                return;
            }
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            if (LocationUtils.d(fusedLocationProvider.f14024a)) {
                return;
            }
            fusedLocationProvider.f14026c.onLocationError(fusedLocationProvider, LocationError.POSITION_UNAVAILABLE, "Unable to retrieve location.");
        }

        @Override // com.google.android.gms.location.LocationCallback
        public final void b(LocationResult locationResult) {
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            fusedLocationProvider.f14026c.onLocationChange(fusedLocationProvider, locationResult.b());
            if (fusedLocationProvider.f14031h) {
                fusedLocationProvider.f14033j.removeCallbacks(fusedLocationProvider.f14034k);
                fusedLocationProvider.f14025b.c(fusedLocationProvider.f14032i);
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    public final Handler f14033j = new Handler(Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f14034k = new Runnable() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.2
        @Override // java.lang.Runnable
        public final void run() {
            FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
            fusedLocationProvider.f14026c.onLocationError(fusedLocationProvider, LocationError.TIMEOUT, null);
            fusedLocationProvider.f14025b.c(fusedLocationProvider.f14032i);
        }
    };

    /* renamed from: com.agontuk.RNFusedLocation.FusedLocationProvider$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14042a;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            f14042a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14042a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14042a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14042a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FusedLocationProvider(ReactApplicationContext reactApplicationContext, RNFusedLocationModule rNFusedLocationModule) {
        this.f14024a = reactApplicationContext;
        int i2 = LocationServices.f38339a;
        Api.ApiOptions.NoOptions noOptions = Api.ApiOptions.NO_OPTIONS;
        GoogleApi.Settings settings = GoogleApi.Settings.DEFAULT_SETTINGS;
        Api api = zzbp.f36637a;
        this.f14025b = new zzbp(reactApplicationContext, api, noOptions, settings);
        this.f14026c = rNFusedLocationModule;
        this.f14027d = new zzce(reactApplicationContext, api, noOptions, settings);
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final boolean a(int i2, int i3) {
        if (i2 != this.f14028e) {
            return false;
        }
        if (i3 == -1) {
            g();
            return true;
        }
        boolean z = this.f14029f.f14071h;
        boolean zD = LocationUtils.d(this.f14024a);
        if (z && zD) {
            g();
            return true;
        }
        this.f14026c.onLocationError(this, zD ? LocationError.SETTINGS_NOT_SATISFIED : LocationError.POSITION_UNAVAILABLE, null);
        return true;
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void b(LocationOptions locationOptions) {
        this.f14031h = false;
        this.f14029f = locationOptions;
        this.f14030g = e(locationOptions);
        f();
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void c() {
        this.f14025b.c(this.f14032i);
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void d(final LocationOptions locationOptions) {
        this.f14031h = true;
        this.f14029f = locationOptions;
        this.f14030g = e(locationOptions);
        this.f14025b.b().e(new OnSuccessListener<Location>() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Location location = (Location) obj;
                FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
                if (location == null || (SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos()) / 1000000 >= locationOptions.f14069f) {
                    fusedLocationProvider.f();
                } else {
                    Log.i(RNFusedLocationModule.TAG, "returning cached location.");
                    fusedLocationProvider.f14026c.onLocationChange(fusedLocationProvider, location);
                }
            }
        }).c(new OnFailureListener() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FusedLocationProvider.this.f();
            }
        });
    }

    public final LocationRequest e(LocationOptions locationOptions) {
        int i2;
        LocationRequest locationRequest = new LocationRequest();
        LocationAccuracy locationAccuracy = locationOptions.f14064a;
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
        locationRequest.s(locationOptions.f14065b);
        locationRequest.r(locationOptions.f14066c);
        float f2 = this.f14031h ? 0.0f : locationOptions.f14067d;
        if (f2 >= 0.0f) {
            locationRequest.f38317g = f2;
            return locationRequest;
        }
        throw new IllegalArgumentException("invalid displacement: " + f2);
    }

    public final void f() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        LocationRequest locationRequest = this.f14030g;
        ArrayList arrayList = builder.f38343a;
        if (locationRequest != null) {
            arrayList.add(locationRequest);
        }
        LocationSettingsRequest locationSettingsRequest = new LocationSettingsRequest(arrayList, false, false);
        zzce zzceVar = this.f14027d;
        zzceVar.getClass();
        zzceVar.doRead(TaskApiCall.builder().run(new zzcd(locationSettingsRequest)).setMethodKey(2426).build()).e(new OnSuccessListener<LocationSettingsResponse>() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.6
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FusedLocationProvider.this.g();
            }
        }).c(new OnFailureListener() { // from class: com.agontuk.RNFusedLocation.FusedLocationProvider.5
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationError locationError = LocationError.INTERNAL_ERROR;
                ApiException apiException = (ApiException) exc;
                int statusCode = apiException.getStatusCode();
                LocationError locationError2 = LocationError.SETTINGS_NOT_SATISFIED;
                FusedLocationProvider fusedLocationProvider = FusedLocationProvider.this;
                if (statusCode != 6) {
                    if (statusCode == 8502) {
                        boolean zIsProviderEnabled = false;
                        if (Settings.Global.getInt(fusedLocationProvider.f14024a.getContentResolver(), "airplane_mode_on", 0) != 0) {
                            try {
                                zIsProviderEnabled = ((LocationManager) fusedLocationProvider.f14024a.getSystemService("location")).isProviderEnabled("gps");
                            } catch (Exception unused) {
                            }
                            if (zIsProviderEnabled) {
                                fusedLocationProvider.g();
                                return;
                            }
                        }
                    }
                    fusedLocationProvider.f14026c.onLocationError(fusedLocationProvider, locationError2, null);
                    return;
                }
                LocationOptions locationOptions = fusedLocationProvider.f14029f;
                boolean z = locationOptions.f14070g;
                ReactApplicationContext reactApplicationContext = fusedLocationProvider.f14024a;
                boolean zD = LocationUtils.d(reactApplicationContext);
                RNFusedLocationModule rNFusedLocationModule = fusedLocationProvider.f14026c;
                if (!z) {
                    if (locationOptions.f14071h && zD) {
                        fusedLocationProvider.g();
                        return;
                    }
                    if (!zD) {
                        locationError2 = LocationError.POSITION_UNAVAILABLE;
                    }
                    rNFusedLocationModule.onLocationError(fusedLocationProvider, locationError2, null);
                    return;
                }
                try {
                    ResolvableApiException resolvableApiException = (ResolvableApiException) apiException;
                    Activity currentActivity = reactApplicationContext.getCurrentActivity();
                    if (currentActivity == null) {
                        rNFusedLocationModule.onLocationError(fusedLocationProvider, locationError, "Tried to open location dialog while not attached to an Activity.");
                        return;
                    }
                    int iNextInt = new Random().nextInt(10000);
                    fusedLocationProvider.f14028e = iNextInt;
                    resolvableApiException.startResolutionForResult(currentActivity, iNextInt);
                } catch (IntentSender.SendIntentException | ClassCastException unused2) {
                    rNFusedLocationModule.onLocationError(fusedLocationProvider, locationError, null);
                }
            }
        });
    }

    public final void g() {
        this.f14025b.d(this.f14030g, this.f14032i, Looper.getMainLooper());
        if (this.f14031h) {
            long j2 = this.f14029f.f14068e;
            if (j2 <= 0 || j2 == Long.MAX_VALUE) {
                return;
            }
            this.f14033j.postDelayed(this.f14034k, j2);
        }
    }
}
