package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.media.b;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.mixpanel.android.util.MPLog;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class MPConfig {
    public static boolean q = false;
    public static MPConfig r;
    public static final Object s = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final int f45998a;

    /* renamed from: b, reason: collision with root package name */
    public final int f45999b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f46000c;

    /* renamed from: d, reason: collision with root package name */
    public final long f46001d;

    /* renamed from: e, reason: collision with root package name */
    public final int f46002e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f46003f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f46004g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f46005h;

    /* renamed from: i, reason: collision with root package name */
    public String f46006i;

    /* renamed from: j, reason: collision with root package name */
    public String f46007j;

    /* renamed from: k, reason: collision with root package name */
    public String f46008k;

    /* renamed from: l, reason: collision with root package name */
    public String f46009l;

    /* renamed from: m, reason: collision with root package name */
    public final int f46010m;
    public final int n;
    public boolean o;
    public final SSLSocketFactory p;

    public MPConfig(Bundle bundle) throws NoSuchAlgorithmException, KeyManagementException {
        long jFloatValue;
        SSLSocketFactory socketFactory = null;
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            socketFactory = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            if (MPLog.d(4)) {
                Log.i("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", e2);
            }
        }
        this.p = socketFactory;
        boolean z = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        q = z;
        if (z) {
            MPLog.f46096a = 2;
        }
        if (bundle.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            MPLog.f("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.f45998a = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.f45999b = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.f46000c = bundle.getBoolean("com.mixpanel.android.MPConfig.FlushOnBackground", true);
        this.f46002e = bundle.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        bundle.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.f46003f = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.f46004g = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.f46005h = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableExceptionHandler", false);
        this.f46010m = bundle.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.n = bundle.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.o = bundle.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        Object obj = bundle.get("com.mixpanel.android.MPConfig.DataExpiration");
        if (obj != null) {
            try {
                if (obj instanceof Integer) {
                    jFloatValue = ((Integer) obj).intValue();
                } else {
                    if (!(obj instanceof Float)) {
                        throw new NumberFormatException(obj.toString() + " is not a number.");
                    }
                    jFloatValue = (long) ((Float) obj).floatValue();
                }
            } catch (Exception e3) {
                MPLog.c("MixpanelAPI.Conf", "Error parsing com.mixpanel.android.MPConfig.DataExpiration meta-data value", e3);
            }
        } else {
            jFloatValue = 432000000;
        }
        this.f46001d = jFloatValue;
        String string = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string != null) {
            this.f46006i = string;
        } else {
            this.f46006i = a("https://api.mixpanel.com/track/", this.o);
        }
        String string2 = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (string2 != null) {
            this.f46007j = string2;
        } else {
            this.f46007j = a("https://api.mixpanel.com/engage/", this.o);
        }
        String string3 = bundle.getString("com.mixpanel.android.MPConfig.GroupsEndpoint");
        if (string3 != null) {
            this.f46008k = string3;
        } else {
            this.f46008k = "https://api.mixpanel.com/groups/";
        }
        String string4 = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (string4 != null) {
            this.f46009l = string4;
        } else {
            this.f46009l = "https://api.mixpanel.com/decide";
        }
        MPLog.e("MixpanelAPI.Conf", toString());
    }

    public static String a(String str, boolean z) {
        if (!str.contains("?ip=")) {
            StringBuilder sbX = b.x(str, "?ip=");
            sbX.append(z ? "1" : "0");
            return sbX.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, str.indexOf("?ip=")));
        sb.append("?ip=");
        sb.append(z ? "1" : "0");
        return sb.toString();
    }

    public static MPConfig b(Context context) {
        synchronized (s) {
            try {
                if (r == null) {
                    Context applicationContext = context.getApplicationContext();
                    String packageName = applicationContext.getPackageName();
                    try {
                        Bundle bundle = applicationContext.getPackageManager().getApplicationInfo(packageName, 128).metaData;
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        r = new MPConfig(bundle);
                    } catch (PackageManager.NameNotFoundException e2) {
                        throw new RuntimeException(b.C("Can't configure Mixpanel with package name ", packageName), e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r;
    }

    public final String toString() {
        return "Mixpanel (6.0.0) configured with:\n    BulkUploadLimit " + this.f45998a + "\n    FlushInterval " + this.f45999b + "\n    DataExpiration " + this.f46001d + "\n    MinimumDatabaseLimit " + this.f46002e + "\n    DisableAppOpenEvent " + this.f46004g + "\n    EnableDebugLogging " + q + "\n    EventsEndpoint " + this.f46006i + "\n    PeopleEndpoint " + this.f46007j + "\n    DecideEndpoint " + this.f46009l + "\n    DisableDecideChecker " + this.f46003f + "\n    MinimumSessionDuration: " + this.f46010m + "\n    SessionTimeoutDuration: " + this.n + "\n    DisableExceptionHandler: " + this.f46005h + "\n    FlushOnBackground: " + this.f46000c;
    }
}
