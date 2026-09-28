package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class zziix extends AbstractList {

    /* renamed from: c, reason: collision with root package name */
    public static final zziiy f34863c = zziiy.b(zziix.class);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f34864a;

    /* renamed from: b, reason: collision with root package name */
    public final zziir f34865b;

    public zziix(ArrayList arrayList, zziir zziirVar) {
        this.f34864a = arrayList;
        this.f34865b = zziirVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        ArrayList arrayList = this.f34864a;
        if (arrayList.size() > i2) {
            return arrayList.get(i2);
        }
        zziir zziirVar = this.f34865b;
        if (!zziirVar.hasNext()) {
            throw new NoSuchElementException();
        }
        arrayList.add(zziirVar.next());
        return get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zziiw(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        zziiy zziiyVar = f34863c;
        zziiyVar.a("potentially expensive size() call");
        zziiyVar.a("blowup running");
        while (true) {
            zziir zziirVar = this.f34865b;
            boolean zHasNext = zziirVar.hasNext();
            ArrayList arrayList = this.f34864a;
            if (!zHasNext) {
                return arrayList.size();
            }
            arrayList.add(zziirVar.next());
        }
    }
}
