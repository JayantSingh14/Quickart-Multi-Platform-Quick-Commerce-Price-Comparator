package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajd extends zzaee implements zzajk {

    /* renamed from: g, reason: collision with root package name */
    public final long f23260g;

    /* renamed from: h, reason: collision with root package name */
    public final int f23261h;

    /* renamed from: i, reason: collision with root package name */
    public final int f23262i;

    /* renamed from: j, reason: collision with root package name */
    public final long f23263j;

    public zzajd(int i2, int i3, long j2, long j3) {
        super(i2, i3, j2, j3);
        this.f23260g = j3;
        this.f23261h = i2;
        this.f23262i = i3;
        this.f23263j = j2 != -1 ? j2 : -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long a(long j2) {
        return (Math.max(0L, j2 - this.f22864b) * 8000000) / this.f22867e;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final long zzf() {
        return this.f23263j;
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final int zzg() {
        return this.f23261h;
    }
}
