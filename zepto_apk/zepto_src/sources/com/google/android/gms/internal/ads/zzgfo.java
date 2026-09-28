package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class zzgfo extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public static volatile Long f32471f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f32472g = new Object();

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        if (f32471f == null) {
            synchronized (f32472g) {
                try {
                    if (f32471f == null) {
                        Long l2 = (Long) method.invoke("", null);
                        if (l2 == null) {
                            throw null;
                        }
                        f32471f = l2;
                    }
                } finally {
                }
            }
        }
        synchronized (zzavsVar) {
            try {
                if (f32471f != null) {
                    long jLongValue = f32471f.longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).T0(jLongValue);
                }
            } finally {
            }
        }
    }
}
