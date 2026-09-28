package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzlq {

    /* renamed from: b, reason: collision with root package name */
    public static volatile zzlq f37088b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzlq f37089c = new zzlq();

    /* renamed from: a, reason: collision with root package name */
    public final Map f37090a = Collections.EMPTY_MAP;

    public static zzlq a() {
        zzlq zzlqVar = f37088b;
        if (zzlqVar != null) {
            return zzlqVar;
        }
        synchronized (zzlq.class) {
            try {
                zzlq zzlqVar2 = f37088b;
                if (zzlqVar2 != null) {
                    return zzlqVar2;
                }
                zznt zzntVar = zznt.f37161c;
                zzlq zzlqVarB = zzly.b();
                f37088b = zzlqVarB;
                return zzlqVarB;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
