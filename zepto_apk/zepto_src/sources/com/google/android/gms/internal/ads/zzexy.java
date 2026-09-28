package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzexy implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfik f30552a;

    /* renamed from: b, reason: collision with root package name */
    public final PackageInfo f30553b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f30554c;

    public zzexy(zzfik zzfikVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f30552a = zzfikVar;
        this.f30553b = packageInfo;
        this.f30554c = zzjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0141  */
    @Override // com.google.android.gms.internal.ads.zzezv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzexy.zza(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zzb(Object obj) {
        int i2;
        zzfik zzfikVar = this.f30552a;
        ArrayList arrayList = zzfikVar.f31220h;
        zzczm zzczmVar = (zzczm) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Bundle bundle = zzczmVar.f27482b;
        zzbjn zzbjnVar = zzfikVar.f31222j;
        if (zzbjnVar == null || (i2 = zzbjnVar.f25257i) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbjnVar.f25258j);
        bundle.putInt("sccg_dir", i2);
    }
}
