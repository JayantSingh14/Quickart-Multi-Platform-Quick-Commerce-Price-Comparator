package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* loaded from: classes4.dex */
final class zzecv implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzecy f29080a;

    public zzecv(zzecy zzecyVar) {
        Objects.requireNonNull(zzecyVar);
        this.f29080a = zzecyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) throws NumberFormatException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R6)).booleanValue()) {
            Matcher matcher = zzecy.f29083h.matcher(th.getMessage());
            if (matcher.matches()) {
                int i2 = Integer.parseInt(matcher.group(1));
                zzegr zzegrVar = this.f29080a.f29088e;
                synchronized (zzegrVar.f29302g) {
                    zzegrVar.f29297b = i2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfic zzficVar = (zzfic) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R6)).booleanValue()) {
            zzecy zzecyVar = this.f29080a;
            zzfhu zzfhuVar = zzficVar.f31194b.f31190b;
            zzegr zzegrVar = zzecyVar.f29088e;
            int i2 = zzfhuVar.f31171f;
            synchronized (zzegrVar.f29302g) {
                zzegrVar.f29297b = i2;
            }
            zzegr zzegrVar2 = zzecyVar.f29088e;
            long j2 = zzfhuVar.f31172g;
            synchronized (zzegrVar2.f29303h) {
                zzegrVar2.f29298c = j2;
            }
        }
    }
}
