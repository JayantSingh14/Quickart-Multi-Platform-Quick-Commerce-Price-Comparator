package com.google.android.gms.internal.pal;

import androidx.fragment.app.e;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zzki {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f37885b = Logger.getLogger(zzki.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f37886a;

    public zzki() {
        this.f37886a = new ConcurrentHashMap();
    }

    public final zzkb a(Class cls, String str) throws GeneralSecurityException {
        zzkh zzkhVarD = d(str);
        if (zzkhVarD.zze().contains(cls)) {
            return zzkhVarD.zza(cls);
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzkhVarD.zzc());
        Set<Class> setZze = zzkhVarD.zze();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : setZze) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String string = sb.toString();
        StringBuilder sbV = e.v("Primitive type ", name, " not supported by key manager of type ", strValueOf, ", supported primitives: ");
        sbV.append(string);
        throw new GeneralSecurityException(sbV.toString());
    }

    public final synchronized void b(zzpr zzprVar, zzpa zzpaVar) {
        Class clsZzd;
        try {
            int iF = zzpaVar.f();
            if (!zzna.a(1)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzprVar.getClass()) + " as it is not FIPS compatible.");
            }
            if (!zzna.a(iF)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzpaVar.getClass()) + " as it is not FIPS compatible.");
            }
            String strD = zzprVar.d();
            String strD2 = zzpaVar.d();
            if (this.f37886a.containsKey(strD) && ((zzkh) this.f37886a.get(strD)).zzd() != null && (clsZzd = ((zzkh) this.f37886a.get(strD)).zzd()) != null && !clsZzd.getName().equals(zzpaVar.getClass().getName())) {
                f37885b.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + strD + " with inconsistent public key type " + strD2);
                throw new GeneralSecurityException("public key manager corresponding to " + zzprVar.getClass().getName() + " is already registered with " + clsZzd.getName() + ", cannot be re-registered with " + zzpaVar.getClass().getName());
            }
            e(new zzkg(zzprVar, zzpaVar), true);
            e(new zzkf(zzpaVar), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(zzpa zzpaVar) {
        if (!zzna.a(zzpaVar.f())) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzpaVar.getClass()) + " as it is not FIPS compatible.");
        }
        e(new zzkf(zzpaVar), false);
    }

    public final synchronized zzkh d(String str) {
        if (!this.f37886a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzkh) this.f37886a.get(str);
    }

    public final synchronized void e(zzkh zzkhVar, boolean z) {
        try {
            String strZzf = zzkhVar.zzb().zzf();
            zzkh zzkhVar2 = (zzkh) this.f37886a.get(strZzf);
            if (zzkhVar2 != null && !zzkhVar2.zzc().equals(zzkhVar.zzc())) {
                f37885b.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(strZzf));
                throw new GeneralSecurityException("typeUrl (" + strZzf + ") is already registered with " + zzkhVar2.zzc().getName() + ", cannot be re-registered with " + zzkhVar.zzc().getName());
            }
            if (z) {
                this.f37886a.put(strZzf, zzkhVar);
            } else {
                this.f37886a.putIfAbsent(strZzf, zzkhVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public zzki(zzki zzkiVar) {
        this.f37886a = new ConcurrentHashMap(zzkiVar.f37886a);
    }
}
