package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.AbstractCollection;

/* loaded from: classes4.dex */
public final class zzfnu extends zziar implements zzicd {
    private static final zzfnu zzaw;
    private static volatile zzick zzax;
    private int zzD;
    private int zzE;
    private int zzF;
    private long zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private int zzK;
    private int zzR;
    private int zzS;
    private int zzU;
    private int zza;
    private long zzae;
    private int zzag;
    private int zzah;
    private int zzai;
    private zzfot zzaj;
    private int zzak;
    private zzfop zzal;
    private zzfoa zzam;
    private zzfoe zzan;
    private zzfoc zzao;
    private zzfor zzap;
    private zzfol zzaq;
    private zzfoh zzar;
    private zzief zzas;
    private zzfov zzau;
    private zzfoj zzav;
    private int zzb;
    private int zzc;
    private long zze;
    private long zzf;
    private long zzg;
    private boolean zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private int zzz;
    private String zzd = "";
    private zziaz zzh = zzias.f34649e;
    private String zzo = "";
    private String zzp = "";
    private String zzu = "";
    private String zzv = "";
    private String zzw = "";
    private String zzx = "";
    private String zzy = "";
    private String zzA = "";
    private String zzB = "";
    private zzibc zzC = zzibq.f34690e;
    private String zzL = "";
    private String zzM = "";
    private String zzN = "";
    private String zzO = "";
    private String zzP = "";
    private String zzQ = "";
    private String zzT = "";
    private String zzV = "";
    private String zzW = "";
    private String zzX = "";
    private String zzY = "";
    private String zzZ = "";
    private String zzaa = "";
    private String zzab = "";
    private String zzac = "";
    private String zzad = "";
    private String zzaf = "";
    private String zzat = "";

    static {
        zzfnu zzfnuVar = new zzfnu();
        zzaw = zzfnuVar;
        zziar.x(zzfnu.class, zzfnuVar);
    }

    public static zzfns E() {
        return (zzfns) zzaw.u();
    }

    public final /* synthetic */ void C(int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzD = i2 - 2;
    }

    public final /* synthetic */ void D(int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzK = i2 - 2;
    }

    public final /* synthetic */ void F(boolean z) {
        this.zzi = z;
    }

    public final /* synthetic */ void G(long j2) {
        this.zzj = j2;
    }

    public final /* synthetic */ void H(long j2) {
        this.zzk = j2;
    }

    public final /* synthetic */ void I(String str) {
        str.getClass();
        this.zzo = str;
    }

    public final /* synthetic */ void J(String str) {
        str.getClass();
        this.zzw = str;
    }

    public final /* synthetic */ void K(String str) {
        String str2 = Build.VERSION.RELEASE;
        str2.getClass();
        this.zzy = str2;
    }

    public final /* synthetic */ void L(int i2) {
        this.zzz = i2;
    }

    public final void M(AbstractCollection abstractCollection) {
        zzibc zzibcVar = this.zzC;
        if (!zzibcVar.zza()) {
            int size = zzibcVar.size();
            this.zzC = zzibcVar.zzh(size + size);
        }
        zzhyu.j(abstractCollection, this.zzC);
    }

    public final /* synthetic */ void N(int i2) {
        this.zzF = i2;
    }

    public final /* synthetic */ void O(long j2) {
        this.zzG = j2;
    }

    public final /* synthetic */ void P(String str) {
        str.getClass();
        this.zzL = str;
    }

    public final /* synthetic */ void Q(String str) {
        str.getClass();
        this.zzM = str;
    }

    public final /* synthetic */ void R(String str) {
        str.getClass();
        this.zzY = str;
    }

    public final /* synthetic */ void S(String str) {
        this.zzZ = str;
    }

    public final /* synthetic */ void T(String str) {
        str.getClass();
        this.zzaa = str;
    }

    public final /* synthetic */ void U(String str) {
        str.getClass();
        this.zzab = str;
    }

    public final /* synthetic */ void V(String str) {
        this.zzac = str;
    }

    public final /* synthetic */ void W(String str) {
        str.getClass();
        this.zzad = str;
    }

    public final /* synthetic */ void X(zzfnt zzfntVar) {
        this.zzak = zzfntVar.zza();
    }

    public final /* synthetic */ void Y(zzief zziefVar) {
        this.zzas = zziefVar;
        this.zza |= 256;
    }

    public final /* synthetic */ void Z(String str) {
        this.zzat = str;
    }

    public final /* synthetic */ void a0(int i2) {
        this.zzb = i2 - 2;
    }

    public final /* synthetic */ void b0() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzaw, "\u0004E\u0000\u0001\u0001EE\u0000\u0002\u0000\u0001\f\u0002\u0007\u0003\u0002\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0004\t\f\n\u0004\u000b\u0002\f\f\rȈ\u000eȈ\u000fȈ\u0010Ȉ\u0011Ȉ\u0012Ȉ\u0013Ȉ\u0014Ȉ\u0015Ȉ\u0016Ȉ\u0017Ȉ\u0018Ȉ\u0019%\u001aȈ\u001bȈ\u001cȈ\u001d\u0002\u001eȈ\u001f\u0002 \u0002!\u0002\"\u0002#\u0002$\u0002%,&\f'\f(\f)ဉ\u0001*ဉ\u0002+\u0004,Ȉ-Ȉ.Ȉ/\f0\u00041\u00042Ȉ3Ȉ4ဉ\u00035\f6ဉ\u00047Ȉ8\u00049ဉ\u0000:ဉ\u0005;ဉ\u0006<Ȉ=ဉ\u0007>ဉ\b?Ȉ@ȈAဉ\tB\u0007C\u0007D\u0007Eဉ\n", new Object[]{"zza", "zzb", "zzi", "zzj", "zzn", "zzo", "zzw", "zzy", "zzz", "zzD", "zzF", "zzG", "zzK", "zzL", "zzM", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzp", "zzu", "zzA", "zzB", "zzC", "zzN", "zzO", "zzW", "zzae", "zzd", "zze", "zzf", "zzg", "zzk", "zzl", "zzm", "zzh", "zzah", "zzai", "zzc", "zzal", "zzam", "zzR", "zzT", "zzQ", "zzP", "zzak", "zzS", "zzU", "zzV", "zzx", "zzan", "zzE", "zzao", "zzaf", "zzag", "zzaj", "zzap", "zzaq", "zzX", "zzar", "zzas", "zzat", "zzv", "zzau", "zzH", "zzI", "zzJ", "zzav"});
        }
        if (iOrdinal == 3) {
            return new zzfnu();
        }
        if (iOrdinal == 4) {
            return new zzfns(zzaw);
        }
        if (iOrdinal == 5) {
            return zzaw;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzax;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzfnu.class) {
            try {
                zziamVar = zzax;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzaw);
                    zzax = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
