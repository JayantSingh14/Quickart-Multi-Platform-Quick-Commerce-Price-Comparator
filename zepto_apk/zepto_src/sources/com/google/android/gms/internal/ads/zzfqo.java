package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31653a;

    public zzfqo(zzfqy zzfqyVar) {
        Objects.requireNonNull(zzfqyVar);
        this.f31653a = zzfqyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f31653a.r();
    }
}
