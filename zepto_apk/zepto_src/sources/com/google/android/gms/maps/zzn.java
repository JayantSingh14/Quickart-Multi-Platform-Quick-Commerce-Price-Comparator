package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Circle;
import com.google.maps.android.collections.CircleManager;

/* loaded from: classes4.dex */
final class zzn extends com.google.android.gms.maps.internal.zzw {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircleManager f38637a;

    public zzn(CircleManager circleManager) {
        this.f38637a = circleManager;
    }

    @Override // com.google.android.gms.maps.internal.zzx
    public final void Fa(com.google.android.gms.internal.maps.zzl zzlVar) {
        this.f38637a.k(new Circle(zzlVar));
    }
}
