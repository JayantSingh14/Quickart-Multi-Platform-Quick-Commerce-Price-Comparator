package com.google.android.gms.ads.internal.util;

import android.os.Process;
import android.webkit.CookieManager;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzcir;
import com.google.android.gms.internal.ads.zzcjc;
import com.google.android.gms.internal.ads.zzcjn;
import com.google.android.gms.internal.ads.zzckf;
import com.google.android.gms.internal.ads.zzeif;

/* loaded from: classes4.dex */
public class zzt extends zzz {
    public final CookieManager h() {
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zzs zzsVar = zztVar.f21679c;
        int iMyUid = Process.myUid();
        if (iMyUid == 0 || iMyUid == 1000) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to obtain CookieManager.", th);
            zztVar.f21684h.e("ApiLevelUtil.getCookieManager", th);
            return null;
        }
    }

    public zzcjc i(zzcir zzcirVar, zzbfj zzbfjVar, boolean z, zzeif zzeifVar) {
        return new zzckf((zzcjn) zzcirVar, zzbfjVar, z, zzeifVar);
    }
}
