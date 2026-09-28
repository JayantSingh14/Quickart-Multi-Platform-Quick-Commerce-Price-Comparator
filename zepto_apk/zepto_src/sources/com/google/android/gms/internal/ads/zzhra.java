package com.google.android.gms.internal.ads;

import java.security.spec.ECParameterSpec;

/* loaded from: classes4.dex */
public final class zzhra {

    /* renamed from: c, reason: collision with root package name */
    public static final zzhra f34078c = new zzhra("NIST_P256", zzhhq.f33824a);

    /* renamed from: d, reason: collision with root package name */
    public static final zzhra f34079d = new zzhra("NIST_P384", zzhhq.f33825b);

    /* renamed from: e, reason: collision with root package name */
    public static final zzhra f34080e = new zzhra("NIST_P521", zzhhq.f33826c);

    /* renamed from: a, reason: collision with root package name */
    public final String f34081a;

    /* renamed from: b, reason: collision with root package name */
    public final ECParameterSpec f34082b;

    public zzhra(String str, ECParameterSpec eCParameterSpec) {
        this.f34081a = str;
        this.f34082b = eCParameterSpec;
    }

    public final String toString() {
        return this.f34081a;
    }
}
