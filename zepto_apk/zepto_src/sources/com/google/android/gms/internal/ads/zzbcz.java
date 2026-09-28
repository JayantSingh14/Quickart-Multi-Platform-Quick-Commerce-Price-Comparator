package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* loaded from: classes4.dex */
public final class zzbcz extends com.google.android.gms.ads.internal.client.zzcn {

    /* renamed from: b, reason: collision with root package name */
    public final AppEventListener f24736b;

    public zzbcz(AppEventListener appEventListener) {
        this.f24736b = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void p1(String str, String str2) {
        this.f24736b.y(str, str2);
    }
}
