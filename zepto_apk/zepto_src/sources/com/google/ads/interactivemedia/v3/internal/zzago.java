package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzago extends zzagp {
    private static final zzago zzc = new zzago(null, null);
    public final Object zza;
    public final Object zzb;

    public zzago(Object obj, Object obj2) {
        this.zza = obj;
        this.zzb = obj2;
    }

    public static zzago zzc(Object obj, Object obj2) {
        return (obj == null && obj2 == null) ? zzc : new zzago(obj, obj2);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagp
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagp
    public final Object zzb() {
        return this.zzb;
    }
}
