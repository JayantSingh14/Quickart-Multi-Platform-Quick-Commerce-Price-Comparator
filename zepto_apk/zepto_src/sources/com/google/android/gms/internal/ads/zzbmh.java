package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmh implements zzbnn {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        WindowManager windowManager = (WindowManager) zzcirVar.getContext().getSystemService("window");
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) zzcirVar).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        android.support.v4.media.b.z(iArr[1], map2, "yInPixels", i2, "windowWidthInPixels");
        map2.put("windowHeightInPixels", Integer.valueOf(i3));
        zzcirVar.g("locationReady", map2);
        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("GET LOCATION COMPILED");
    }
}
