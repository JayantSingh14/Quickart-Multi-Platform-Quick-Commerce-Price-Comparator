package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmk implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = com.google.android.gms.ads.internal.zzt.C.s;
        Context context = zzcirVar.getContext();
        synchronized (zzzVar) {
            zzzVar.f21396c = zzcirVar;
            if (!zzzVar.a(context)) {
                zzzVar.c("Unable to bind", "on_play_store_bind");
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("action", "fetch_completed");
            zzzVar.d("on_play_store_bind", map2);
        }
    }
}
