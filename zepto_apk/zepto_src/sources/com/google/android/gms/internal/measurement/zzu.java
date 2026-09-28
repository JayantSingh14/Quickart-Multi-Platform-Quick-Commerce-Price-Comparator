package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzu extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final Callable f37320c;

    public zzu(Callable callable) {
        super("internal.appMetadata");
        this.f37320c = callable;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        try {
            return zzi.a(this.f37320c.call());
        } catch (Exception unused) {
            return zzao.o0;
        }
    }
}
