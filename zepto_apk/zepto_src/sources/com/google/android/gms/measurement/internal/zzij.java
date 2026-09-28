package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzij implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39117a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39118b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39119c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzjc f39120d;

    public zzij(zzjc zzjcVar, String str, String str2, String str3) {
        this.f39117a = str;
        this.f39118b = str2;
        this.f39119c = str3;
        Objects.requireNonNull(zzjcVar);
        this.f39120d = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39120d;
        zzjcVar.f39177a.A();
        zzav zzavVar = zzjcVar.f39177a.f39596c;
        zzpf.S(zzavVar);
        return zzavVar.e0(this.f39117a, this.f39118b, this.f39119c);
    }
}
