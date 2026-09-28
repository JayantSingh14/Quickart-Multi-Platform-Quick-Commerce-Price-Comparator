package kotlin;

import java.io.Serializable;

@Metadata
/* loaded from: classes3.dex */
public final class InitializedLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f53523a;

    public InitializedLazyImpl(Object obj) {
        this.f53523a = obj;
    }

    @Override // kotlin.Lazy
    public final boolean d() {
        return true;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        return this.f53523a;
    }

    public final String toString() {
        return String.valueOf(this.f53523a);
    }
}
