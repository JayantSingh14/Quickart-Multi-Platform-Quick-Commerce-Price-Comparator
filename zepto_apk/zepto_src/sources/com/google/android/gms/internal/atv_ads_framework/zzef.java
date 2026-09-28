package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzef implements zzem {

    /* renamed from: a, reason: collision with root package name */
    public final zzem[] f36148a;

    public zzef(zzem... zzemVarArr) {
        this.f36148a = zzemVarArr;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzem
    public final zzel zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzem zzemVar = this.f36148a[i2];
            if (zzemVar.zzc(cls)) {
                return zzemVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzem
    public final boolean zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f36148a[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
