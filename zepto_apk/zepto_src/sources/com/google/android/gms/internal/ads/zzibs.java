package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzibs implements zzica {

    /* renamed from: a, reason: collision with root package name */
    public final zzica[] f34693a;

    public zzibs(zzica... zzicaVarArr) {
        this.f34693a = zzicaVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzica
    public final boolean zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f34693a[i2].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzica
    public final zzibz zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzica zzicaVar = this.f34693a[i2];
            if (zzicaVar.zzb(cls)) {
                return zzicaVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
