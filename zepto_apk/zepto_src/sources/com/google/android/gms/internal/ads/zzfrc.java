package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfrc extends zzcal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgzf f31697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhi f31698b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfrd f31699c;

    public zzfrc(zzfrd zzfrdVar, zzgzf zzgzfVar, zzfhi zzfhiVar) {
        this.f31697a = zzgzfVar;
        this.f31698b = zzfhiVar;
        Objects.requireNonNull(zzfrdVar);
        this.f31699c = zzfrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.r().toString();
        zzfrd zzfrdVar = this.f31699c;
        String str = zzfrdVar.f31671e.f21239a;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 51 + String.valueOf(str).length());
        sb.append("Failed to load rewarded ad with error: ");
        sb.append(string);
        sb.append(", adUnitId: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        zzfrdVar.a(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zze() {
        Objects.requireNonNull(this.f31699c);
        this.f31697a.c(this.f31698b);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzf(int i2) {
    }
}
