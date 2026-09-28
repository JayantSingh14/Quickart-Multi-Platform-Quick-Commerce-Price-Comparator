package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* loaded from: classes4.dex */
final class zzgzl extends zzgyd implements RunnableFuture {

    /* renamed from: h, reason: collision with root package name */
    public volatile zzgyt f33403h;

    public zzgzl(Callable callable) {
        this.f33403h = new zzgzk(this, callable);
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void e() {
        zzgyt zzgytVar;
        if (l() && (zzgytVar = this.f33403h) != null) {
            zzgytVar.g();
        }
        this.f33403h = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        zzgyt zzgytVar = this.f33403h;
        if (zzgytVar == null) {
            return super.f();
        }
        String string = zzgytVar.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 7), "task=[", string, "]");
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgyt zzgytVar = this.f33403h;
        if (zzgytVar != null) {
            zzgytVar.run();
        }
        this.f33403h = null;
    }
}
