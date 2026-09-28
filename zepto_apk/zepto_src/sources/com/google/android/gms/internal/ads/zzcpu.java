package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzcpu implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f26873a;

    public zzcpu(com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f26873a = zzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) {
        boolean z = Boolean.parseBoolean((String) map.get("content_vertical_opted_out"));
        com.google.android.gms.ads.internal.util.zzj zzjVar = this.f26873a;
        zzjVar.d();
        synchronized (zzjVar.f21580a) {
            try {
                if (zzjVar.v == z) {
                    return;
                }
                zzjVar.v = z;
                SharedPreferences.Editor editor = zzjVar.f21586g;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    zzjVar.f21586g.apply();
                }
                zzjVar.e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
