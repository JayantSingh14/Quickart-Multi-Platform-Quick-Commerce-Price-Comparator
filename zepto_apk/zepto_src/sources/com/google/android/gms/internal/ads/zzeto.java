package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzeto implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30297a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f30298b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30299c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30300d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f30301e;

    /* renamed from: f, reason: collision with root package name */
    public final String f30302f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcxo f30303g;

    public zzeto(Context context, Bundle bundle, String str, String str2, com.google.android.gms.ads.internal.util.zzj zzjVar, String str3, zzcxo zzcxoVar) {
        this.f30297a = context;
        this.f30298b = bundle;
        this.f30299c = str;
        this.f30300d = str2;
        this.f30301e = zzjVar;
        this.f30302f = str3;
        this.f30303g = zzcxoVar;
    }

    public final void a(Bundle bundle) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q6)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                bundle.putString("_app_id", com.google.android.gms.ads.internal.util.zzs.Q(this.f30297a));
            } catch (RemoteException | RuntimeException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("AppStatsSignal_AppId", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putBundle("quality_signals", this.f30298b);
        bundle.putString("seq_num", this.f30299c);
        if (!this.f30301e.q()) {
            bundle.putString("session_id", this.f30300d);
        }
        bundle.putBoolean("client_purpose_one", !r0.q());
        a(bundle);
        String str = this.f30302f;
        if (str != null) {
            Bundle bundle2 = new Bundle();
            zzcxo zzcxoVar = this.f30303g;
            Long l2 = (Long) zzcxoVar.f27362d.get(str);
            bundle2.putLong("dload", l2 == null ? -1L : l2.longValue());
            Integer num = (Integer) zzcxoVar.f27360b.get(str);
            bundle2.putInt("pcc", num == null ? 0 : num.intValue());
            bundle.putBundle("ad_unit_quality_signals", bundle2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sa)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            if (zztVar.f21684h.f25942l.get() > 0) {
                bundle.putInt("nrwv", zztVar.f21684h.f25942l.get());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        bundle.putBundle("quality_signals", this.f30298b);
        a(bundle);
    }
}
