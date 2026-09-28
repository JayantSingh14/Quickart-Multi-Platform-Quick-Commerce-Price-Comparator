package com.google.android.gms.internal.ads;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* loaded from: classes4.dex */
final class zzgyr extends AbstractOwnableSynchronizer implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyt f33380a;

    public final /* synthetic */ void a(Thread thread) {
        setExclusiveOwnerThread(thread);
    }

    @Override // java.lang.Runnable
    public final void run() {
    }

    public final String toString() {
        return this.f33380a.toString();
    }
}
