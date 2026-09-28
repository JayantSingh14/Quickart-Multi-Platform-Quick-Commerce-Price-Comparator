package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes4.dex */
final /* synthetic */ class zziy implements zzgqs {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f34978a;

    public /* synthetic */ zziy(Context context) {
        this.f34978a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgqs
    public final Object zza() {
        zzaap zzaapVar;
        Context context = this.f34978a;
        zzgtd zzgtdVar = zzaap.n;
        synchronized (zzaap.class) {
            try {
                if (zzaap.t == null) {
                    Context applicationContext = context == null ? null : context.getApplicationContext();
                    HashMap map = new HashMap(8);
                    map.put(0, 1000000L);
                    map.put(2, -9223372036854775807L);
                    map.put(3, -9223372036854775807L);
                    map.put(4, -9223372036854775807L);
                    map.put(5, -9223372036854775807L);
                    map.put(10, -9223372036854775807L);
                    map.put(9, -9223372036854775807L);
                    map.put(7, -9223372036854775807L);
                    zzaap.t = new zzaap(applicationContext, map);
                }
                zzaapVar = zzaap.t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaapVar;
    }
}
