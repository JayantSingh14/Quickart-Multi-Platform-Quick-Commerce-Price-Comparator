package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* loaded from: classes4.dex */
public final class zzaed {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f22862a = new LinkedHashMap();

    public final void a(zzaec zzaecVar) {
        long[] jArr = zzaecVar.f22860e;
        if (jArr.length > 0) {
            LinkedHashMap linkedHashMap = this.f22862a;
            if (linkedHashMap.containsKey(Long.valueOf(jArr[0]))) {
                return;
            }
            linkedHashMap.put(Long.valueOf(jArr[0]), zzaecVar);
        }
    }
}
