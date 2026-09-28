package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhix {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhix f33872b = new zzhix();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33873a = new HashMap();

    public final synchronized void a(zzhiw zzhiwVar, Class cls) {
        try {
            HashMap map = this.f33873a;
            zzhiw zzhiwVar2 = (zzhiw) map.get(cls);
            if (zzhiwVar2 != null && !zzhiwVar2.equals(zzhiwVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            map.put(cls, zzhiwVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
