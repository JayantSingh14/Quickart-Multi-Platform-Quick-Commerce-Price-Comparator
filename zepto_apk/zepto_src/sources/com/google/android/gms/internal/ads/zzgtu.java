package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class zzgtu implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgtu f33211a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzgtu[] f33212b;

    static {
        zzgtu zzgtuVar = new zzgtu("INSTANCE", 0);
        f33211a = zzgtuVar;
        f33212b = new zzgtu[]{zzgtuVar};
    }

    public static zzgtu[] values() {
        return (zzgtu[]) f33212b.clone();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgqa.g("no calls to next() since the last call to remove()", false);
    }
}
