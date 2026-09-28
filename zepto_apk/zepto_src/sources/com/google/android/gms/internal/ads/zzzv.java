package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzzv {

    /* renamed from: a, reason: collision with root package name */
    public final zzbg f35997a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f35998b;

    public zzzv(zzbg zzbgVar, int[] iArr) {
        if (iArr.length == 0) {
            zzee.f("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f35997a = zzbgVar;
        this.f35998b = iArr;
    }
}
