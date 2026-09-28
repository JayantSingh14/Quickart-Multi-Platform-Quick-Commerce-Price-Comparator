package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzdir;
import com.google.android.gms.internal.ads.zzdxe;

/* loaded from: classes4.dex */
public final class zzn {
    public static final void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z, zzdxe zzdxeVar) {
        if (adOverlayInfoParcel.f21324k == 4 && adOverlayInfoParcel.f21316c == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.f21315b;
            if (zzaVar != null) {
                zzaVar.h();
            }
            zzdir zzdirVar = adOverlayInfoParcel.u;
            if (zzdirVar != null) {
                zzdirVar.S();
            }
            Activity activityZzj = adOverlayInfoParcel.f21317d.zzj();
            zzc zzcVar = adOverlayInfoParcel.f21314a;
            Context context2 = (zzcVar == null || !zzcVar.f21345j || activityZzj == null) ? context : activityZzj;
            zza zzaVar2 = com.google.android.gms.ads.internal.zzt.C.f21677a;
            zza.b(context2, zzcVar, adOverlayInfoParcel.f21322i, zzcVar != null ? zzcVar.f21344i : null, zzdxeVar, adOverlayInfoParcel.q);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f21326m.f21403d);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.le)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            com.google.android.gms.ads.internal.util.zzs.v(context, intent, zzdxeVar, adOverlayInfoParcel.q);
        } else {
            com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzt.C.f21679c;
            com.google.android.gms.ads.internal.util.zzs.t(context, intent);
        }
    }
}
