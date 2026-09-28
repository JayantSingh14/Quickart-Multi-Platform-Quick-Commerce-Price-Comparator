package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzic implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39097a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39098b;

    public zzic(zzjc zzjcVar, String str) {
        this.f39097a = str;
        Objects.requireNonNull(zzjcVar);
        this.f39098b = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39098b;
        zzjcVar.f39177a.A();
        zzav zzavVar = zzjcVar.f39177a.f39596c;
        zzpf.S(zzavVar);
        return zzavVar.d0(this.f39097a);
    }
}
