package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzbtr implements MediationAdRequest {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f25540a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25541b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25542c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25543d;

    public zzbtr(HashSet hashSet, boolean z, int i2, boolean z2) {
        this.f25540a = hashSet;
        this.f25541b = z;
        this.f25542c = i2;
        this.f25543d = z2;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int b() {
        return this.f25542c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean c() {
        return this.f25543d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean d() {
        return this.f25541b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set g() {
        return this.f25540a;
    }
}
