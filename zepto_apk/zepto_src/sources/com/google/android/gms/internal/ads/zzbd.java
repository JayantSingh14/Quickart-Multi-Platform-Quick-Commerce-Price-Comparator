package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzbd {

    /* renamed from: a, reason: collision with root package name */
    public Integer f24737a;

    /* renamed from: b, reason: collision with root package name */
    public Object f24738b;

    /* renamed from: c, reason: collision with root package name */
    public int f24739c;

    /* renamed from: d, reason: collision with root package name */
    public long f24740d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f24741e;

    /* renamed from: f, reason: collision with root package name */
    public zzc f24742f = zzc.f25783b;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public final void a(Integer num, Object obj, int i2, long j2, boolean z) {
        zzc zzcVar = zzc.f25783b;
        this.f24737a = num;
        this.f24738b = obj;
        this.f24739c = i2;
        this.f24740d = j2;
        this.f24742f = zzcVar;
        this.f24741e = z;
    }

    public final long b(int i2, int i3) {
        zza zzaVarA = this.f24742f.a(i2);
        if (zzaVarA.f22569a != -1) {
            return zzaVarA.f22573e[i3];
        }
        return -9223372036854775807L;
    }

    public final void c(int i2) {
        this.f24742f.a(i2).getClass();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !zzbd.class.equals(obj.getClass())) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return Objects.equals(this.f24737a, zzbdVar.f24737a) && Objects.equals(this.f24738b, zzbdVar.f24738b) && this.f24739c == zzbdVar.f24739c && this.f24740d == zzbdVar.f24740d && this.f24741e == zzbdVar.f24741e && Objects.equals(this.f24742f, zzbdVar.f24742f);
    }

    public final int hashCode() {
        Integer num = this.f24737a;
        int iHashCode = num == null ? 0 : num.hashCode();
        Object obj = this.f24738b;
        int iHashCode2 = ((((iHashCode + 217) * 31) + (obj != null ? obj.hashCode() : 0)) * 31) + this.f24739c;
        long j2 = this.f24740d;
        return this.f24742f.hashCode() + (((((iHashCode2 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 961) + (this.f24741e ? 1 : 0)) * 31);
    }
}
