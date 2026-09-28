package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
final class zzele implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhr f29628a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbuy f29629b;

    /* renamed from: c, reason: collision with root package name */
    public final AdFormat f29630c;

    /* renamed from: d, reason: collision with root package name */
    public zzdbc f29631d = null;

    public zzele(zzfhr zzfhrVar, zzbuy zzbuyVar, AdFormat adFormat) {
        this.f29628a = zzfhrVar;
        this.f29629b = zzbuyVar;
        this.f29630c = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) throws zzdlg {
        boolean zO0;
        try {
            int iOrdinal = this.f29630c.ordinal();
            zzbuy zzbuyVar = this.f29629b;
            if (iOrdinal == 1) {
                zO0 = zzbuyVar.O0(new ObjectWrapper(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zO0 = zzbuyVar.S(new ObjectWrapper(context));
                    }
                    throw new zzdlg("Adapter failed to show.");
                }
                zO0 = zzbuyVar.G0(new ObjectWrapper(context));
            }
            if (zO0) {
                zzdbc zzdbcVar = this.f29631d;
                if (zzdbcVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R1)).booleanValue() || this.f29628a.Y != 2) {
                    return;
                }
                zzdbcVar.g();
                return;
            }
            throw new zzdlg("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdlg(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29628a;
    }
}
