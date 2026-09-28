package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzw {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f36508a;

    /* renamed from: b, reason: collision with root package name */
    public final zzu f36509b;

    public zzw(zzu zzuVar, boolean z) {
        this.f36509b = zzuVar;
        this.f36508a = z;
    }

    public static zzw a(zzp zzpVar) {
        return new zzw(new zzu(zzpVar), false);
    }

    public final Iterable b(String str) {
        return new zzt(this, str);
    }

    public final List c(String str) {
        str.getClass();
        zzs zzsVar = new zzs(this, str, this.f36509b.f36503a);
        ArrayList arrayList = new ArrayList();
        while (zzsVar.hasNext()) {
            arrayList.add((String) zzsVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
