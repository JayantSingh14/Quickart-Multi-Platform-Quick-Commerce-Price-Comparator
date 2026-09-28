package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;

/* loaded from: classes4.dex */
public final class zzhpj extends zziar implements zzicd {
    private static final zzhpj zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzibd zzb = zzicn.f34726e;

    static {
        zzhpj zzhpjVar = new zzhpj();
        zzc = zzhpjVar;
        zziar.x(zzhpj.class, zzhpjVar);
    }

    public static zzhpj G(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zzc, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zzhpj) zziarVarA;
    }

    public static zzhpj H(ByteArrayInputStream byteArrayInputStream, zziab zziabVar) throws zzibg {
        zziar zziarVarP = zziar.p(zzc, new zzhzo(byteArrayInputStream), zziabVar);
        zziar.B(zziarVarP);
        return (zzhpj) zziarVarP;
    }

    public static zzhpg I() {
        return (zzhpg) zzc.u();
    }

    public final int C() {
        return this.zza;
    }

    public final zzibd D() {
        return this.zzb;
    }

    public final int E() {
        return this.zzb.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzhpi F(int i2) {
        return (zzhpi) this.zzb.get(i2);
    }

    public final /* synthetic */ void J(int i2) {
        this.zza = i2;
    }

    public final void K(zzhpi zzhpiVar) {
        zzibd zzibdVar = this.zzb;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzb = zzibdVar.zzh(size + size);
        }
        this.zzb.add(zzhpiVar);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzb", zzhpi.class});
        }
        if (iOrdinal == 3) {
            return new zzhpj();
        }
        if (iOrdinal == 4) {
            return new zzhpg(zzc);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzd;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhpj.class) {
            try {
                zziamVar = zzd;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzc);
                    zzd = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
