package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.xbill.DNS.TTL;

/* loaded from: classes.dex */
final class zzh {
    public Long A;
    public long B;
    public String C;
    public int D;
    public int E;
    public long F;
    public String G;
    public byte[] H;
    public int I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public String P;
    public boolean Q;
    public long R;
    public long S;

    /* renamed from: a, reason: collision with root package name */
    public final zzib f38983a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38984b;

    /* renamed from: c, reason: collision with root package name */
    public String f38985c;

    /* renamed from: d, reason: collision with root package name */
    public String f38986d;

    /* renamed from: e, reason: collision with root package name */
    public String f38987e;

    /* renamed from: f, reason: collision with root package name */
    public String f38988f;

    /* renamed from: g, reason: collision with root package name */
    public long f38989g;

    /* renamed from: h, reason: collision with root package name */
    public long f38990h;

    /* renamed from: i, reason: collision with root package name */
    public long f38991i;

    /* renamed from: j, reason: collision with root package name */
    public String f38992j;

    /* renamed from: k, reason: collision with root package name */
    public long f38993k;

    /* renamed from: l, reason: collision with root package name */
    public String f38994l;

    /* renamed from: m, reason: collision with root package name */
    public long f38995m;
    public long n;
    public boolean o;
    public boolean p;
    public Boolean q;
    public long r;
    public ArrayList s;
    public String t;
    public boolean u;
    public long v;
    public long w;
    public int x;
    public boolean y;
    public Long z;

    public zzh(zzib zzibVar, String str) {
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        this.f38983a = zzibVar;
        this.f38984b = str;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
    }

    public final void A(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.w != j2;
        this.w = j2;
    }

    public final void B(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.B != j2;
        this.B = j2;
    }

    public final String C() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.C;
    }

    public final String D() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38984b;
    }

    public final String E() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38985c;
    }

    public final void F(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.f38985c, str);
        this.f38985c = str;
    }

    public final String G() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38986d;
    }

    public final void H(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.Q |= true ^ Objects.equals(this.f38986d, str);
        this.f38986d = str;
    }

    public final void I(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.f38987e, str);
        this.f38987e = str;
    }

    public final String J() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38988f;
    }

    public final void K(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.f38988f, str);
        this.f38988f = str;
    }

    public final void L(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.f38990h != j2;
        this.f38990h = j2;
    }

    public final void M(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.f38991i != j2;
        this.f38991i = j2;
    }

    public final String N() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38992j;
    }

    public final void O(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.f38992j, str);
        this.f38992j = str;
    }

    public final long P() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.f38993k;
    }

    public final void Q(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.f38993k != j2;
        this.f38993k = j2;
    }

    public final void R(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.f38994l, str);
        this.f38994l = str;
    }

    public final void S(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.f38995m != j2;
        this.f38995m = j2;
    }

    public final void a(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.n != j2;
        this.n = j2;
    }

    public final long b() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.r;
    }

    public final void c(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.r != j2;
        this.r = j2;
    }

    public final void d(boolean z) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.o != z;
        this.o = z;
    }

    public final void e(long j2) {
        Preconditions.checkArgument(j2 >= 0);
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.f38989g != j2;
        this.f38989g = j2;
    }

    public final void f(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.R != j2;
        this.R = j2;
    }

    public final void g(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.S != j2;
        this.S = j2;
    }

    public final void h(long j2) {
        zzib zzibVar = this.f38983a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        long j3 = this.f38989g + j2;
        String str = this.f38984b;
        zzgt zzgtVar = zzibVar.f39089f;
        if (j3 > TTL.MAX_VALUE) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(zzgt.o(str), "Bundle index overflow. appId");
            j3 = (-1) + j2;
        }
        long j4 = this.F + 1;
        if (j4 > TTL.MAX_VALUE) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(zzgt.o(str), "Delivery index overflow. appId");
            j4 = 0;
        }
        this.Q = true;
        this.f38989g = j3;
        this.F = j4;
    }

    public final void i(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.J != j2;
        this.J = j2;
    }

    public final void j(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.K != j2;
        this.K = j2;
    }

    public final void k(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.L != j2;
        this.L = j2;
    }

    public final void l(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.M != j2;
        this.M = j2;
    }

    public final void m(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.O != j2;
        this.O = j2;
    }

    public final void n(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.N != j2;
        this.N = j2;
    }

    public final boolean o() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.Q;
    }

    public final void p(int i2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.D != i2;
        this.D = i2;
    }

    public final void q(int i2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.E != i2;
        this.E = i2;
    }

    public final void r(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.F != j2;
        this.F = j2;
    }

    public final String s() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.G;
    }

    public final int t() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.I;
    }

    public final String u() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        String str = this.P;
        v(null);
        return str;
    }

    public final void v(String str) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= !Objects.equals(this.P, str);
        this.P = str;
    }

    public final Boolean w() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.q;
    }

    public final void x(List list) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (Objects.equals(this.s, list)) {
            return;
        }
        this.Q = true;
        this.s = list != null ? new ArrayList(list) : null;
    }

    public final boolean y() {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        return this.u;
    }

    public final void z(long j2) {
        zzhy zzhyVar = this.f38983a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        this.Q |= this.v != j2;
        this.v = j2;
    }
}
