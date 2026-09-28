package com.google.android.gms.internal.pal;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzzm extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzzr f38170a;

    public zzzm(zzzr zzzrVar) {
        this.f38170a = zzzrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f38170a.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b A[RETURN] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L2d
            com.google.android.gms.internal.pal.zzzr r0 = r4.f38170a
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r2 = r5.getKey()
            r3 = 0
            if (r2 == 0) goto L15
            com.google.android.gms.internal.pal.zzzq r0 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L15
            goto L16
        L15:
            r0 = r3
        L16:
            if (r0 == 0) goto L29
            java.lang.Object r2 = r0.f38182g
            java.lang.Object r5 = r5.getValue()
            if (r2 == r5) goto L28
            if (r2 == 0) goto L29
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L29
        L28:
            r3 = r0
        L29:
            if (r3 == 0) goto L2d
            r5 = 1
            return r5
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzzm.contains(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzzl(this.f38170a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 != 0) goto L6
            goto L2c
        L6:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            com.google.android.gms.internal.pal.zzzr r0 = r5.f38170a
            java.lang.Object r2 = r6.getKey()
            r3 = 0
            if (r2 == 0) goto L16
            com.google.android.gms.internal.pal.zzzq r2 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L16
            goto L17
        L16:
            r2 = r3
        L17:
            if (r2 == 0) goto L2a
            java.lang.Object r4 = r2.f38182g
            java.lang.Object r6 = r6.getValue()
            if (r4 == r6) goto L29
            if (r4 == 0) goto L2a
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L2a
        L29:
            r3 = r2
        L2a:
            if (r3 != 0) goto L2d
        L2c:
            return r1
        L2d:
            r6 = 1
            r0.b(r3, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzzm.remove(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f38170a.f38187c;
    }
}
