package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class zzgqw {
    public static zzgqs a(zzgqs zzgqsVar) {
        return ((zzgqsVar instanceof zzgqv) || (zzgqsVar instanceof zzgqt)) ? zzgqsVar : zzgqsVar instanceof Serializable ? new zzgqt(zzgqsVar) : new zzgqv(zzgqsVar);
    }
}
