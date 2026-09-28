package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* loaded from: classes4.dex */
final class zzfjy {

    /* renamed from: b, reason: collision with root package name */
    public final int f31288b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31289c;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f31287a = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public final zzfkx f31290d = new zzfkx();

    public zzfjy(int i2, int i3) {
        this.f31288b = i2;
        this.f31289c = i3;
    }

    public final void a() {
        while (true) {
            LinkedList linkedList = this.f31287a;
            if (linkedList.isEmpty()) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - ((zzfki) linkedList.getFirst()).f31320d < this.f31289c) {
                return;
            }
            zzfkx zzfkxVar = this.f31290d;
            zzfkxVar.f31344f++;
            zzfkxVar.f31340b.f31338b++;
            linkedList.remove();
        }
    }
}
