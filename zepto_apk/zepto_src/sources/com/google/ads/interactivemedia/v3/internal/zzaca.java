package com.google.ads.interactivemedia.v3.internal;

import org.xbill.DNS.Message;

/* loaded from: classes3.dex */
final class zzaca {
    private final Object zza;
    private final int zzb;

    public zzaca(Object obj, int i2) {
        this.zza = obj;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaca)) {
            return false;
        }
        zzaca zzacaVar = (zzaca) obj;
        return this.zza == zzacaVar.zza && this.zzb == zzacaVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Message.MAXLENGTH) + this.zzb;
    }
}
