package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzijg;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzbb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzay f21833a;

    public zzbb(zzay zzayVar) {
        this.f21833a = zzayVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzay zzayVar = this.f21833a;
        zzayVar.getClass();
        HashSet hashSet = new HashSet();
        hashSet.add(zzayVar.f21823a.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
