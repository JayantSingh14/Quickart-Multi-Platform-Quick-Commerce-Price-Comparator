package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class zzxq extends zzuu {
    private static final zzuv zza = zzb(zzur.LAZILY_PARSED_NUMBER);
    private final zzus zzb;

    private zzxq(zzus zzusVar) {
        this.zzb = zzusVar;
    }

    public static zzuv zza(zzus zzusVar) {
        return zzusVar == zzur.LAZILY_PARSED_NUMBER ? zza : zzb(zzusVar);
    }

    private static zzuv zzb(zzus zzusVar) {
        return new zzxp(new zzxq(zzusVar));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        int iZzr = zzaaqVar.zzr();
        int i2 = iZzr - 1;
        if (i2 == 5 || i2 == 6) {
            return this.zzb.zza(zzaaqVar);
        }
        if (i2 != 8) {
            throw new zzuk(e.p("Expecting number, got: ", zzaar.zza(iZzr), "; at path ", zzaaqVar.zze()));
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzk((Number) obj);
    }
}
