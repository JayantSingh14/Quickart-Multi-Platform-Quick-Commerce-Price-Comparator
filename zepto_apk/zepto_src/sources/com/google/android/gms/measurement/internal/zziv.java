package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zziv implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39150a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f39151b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39152c;

    public zziv(zzjc zzjcVar, zzr zzrVar, Bundle bundle) {
        this.f39150a = zzrVar;
        this.f39151b = bundle;
        this.f39152c = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws IOException {
        zzjc zzjcVar = this.f39152c;
        zzjcVar.f39177a.A();
        zzr zzrVar = this.f39150a;
        return zzjcVar.f39177a.b0(this.f39151b, zzrVar);
    }
}
