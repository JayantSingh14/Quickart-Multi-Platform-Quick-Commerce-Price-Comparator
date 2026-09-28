package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public enum zzur implements zzus {
    DOUBLE,
    LAZILY_PARSED_NUMBER,
    LONG_OR_DOUBLE,
    BIG_DECIMAL;

    @Override // com.google.ads.interactivemedia.v3.internal.zzus
    public final /* synthetic */ Number zza(zzaaq zzaaqVar) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return Double.valueOf(zzaaqVar.zza());
        }
        if (iOrdinal == 1) {
            return new zzwb(zzaaqVar.zzh());
        }
        if (iOrdinal == 2 || iOrdinal != 3) {
            throw null;
        }
        throw null;
    }
}
