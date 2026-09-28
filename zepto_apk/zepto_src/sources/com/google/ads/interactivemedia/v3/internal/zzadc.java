package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: classes3.dex */
final class zzadc implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzade) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzadz) {
            return ((zzade) this.zza.getValue()).zzc((zzadz) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzade zza() {
        return (zzade) this.zza.getValue();
    }
}
