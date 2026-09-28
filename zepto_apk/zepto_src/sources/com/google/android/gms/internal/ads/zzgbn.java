package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgbn implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f32227a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32228b;

    public zzgbn(long j2, Runnable runnable) {
        this.f32227a = runnable;
        this.f32228b = j2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.f32228b, ((zzgbn) obj).f32228b);
    }
}
