package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31662a;

    public zzfqt(zzfqy zzfqyVar) {
        Objects.requireNonNull(zzfqyVar);
        this.f31662a = zzfqyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfqy zzfqyVar = this.f31662a;
        zzfqd zzfqdVar = zzfqyVar.r;
        if (zzfqdVar != null) {
            zzfqdVar.g("pae", "paeo_ts", zzfqyVar.s.currentTimeMillis(), zzfqyVar.f31671e.f21242d, 0, null, zzfqyVar.t, zzfqyVar.f());
        }
    }
}
