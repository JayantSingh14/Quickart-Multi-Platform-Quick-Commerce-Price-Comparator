package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdsc implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzblc f28404a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdsp f28405b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f28406c;

    public zzdsc(zzdnw zzdnwVar, zzdnm zzdnmVar, zzdsp zzdspVar, zzija zzijaVar) {
        this.f28404a = (zzblc) zzdnwVar.f28064g.get(zzdnmVar.g());
        this.f28405b = zzdspVar;
        this.f28406c = zzijaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.f28404a.K7((zzbks) this.f28406c.zzb(), str);
        } catch (RemoteException e2) {
            String strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 40), "Failed to call onCustomClick for asset ", str, CLConstants.DOT_SALT_DELIMETER);
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g(strS, e2);
        }
    }
}
