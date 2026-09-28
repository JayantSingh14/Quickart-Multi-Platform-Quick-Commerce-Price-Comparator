package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzboi implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzeak f25389a;

    public zzboi(zzeak zzeakVar) {
        Preconditions.checkNotNull(zzeakVar, "The Inspector Manager must not be null");
        this.f25389a = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        long j2 = Long.MAX_VALUE;
        if (map.containsKey("expires")) {
            try {
                j2 = Long.parseLong((String) map.get("expires"));
            } catch (NumberFormatException unused) {
            }
        }
        zzeak zzeakVar = this.f25389a;
        String str = (String) map.get("extras");
        synchronized (zzeakVar) {
            zzeakVar.o = str;
            zzeakVar.q = j2;
            zzeakVar.m();
        }
    }
}
