package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzil implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39125a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39126b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39127c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzjc f39128d;

    public zzil(zzjc zzjcVar, String str, String str2, String str3) {
        this.f39125a = str;
        this.f39126b = str2;
        this.f39127c = str3;
        Objects.requireNonNull(zzjcVar);
        this.f39128d = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39128d;
        zzjcVar.f39177a.A();
        zzav zzavVar = zzjcVar.f39177a.f39596c;
        zzpf.S(zzavVar);
        return zzavVar.i0(this.f39125a, this.f39126b, this.f39127c);
    }
}
