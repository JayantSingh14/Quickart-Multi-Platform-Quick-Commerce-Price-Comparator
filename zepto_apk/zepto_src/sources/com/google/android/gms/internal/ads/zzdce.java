package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdce extends zzdgi implements zzbmd {

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f27604b;

    public zzdce(Set set) {
        super(set);
        this.f27604b = new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbmd
    public final synchronized void T(Bundle bundle, String str) {
        this.f27604b.putAll(bundle);
        v0(zzdcd.f27603a);
    }
}
