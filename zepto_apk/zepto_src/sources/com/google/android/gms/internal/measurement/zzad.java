package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzad implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f36754a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzae f36755b;

    public zzad(zzae zzaeVar) {
        Objects.requireNonNull(zzaeVar);
        this.f36755b = zzaeVar;
        this.f36754a = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36754a < this.f36755b.n();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i2 = this.f36754a;
        zzae zzaeVar = this.f36755b;
        if (i2 >= zzaeVar.n()) {
            int i3 = this.f36754a;
            throw new NoSuchElementException(e.r(new StringBuilder(String.valueOf(i3).length() + 21), i3, "Out of bounds index: "));
        }
        int i4 = this.f36754a;
        this.f36754a = i4 + 1;
        return zzaeVar.o(i4);
    }
}
