package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzbe {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f24822m = new Object();
    public static final zzak n;

    /* renamed from: a, reason: collision with root package name */
    public Object f24823a = f24822m;

    /* renamed from: b, reason: collision with root package name */
    public zzak f24824b = n;

    /* renamed from: c, reason: collision with root package name */
    public long f24825c;

    /* renamed from: d, reason: collision with root package name */
    public long f24826d;

    /* renamed from: e, reason: collision with root package name */
    public long f24827e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f24828f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24829g;

    /* renamed from: h, reason: collision with root package name */
    public zzaf f24830h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f24831i;

    /* renamed from: j, reason: collision with root package name */
    public long f24832j;

    /* renamed from: k, reason: collision with root package name */
    public int f24833k;

    /* renamed from: l, reason: collision with root package name */
    public int f24834l;

    static {
        zzz zzzVar = new zzz();
        zzzVar.f35941a = "androidx.media3.common.Timeline";
        zzzVar.f35942b = Uri.EMPTY;
        n = zzzVar.a();
        String str = zzfj.f31254a;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final void a(zzak zzakVar, boolean z, boolean z2, zzaf zzafVar, long j2) {
        this.f24823a = f24822m;
        if (zzakVar == null) {
            zzakVar = n;
        }
        this.f24824b = zzakVar;
        this.f24825c = -9223372036854775807L;
        this.f24826d = -9223372036854775807L;
        this.f24827e = -9223372036854775807L;
        this.f24828f = z;
        this.f24829g = z2;
        this.f24830h = zzafVar;
        this.f24832j = j2;
        this.f24833k = 0;
        this.f24834l = 0;
        this.f24831i = false;
    }

    public final boolean b() {
        return this.f24830h != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !zzbe.class.equals(obj.getClass())) {
            return false;
        }
        zzbe zzbeVar = (zzbe) obj;
        return Objects.equals(this.f24823a, zzbeVar.f24823a) && Objects.equals(this.f24824b, zzbeVar.f24824b) && Objects.equals(this.f24830h, zzbeVar.f24830h) && this.f24825c == zzbeVar.f24825c && this.f24826d == zzbeVar.f24826d && this.f24827e == zzbeVar.f24827e && this.f24828f == zzbeVar.f24828f && this.f24829g == zzbeVar.f24829g && this.f24831i == zzbeVar.f24831i && this.f24832j == zzbeVar.f24832j && this.f24833k == zzbeVar.f24833k && this.f24834l == zzbeVar.f24834l;
    }

    public final int hashCode() {
        int iHashCode = ((this.f24823a.hashCode() + 217) * 31) + this.f24824b.hashCode();
        zzaf zzafVar = this.f24830h;
        int iHashCode2 = ((iHashCode * 961) + (zzafVar == null ? 0 : zzafVar.hashCode())) * 31;
        long j2 = this.f24825c;
        int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f24826d;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f24827e;
        int i4 = ((((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f24828f ? 1 : 0)) * 31) + (this.f24829g ? 1 : 0)) * 31) + (this.f24831i ? 1 : 0);
        long j5 = this.f24832j;
        return ((((((i4 * 961) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f24833k) * 31) + this.f24834l) * 31;
    }
}
