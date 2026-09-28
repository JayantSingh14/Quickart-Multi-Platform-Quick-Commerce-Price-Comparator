package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class zzbhu {

    /* renamed from: a, reason: collision with root package name */
    public final String f25097a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f25098b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25099c;

    public zzbhu(String str, Object obj, int i2) {
        this.f25097a = str;
        this.f25098b = obj;
        this.f25099c = i2;
    }

    public static zzbhu a(String str, boolean z) {
        return new zzbhu(str, Boolean.valueOf(z), 1);
    }

    public static zzbhu b(long j2, String str) {
        return new zzbhu(str, Long.valueOf(j2), 2);
    }

    public final Object c() {
        zzbja zzbjaVar = (zzbja) zzbjc.f25227a.get();
        Object obj = this.f25098b;
        if (zzbjaVar != null) {
            int i2 = this.f25099c - 1;
            String str = this.f25097a;
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? zzbjaVar.a(str, (String) obj) : zzbjaVar.b(str, ((Double) obj).doubleValue()) : zzbjaVar.zzb(str, ((Long) obj).longValue()) : zzbjaVar.zza(str, ((Boolean) obj).booleanValue());
        }
        AtomicReference atomicReference = zzbjc.f25228b;
        if (((zzbjb) atomicReference.get()) != null) {
            ((zzbjb) atomicReference.get()).zza();
        }
        return obj;
    }
}
