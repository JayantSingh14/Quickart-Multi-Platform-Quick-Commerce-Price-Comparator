package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
final class zznn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpf f39502a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f39503b;

    public zznn(zzns zznsVar, zzpf zzpfVar, Runnable runnable) {
        this.f39502a = zzpfVar;
        this.f39503b = runnable;
        Objects.requireNonNull(zznsVar);
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzpf zzpfVar = this.f39502a;
        zzpfVar.A();
        zzpfVar.c().g();
        if (zzpfVar.p == null) {
            zzpfVar.p = new ArrayList();
        }
        zzpfVar.p.add(this.f39503b);
        zzpfVar.q();
    }
}
