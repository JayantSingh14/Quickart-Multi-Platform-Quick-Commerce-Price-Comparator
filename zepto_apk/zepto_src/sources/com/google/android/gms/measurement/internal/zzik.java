package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzik implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39121a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39122b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39123c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzjc f39124d;

    public zzik(zzjc zzjcVar, String str, String str2, String str3) {
        this.f39121a = str;
        this.f39122b = str2;
        this.f39123c = str3;
        Objects.requireNonNull(zzjcVar);
        this.f39124d = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39124d;
        zzjcVar.f39177a.A();
        zzav zzavVar = zzjcVar.f39177a.f39596c;
        zzpf.S(zzavVar);
        return zzavVar.i0(this.f39121a, this.f39122b, this.f39123c);
    }
}
