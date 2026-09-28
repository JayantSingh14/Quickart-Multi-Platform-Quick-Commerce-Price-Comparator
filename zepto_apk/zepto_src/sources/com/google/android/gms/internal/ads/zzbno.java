package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbno implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzeak f25350a;

    public zzbno(zzeak zzeakVar) {
        Preconditions.checkNotNull(zzeakVar, "The Inspector Manager must not be null");
        this.f25350a = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        if (map == null || !map.containsKey("persistentData") || TextUtils.isEmpty((CharSequence) map.get("persistentData"))) {
            return;
        }
        zzeak zzeakVar = this.f25350a;
        String str = (String) map.get("persistentData");
        synchronized (zzeakVar) {
            zzeakVar.x = str;
            com.google.android.gms.ads.internal.zzt.C.f21684h.g().c(zzeakVar.x);
        }
    }
}
