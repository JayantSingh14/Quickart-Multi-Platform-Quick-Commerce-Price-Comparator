package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzijg;
import com.google.android.gms.internal.ads.zzijo;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzba implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzay f21832a;

    public zzba(zzay zzayVar) {
        this.f21832a = zzayVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        String lowerCase = this.f21832a.f21823a.toLowerCase(Locale.ROOT);
        zzijo.a(lowerCase);
        return lowerCase;
    }
}
