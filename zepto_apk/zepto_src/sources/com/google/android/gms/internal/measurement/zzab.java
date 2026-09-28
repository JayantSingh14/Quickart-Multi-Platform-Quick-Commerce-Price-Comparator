package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzab {

    /* renamed from: a, reason: collision with root package name */
    public zzaa f36749a;

    /* renamed from: b, reason: collision with root package name */
    public zzaa f36750b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f36751c;

    public zzab() {
        this.f36749a = new zzaa("", 0L, null);
        this.f36750b = new zzaa("", 0L, null);
        this.f36751c = new ArrayList();
    }

    public final zzaa a() {
        return this.f36749a;
    }

    public final void b(zzaa zzaaVar) {
        this.f36749a = zzaaVar;
        this.f36750b = zzaaVar.clone();
        this.f36751c.clear();
    }

    public final zzaa c() {
        return this.f36750b;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzab zzabVar = new zzab(this.f36749a.clone());
        Iterator it = this.f36751c.iterator();
        while (it.hasNext()) {
            zzabVar.f36751c.add(((zzaa) it.next()).clone());
        }
        return zzabVar;
    }

    public final List d() {
        return this.f36751c;
    }

    public zzab(zzaa zzaaVar) {
        this.f36749a = zzaaVar;
        this.f36750b = zzaaVar.clone();
        this.f36751c = new ArrayList();
    }
}
