package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzelf implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzejj f29632a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29633b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzelg f29634c;

    public zzelf(zzelg zzelgVar, zzejj zzejjVar, zzfhr zzfhrVar) {
        this.f29632a = zzejjVar;
        this.f29633b = zzfhrVar;
        Objects.requireNonNull(zzelgVar);
        this.f29634c = zzelgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) throws zzdlg {
        zzfir zzfirVar;
        try {
            zzfji zzfjiVar = (zzfji) this.f29632a.f29463b;
            zzfjiVar.b(z);
            int i2 = this.f29634c.f29637c.f21402c;
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d1)).intValue();
            zzbtc zzbtcVar = zzfjiVar.f31270a;
            if (i2 < iIntValue) {
                try {
                    zzbtcVar.zzh();
                    return;
                } finally {
                }
            } else {
                try {
                    zzbtcVar.D2(new ObjectWrapper(context));
                    return;
                } finally {
                }
            }
        } catch (zzfir e2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Cannot show interstitial.");
            throw new zzdlg(e2.getCause());
        }
        int i32 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e("Cannot show interstitial.");
        throw new zzdlg(e2.getCause());
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29633b;
    }
}
