package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public final class zzkp {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f37894a = new CopyOnWriteArrayList();

    public static zzko a(String str) throws GeneralSecurityException {
        Iterator it = f37894a.iterator();
        while (it.hasNext()) {
            zzko zzkoVar = (zzko) it.next();
            if (zzkoVar.zza()) {
                return zzkoVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
