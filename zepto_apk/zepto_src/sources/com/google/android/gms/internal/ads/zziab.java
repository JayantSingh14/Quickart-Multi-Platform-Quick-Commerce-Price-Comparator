package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zziab {

    /* renamed from: b, reason: collision with root package name */
    public static volatile zziab f34620b;

    /* renamed from: c, reason: collision with root package name */
    public static final zziab f34621c = new zziab();

    /* renamed from: a, reason: collision with root package name */
    public final Map f34622a = Collections.EMPTY_MAP;

    public static zziab a() {
        zziab zziabVar = f34620b;
        if (zziabVar != null) {
            return zziabVar;
        }
        synchronized (zziab.class) {
            try {
                zziab zziabVar2 = f34620b;
                if (zziabVar2 != null) {
                    return zziabVar2;
                }
                int i2 = zzhyy.f34536a;
                zziab zziabVarB = zziaj.b();
                f34620b = zziabVarB;
                return zziabVarB;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
