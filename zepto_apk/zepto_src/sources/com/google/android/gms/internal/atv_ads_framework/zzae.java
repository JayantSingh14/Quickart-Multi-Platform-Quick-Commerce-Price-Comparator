package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzae implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Object f36032a;

    /* renamed from: b, reason: collision with root package name */
    public int f36033b;

    public abstract String a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f36033b;
        if (i2 == 4) {
            throw new IllegalStateException();
        }
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.f36033b = 4;
            this.f36032a = a();
            if (this.f36033b != 3) {
                this.f36033b = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f36033b = 2;
        Object obj = this.f36032a;
        this.f36032a = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
