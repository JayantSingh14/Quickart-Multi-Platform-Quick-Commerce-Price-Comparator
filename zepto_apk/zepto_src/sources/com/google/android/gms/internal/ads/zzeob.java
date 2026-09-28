package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzeob implements zzeji {

    /* renamed from: a, reason: collision with root package name */
    public final zzepf f29942a;

    /* renamed from: b, reason: collision with root package name */
    public final zzduu f29943b;

    public zzeob(zzepf zzepfVar, zzduu zzduuVar) {
        this.f29942a = zzepfVar;
        this.f29943b = zzduuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeji
    public final zzejj a(String str, JSONObject jSONObject) {
        zzbuy zzbuyVarB;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z1)).booleanValue()) {
            try {
                zzbuyVarB = this.f29943b.b(str);
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Coundn't create RTB adapter: ", e2);
            }
        } else {
            ConcurrentHashMap concurrentHashMap = this.f29942a.f30025a;
            zzbuyVarB = concurrentHashMap.containsKey(str) ? (zzbuy) concurrentHashMap.get(str) : null;
        }
        if (zzbuyVarB == null) {
            return null;
        }
        return new zzejj(zzbuyVarB, new zzekv(), str);
    }
}
