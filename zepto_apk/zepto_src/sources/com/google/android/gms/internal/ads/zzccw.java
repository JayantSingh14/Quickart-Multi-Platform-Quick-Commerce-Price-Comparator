package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzccw extends com.google.android.gms.ads.internal.util.zzb {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcda f25917b;

    public zzccw(zzcda zzcdaVar) {
        Objects.requireNonNull(zzcdaVar);
        this.f25917b = zzcdaVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void a() {
        zzcda zzcdaVar = this.f25917b;
        zzbgn zzbgnVar = new zzbgn(zzcdaVar.f25935e, zzcdaVar.f25936f.f21400a);
        synchronized (zzcdaVar.f25931a) {
            try {
                zzbgq zzbgqVar = com.google.android.gms.ads.internal.zzt.C.f21689m;
                zzbgq.a(zzcdaVar.f25938h, zzbgnVar);
            } catch (IllegalArgumentException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Cannot config CSI reporter.", e2);
            }
        }
    }
}
