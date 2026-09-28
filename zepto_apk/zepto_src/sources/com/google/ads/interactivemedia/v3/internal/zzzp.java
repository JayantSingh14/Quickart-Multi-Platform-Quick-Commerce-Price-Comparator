package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class zzzp extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        try {
            return new AtomicInteger(zzaaqVar.zzb());
        } catch (NumberFormatException e2) {
            throw new zzuk(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzi(((AtomicInteger) obj).get());
    }
}
