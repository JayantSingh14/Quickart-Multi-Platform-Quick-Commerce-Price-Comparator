package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeqz implements zzere {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzera f30139a;

    public zzeqz(zzera zzeraVar) {
        Objects.requireNonNull(zzeraVar);
        this.f30139a = zzeraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void a(zzcvk zzcvkVar) {
        zzera zzeraVar = this.f30139a;
        synchronized (zzeraVar) {
            zzeraVar.f30149c = zzcvkVar.f27232f;
            zzcvkVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzere
    public final void zza() {
        synchronized (this.f30139a) {
        }
    }
}
