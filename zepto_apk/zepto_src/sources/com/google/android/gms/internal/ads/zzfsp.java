package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfsp {

    /* renamed from: d, reason: collision with root package name */
    public static final zzfsp f31802d = new zzfsp();

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f31803a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31804b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31805c = false;

    public final void a(boolean z, boolean z2) {
        if ((z2 || z) == (this.f31805c || this.f31804b)) {
            return;
        }
        Iterator it = Collections.unmodifiableCollection(zzfsf.f31780c.f31781a).iterator();
        while (it.hasNext()) {
            zzfsv zzfsvVar = ((zzfrl) it.next()).f31721d;
            boolean z3 = z2 || z;
            if (zzfsvVar.f31811b.get() != 0) {
                zzfsm.f31796a.a(zzfsvVar.c(), "setDeviceLockState", true != z3 ? "unlocked" : "locked");
            }
        }
    }
}
