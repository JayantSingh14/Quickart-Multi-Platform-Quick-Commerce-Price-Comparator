package androidx.appcompat.app;

import android.content.Context;
import android.location.LocationManager;

/* loaded from: classes3.dex */
class TwilightManager {

    /* renamed from: d, reason: collision with root package name */
    public static TwilightManager f385d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f386a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f387b;

    /* renamed from: c, reason: collision with root package name */
    public final TwilightState f388c = new TwilightState();

    public static class TwilightState {

        /* renamed from: a, reason: collision with root package name */
        public boolean f389a;

        /* renamed from: b, reason: collision with root package name */
        public long f390b;
    }

    public TwilightManager(Context context, LocationManager locationManager) {
        this.f386a = context;
        this.f387b = locationManager;
    }

    public static TwilightManager a(Context context) {
        if (f385d == null) {
            Context applicationContext = context.getApplicationContext();
            f385d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f385d;
    }
}
