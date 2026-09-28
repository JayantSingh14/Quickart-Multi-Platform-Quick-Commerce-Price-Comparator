package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzadw implements zzaed {

    /* renamed from: a, reason: collision with root package name */
    public final zzaed[] f37432a;

    public zzadw(zzaed... zzaedVarArr) {
        this.f37432a = zzaedVarArr;
    }

    @Override // com.google.android.gms.internal.pal.zzaed
    public final zzaec zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzaed zzaedVar = this.f37432a[i2];
            if (zzaedVar.zzc(cls)) {
                return zzaedVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.pal.zzaed
    public final boolean zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f37432a[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
