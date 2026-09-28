package com.zeptoconsumerapp.Startup;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.zeptoconsumerapp.FusedLocation.FusedLocationMain;
import com.zeptoconsumerapp.FusedLocation.LocationStatusTypes;
import com.zeptoconsumerapp.FusedLocation.LocationUtils;
import com.zeptoconsumerapp.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class AppInitializer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47548a;

    public AppInitializer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47548a = context;
    }

    public final void a() {
        Context context = this.f47548a;
        if (context != null) {
            try {
                boolean z = ContextCompat.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
                boolean zA = LocationUtils.a(context);
                if (z && zA) {
                    FusedLocationMain.f47427a = LocationStatusTypes.f47480d;
                } else if (z) {
                    FusedLocationMain.f47427a = LocationStatusTypes.f47479c;
                } else {
                    FusedLocationMain.f47427a = LocationStatusTypes.f47478b;
                }
            } catch (Exception e2) {
                Utils.i(e2);
            }
        }
        AppCoroutineManager.a(new AppInitializer$initializePostSuper$1(this, null));
    }
}
