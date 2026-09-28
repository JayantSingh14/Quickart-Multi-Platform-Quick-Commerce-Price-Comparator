package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;

@Deprecated
/* loaded from: classes4.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* renamed from: a, reason: collision with root package name */
    public static int f22164a = 1;

    public final synchronized int b() {
        int i2;
        try {
            i2 = f22164a;
            if (i2 == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
                int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, 12451000);
                if (iIsGooglePlayServicesAvailable == 0) {
                    i2 = 4;
                    f22164a = 4;
                } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, iIsGooglePlayServicesAvailable, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i2 = 2;
                    f22164a = 2;
                } else {
                    i2 = 3;
                    f22164a = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i2;
    }
}
