package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzijr {

    /* renamed from: a, reason: collision with root package name */
    public final List f34901a;

    /* renamed from: b, reason: collision with root package name */
    public final List f34902b;

    public zzijr(int i2, int i3) {
        this.f34901a = i2 == 0 ? Collections.EMPTY_LIST : new ArrayList(i2);
        this.f34902b = i3 == 0 ? Collections.EMPTY_LIST : new ArrayList(i3);
    }

    public final void a(zzijp zzijpVar) {
        this.f34901a.add(zzijpVar);
    }

    public final void b(zzijp zzijpVar) {
        this.f34902b.add(zzijpVar);
    }

    public final zzijs c() {
        return new zzijs(this.f34901a, this.f34902b);
    }
}
