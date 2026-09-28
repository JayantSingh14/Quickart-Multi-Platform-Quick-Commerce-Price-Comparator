package io.sentry.android.replay.util;

import android.annotation.TargetApi;
import io.sentry.rrweb.RRWebEvent;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PersistableLinkedList extends ConcurrentLinkedDeque<RRWebEvent> {
    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        RRWebEvent element = (RRWebEvent) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        super.add(element);
        throw null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        super.addAll(elements);
        throw null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof RRWebEvent) {
            return super.contains((RRWebEvent) obj);
        }
        return false;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof RRWebEvent) {
            return super.remove((RRWebEvent) obj);
        }
        return false;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.Deque, java.util.Queue
    public final Object remove() {
        throw null;
    }
}
