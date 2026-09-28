package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcrp implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcrs f26990a;

    public zzcrp(zzcrs zzcrsVar) {
        Objects.requireNonNull(zzcrsVar);
        this.f26990a = zzcrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcrs zzcrsVar = this.f26990a;
        zzcrsVar.getClass();
        if (map == null) {
            return;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(zzcrsVar.f26993a)) {
            return;
        }
        ((zzcdn) zzcrsVar.f26995c).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcro
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f26989a.f26990a.f26996d.b();
            }
        });
    }
}
