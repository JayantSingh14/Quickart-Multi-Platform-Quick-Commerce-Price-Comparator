package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzis implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjc f39143a;

    public zzis(zzjc zzjcVar, zzbg zzbgVar, String str) {
        Objects.requireNonNull(zzjcVar);
        this.f39143a = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39143a;
        zzjcVar.f39177a.A();
        zzlo zzloVar = zzjcVar.f39177a.f39601h;
        zzpf.S(zzloVar);
        zzloVar.g();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
