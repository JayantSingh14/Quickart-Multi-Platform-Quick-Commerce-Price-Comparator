package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzaep implements zzaec {

    /* renamed from: a, reason: collision with root package name */
    public final zzaef f37463a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37464b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f37465c;

    /* renamed from: d, reason: collision with root package name */
    public final int f37466d;

    public zzaep(zzaef zzaefVar, String str, Object[] objArr) {
        this.f37463a = zzaefVar;
        this.f37464b = str;
        this.f37465c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f37466d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 1;
        int i4 = 13;
        while (true) {
            int i5 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.f37466d = i2 | (cCharAt2 << i4);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i3 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaec
    public final zzaef zza() {
        return this.f37463a;
    }

    @Override // com.google.android.gms.internal.pal.zzaec
    public final boolean zzb() {
        return (this.f37466d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.pal.zzaec
    public final int zzc() {
        return (this.f37466d & 1) == 1 ? 1 : 2;
    }
}
