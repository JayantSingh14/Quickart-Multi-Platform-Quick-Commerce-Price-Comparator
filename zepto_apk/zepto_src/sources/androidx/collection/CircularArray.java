package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CircularArray<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1405a;

    @JvmOverloads
    public CircularArray() {
        this.f1405a = new Object[Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8];
    }
}
