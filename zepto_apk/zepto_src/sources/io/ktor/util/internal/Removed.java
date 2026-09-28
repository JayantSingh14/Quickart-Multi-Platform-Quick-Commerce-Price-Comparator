package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class Removed {

    /* renamed from: a, reason: collision with root package name */
    public final LockFreeLinkedListNode f50567a;

    public Removed(LockFreeLinkedListNode ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.f50567a = ref;
    }

    public final String toString() {
        return "Removed[" + this.f50567a + ']';
    }
}
