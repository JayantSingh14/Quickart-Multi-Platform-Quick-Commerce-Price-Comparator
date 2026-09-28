package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class zzgfz implements zzgfy {

    /* renamed from: a, reason: collision with root package name */
    public final String f32502a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32503b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgev f32504c;

    /* renamed from: d, reason: collision with root package name */
    public final zzavs f32505d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgna f32506e;

    public zzgfz(String str, String str2, zzavs zzavsVar, zzgev zzgevVar, zzgna zzgnaVar) {
        this.f32502a = str;
        this.f32503b = str2;
        this.f32505d = zzavsVar;
        this.f32504c = zzgevVar;
        this.f32506e = zzgnaVar;
    }

    public abstract void a(Method method, zzavs zzavsVar);

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzgna zzgnaVar = this.f32506e;
        try {
            zzgnaVar.a();
            Method methodC = this.f32504c.c(this.f32502a, this.f32503b);
            if (methodC != null) {
                a(methodC, this.f32505d);
            }
            zzgnaVar.c();
            return null;
        } finally {
        }
    }
}
