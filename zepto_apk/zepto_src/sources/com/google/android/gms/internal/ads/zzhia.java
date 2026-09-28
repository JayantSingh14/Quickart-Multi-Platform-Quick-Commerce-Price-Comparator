package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzhia {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f33847c = Logger.getLogger(zzhia.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final zzhia f33848d = new zzhia();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f33849a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f33850b = new ConcurrentHashMap();

    public final synchronized void a(zzgzy zzgzyVar, boolean z) {
        c(zzgzyVar, 1, z);
    }

    public final zzgzy b(Class cls, String str) throws GeneralSecurityException {
        zzgzy zzgzyVarD = d(str);
        if (zzgzyVarD.zzc().equals(cls)) {
            return zzgzyVarD;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzgzyVarD.getClass());
        String string = zzgzyVarD.zzc().toString();
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(name.length() + 53, 23, strValueOf) + string.length());
        android.support.v4.media.b.B(sb, "Primitive type ", name, " not supported by key manager of type ", strValueOf);
        throw new GeneralSecurityException(android.support.v4.media.b.r(sb, ", which only supports: ", string));
    }

    public final synchronized void c(zzgzy zzgzyVar, int i2, boolean z) {
        if (!zzhhb.a(i2)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        e(zzgzyVar, z);
    }

    public final synchronized zzgzy d(String str) {
        ConcurrentHashMap concurrentHashMap;
        concurrentHashMap = this.f33849a;
        if (!concurrentHashMap.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 98);
            sb.append("No key manager found for key type ");
            sb.append(str);
            sb.append(", see https://developers.google.com/tink/faq/registration_errors");
            throw new GeneralSecurityException(sb.toString());
        }
        return (zzgzy) concurrentHashMap.get(str);
    }

    public final synchronized void e(zzgzy zzgzyVar, boolean z) {
        try {
            String strZzb = zzgzyVar.zzb();
            if (z) {
                ConcurrentHashMap concurrentHashMap = this.f33850b;
                if (concurrentHashMap.containsKey(strZzb) && !((Boolean) concurrentHashMap.get(strZzb)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(strZzb));
                }
            }
            ConcurrentHashMap concurrentHashMap2 = this.f33849a;
            zzgzy zzgzyVar2 = (zzgzy) concurrentHashMap2.get(strZzb);
            if (zzgzyVar2 != null && !zzgzyVar2.getClass().equals(zzgzyVar.getClass())) {
                f33847c.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(strZzb));
                throw new GeneralSecurityException("typeUrl (" + strZzb + ") is already registered with " + zzgzyVar2.getClass().getName() + ", cannot be re-registered with " + zzgzyVar.getClass().getName());
            }
            concurrentHashMap2.putIfAbsent(strZzb, zzgzyVar);
            this.f33850b.put(strZzb, Boolean.valueOf(z));
        } catch (Throwable th) {
            throw th;
        }
    }
}
