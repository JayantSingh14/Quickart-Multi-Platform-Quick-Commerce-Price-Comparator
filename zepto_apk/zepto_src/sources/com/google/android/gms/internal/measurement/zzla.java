package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzla implements zzlc {
    @Override // java.util.Iterator
    public final Object next() {
        zzkz zzkzVar = (zzkz) this;
        int i2 = zzkzVar.f37067a;
        if (i2 >= zzkzVar.f37068b) {
            throw new NoSuchElementException();
        }
        zzkzVar.f37067a = i2 + 1;
        return Byte.valueOf(zzkzVar.f37069c.d(i2));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
