package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzbez extends zzcdt {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbff f24867b;

    public zzbez(zzbff zzbffVar) {
        this.f24867b = zzbffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdt, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.f24867b.a();
        return this.f25992a.cancel(z);
    }
}
