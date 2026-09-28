package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* loaded from: classes4.dex */
final class zzma {
    public static final zzwg t = new zzwg(-1, new Object());

    /* renamed from: a, reason: collision with root package name */
    public final zzbf f35179a;

    /* renamed from: b, reason: collision with root package name */
    public final zzwg f35180b;

    /* renamed from: c, reason: collision with root package name */
    public final long f35181c;

    /* renamed from: d, reason: collision with root package name */
    public final long f35182d;

    /* renamed from: e, reason: collision with root package name */
    public final int f35183e;

    /* renamed from: f, reason: collision with root package name */
    public final zzit f35184f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35185g;

    /* renamed from: h, reason: collision with root package name */
    public final zzyh f35186h;

    /* renamed from: i, reason: collision with root package name */
    public final zzaae f35187i;

    /* renamed from: j, reason: collision with root package name */
    public final List f35188j;

    /* renamed from: k, reason: collision with root package name */
    public final zzwg f35189k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f35190l;

    /* renamed from: m, reason: collision with root package name */
    public final int f35191m;
    public final int n;
    public final zzav o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public volatile long s;

    public zzma(zzbf zzbfVar, zzwg zzwgVar, long j2, long j3, int i2, zzit zzitVar, boolean z, zzyh zzyhVar, zzaae zzaaeVar, List list, zzwg zzwgVar2, boolean z2, int i3, int i4, zzav zzavVar, long j4, long j5, long j6, long j7) {
        this.f35179a = zzbfVar;
        this.f35180b = zzwgVar;
        this.f35181c = j2;
        this.f35182d = j3;
        this.f35183e = i2;
        this.f35184f = zzitVar;
        this.f35185g = z;
        this.f35186h = zzyhVar;
        this.f35187i = zzaaeVar;
        this.f35188j = list;
        this.f35189k = zzwgVar2;
        this.f35190l = z2;
        this.f35191m = i3;
        this.n = i4;
        this.o = zzavVar;
        this.p = j4;
        this.q = j5;
        this.r = j6;
        this.s = j7;
    }

    public static zzma a(zzaae zzaaeVar) {
        zzbf zzbfVar = zzbf.f24868a;
        zzwg zzwgVar = t;
        return new zzma(zzbfVar, zzwgVar, -9223372036854775807L, 0L, 1, null, false, zzyh.f35904d, zzaaeVar, zzguy.f33232e, zzwgVar, false, 1, 0, zzav.f24411d, 0L, 0L, 0L, 0L);
    }

    public final zzma b(zzwg zzwgVar, long j2, long j3, long j4, long j5, zzyh zzyhVar, zzaae zzaaeVar, List list) {
        zzwg zzwgVar2 = this.f35189k;
        boolean z = this.f35190l;
        int i2 = this.f35191m;
        int i3 = this.n;
        zzav zzavVar = this.o;
        long j6 = this.p;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzma(this.f35179a, zzwgVar, j3, j4, this.f35183e, this.f35184f, this.f35185g, zzyhVar, zzaaeVar, list, zzwgVar2, z, i2, i3, zzavVar, j6, j5, j2, jElapsedRealtime);
    }

    public final zzma c(zzbf zzbfVar) {
        return new zzma(zzbfVar, this.f35180b, this.f35181c, this.f35182d, this.f35183e, this.f35184f, this.f35185g, this.f35186h, this.f35187i, this.f35188j, this.f35189k, this.f35190l, this.f35191m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public final zzma d(int i2) {
        return new zzma(this.f35179a, this.f35180b, this.f35181c, this.f35182d, i2, this.f35184f, this.f35185g, this.f35186h, this.f35187i, this.f35188j, this.f35189k, this.f35190l, this.f35191m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public final zzma e(zzit zzitVar) {
        return new zzma(this.f35179a, this.f35180b, this.f35181c, this.f35182d, this.f35183e, zzitVar, this.f35185g, this.f35186h, this.f35187i, this.f35188j, this.f35189k, this.f35190l, this.f35191m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public final zzma f(boolean z) {
        return new zzma(this.f35179a, this.f35180b, this.f35181c, this.f35182d, this.f35183e, this.f35184f, z, this.f35186h, this.f35187i, this.f35188j, this.f35189k, this.f35190l, this.f35191m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public final zzma g(zzwg zzwgVar) {
        return new zzma(this.f35179a, this.f35180b, this.f35181c, this.f35182d, this.f35183e, this.f35184f, this.f35185g, this.f35186h, this.f35187i, this.f35188j, zzwgVar, this.f35190l, this.f35191m, this.n, this.o, this.p, this.q, this.r, this.s);
    }

    public final zzma h(int i2, int i3, boolean z) {
        return new zzma(this.f35179a, this.f35180b, this.f35181c, this.f35182d, this.f35183e, this.f35184f, this.f35185g, this.f35186h, this.f35187i, this.f35188j, this.f35189k, z, i2, i3, this.o, this.p, this.q, this.r, this.s);
    }

    public final boolean i() {
        return this.f35183e == 3 && this.f35190l && this.n == 0;
    }
}
