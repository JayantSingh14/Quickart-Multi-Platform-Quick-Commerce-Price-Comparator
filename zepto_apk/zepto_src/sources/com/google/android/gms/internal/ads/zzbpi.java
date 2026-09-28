package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbpi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbpl f25405a;

    public zzbpi(zzbpl zzbplVar) {
        Objects.requireNonNull(zzbplVar);
        this.f25405a = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpl zzbplVar = this.f25405a;
        if (zzbplVar.f25409a == null) {
            return;
        }
        zzbplVar.f25409a.disconnect();
        Binder.flushPendingCommands();
    }
}
