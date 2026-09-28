package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes4.dex */
public final class zzfjj {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingDeque f31271a = new LinkedBlockingDeque();

    /* renamed from: b, reason: collision with root package name */
    public final zzdsn f31272b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f31273c;

    public zzfjj(zzdsn zzdsnVar, zzgyw zzgywVar) {
        this.f31272b = zzdsnVar;
        this.f31273c = zzgywVar;
    }

    public final synchronized void a(int i2) {
        LinkedBlockingDeque linkedBlockingDeque = this.f31271a;
        int size = i2 - linkedBlockingDeque.size();
        for (int i3 = 0; i3 < size; i3++) {
            linkedBlockingDeque.add(((zzgxi) this.f31273c).submit(this.f31272b));
        }
    }

    public final synchronized ListenableFuture b() {
        a(1);
        return (ListenableFuture) this.f31271a.poll();
    }
}
