package com.google.android.gms.internal.pal;

import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzaf extends zzacz implements zzaeg {
    private static final zzaf zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzG;
    private long zzH;
    private long zzI;
    private long zzK;
    private zzah zzN;
    private zzadf zzaA;
    private int zzaB;
    private zzadf zzaC;
    private zzaa zzaD;
    private String zzaE;
    private long zzaF;
    private long zzaG;
    private long zzaH;
    private long zzaI;
    private long zzaJ;
    private long zzaK;
    private String zzaL;
    private long zzaM;
    private String zzaN;
    private int zzaO;
    private boolean zzaP;
    private String zzaQ;
    private long zzaR;
    private zzaq zzaS;
    private long zzaT;
    private String zzaU;
    private zzac zzaf;
    private zzadf zzag;
    private zzae zzah;
    private long zzai;
    private long zzaj;
    private long zzak;
    private long zzal;
    private long zzam;
    private long zzan;
    private long zzao;
    private long zzap;
    private String zzaq;
    private long zzar;
    private int zzas;
    private int zzat;
    private int zzau;
    private zzas zzav;
    private long zzaw;
    private int zzax;
    private int zzay;
    private String zzaz;
    private int zze;
    private int zzf;
    private int zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zzh = "";
    private String zzi = "";
    private String zzt = "";
    private String zzD = "";
    private String zzE = "D";
    private String zzF = "";
    private String zzJ = "";
    private long zzL = -1;
    private long zzM = -1;
    private long zzO = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private String zzU = "D";
    private String zzV = "D";
    private long zzW = -1;
    private int zzX = 1000;
    private int zzY = 1000;
    private long zzZ = -1;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private int zzae = 1000;

    static {
        zzaf zzafVar = new zzaf();
        zzb = zzafVar;
        zzacz.h(zzaf.class, zzafVar);
    }

    public zzaf() {
        zzaeo zzaeoVar = zzaeo.f37460d;
        this.zzag = zzaeoVar;
        this.zzai = -1L;
        this.zzaj = -1L;
        this.zzak = -1L;
        this.zzal = -1L;
        this.zzam = -1L;
        this.zzan = -1L;
        this.zzao = -1L;
        this.zzap = -1L;
        this.zzaq = "D";
        this.zzar = -1L;
        this.zzaw = -1L;
        this.zzax = 1000;
        this.zzay = 1000;
        this.zzaz = "D";
        this.zzaA = zzaeoVar;
        this.zzaB = 1000;
        this.zzaC = zzaeoVar;
        this.zzaE = "";
        this.zzaF = -1L;
        this.zzaG = -1L;
        this.zzaH = -1L;
        this.zzaI = -1L;
        this.zzaK = -1L;
        this.zzaL = "";
        this.zzaN = "";
        this.zzaO = 2;
        this.zzaQ = "";
        this.zzaU = "";
    }

    public static /* synthetic */ void A(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 4096;
        zzafVar.zzZ = j2;
    }

    public static /* synthetic */ void A0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 33554432;
        zzafVar.zzG = j2;
    }

    public static /* synthetic */ void B0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 67108864;
        zzafVar.zzH = j2;
    }

    public static /* synthetic */ void C(zzaf zzafVar, long j2) {
        zzafVar.zzf |= KEYRecord.Flags.FLAG2;
        zzafVar.zzaa = j2;
    }

    public static /* synthetic */ void C0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 134217728;
        zzafVar.zzI = j2;
    }

    public static /* synthetic */ void D(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 16384;
        zzafVar.zzab = j2;
    }

    public static /* synthetic */ void D0(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zze |= 268435456;
        zzafVar.zzJ = str;
    }

    public static /* synthetic */ void E(zzaf zzafVar, zzac zzacVar) {
        zzafVar.zzaf = zzacVar;
        zzafVar.zzf |= 262144;
    }

    public static /* synthetic */ void G(zzaf zzafVar, zzac zzacVar) {
        zzadf zzadfVar = zzafVar.zzag;
        if (!zzadfVar.zzc()) {
            zzafVar.zzag = zzacz.d(zzadfVar);
        }
        zzafVar.zzag.add(zzacVar);
    }

    public static void H(zzaf zzafVar) {
        zzafVar.zzag = zzaeo.f37460d;
    }

    public static /* synthetic */ void I(zzaf zzafVar, zzae zzaeVar) {
        zzafVar.zzah = zzaeVar;
        zzafVar.zzf |= 524288;
    }

    public static /* synthetic */ void J(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 2097152;
        zzafVar.zzaj = j2;
    }

    public static /* synthetic */ void K(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 4194304;
        zzafVar.zzak = j2;
    }

    public static /* synthetic */ void L(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 8388608;
        zzafVar.zzal = j2;
    }

    public static /* synthetic */ void M(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 67108864;
        zzafVar.zzao = j2;
    }

    public static /* synthetic */ void N(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 134217728;
        zzafVar.zzap = j2;
    }

    public static /* synthetic */ void O(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zzf |= 268435456;
        zzafVar.zzaq = str;
    }

    public static /* synthetic */ void P(zzaf zzafVar, zzas zzasVar) {
        zzafVar.zzav = zzasVar;
        zzafVar.zzg |= 2;
    }

    public static /* synthetic */ void Q(zzaf zzafVar, long j2) {
        zzafVar.zzg |= 512;
        zzafVar.zzaF = j2;
    }

    public static zzr R() {
        return (zzr) zzb.k();
    }

    public static /* synthetic */ void S(zzaf zzafVar, long j2) {
        zzafVar.zzg |= 1024;
        zzafVar.zzaG = j2;
    }

    public static /* synthetic */ void T(zzaf zzafVar, long j2) {
        zzafVar.zzg |= 2048;
        zzafVar.zzaH = j2;
    }

    public static /* synthetic */ void U(zzaf zzafVar, long j2) {
        zzafVar.zzg |= 4096;
        zzafVar.zzaI = j2;
    }

    public static /* synthetic */ void V(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zzg |= 32768;
        zzafVar.zzaL = str;
    }

    public static /* synthetic */ void W(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zzg |= 131072;
        zzafVar.zzaN = str;
    }

    public static /* synthetic */ void X(zzaf zzafVar, boolean z) {
        zzafVar.zzg |= 524288;
        zzafVar.zzaP = z;
    }

    public static /* synthetic */ void Y(zzaf zzafVar, long j2) {
        zzafVar.zzg |= 2097152;
        zzafVar.zzaR = j2;
    }

    public static /* synthetic */ void b0(zzaf zzafVar, int i2) {
        zzafVar.zzX = i2 - 1;
        zzafVar.zzf |= 1024;
    }

    public static /* synthetic */ void c0(zzaf zzafVar, int i2) {
        zzafVar.zzY = i2 - 1;
        zzafVar.zzf |= 2048;
    }

    public static /* synthetic */ void d0(zzaf zzafVar, int i2) {
        zzafVar.zzae = i2 - 1;
        zzafVar.zzf |= 131072;
    }

    public static /* synthetic */ void e0(zzaf zzafVar, int i2) {
        zzafVar.zzax = i2 - 1;
        zzafVar.zzg |= 8;
    }

    public static /* synthetic */ void f0(zzaf zzafVar, int i2) {
        zzafVar.zzay = i2 - 1;
        zzafVar.zzg |= 16;
    }

    public static /* synthetic */ void g0(zzaf zzafVar) {
        zzafVar.zzaO = 5;
        zzafVar.zzg |= 262144;
    }

    public static zzaf h0(byte[] bArr, zzacm zzacmVar) {
        return (zzaf) zzacz.n(zzb, bArr, zzacmVar);
    }

    public static /* synthetic */ void k0(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zze |= 1;
        zzafVar.zzh = str;
    }

    public static /* synthetic */ void l0(zzaf zzafVar, String str) {
        zzafVar.zze |= 2;
        zzafVar.zzi = str;
    }

    public static /* synthetic */ void m0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 4;
        zzafVar.zzj = j2;
    }

    public static /* synthetic */ void n0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 16;
        zzafVar.zzl = j2;
    }

    public static /* synthetic */ void o0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 32;
        zzafVar.zzm = j2;
    }

    public static /* synthetic */ void p(zzaf zzafVar, long j2) {
        zzafVar.zze |= 536870912;
        zzafVar.zzK = j2;
    }

    public static /* synthetic */ void p0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 1024;
        zzafVar.zzr = j2;
    }

    public static /* synthetic */ void q(zzaf zzafVar, long j2) {
        zzafVar.zze |= 1073741824;
        zzafVar.zzL = j2;
    }

    public static /* synthetic */ void q0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 2048;
        zzafVar.zzs = j2;
    }

    public static /* synthetic */ void r(zzaf zzafVar, long j2) {
        zzafVar.zze |= Integer.MIN_VALUE;
        zzafVar.zzM = j2;
    }

    public static /* synthetic */ void r0(zzaf zzafVar, long j2) {
        zzafVar.zze |= KEYRecord.Flags.FLAG2;
        zzafVar.zzu = j2;
    }

    public static /* synthetic */ void s(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 2;
        zzafVar.zzO = j2;
    }

    public static /* synthetic */ void s0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 16384;
        zzafVar.zzv = j2;
    }

    public static /* synthetic */ void t(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 4;
        zzafVar.zzP = j2;
    }

    public static /* synthetic */ void t0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 32768;
        zzafVar.zzw = j2;
    }

    public static /* synthetic */ void u(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 8;
        zzafVar.zzQ = j2;
    }

    public static /* synthetic */ void u0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 65536;
        zzafVar.zzx = j2;
    }

    public static /* synthetic */ void v(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 16;
        zzafVar.zzR = j2;
    }

    public static /* synthetic */ void v0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 524288;
        zzafVar.zzA = j2;
    }

    public static /* synthetic */ void w(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 32;
        zzafVar.zzS = j2;
    }

    public static /* synthetic */ void w0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 1048576;
        zzafVar.zzB = j2;
    }

    public static /* synthetic */ void x(zzaf zzafVar, long j2) {
        zzafVar.zzf |= 64;
        zzafVar.zzT = j2;
    }

    public static /* synthetic */ void x0(zzaf zzafVar, long j2) {
        zzafVar.zze |= 2097152;
        zzafVar.zzC = j2;
    }

    public static /* synthetic */ void y(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zzf |= 128;
        zzafVar.zzU = str;
    }

    public static /* synthetic */ void y0(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zze |= 4194304;
        zzafVar.zzD = str;
    }

    public static /* synthetic */ void z(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zzf |= 256;
        zzafVar.zzV = str;
    }

    public static /* synthetic */ void z0(zzaf zzafVar, String str) {
        str.getClass();
        zzafVar.zze |= 16777216;
        zzafVar.zzF = str;
    }

    public final boolean Z() {
        return (this.zze & 4194304) != 0;
    }

    public final boolean a0() {
        return (this.zzg & 4194304) != 0;
    }

    public final zzaq i0() {
        zzaq zzaqVar = this.zzaS;
        return zzaqVar == null ? zzaq.q() : zzaqVar;
    }

    public final String j0() {
        return this.zzD;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzadd zzaddVar = zzv.f38080a;
            zzadd zzaddVar2 = zzan.f37523a;
            return new zzaep(zzb, "\u0001\\\u0000\u0003\u0001Į\\\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂP\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈQ\u0019ဂU\u001aဌR\u001bဈ\u0016\u001cဇS\u001dဈ\u0018\u001eဈT\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEN\u001bOဌFP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOÉဉVĭဂWĮဈX", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzaM", "zzB", "zzC", "zzaN", "zzaR", "zzaO", zzaddVar, "zzD", "zzaP", "zzF", "zzaQ", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzag", zzac.class, "zzS", "zzT", "zzU", "zzV", "zzX", zzaddVar2, "zzY", zzaddVar2, "zzaf", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", zzaddVar2, "zzah", "zzai", "zzaj", "zzak", "zzal", "zzao", "zzap", "zzar", "zzas", zzam.f37522a, "zzat", zzao.f37524a, "zzaq", "zzau", zzs.f38056a, "zzav", "zzaw", "zzam", "zzan", "zzax", zzaddVar2, "zzW", "zzE", "zzay", zzaddVar2, "zzaz", "zzaA", zzy.class, "zzaB", zzaddVar2, "zzaC", zzu.class, "zzaD", "zzaE", "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaS", "zzaT", "zzaU"});
        }
        if (i3 == 3) {
            return new zzaf();
        }
        if (i3 == 4) {
            return new zzr(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
