package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzeqs implements zzddb {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f30115a = new AtomicReference();

    @Override // com.google.android.gms.internal.ads.zzddb
    public final void a(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfey.a(this.f30115a, new zzfex() { // from class: com.google.android.gms.internal.ads.zzeqr
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdt) obj).va(zztVar);
            }
        });
    }
}
