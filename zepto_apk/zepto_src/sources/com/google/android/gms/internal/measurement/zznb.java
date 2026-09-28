package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zznb implements zznj {

    /* renamed from: a, reason: collision with root package name */
    public final zznj[] f37134a;

    public zznb(zznj... zznjVarArr) {
        this.f37134a = zznjVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f37134a[i2].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zznj zznjVar = this.f37134a[i2];
            if (zznjVar.zzb(cls)) {
                return zznjVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
