package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzii implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39113a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39114b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39115c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzjc f39116d;

    public zzii(zzjc zzjcVar, String str, String str2, String str3) {
        this.f39113a = str;
        this.f39114b = str2;
        this.f39115c = str3;
        Objects.requireNonNull(zzjcVar);
        this.f39116d = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        zzjc zzjcVar = this.f39116d;
        zzjcVar.f39177a.A();
        zzav zzavVar = zzjcVar.f39177a.f39596c;
        zzpf.S(zzavVar);
        return zzavVar.e0(this.f39113a, this.f39114b, this.f39115c);
    }
}
