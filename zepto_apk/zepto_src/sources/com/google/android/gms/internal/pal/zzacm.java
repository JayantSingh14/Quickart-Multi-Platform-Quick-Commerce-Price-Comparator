package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzacm {

    /* renamed from: b, reason: collision with root package name */
    public static volatile zzacm f37388b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzacm f37389c = new zzacm();

    /* renamed from: a, reason: collision with root package name */
    public final Map f37390a = Collections.EMPTY_MAP;

    public static zzacm a() {
        zzacm zzacmVar;
        zzacm zzacmVar2 = f37388b;
        if (zzacmVar2 != null) {
            return zzacmVar2;
        }
        synchronized (zzacm.class) {
            try {
                zzacmVar = f37388b;
                if (zzacmVar == null) {
                    zzacmVar = f37389c;
                    f37388b = zzacmVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzacmVar;
    }
}
