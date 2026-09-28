package io.ktor.events;

import io.ktor.util.internal.LockFreeLinkedListHead;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class Events$subscribe$1 extends Lambda implements Function1<EventDefinition<?>, LockFreeLinkedListHead> {
    static {
        new Events$subscribe$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        EventDefinition it = (EventDefinition) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return new LockFreeLinkedListHead();
    }
}
