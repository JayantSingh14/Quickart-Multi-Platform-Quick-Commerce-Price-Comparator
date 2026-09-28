package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* loaded from: classes4.dex */
final class zzer implements AdapterStatus {
    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State a() {
        return AdapterStatus.State.f21078b;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }
}
