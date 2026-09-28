package com.google.android.gms.internal.measurement;

import android.os.Build;
import com.google.android.gms.common.api.Api;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public final class zzid extends zzme implements zznm {
    private static final zzid zzat;
    private int zzA;
    private String zzB;
    private String zzC;
    private boolean zzD;
    private zzmn zzE;
    private String zzF;
    private int zzG;
    private int zzH;
    private int zzI;
    private String zzJ;
    private long zzK;
    private long zzL;
    private String zzM;
    private String zzN;
    private int zzO;
    private String zzP;
    private zzig zzQ;
    private zzml zzR;
    private long zzS;
    private long zzT;
    private String zzU;
    private String zzV;
    private int zzW;
    private boolean zzX;
    private String zzY;
    private boolean zzZ;
    private zzhy zzaa;
    private String zzab;
    private zzmn zzac;
    private String zzad;
    private long zzae;
    private boolean zzaf;
    private String zzag;
    private boolean zzah;
    private String zzai;
    private int zzaj;
    private String zzak;
    private zzhe zzal;
    private int zzam;
    private zzha zzan;
    private String zzao;
    private zzis zzap;
    private long zzaq;
    private String zzar;
    private zzho zzas;
    private int zzb;
    private int zzd;
    private int zze;
    private zzmn zzf;
    private zzmn zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private int zzq;
    private String zzr;
    private String zzs;
    private String zzt;
    private long zzu;
    private long zzv;
    private String zzw;
    private boolean zzx;
    private String zzy;
    private long zzz;

    static {
        zzid zzidVar = new zzid();
        zzat = zzidVar;
        zzme.p(zzid.class, zzidVar);
    }

    public zzid() {
        zznu zznuVar = zznu.f37165e;
        this.zzf = zznuVar;
        this.zzg = zznuVar;
        this.zzm = "";
        this.zzn = "";
        this.zzo = "";
        this.zzp = "";
        this.zzr = "";
        this.zzs = "";
        this.zzt = "";
        this.zzw = "";
        this.zzy = "";
        this.zzB = "";
        this.zzC = "";
        this.zzE = zznuVar;
        this.zzF = "";
        this.zzJ = "";
        this.zzM = "";
        this.zzN = "";
        this.zzP = "";
        this.zzR = zzmf.f37109e;
        this.zzU = "";
        this.zzV = "";
        this.zzY = "";
        this.zzab = "";
        this.zzac = zznuVar;
        this.zzad = "";
        this.zzag = "";
        this.zzai = "";
        this.zzak = "";
        this.zzao = "";
        this.zzar = "";
    }

    public static zzic X() {
        return (zzic) zzat.l();
    }

    public static zzic Y(zzid zzidVar) {
        zzma zzmaVarL = zzat.l();
        zzmaVarL.m(zzidVar);
        return (zzic) zzmaVarL;
    }

    public final boolean A() {
        return this.zzx;
    }

    public final String A0() {
        return this.zzab;
    }

    public final /* synthetic */ void A1(long j2) {
        this.zzb |= 16384;
        this.zzu = j2;
    }

    public final String B() {
        return this.zzy;
    }

    public final boolean B0() {
        return (this.zzd & 32768) != 0;
    }

    public final /* synthetic */ void B1() {
        this.zzb |= 32768;
        this.zzv = 130000L;
    }

    public final boolean C() {
        return (this.zzb & 524288) != 0;
    }

    public final long C0() {
        return this.zzae;
    }

    public final /* synthetic */ void C1(String str) {
        str.getClass();
        this.zzb |= 65536;
        this.zzw = str;
    }

    public final long D() {
        return this.zzz;
    }

    public final boolean D0() {
        return this.zzaf;
    }

    public final /* synthetic */ void D1() {
        this.zzb &= -65537;
        this.zzw = zzat.zzw;
    }

    public final boolean E() {
        return (this.zzb & 1048576) != 0;
    }

    public final boolean E0() {
        return (this.zzd & 131072) != 0;
    }

    public final /* synthetic */ void E1(boolean z) {
        this.zzb |= 131072;
        this.zzx = z;
    }

    public final int F() {
        return this.zzA;
    }

    public final String F0() {
        return this.zzag;
    }

    public final /* synthetic */ void F1() {
        this.zzb &= -131073;
        this.zzx = false;
    }

    public final String G() {
        return this.zzB;
    }

    public final boolean G0() {
        return (this.zzd & 262144) != 0;
    }

    public final /* synthetic */ void G1(String str) {
        str.getClass();
        this.zzb |= 262144;
        this.zzy = str;
    }

    public final String H() {
        return this.zzC;
    }

    public final boolean H0() {
        return this.zzah;
    }

    public final /* synthetic */ void H1() {
        this.zzb &= -262145;
        this.zzy = zzat.zzy;
    }

    public final boolean I() {
        return (this.zzb & 8388608) != 0;
    }

    public final boolean I0() {
        return (this.zzd & 524288) != 0;
    }

    public final /* synthetic */ void I1(long j2) {
        this.zzb |= 524288;
        this.zzz = j2;
    }

    public final boolean J() {
        return this.zzD;
    }

    public final String J0() {
        return this.zzai;
    }

    public final /* synthetic */ void J1(int i2) {
        this.zzb |= 1048576;
        this.zzA = i2;
    }

    public final zzmn K() {
        return this.zzE;
    }

    public final int K0() {
        return this.zzaj;
    }

    public final /* synthetic */ void K1(String str) {
        this.zzb |= 2097152;
        this.zzB = str;
    }

    public final String L() {
        return this.zzF;
    }

    public final boolean L0() {
        return (this.zzd & 4194304) != 0;
    }

    public final /* synthetic */ void L1() {
        this.zzb &= -2097153;
        this.zzB = zzat.zzB;
    }

    public final boolean M() {
        return (this.zzb & 33554432) != 0;
    }

    public final zzhe M0() {
        zzhe zzheVar = this.zzal;
        return zzheVar == null ? zzhe.A() : zzheVar;
    }

    public final /* synthetic */ void M1(String str) {
        str.getClass();
        this.zzb |= 4194304;
        this.zzC = str;
    }

    public final int N() {
        return this.zzG;
    }

    public final boolean N0() {
        return (this.zzd & 8388608) != 0;
    }

    public final /* synthetic */ void N1() {
        this.zzb |= 8388608;
        this.zzD = false;
    }

    public final boolean O() {
        return (this.zzb & 536870912) != 0;
    }

    public final int O0() {
        return this.zzam;
    }

    public final void O1(ArrayList arrayList) {
        zzmn zzmnVar = this.zzE;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzE = zzmnVar.zzg(size + size);
        }
        zzkr.h(arrayList, this.zzE);
    }

    public final long P() {
        return this.zzK;
    }

    public final boolean P0() {
        return (this.zzd & 16777216) != 0;
    }

    public final void P1() {
        this.zzE = zznu.f37165e;
    }

    public final boolean Q() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final zzha Q0() {
        zzha zzhaVar = this.zzan;
        return zzhaVar == null ? zzha.T() : zzhaVar;
    }

    public final /* synthetic */ void Q1(String str) {
        str.getClass();
        this.zzb |= 16777216;
        this.zzF = str;
    }

    public final String R() {
        return this.zzM;
    }

    public final boolean R0() {
        return (this.zzd & 67108864) != 0;
    }

    public final /* synthetic */ void R1(int i2) {
        this.zzb |= 33554432;
        this.zzG = i2;
    }

    public final boolean S() {
        return (this.zzb & 1) != 0;
    }

    public final zzis S0() {
        zzis zzisVar = this.zzap;
        return zzisVar == null ? zzis.u() : zzisVar;
    }

    public final /* synthetic */ void S1() {
        this.zzb &= -268435457;
        this.zzJ = zzat.zzJ;
    }

    public final boolean T() {
        return (this.zzd & 134217728) != 0;
    }

    public final int T0() {
        return this.zze;
    }

    public final List T1() {
        return this.zzf;
    }

    public final long U() {
        return this.zzaq;
    }

    public final /* synthetic */ void U0(long j2) {
        this.zzb |= 536870912;
        this.zzK = j2;
    }

    public final void U1() {
        zzmn zzmnVar = this.zzf;
        if (zzmnVar.zza()) {
            return;
        }
        int size = zzmnVar.size();
        this.zzf = zzmnVar.zzg(size + size);
    }

    public final boolean V() {
        return (this.zzd & 536870912) != 0;
    }

    public final /* synthetic */ void V0(String str) {
        str.getClass();
        this.zzb |= Integer.MIN_VALUE;
        this.zzM = str;
    }

    public final void V1() {
        zzmn zzmnVar = this.zzg;
        if (zzmnVar.zza()) {
            return;
        }
        int size = zzmnVar.size();
        this.zzg = zzmnVar.zzg(size + size);
    }

    public final zzho W() {
        zzho zzhoVar = this.zzas;
        return zzhoVar == null ? zzho.u() : zzhoVar;
    }

    public final /* synthetic */ void W0() {
        this.zzb &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzM = zzat.zzM;
    }

    public final int W1() {
        return this.zzf.size();
    }

    public final /* synthetic */ void X0(int i2) {
        this.zzd |= 2;
        this.zzO = i2;
    }

    public final zzhs X1(int i2) {
        return (zzhs) this.zzf.get(i2);
    }

    public final /* synthetic */ void Y0(ArrayList arrayList) {
        zzml zzmlVar = this.zzR;
        if (!zzmlVar.zza()) {
            int size = zzmlVar.size();
            this.zzR = zzmlVar.zzg(size + size);
        }
        zzkr.h(arrayList, this.zzR);
    }

    public final zzmn Y1() {
        return this.zzg;
    }

    public final /* synthetic */ void Z() {
        this.zzb |= 1;
        this.zze = 1;
    }

    public final /* synthetic */ void Z0(long j2) {
        this.zzd |= 16;
        this.zzS = j2;
    }

    public final int Z1() {
        return this.zzg.size();
    }

    public final /* synthetic */ void a0(int i2, zzhs zzhsVar) {
        U1();
        this.zzf.set(i2, zzhsVar);
    }

    public final /* synthetic */ void a1(long j2) {
        this.zzd |= 32;
        this.zzT = j2;
    }

    public final zziu a2(int i2) {
        return (zziu) this.zzg.get(i2);
    }

    public final /* synthetic */ void b0(zzhs zzhsVar) {
        U1();
        this.zzf.add(zzhsVar);
    }

    public final /* synthetic */ void b1(String str) {
        this.zzd |= 128;
        this.zzV = str;
    }

    public final boolean b2() {
        return (this.zzb & 2) != 0;
    }

    public final /* synthetic */ void c0(List list) {
        U1();
        zzkr.h(list, this.zzf);
    }

    public final /* synthetic */ void c1(String str) {
        str.getClass();
        this.zzd |= KEYRecord.Flags.FLAG2;
        this.zzab = str;
    }

    public final long c2() {
        return this.zzh;
    }

    public final void d0() {
        this.zzf = zznu.f37165e;
    }

    public final /* synthetic */ void d1() {
        this.zzd &= -8193;
        this.zzab = zzat.zzab;
    }

    public final boolean d2() {
        return (this.zzb & 4) != 0;
    }

    public final /* synthetic */ void e0(int i2) {
        U1();
        this.zzf.remove(i2);
    }

    public final void e1(Set set) {
        zzmn zzmnVar = this.zzac;
        if (!zzmnVar.zza()) {
            int size = zzmnVar.size();
            this.zzac = zzmnVar.zzg(size + size);
        }
        zzkr.h(set, this.zzac);
    }

    public final long e2() {
        return this.zzi;
    }

    public final /* synthetic */ void f0(int i2, zziu zziuVar) {
        V1();
        this.zzg.set(i2, zziuVar);
    }

    public final /* synthetic */ void f1(String str) {
        str.getClass();
        this.zzd |= 16384;
        this.zzad = str;
    }

    public final boolean f2() {
        return (this.zzb & 8) != 0;
    }

    public final /* synthetic */ void g0(zziu zziuVar) {
        V1();
        this.zzg.add(zziuVar);
    }

    public final /* synthetic */ void g1(long j2) {
        this.zzd |= 32768;
        this.zzae = j2;
    }

    public final long g2() {
        return this.zzj;
    }

    public final /* synthetic */ void h0(int i2) {
        V1();
        this.zzg.remove(i2);
    }

    public final /* synthetic */ void h1(boolean z) {
        this.zzd |= 65536;
        this.zzaf = z;
    }

    public final boolean h2() {
        return (this.zzb & 16) != 0;
    }

    public final /* synthetic */ void i0(long j2) {
        this.zzb |= 2;
        this.zzh = j2;
    }

    public final /* synthetic */ void i1(String str) {
        this.zzd |= 131072;
        this.zzag = str;
    }

    public final long i2() {
        return this.zzk;
    }

    public final /* synthetic */ void j0() {
        this.zzb &= -3;
        this.zzh = 0L;
    }

    public final /* synthetic */ void j1(boolean z) {
        this.zzd |= 262144;
        this.zzah = z;
    }

    public final boolean j2() {
        return (this.zzb & 32) != 0;
    }

    public final /* synthetic */ void k0(long j2) {
        this.zzb |= 4;
        this.zzi = j2;
    }

    public final /* synthetic */ void k1(String str) {
        str.getClass();
        this.zzd |= 524288;
        this.zzai = str;
    }

    public final long k2() {
        return this.zzl;
    }

    public final /* synthetic */ void l0(long j2) {
        this.zzb |= 8;
        this.zzj = j2;
    }

    public final /* synthetic */ void l1(int i2) {
        this.zzd |= 1048576;
        this.zzaj = i2;
    }

    public final String l2() {
        return this.zzm;
    }

    public final /* synthetic */ void m0(long j2) {
        this.zzb |= 16;
        this.zzk = j2;
    }

    public final /* synthetic */ void m1(zzhe zzheVar) {
        this.zzal = zzheVar;
        this.zzd |= 4194304;
    }

    public final String m2() {
        return this.zzn;
    }

    public final /* synthetic */ void n0() {
        this.zzb &= -17;
        this.zzk = 0L;
    }

    public final /* synthetic */ void n1(int i2) {
        this.zzd |= 8388608;
        this.zzam = i2;
    }

    public final String n2() {
        return this.zzo;
    }

    public final /* synthetic */ void o0(long j2) {
        this.zzb |= 32;
        this.zzl = j2;
    }

    public final /* synthetic */ void o1(zzha zzhaVar) {
        this.zzan = zzhaVar;
        this.zzd |= 16777216;
    }

    public final String o2() {
        return this.zzp;
    }

    public final /* synthetic */ void p0() {
        this.zzb &= -33;
        this.zzl = 0L;
    }

    public final /* synthetic */ void p1(zzis zzisVar) {
        this.zzap = zzisVar;
        this.zzd |= 67108864;
    }

    public final boolean p2() {
        return (this.zzb & 1024) != 0;
    }

    public final /* synthetic */ void q0() {
        this.zzb |= 64;
        this.zzm = LogSubCategory.LifeCycle.ANDROID;
    }

    public final /* synthetic */ void q1(long j2) {
        this.zzd |= 134217728;
        this.zzaq = j2;
    }

    public final int q2() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zznv(zzat, "\u0004C\u0000\u0002\u0001VC\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<Vဉ=", new Object[]{"zzb", "zzd", "zze", "zzf", zzhs.class, "zzg", zziu.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzk", "zzD", "zzE", zzhg.class, "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", zzgw.f36960a, "zzX", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas"});
        }
        if (i3 == 3) {
            return new zzid();
        }
        if (i3 == 4) {
            return new zzic(zzat);
        }
        if (i3 == 5) {
            return zzat;
        }
        throw null;
    }

    public final /* synthetic */ void r0(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzn = str;
    }

    public final /* synthetic */ void r1() {
        this.zzd |= 268435456;
        this.zzar = "";
    }

    public final String r2() {
        return this.zzr;
    }

    public final String s() {
        return this.zzs;
    }

    public final boolean s0() {
        return (this.zzd & 2) != 0;
    }

    public final /* synthetic */ void s1(zzho zzhoVar) {
        this.zzas = zzhoVar;
        this.zzd |= 536870912;
    }

    public final String t() {
        return this.zzt;
    }

    public final int t0() {
        return this.zzO;
    }

    public final /* synthetic */ void t1() {
        String str = Build.MODEL;
        str.getClass();
        this.zzb |= 256;
        this.zzo = str;
    }

    public final boolean u() {
        return (this.zzb & 16384) != 0;
    }

    public final boolean u0() {
        return (this.zzd & 16) != 0;
    }

    public final /* synthetic */ void u1() {
        this.zzb &= -257;
        this.zzo = zzat.zzo;
    }

    public final long v() {
        return this.zzu;
    }

    public final long v0() {
        return this.zzS;
    }

    public final /* synthetic */ void v1(String str) {
        str.getClass();
        this.zzb |= 512;
        this.zzp = str;
    }

    public final boolean w() {
        return (this.zzb & 32768) != 0;
    }

    public final boolean w0() {
        return (this.zzd & 128) != 0;
    }

    public final /* synthetic */ void w1(int i2) {
        this.zzb |= 1024;
        this.zzq = i2;
    }

    public final long x() {
        return this.zzv;
    }

    public final String x0() {
        return this.zzV;
    }

    public final /* synthetic */ void x1(String str) {
        str.getClass();
        this.zzb |= 2048;
        this.zzr = str;
    }

    public final String y() {
        return this.zzw;
    }

    public final /* synthetic */ void y1(String str) {
        str.getClass();
        this.zzb |= 4096;
        this.zzs = str;
    }

    public final boolean z() {
        return (this.zzb & 131072) != 0;
    }

    public final boolean z0() {
        return (this.zzd & KEYRecord.Flags.FLAG2) != 0;
    }

    public final /* synthetic */ void z1(String str) {
        str.getClass();
        this.zzb |= KEYRecord.Flags.FLAG2;
        this.zzt = str;
    }
}
