package com.google.android.gms.internal.ads;

import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzawp extends zziar implements zzicd {
    private static final zzawp zzbe;
    private static volatile zzick zzbf;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzH;
    private long zzI;
    private long zzJ;
    private long zzL;
    private zzawr zzO;
    private int zza;
    private int zzaA;
    private String zzaB;
    private zzibd zzaC;
    private int zzaD;
    private zzibd zzaE;
    private zzawk zzaF;
    private zzawi zzaG;
    private String zzaH;
    private long zzaI;
    private long zzaJ;
    private long zzaK;
    private long zzaL;
    private long zzaM;
    private long zzaN;
    private long zzaO;
    private String zzaP;
    private zzawa zzaQ;
    private zzawc zzaR;
    private long zzaS;
    private long zzaT;
    private int zzaU;
    private long zzaV;
    private String zzaW;
    private int zzaX;
    private boolean zzaY;
    private String zzaZ;
    private zzawm zzag;
    private zzibd zzah;
    private zzawo zzai;
    private long zzaj;
    private long zzak;
    private long zzal;
    private long zzam;
    private long zzan;
    private long zzao;
    private long zzap;
    private long zzaq;
    private String zzar;
    private long zzas;
    private int zzat;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzaxe zzax;
    private long zzay;
    private int zzaz;
    private int zzb;
    private long zzba;
    private zzaxc zzbb;
    private long zzbc;
    private String zzbd;
    private int zzc;
    private int zzd;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zze = "";
    private String zzf = "";
    private String zzu = "";
    private String zzE = "";
    private String zzF = "D";
    private String zzG = "";
    private String zzK = "";
    private long zzM = -1;
    private long zzN = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private String zzV = "D";
    private String zzW = "D";
    private long zzX = -1;
    private int zzY = 1000;
    private int zzZ = 1000;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private int zzaf = 1000;

    static {
        zzawp zzawpVar = new zzawp();
        zzbe = zzawpVar;
        zziar.x(zzawp.class, zzawpVar);
    }

    public zzawp() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zzah = zzicnVar;
        this.zzaj = -1L;
        this.zzak = -1L;
        this.zzal = -1L;
        this.zzam = -1L;
        this.zzan = -1L;
        this.zzao = -1L;
        this.zzap = -1L;
        this.zzaq = -1L;
        this.zzar = "D";
        this.zzas = -1L;
        this.zzay = -1L;
        this.zzaz = 1000;
        this.zzaA = 1000;
        this.zzaB = "D";
        this.zzaC = zzicnVar;
        this.zzaD = 1000;
        this.zzaE = zzicnVar;
        this.zzaH = "";
        this.zzaI = -1L;
        this.zzaJ = -1L;
        this.zzaK = -1L;
        this.zzaL = -1L;
        this.zzaO = -1L;
        this.zzaP = "";
        this.zzaS = -1L;
        this.zzaT = -1L;
        this.zzaW = "";
        this.zzaX = 2;
        this.zzaZ = "";
        this.zzbc = -1L;
        this.zzbd = "";
    }

    public static zzawp E0(byte[] bArr, zziab zziabVar) {
        return (zzawp) zziar.r(zzbe, bArr, zziabVar);
    }

    public static zzavs F0() {
        return (zzavs) zzbe.u();
    }

    public static zzawp G0() {
        return zzbe;
    }

    public final long A0() {
        return this.zzaj;
    }

    public final long B0() {
        return this.zzan;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzG = str;
    }

    public final boolean C0() {
        return (this.zzc & 1073741824) != 0;
    }

    public final /* synthetic */ void D(long j2) {
        this.zza |= 33554432;
        this.zzH = j2;
    }

    public final zzaxc D0() {
        zzaxc zzaxcVar = this.zzbb;
        return zzaxcVar == null ? zzaxc.G() : zzaxcVar;
    }

    public final /* synthetic */ void E(long j2) {
        this.zza |= 67108864;
        this.zzI = j2;
    }

    public final /* synthetic */ void F(long j2) {
        this.zza |= 134217728;
        this.zzJ = j2;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zza |= 268435456;
        this.zzK = str;
    }

    public final /* synthetic */ void H(long j2) {
        this.zza |= 536870912;
        this.zzL = j2;
    }

    public final /* synthetic */ void H0(String str) {
        str.getClass();
        this.zza |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void I(long j2) {
        this.zza |= 1073741824;
        this.zzM = j2;
    }

    public final /* synthetic */ void I0(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzf = str;
    }

    public final /* synthetic */ void J(long j2) {
        this.zza |= Integer.MIN_VALUE;
        this.zzN = j2;
    }

    public final /* synthetic */ void J0(long j2) {
        this.zza |= 4;
        this.zzg = j2;
    }

    public final /* synthetic */ void K(long j2) {
        this.zzb |= 2;
        this.zzP = j2;
    }

    public final /* synthetic */ void K0(long j2) {
        this.zza |= 16;
        this.zzi = j2;
    }

    public final /* synthetic */ void L(long j2) {
        this.zzb |= 4;
        this.zzQ = j2;
    }

    public final /* synthetic */ void L0(long j2) {
        this.zza |= 32;
        this.zzj = j2;
    }

    public final /* synthetic */ void M(long j2) {
        this.zzb |= 8;
        this.zzR = j2;
    }

    public final /* synthetic */ void M0(long j2) {
        this.zza |= 1024;
        this.zzo = j2;
    }

    public final /* synthetic */ void N(long j2) {
        this.zzb |= 16;
        this.zzS = j2;
    }

    public final /* synthetic */ void N0(long j2) {
        this.zza |= 2048;
        this.zzp = j2;
    }

    public final /* synthetic */ void O(long j2) {
        this.zzb |= 32;
        this.zzT = j2;
    }

    public final /* synthetic */ void O0(long j2) {
        this.zza |= KEYRecord.Flags.FLAG2;
        this.zzv = j2;
    }

    public final /* synthetic */ void P(long j2) {
        this.zzb |= 64;
        this.zzU = j2;
    }

    public final /* synthetic */ void P0(long j2) {
        this.zza |= 16384;
        this.zzw = j2;
    }

    public final /* synthetic */ void Q(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzV = str;
    }

    public final /* synthetic */ void Q0(long j2) {
        this.zza |= 32768;
        this.zzx = j2;
    }

    public final /* synthetic */ void R(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzW = str;
    }

    public final /* synthetic */ void R0(long j2) {
        this.zza |= 65536;
        this.zzy = j2;
    }

    public final /* synthetic */ void S(long j2) {
        this.zzb |= 4096;
        this.zzaa = j2;
    }

    public final /* synthetic */ void S0(long j2) {
        this.zza |= 524288;
        this.zzB = j2;
    }

    public final /* synthetic */ void T(long j2) {
        this.zzb |= KEYRecord.Flags.FLAG2;
        this.zzab = j2;
    }

    public final /* synthetic */ void T0(long j2) {
        this.zza |= 1048576;
        this.zzC = j2;
    }

    public final /* synthetic */ void U(long j2) {
        this.zzb |= 16384;
        this.zzac = j2;
    }

    public final /* synthetic */ void U0(long j2) {
        this.zza |= 2097152;
        this.zzD = j2;
    }

    public final /* synthetic */ void V(zzawm zzawmVar) {
        this.zzag = zzawmVar;
        this.zzb |= 262144;
    }

    public final /* synthetic */ void V0(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzE = str;
    }

    public final void W(zzawm zzawmVar) {
        zzibd zzibdVar = this.zzah;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzah = zzibdVar.zzh(size + size);
        }
        this.zzah.add(zzawmVar);
    }

    public final void X() {
        this.zzah = zzicn.f34726e;
    }

    public final /* synthetic */ void Y(zzawo zzawoVar) {
        this.zzai = zzawoVar;
        this.zzb |= 524288;
    }

    public final /* synthetic */ void Z(long j2) {
        this.zzb |= 1048576;
        this.zzaj = j2;
    }

    public final /* synthetic */ void a0(long j2) {
        this.zzb |= 2097152;
        this.zzak = j2;
    }

    public final /* synthetic */ void b0(long j2) {
        this.zzb |= 4194304;
        this.zzal = j2;
    }

    public final boolean c0() {
        return (this.zza & 4194304) != 0;
    }

    public final /* synthetic */ void d0(long j2) {
        this.zzb |= 8388608;
        this.zzam = j2;
    }

    public final /* synthetic */ void e0(long j2) {
        this.zzb |= 16777216;
        this.zzan = j2;
    }

    public final /* synthetic */ void f0(long j2) {
        this.zzb |= 67108864;
        this.zzap = j2;
    }

    public final /* synthetic */ void g0(long j2) {
        this.zzb |= 134217728;
        this.zzaq = j2;
    }

    public final /* synthetic */ void h0(String str) {
        str.getClass();
        this.zzb |= 268435456;
        this.zzar = str;
    }

    public final /* synthetic */ void i0(String str) {
        str.getClass();
        this.zzc |= 1024;
        this.zzaH = str;
    }

    public final /* synthetic */ void j0(long j2) {
        this.zzc |= 2048;
        this.zzaI = j2;
    }

    public final /* synthetic */ void k0(long j2) {
        this.zzc |= 4096;
        this.zzaJ = j2;
    }

    public final /* synthetic */ void l0(long j2) {
        this.zzc |= KEYRecord.Flags.FLAG2;
        this.zzaK = j2;
    }

    public final /* synthetic */ void m0(long j2) {
        this.zzc |= 16384;
        this.zzaL = j2;
    }

    public final /* synthetic */ void o0(String str) {
        str.getClass();
        this.zzc |= 262144;
        this.zzaP = str;
    }

    public final /* synthetic */ void p0(long j2) {
        this.zzc |= 4194304;
        this.zzaT = j2;
    }

    public final /* synthetic */ void q0(long j2) {
        this.zzc |= 536870912;
        this.zzba = j2;
    }

    public final /* synthetic */ void r0(zzaxc zzaxcVar) {
        zzaxcVar.getClass();
        this.zzbb = zzaxcVar;
        this.zzc |= 1073741824;
    }

    public final /* synthetic */ void s0(int i2) {
        this.zzY = i2 - 1;
        this.zzb |= 1024;
    }

    public final /* synthetic */ void t0(int i2) {
        this.zzZ = i2 - 1;
        this.zzb |= 2048;
    }

    public final /* synthetic */ void u0(int i2) {
        this.zzaf = i2 - 1;
        this.zzb |= 131072;
    }

    public final /* synthetic */ void v0(int i2) {
        this.zzaz = i2 - 1;
        this.zzc |= 16;
    }

    public final /* synthetic */ void w0(int i2) {
        this.zzaA = i2 - 1;
        this.zzc |= 32;
    }

    public final /* synthetic */ void x0(int i2) {
        this.zzaU = i2 - 1;
        this.zzc |= 8388608;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziax zziaxVar = zzavw.f24421a;
            zziax zziaxVar2 = zzawx.f24427a;
            return new zzico(zzbe, "\u0001d\u0000\u0004\u0001Įd\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂX\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈY\u0019ဂ]\u001a᠌Z\u001bဈ\u0016\u001cဇ[\u001dဈ\u0018\u001eဈ\\\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉS[ဉT\\ဂU]ဂV^᠌W_᠌@`ဉIaဂPÉဉ^ĭဂ_Įဈ`", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzaV", "zzC", "zzD", "zzaW", "zzba", "zzaX", zziaxVar, "zzE", "zzaY", "zzG", "zzaZ", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzah", zzawm.class, "zzT", "zzU", "zzV", "zzW", "zzY", zziaxVar2, "zzZ", zziaxVar2, "zzag", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", zziaxVar2, "zzai", "zzaj", "zzak", "zzal", "zzam", "zzap", "zzaq", "zzas", "zzat", zzaww.f24426a, "zzau", zzaxa.f24429a, "zzar", "zzaw", zzavt.f24420a, "zzax", "zzay", "zzan", "zzao", "zzaz", zziaxVar2, "zzX", "zzF", "zzaA", zziaxVar2, "zzaB", "zzaC", zzawg.class, "zzaD", zziaxVar2, "zzaE", zzavv.class, "zzaF", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", "zzaT", "zzaU", zzawd.f24425a, "zzav", zzavx.f24422a, "zzaG", "zzaN", "zzbb", "zzbc", "zzbd"});
        }
        if (iOrdinal == 3) {
            return new zzawp();
        }
        if (iOrdinal == 4) {
            return new zzavs(zzbe);
        }
        if (iOrdinal == 5) {
            return zzbe;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzbf;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawp.class) {
            try {
                zziamVar = zzbf;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzbe);
                    zzbf = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }

    public final String y0() {
        return this.zzE;
    }

    public final boolean z0() {
        return (this.zzb & 1048576) != 0;
    }
}
