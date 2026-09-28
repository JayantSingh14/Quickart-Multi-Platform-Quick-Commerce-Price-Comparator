package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import io.ktor.util.internal.LockFreeLinkedListHead;
import io.ktor.util.internal.LockFreeLinkedListNode;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Events {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteHashMap f50114a = new CopyOnWriteHashMap();

    @Metadata
    /* loaded from: classes3.dex */
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
        public final Function1 e() {
            return null;
        }
    }

    public final void a(EventDefinition definition, Object obj) {
        Unit unit;
        Intrinsics.checkNotNullParameter(definition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead) this.f50114a.a(definition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Object objA = lockFreeLinkedListHead.a();
            Intrinsics.d(objA, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNodeC = (LockFreeLinkedListNode) objA; !Intrinsics.b(lockFreeLinkedListNodeC, lockFreeLinkedListHead); lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.c()) {
                if (lockFreeLinkedListNodeC instanceof HandlerRegistration) {
                    try {
                        Function1 function1E = ((HandlerRegistration) lockFreeLinkedListNodeC).e();
                        Intrinsics.d(function1E, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise$lambda$2, kotlin.Unit>{ io.ktor.events.EventsKt.EventHandler<T of io.ktor.events.Events.raise$lambda$2> }");
                        TypeIntrinsics.b(1, function1E);
                        function1E.invoke(obj);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.a(th2, th3);
                            unit = Unit.f53572a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th != null) {
            throw th;
        }
    }
}
