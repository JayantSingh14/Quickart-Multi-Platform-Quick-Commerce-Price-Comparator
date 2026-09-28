package com.google.android.gms.internal.pal;

import com.amazon.apay.hardened.external.model.APayConstants;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.LockFreeTaskQueue;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean A(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Continuation continuation) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, continuation, null)) {
            if (atomicReferenceFieldUpdater.get(obj) != continuation) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int a() {
        return (int) (((-1) & 4294967295L) / (4294967295L & 10));
    }

    public static int d(int i2, int i3, int i4) {
        return zzach.a(i2) + i3 + i4;
    }

    public static int e(int i2, int i3, int i4, int i5) {
        return zzach.a(i2) + i3 + i4 + i5;
    }

    public static /* synthetic */ String f(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "\r\n");
            }
        }
        return sb.toString();
    }

    public static Throwable g(ClassNotFoundException classNotFoundException) {
        return new NoClassDefFoundError().initCause(classNotFoundException);
    }

    public static /* synthetic */ Map h(String str, String str2, String str3) {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry(APayConstants.Error.MESSAGE, str), new AbstractMap.SimpleEntry(CLConstants.OTP_STATUS, str2), new AbstractMap.SimpleEntry("timeTaken", str3)};
        HashMap map = new HashMap(3);
        for (int i2 = 0; i2 < 3; i2++) {
            Map.Entry entry = entryArr[i2];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException(android.support.v4.media.b.j(key, "duplicate key: "));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public static /* synthetic */ Set i(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            if (!hashSet.add(obj)) {
                throw new IllegalArgumentException(android.support.v4.media.b.j(obj, "duplicate element: "));
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static /* synthetic */ void j(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, JobSupport jobSupport, Object obj, Incomplete incomplete) {
        while (!atomicReferenceFieldUpdater.compareAndSet(jobSupport, obj, incomplete) && atomicReferenceFieldUpdater.get(jobSupport) == obj) {
        }
    }

    public static /* synthetic */ void k(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, LockFreeTaskQueue lockFreeTaskQueue, LockFreeTaskQueueCore lockFreeTaskQueueCore, LockFreeTaskQueueCore lockFreeTaskQueueCore2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeTaskQueue, lockFreeTaskQueueCore, lockFreeTaskQueueCore2) && atomicReferenceFieldUpdater.get(lockFreeTaskQueue) == lockFreeTaskQueueCore) {
        }
    }

    public static /* synthetic */ boolean l(AtomicReference atomicReference, Object obj) {
        Symbol symbol = StateFlowKt.f54927b;
        while (!atomicReference.compareAndSet(obj, symbol)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean m(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ByteBufferChannel byteBufferChannel, CancellableContinuationImpl cancellableContinuationImpl) {
        while (!atomicReferenceFieldUpdater.compareAndSet(byteBufferChannel, null, cancellableContinuationImpl)) {
            if (atomicReferenceFieldUpdater.get(byteBufferChannel) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean n(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(chunkBuffer, null, chunkBuffer2)) {
            if (atomicReferenceFieldUpdater.get(chunkBuffer) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean o(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, CancellableReusableContinuation cancellableReusableContinuation, Object obj) {
        while (!atomicReferenceFieldUpdater.compareAndSet(cancellableReusableContinuation, obj, null)) {
            if (atomicReferenceFieldUpdater.get(cancellableReusableContinuation) != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean p(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Continuation continuation) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, null, continuation)) {
            if (atomicReferenceFieldUpdater.get(obj) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean q(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, BufferedChannel bufferedChannel, Function1 function1) {
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, null, function1)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean r(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, BufferedChannel bufferedChannel, Segment segment, ChannelSegment channelSegment) {
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, channelSegment)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != segment) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean s(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, BufferedChannel bufferedChannel, Segment segment, Segment segment2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, segment2)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != segment) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean t(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, BufferedChannel bufferedChannel, Symbol symbol, Symbol symbol2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, symbol, symbol2)) {
            if (atomicReferenceFieldUpdater.get(bufferedChannel) != symbol) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean u(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ConcurrentLinkedListNode concurrentLinkedListNode, Object obj, ConcurrentLinkedListNode concurrentLinkedListNode2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(concurrentLinkedListNode, obj, concurrentLinkedListNode2)) {
            if (atomicReferenceFieldUpdater.get(concurrentLinkedListNode) != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean v(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Segment segment, Segment segment2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(segment, null, segment2)) {
            if (atomicReferenceFieldUpdater.get(segment) != null) {
                return false;
            }
        }
        return true;
    }

    public static int x(int i2, int i3, int i4) {
        return (zzach.u(i2) * i3) + i4;
    }

    public static /* synthetic */ boolean y(AtomicReference atomicReference, Object obj) {
        Symbol symbol = StateFlowKt.f54926a;
        while (!atomicReference.compareAndSet(obj, symbol)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean z(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ByteBufferChannel byteBufferChannel, CancellableContinuationImpl cancellableContinuationImpl) {
        while (!atomicReferenceFieldUpdater.compareAndSet(byteBufferChannel, cancellableContinuationImpl, null)) {
            if (atomicReferenceFieldUpdater.get(byteBufferChannel) != cancellableContinuationImpl) {
                return false;
            }
        }
        return true;
    }
}
