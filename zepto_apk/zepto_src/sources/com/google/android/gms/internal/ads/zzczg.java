package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzczg implements zzdby, zzdbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhr f27460a;

    public zzczg(zzfhr zzfhrVar) {
        this.f27460a = zzfhrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void P(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void S(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void a(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        zzbxe zzbxeVar = this.f27460a.d0;
        if (zzbxeVar == null || !zzbxeVar.f25662a) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str = zzbxeVar.f25663b;
        if (str.isEmpty()) {
            return;
        }
        arrayList.add(str);
    }
}
