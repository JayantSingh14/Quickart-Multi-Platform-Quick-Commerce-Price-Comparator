package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzglx {

    /* renamed from: a, reason: collision with root package name */
    public final Set f32884a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgmo f32885b;

    public zzglx(zzgmo zzgmoVar, Set set) {
        this.f32884a = set;
        this.f32885b = zzgmoVar;
    }

    public final HashMap a() {
        HashMap map = new HashMap();
        Iterator it = this.f32884a.iterator();
        while (it.hasNext()) {
            ((zzglz) it.next()).c(map);
        }
        return map;
    }

    public final HashMap b(Context context, View view) {
        HashMap map = new HashMap();
        Iterator it = this.f32884a.iterator();
        while (it.hasNext()) {
            ((zzglz) it.next()).a(map, context, view);
        }
        return map;
    }

    public final HashMap c() {
        HashMap map = new HashMap();
        Iterator it = this.f32884a.iterator();
        while (it.hasNext()) {
            ((zzglz) it.next()).b(map);
        }
        return map;
    }
}
