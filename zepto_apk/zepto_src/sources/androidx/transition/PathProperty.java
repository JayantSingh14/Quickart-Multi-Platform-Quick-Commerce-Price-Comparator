package androidx.transition;

import android.util.Property;

/* loaded from: classes3.dex */
class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    public float f12100a;

    @Override // android.util.Property
    public final Float get(Object obj) {
        return Float.valueOf(this.f12100a);
    }

    @Override // android.util.Property
    public final void set(Object obj, Float f2) {
        this.f12100a = f2.floatValue();
        throw null;
    }
}
