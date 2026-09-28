package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhiv {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhhz f33869b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhiv f33870c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33871a = new HashMap();

    static {
        zzhiu zzhiuVar = zzhiu.f33868a;
        zzhiv zzhivVar = new zzhiv();
        try {
            zzhivVar.a(zzhiuVar, zzhin.class);
            f33870c = zzhivVar;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException("unexpected error.", e2);
        }
    }

    public final synchronized void a(zzhhz zzhhzVar, Class cls) {
        try {
            HashMap map = this.f33871a;
            zzhhz zzhhzVar2 = (zzhhz) map.get(cls);
            if (zzhhzVar2 != null && !zzhhzVar2.equals(zzhhzVar)) {
                String string = cls.toString();
                StringBuilder sb = new StringBuilder(string.length() + 60);
                sb.append("Different key creator for parameters class ");
                sb.append(string);
                sb.append(" already inserted");
                throw new GeneralSecurityException(sb.toString());
            }
            map.put(cls, zzhhzVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final zzgzx b(zzhan zzhanVar, Integer num) {
        zzgzx zzgzxVarA;
        synchronized (this) {
            zzhhz zzhhzVar = (zzhhz) this.f33871a.get(zzhanVar.getClass());
            if (zzhhzVar == null) {
                String string = zzhanVar.toString();
                StringBuilder sb = new StringBuilder(string.length() + 86);
                sb.append("Cannot create a new key for parameters ");
                sb.append(string);
                sb.append(": no key creator for this class was registered.");
                throw new GeneralSecurityException(sb.toString());
            }
            zzgzxVarA = zzhhzVar.a(zzhanVar, num);
        }
        return zzgzxVarA;
    }
}
