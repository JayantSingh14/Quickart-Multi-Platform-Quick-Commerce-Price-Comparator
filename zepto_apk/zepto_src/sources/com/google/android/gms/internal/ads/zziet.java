package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zziet extends zziar implements zzicd {
    private static final zziet zzy;
    private static volatile zzick zzz;
    private int zza;
    private int zzb;
    private boolean zzc;
    private String zzd = "";
    private zzibd zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private String zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private zzibd zzo;
    private boolean zzp;
    private long zzu;
    private zziaz zzv;
    private boolean zzw;
    private zziaz zzx;

    static {
        zziet zzietVar = new zziet();
        zzy = zzietVar;
        zziar.x(zziet.class, zzietVar);
    }

    public zziet() {
        zzicn zzicnVar = zzicn.f34726e;
        this.zze = zzicnVar;
        this.zzj = "";
        this.zzo = zzicnVar;
        zzias zziasVar = zzias.f34649e;
        this.zzv = zziasVar;
        this.zzx = zziasVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzy, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zza", "zzb", zzies.f34813a, "zzc", "zzd", "zze", "zzf", zzieq.f34811a, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zziep.class, "zzp", "zzu", "zzv", zzieg.f34809a, "zzw", "zzx", zzier.f34812a});
        }
        if (iOrdinal == 3) {
            return new zziet();
        }
        if (iOrdinal == 4) {
            return new zziem(zzy);
        }
        if (iOrdinal == 5) {
            return zzy;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzz;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zziet.class) {
            try {
                zziamVar = zzz;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzy);
                    zzz = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
