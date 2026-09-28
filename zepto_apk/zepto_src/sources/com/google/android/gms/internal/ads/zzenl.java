package com.google.android.gms.internal.ads;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzenl implements zzeji {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f29879a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final zzduu f29880b;

    public zzenl(zzduu zzduuVar) {
        this.f29880b = zzduuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeji
    public final zzejj a(String str, JSONObject jSONObject) {
        zzejj zzejjVar;
        synchronized (this) {
            try {
                HashMap map = this.f29879a;
                zzejjVar = (zzejj) map.get(str);
                if (zzejjVar == null) {
                    zzejjVar = new zzejj(this.f29880b.a(str, jSONObject), new zzekw(), str);
                    map.put(str, zzejjVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzejjVar;
    }
}
