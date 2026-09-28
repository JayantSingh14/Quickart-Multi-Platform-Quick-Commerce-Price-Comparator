package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzcps implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f26871a;

    public zzcps(com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f26871a = zzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) {
        boolean z = Boolean.parseBoolean((String) map.get("content_url_opted_out"));
        com.google.android.gms.ads.internal.util.zzj zzjVar = this.f26871a;
        zzjVar.d();
        synchronized (zzjVar.f21580a) {
            try {
                if (zzjVar.u == z) {
                    return;
                }
                zzjVar.u = z;
                SharedPreferences.Editor editor = zzjVar.f21586g;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    zzjVar.f21586g.apply();
                }
                zzjVar.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
