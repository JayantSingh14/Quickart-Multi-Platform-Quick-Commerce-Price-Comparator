package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zzbr extends zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbs f36306a;

    public zzbr(zzbs zzbsVar) {
        this.f36306a = zzbsVar;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void o(String str) {
        zzbs zzbsVar = this.f36306a;
        if (str != null) {
            zzbsVar.setResult((zzbs) new zzbv(str));
        } else {
            zzbsVar.setResult((zzbs) new zzbv(new Status(3006)));
        }
    }
}
