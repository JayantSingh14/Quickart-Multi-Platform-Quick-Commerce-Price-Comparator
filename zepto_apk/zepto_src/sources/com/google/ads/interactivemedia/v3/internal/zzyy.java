package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;
import java.util.Currency;

/* loaded from: classes3.dex */
final class zzyy extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        String strZzh = zzaaqVar.zzh();
        try {
            return Currency.getInstance(strZzh);
        } catch (IllegalArgumentException e2) {
            throw new zzuk(e.p("Failed parsing '", strZzh, "' as Currency; at path ", zzaaqVar.zzf()), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzl(((Currency) obj).getCurrencyCode());
    }
}
