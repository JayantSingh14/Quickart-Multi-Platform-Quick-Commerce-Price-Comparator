package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzigz extends zziar implements zzicd {
    private static final zzigz zzR;
    private static volatile zzick zzS;
    private zzigv zzA;
    private zzibd zzB;
    private zzifb zzC;
    private String zzD;
    private zziet zzE;
    private zzibd zzF;
    private zzifu zzG;
    private int zzH;
    private zzibd zzI;
    private zzibd zzJ;
    private long zzK;
    private zzigy zzL;
    private zzifz zzM;
    private String zzN;
    private zzigs zzO;
    private zzibd zzP;
    private int zza;
    private int zzb;
    private int zzc;
    private zziex zzg;
    private zzibd zzh;
    private zzibd zzi;
    private String zzj;
    private zzigf zzk;
    private boolean zzl;
    private zzibd zzm;
    private String zzn;
    private boolean zzo;
    private boolean zzp;
    private zzhzl zzu;
    private zzigm zzv;
    private boolean zzw;
    private String zzx;
    private zzibd zzy;
    private zzibd zzz;
    private byte zzQ = 2;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzigz zzigzVar = new zzigz();
        zzR = zzigzVar;
        zziar.x(zzigz.class, zzigzVar);
    }

    public zzigz() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zzh = zzicnVar;
        this.zzi = zzicnVar;
        this.zzj = "";
        this.zzm = zzicnVar;
        this.zzn = "";
        this.zzu = zzhzl.f34557b;
        this.zzx = "";
        this.zzy = zzicnVar;
        this.zzz = zzicnVar;
        this.zzB = zzicnVar;
        this.zzD = "";
        this.zzF = zzicnVar;
        this.zzI = zzicnVar;
        this.zzJ = zzicnVar;
        this.zzN = "";
        this.zzP = zzicnVar;
    }

    public static zziev F() {
        return (zziev) zzR.u();
    }

    public final String C() {
        return this.zzd;
    }

    public final zzibd D() {
        return this.zzh;
    }

    public final String E() {
        return this.zzj;
    }

    public final /* synthetic */ void G(String str) {
        this.zza |= 4;
        this.zzd = str;
    }

    public final /* synthetic */ void H(String str) {
        this.zza |= 8;
        this.zze = str;
    }

    public final /* synthetic */ void I(zziex zziexVar) {
        this.zzg = zziexVar;
        this.zza |= 32;
    }

    public final void J(zzigk zzigkVar) {
        zzibd zzibdVar = this.zzh;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzh = zzibdVar.zzh(size + size);
        }
        this.zzh.add(zzigkVar);
    }

    public final /* synthetic */ void K(String str) {
        this.zza |= 64;
        this.zzj = str;
    }

    public final /* synthetic */ void L() {
        this.zza &= -65;
        this.zzj = zzR.zzj;
    }

    public final /* synthetic */ void M(zzigf zzigfVar) {
        this.zzk = zzigfVar;
        this.zza |= 128;
    }

    public final /* synthetic */ void N(zzigm zzigmVar) {
        this.zzv = zzigmVar;
        this.zza |= KEYRecord.Flags.FLAG2;
    }

    public final void O(ArrayList arrayList) {
        zzibd zzibdVar = this.zzy;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzy = zzibdVar.zzh(size + size);
        }
        zzhyu.j(arrayList, this.zzy);
    }

    public final void P(ArrayList arrayList) {
        zzibd zzibdVar = this.zzz;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzz = zzibdVar.zzh(size + size);
        }
        zzhyu.j(arrayList, this.zzz);
    }

    public final /* synthetic */ void Q(int i2) {
        this.zzb = i2 - 1;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        switch (zziaqVar.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzQ);
            case 1:
                this.zzQ = zziarVar == null ? (byte) 0 : (byte) 1;
                return null;
            case 2:
                return new zzico(zzR, "\u0001%\u0000\u0001\u0001%%\u0000\n\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019$ဉ\u001a%\u001b", new Object[]{"zza", "zzd", "zze", "zzf", "zzh", zzigk.class, "zzl", "zzm", "zzn", "zzo", "zzp", "zzb", zzigg.f34821a, "zzc", zzieu.f34814a, "zzg", "zzj", "zzk", "zzu", "zzi", zzihd.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", zzihj.class, "zzC", "zzD", "zzE", "zzF", zziff.class, "zzG", "zzH", zzigt.f34825a, "zzI", zzifx.class, "zzJ", zzigc.class, "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", zzigp.class});
            case 3:
                return new zzigz();
            case 4:
                return new zziev(zzR);
            case 5:
                return zzR;
            case 6:
                zzick zzickVar = zzS;
                if (zzickVar != null) {
                    return zzickVar;
                }
                synchronized (zzigz.class) {
                    try {
                        zziamVar = zzS;
                        if (zziamVar == null) {
                            zziamVar = new zziam(zzR);
                            zzS = zziamVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zziamVar;
            default:
                throw null;
        }
    }
}
