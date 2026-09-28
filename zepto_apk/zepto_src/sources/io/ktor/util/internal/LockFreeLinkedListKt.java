package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LockFreeLinkedListKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f50561a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f50562b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f50563c;

    static {
        new Symbol("CONDITION_FALSE");
        new Symbol("ALREADY_REMOVED");
        new Symbol("LIST_EMPTY");
        new Symbol("REMOVE_PREPARED");
        f50563c = new Symbol("NO_DECISION");
    }

    public static final LockFreeLinkedListNode a(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        return (removed == null || (lockFreeLinkedListNode = removed.f50567a) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
