package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zziu implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39147a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f39148b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39149c;

    public zziu(zzjc zzjcVar, zzr zzrVar, Bundle bundle) {
        this.f39147a = zzrVar;
        this.f39148b = bundle;
        this.f39149c = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws IOException {
        zzjc zzjcVar = this.f39149c;
        zzjcVar.f39177a.A();
        zzr zzrVar = this.f39147a;
        return zzjcVar.f39177a.b0(this.f39148b, zzrVar);
    }
}
