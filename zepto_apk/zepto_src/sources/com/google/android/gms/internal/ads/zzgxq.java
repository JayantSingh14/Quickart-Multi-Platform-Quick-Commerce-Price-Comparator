package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
final class zzgxq extends zzgxp {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f33352a = AtomicReferenceFieldUpdater.newUpdater(zzgxs.class, Set.class, "h");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f33353b = AtomicIntegerFieldUpdater.newUpdater(zzgxs.class, "i");

    @Override // com.google.android.gms.internal.ads.zzgxp
    public final void a(zzgxo zzgxoVar, Set set) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f33352a;
            if (atomicReferenceFieldUpdater.compareAndSet(zzgxoVar, null, set)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(zzgxoVar) == null);
    }

    @Override // com.google.android.gms.internal.ads.zzgxp
    public final int b(zzgxo zzgxoVar) {
        return f33353b.decrementAndGet(zzgxoVar);
    }
}
