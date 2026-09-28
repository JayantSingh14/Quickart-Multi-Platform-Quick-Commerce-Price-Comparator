package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzfo implements zzfv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfv[] f36363a;

    public zzfo(zzfv... zzfvVarArr) {
        this.f36363a = zzfvVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final zzfu zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzfv zzfvVar = this.f36363a[i2];
            if (zzfvVar.zzc(cls)) {
                return zzfvVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final boolean zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f36363a[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
