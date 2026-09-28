package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzsv implements zzrc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzsw f35552a;

    public /* synthetic */ zzsv(zzsw zzswVar) {
        Objects.requireNonNull(zzswVar);
        this.f35552a = zzswVar;
    }

    public final void a(final Exception exc) {
        zzee.f("MediaCodecAudioRenderer", "Audio sink error", exc);
        final zzqx zzqxVar = this.f35552a.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable(exc) { // from class: com.google.android.gms.internal.ads.zzqt
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = this.f35413a;
                    zzqxVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1014, new zzmz());
                }
            });
        }
    }
}
