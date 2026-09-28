package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import java.util.HashSet;

/* loaded from: classes.dex */
final class zzad extends zzor {

    /* renamed from: d, reason: collision with root package name */
    public String f38668d;

    /* renamed from: e, reason: collision with root package name */
    public HashSet f38669e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayMap f38670f;

    /* renamed from: g, reason: collision with root package name */
    public Long f38671g;

    /* renamed from: h, reason: collision with root package name */
    public Long f38672h;

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final java.util.ArrayList k(java.lang.String r35, java.util.List r36, java.util.List r37, java.lang.Long r38, java.lang.Long r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 2767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.k(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.ArrayList");
    }

    public final zzy l(Integer num) {
        if (this.f38670f.containsKey(num)) {
            return (zzy) this.f38670f.get(num);
        }
        zzy zzyVar = new zzy(this, this.f38668d);
        this.f38670f.put(num, zzyVar);
        return zzyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
