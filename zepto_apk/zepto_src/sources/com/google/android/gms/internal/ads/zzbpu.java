package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* loaded from: classes4.dex */
public final class zzbpu implements AdapterStatus {

    /* renamed from: a, reason: collision with root package name */
    public final AdapterStatus.State f25415a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25416b;

    public zzbpu(AdapterStatus.State state, String str) {
        this.f25415a = state;
        this.f25416b = str;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State a() {
        return this.f25415a;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.f25416b;
    }
}
