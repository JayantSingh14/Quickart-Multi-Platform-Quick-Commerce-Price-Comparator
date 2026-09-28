package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzann implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f23771a;

    /* renamed from: b, reason: collision with root package name */
    public final zzani f23772b;

    public zzann(int i2, zzani zzaniVar) {
        this.f23771a = i2;
        this.f23772b = zzaniVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.f23771a, ((zzann) obj).f23771a);
    }
}
