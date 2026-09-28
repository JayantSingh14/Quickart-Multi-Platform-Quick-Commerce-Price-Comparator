package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzacl;
import com.google.ads.interactivemedia.v3.internal.zzacq;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class zzacq<MessageType extends zzacq<MessageType, BuilderType>, BuilderType extends zzacl<MessageType, BuilderType>> extends zzaav<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzafl zzc = zzafl.zzc();

    public static zzacq zzaB(zzacq zzacqVar, zzabn zzabnVar) throws zzacz {
        zzacb zzacbVar = zzacb.zza;
        zzabr zzabrVarZzl = zzabnVar.zzl();
        zzacq zzacqVarZzaA = zzacqVar.zzaA();
        try {
            zzaet zzaetVarZzb = zzaei.zza().zzb(zzacqVarZzaA.getClass());
            zzaetVarZzb.zzh(zzacqVarZzaA, zzabs.zzq(zzabrVarZzl), zzacbVar);
            zzaetVarZzb.zzf(zzacqVarZzaA);
            try {
                zzabrVarZzl.zzm(0);
                zze(zzacqVarZzaA);
                zze(zzacqVarZzaA);
                return zzacqVarZzaA;
            } catch (zzacz e2) {
                e2.zzh(zzacqVarZzaA);
                throw e2;
            }
        } catch (zzacz e3) {
            e3.zzh(zzacqVarZzaA);
            throw e3;
        } catch (zzafj e4) {
            zzacz zzaczVarZza = e4.zza();
            zzaczVarZza.zzh(zzacqVarZzaA);
            throw zzaczVarZza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzacz) {
                throw ((zzacz) e5.getCause());
            }
            zzacz zzaczVar = new zzacz(e5);
            zzaczVar.zzh(zzacqVarZzaA);
            throw zzaczVar;
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzacz) {
                throw ((zzacz) e6.getCause());
            }
            throw e6;
        }
    }

    public static zzacq zzaC(zzacq zzacqVar, zzabn zzabnVar, zzacb zzacbVar) throws zzacz {
        zzabr zzabrVarZzl = zzabnVar.zzl();
        zzacq zzacqVarZzaA = zzacqVar.zzaA();
        try {
            zzaet zzaetVarZzb = zzaei.zza().zzb(zzacqVarZzaA.getClass());
            zzaetVarZzb.zzh(zzacqVarZzaA, zzabs.zzq(zzabrVarZzl), zzacbVar);
            zzaetVarZzb.zzf(zzacqVarZzaA);
            try {
                zzabrVarZzl.zzm(0);
                zze(zzacqVarZzaA);
                return zzacqVarZzaA;
            } catch (zzacz e2) {
                e2.zzh(zzacqVarZzaA);
                throw e2;
            }
        } catch (zzacz e3) {
            e3.zzh(zzacqVarZzaA);
            throw e3;
        } catch (zzafj e4) {
            zzacz zzaczVarZza = e4.zza();
            zzaczVarZza.zzh(zzacqVarZzaA);
            throw zzaczVarZza;
        } catch (IOException e5) {
            if (e5.getCause() instanceof zzacz) {
                throw ((zzacz) e5.getCause());
            }
            zzacz zzaczVar = new zzacz(e5);
            zzaczVar.zzh(zzacqVarZzaA);
            throw zzaczVar;
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof zzacz) {
                throw ((zzacz) e6.getCause());
            }
            throw e6;
        }
    }

    public static zzacq zzaD(zzacq zzacqVar, byte[] bArr, zzacb zzacbVar) throws zzacz {
        zzacq zzacqVarZzf = zzf(zzacqVar, bArr, 0, bArr.length, zzacbVar);
        zze(zzacqVarZzf);
        return zzacqVarZzf;
    }

    public static zzacv zzaE() {
        return zzacr.zzf();
    }

    public static zzacw zzaF() {
        return zzaej.zze();
    }

    public static zzacw zzaG(zzacw zzacwVar) {
        int size = zzacwVar.size();
        return zzacwVar.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzaH(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzaI(zzadz zzadzVar, String str, Object[] objArr) {
        return new zzaek(zzadzVar, str, objArr);
    }

    public static void zzaL(Class cls, zzacq zzacqVar) {
        zzacqVar.zzaK();
        zzb.put(cls, zzacqVar);
    }

    public static final boolean zzaN(zzacq zzacqVar, boolean z) {
        byte bByteValue = ((Byte) zzacqVar.zzj(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzaei.zza().zzb(zzacqVar.getClass()).zzl(zzacqVar);
        if (z) {
            zzacqVar.zzj(2, true != zZzl ? null : zzacqVar, null);
        }
        return zZzl;
    }

    public static zzacq zzaz(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzacq zzacqVar = (zzacq) map.get(cls);
        if (zzacqVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzacqVar = (zzacq) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzacqVar != null) {
            return zzacqVar;
        }
        zzacq zzacqVar2 = (zzacq) ((zzacq) zzafu.zze(cls)).zzj(6, null, null);
        if (zzacqVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzacqVar2);
        return zzacqVar2;
    }

    private final int zzc(zzaet zzaetVar) {
        return zzaei.zza().zzb(getClass()).zza(this);
    }

    private static zzacq zze(zzacq zzacqVar) throws zzacz {
        if (zzacqVar == null || zzacqVar.zzaT()) {
            return zzacqVar;
        }
        zzacz zzaczVarZza = new zzafj(zzacqVar).zza();
        zzaczVarZza.zzh(zzacqVar);
        throw zzaczVarZza;
    }

    private static zzacq zzf(zzacq zzacqVar, byte[] bArr, int i2, int i3, zzacb zzacbVar) throws zzacz {
        zzacq zzacqVarZzaA = zzacqVar.zzaA();
        try {
            zzaet zzaetVarZzb = zzaei.zza().zzb(zzacqVarZzaA.getClass());
            zzaetVarZzb.zzi(zzacqVarZzaA, bArr, 0, i3, new zzaaz(zzacbVar));
            zzaetVarZzb.zzf(zzacqVarZzaA);
            return zzacqVarZzaA;
        } catch (zzacz e2) {
            e2.zzh(zzacqVarZzaA);
            throw e2;
        } catch (zzafj e3) {
            zzacz zzaczVarZza = e3.zza();
            zzaczVarZza.zzh(zzacqVarZzaA);
            throw zzaczVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzacz) {
                throw ((zzacz) e4.getCause());
            }
            zzacz zzaczVar = new zzacz(e4);
            zzaczVar.zzh(zzacqVarZzaA);
            throw zzaczVar;
        } catch (IndexOutOfBoundsException unused) {
            zzacz zzaczVarZzi = zzacz.zzi();
            zzaczVarZzi.zzh(zzacqVarZzaA);
            throw zzaczVarZzi;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzaei.zza().zzb(getClass()).zzk(this, (zzacq) obj);
    }

    public final int hashCode() {
        if (zzaO()) {
            return zzaw();
        }
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iZzaw = zzaw();
        this.zza = iZzaw;
        return iZzaw;
    }

    public final String toString() {
        return zzaeb.zza(this, super.toString());
    }

    public final zzacq zzaA() {
        return (zzacq) zzj(4, null, null);
    }

    public final void zzaJ() {
        zzaei.zza().zzb(getClass()).zzf(this);
        zzaK();
    }

    public final void zzaK() {
        this.zzd &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final void zzaM(int i2) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean zzaO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadz
    public final /* synthetic */ zzady zzaP() {
        return (zzacl) zzj(5, null, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadz
    public final /* synthetic */ zzady zzaQ() {
        zzacl zzaclVar = (zzacl) zzj(5, null, null);
        zzaclVar.zzaj(this);
        return zzaclVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadz
    public final void zzaR(zzabw zzabwVar) throws IOException {
        zzaei.zza().zzb(getClass()).zzj(this, zzabx.zza(zzabwVar));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaea
    public final /* synthetic */ zzadz zzaS() {
        return (zzacq) zzj(6, null, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaea
    public final boolean zzaT() {
        return zzaN(this, true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaav
    public final int zzat(zzaet zzaetVar) {
        if (zzaO()) {
            int iZza = zzaetVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(b.f(iZza, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iZza2 = zzaetVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(b.f(iZza2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzaw() {
        return zzaei.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadz
    public final int zzax() {
        if (zzaO()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException(b.f(iZzc, "serialized size must be non-negative, was "));
        }
        int i2 = this.zzd & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 < 0) {
            throw new IllegalStateException(b.f(iZzc2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
        return iZzc2;
    }

    public final zzacl zzay() {
        return (zzacl) zzj(5, null, null);
    }

    public abstract Object zzj(int i2, Object obj, Object obj2);
}
