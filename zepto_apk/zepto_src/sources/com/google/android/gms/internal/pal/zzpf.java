package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzpf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzrc f37995a = new zzpe();

    public static zzri a(zzlb zzlbVar) {
        zzkj zzkjVar;
        zzre zzreVar = new zzre();
        if (zzreVar.f38041a == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build()");
        }
        zzreVar.f38042b = zzlbVar.f37910c;
        Iterator it = zzlbVar.f37908a.values().iterator();
        while (it.hasNext()) {
            for (zzkv zzkvVar : (List) it.next()) {
                int i2 = zzkvVar.f37903e - 2;
                if (i2 == 1) {
                    zzkjVar = zzkj.f37887b;
                } else if (i2 == 2) {
                    zzkjVar = zzkj.f37888c;
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzkjVar = zzkj.f37889d;
                }
                ArrayList arrayList = zzreVar.f38041a;
                if (arrayList == null) {
                    throw new IllegalStateException("addEntry cannot be called after build()");
                }
                arrayList.add(new zzrg(zzkjVar, zzkvVar.f37901c, zzkvVar.f37902d));
            }
        }
        zzkv zzkvVar2 = zzlbVar.f37909b;
        if (zzkvVar2 != null) {
            if (zzreVar.f38041a == null) {
                throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
            }
            zzreVar.f38043c = Integer.valueOf(zzkvVar2.f37901c);
        }
        try {
            return zzreVar.a();
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
