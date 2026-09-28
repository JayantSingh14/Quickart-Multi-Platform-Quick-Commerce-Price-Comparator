package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Optional;

/* loaded from: classes4.dex */
public final class zzatf extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzatf(zzate zzateVar, zzatc zzatcVar, long j2) {
        Locale locale = Locale.US;
        Long lValueOf = Long.valueOf(j2);
        super(String.format(locale, zzatu.a("bk3t6gFTc30="), Long.valueOf(zzateVar.f24314a), Long.valueOf(zzatcVar.f24305a), lValueOf));
        Optional.of(zzatcVar);
        Optional.of(lValueOf);
    }

    public zzatf(zzate zzateVar, Exception exc) {
        super(String.format(Locale.US, zzatu.a("bk0="), Long.valueOf(zzateVar.f24314a)), exc);
        Optional.empty();
        Optional.empty();
    }
}
