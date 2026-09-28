package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class ReadWriteBufferState {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f51253a;

    /* renamed from: b, reason: collision with root package name */
    public final RingBufferCapacity f51254b;

    @Metadata
    public static final class IdleEmpty extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public static final IdleEmpty f51255c = new IdleEmpty(ReadWriteBufferStateKt.f51267a, ReadWriteBufferStateKt.f51268b);

        public final String toString() {
            return "IDLE(empty)";
        }
    }

    @Metadata
    public static final class IdleNonEmpty extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public final Initial f51256c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdleNonEmpty(Initial initial) {
            super(initial.f51253a, initial.f51254b);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.f51256c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final boolean a() {
            return true;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState d() {
            return this.f51256c.f51260f;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState e() {
            return this.f51256c.f51261g;
        }

        public final String toString() {
            return "IDLE(with buffer)";
        }
    }

    @Metadata
    public static final class Initial extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public final ByteBuffer f51257c;

        /* renamed from: d, reason: collision with root package name */
        public final ByteBuffer f51258d;

        /* renamed from: e, reason: collision with root package name */
        public final IdleNonEmpty f51259e;

        /* renamed from: f, reason: collision with root package name */
        public final Reading f51260f;

        /* renamed from: g, reason: collision with root package name */
        public final Writing f51261g;

        /* renamed from: h, reason: collision with root package name */
        public final ReadingWriting f51262h;

        public /* synthetic */ Initial(ByteBuffer byteBuffer) {
            this(8, byteBuffer);
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final boolean a() {
            throw new IllegalStateException("Not available for initial state");
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer b() {
            return this.f51258d;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer c() {
            return this.f51257c;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState d() {
            return this.f51260f;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState e() {
            return this.f51261g;
        }

        public final String toString() {
            return "Initial";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Initial(int i2, ByteBuffer backingBuffer) {
            super(backingBuffer, new RingBufferCapacity(backingBuffer.capacity() - i2));
            Intrinsics.checkNotNullParameter(backingBuffer, "backingBuffer");
            if (backingBuffer.position() != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (backingBuffer.limit() != backingBuffer.capacity()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            ByteBuffer byteBufferDuplicate = backingBuffer.duplicate();
            Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate, "backingBuffer.duplicate()");
            this.f51257c = byteBufferDuplicate;
            ByteBuffer byteBufferDuplicate2 = backingBuffer.duplicate();
            Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate2, "backingBuffer.duplicate()");
            this.f51258d = byteBufferDuplicate2;
            this.f51259e = new IdleNonEmpty(this);
            this.f51260f = new Reading(this);
            this.f51261g = new Writing(this);
            this.f51262h = new ReadingWriting(this);
        }
    }

    @Metadata
    public static final class Reading extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public final Initial f51263c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Reading(Initial initial) {
            super(initial.f51253a, initial.f51254b);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.f51263c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer b() {
            return this.f51263c.f51258d;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState e() {
            return this.f51263c.f51262h;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState f() {
            return this.f51263c.f51259e;
        }

        public final String toString() {
            return "Reading";
        }
    }

    @Metadata
    public static final class ReadingWriting extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public final Initial f51264c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadingWriting(Initial initial) {
            super(initial.f51253a, initial.f51254b);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.f51264c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer b() {
            return this.f51264c.f51258d;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer c() {
            return this.f51264c.f51257c;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState f() {
            return this.f51264c.f51261g;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState g() {
            return this.f51264c.f51260f;
        }

        public final String toString() {
            return "Reading+Writing";
        }
    }

    @Metadata
    public static final class Terminated extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public static final Terminated f51265c = new Terminated(ReadWriteBufferStateKt.f51267a, ReadWriteBufferStateKt.f51268b);

        public final String toString() {
            return "Terminated";
        }
    }

    @Metadata
    public static final class Writing extends ReadWriteBufferState {

        /* renamed from: c, reason: collision with root package name */
        public final Initial f51266c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Writing(Initial initial) {
            super(initial.f51253a, initial.f51254b);
            Intrinsics.checkNotNullParameter(initial, "initial");
            this.f51266c = initial;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ByteBuffer c() {
            return this.f51266c.f51257c;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState d() {
            return this.f51266c.f51262h;
        }

        @Override // io.ktor.utils.io.internal.ReadWriteBufferState
        public final ReadWriteBufferState g() {
            return this.f51266c.f51259e;
        }

        public final String toString() {
            return "Writing";
        }
    }

    public ReadWriteBufferState(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity) {
        this.f51253a = byteBuffer;
        this.f51254b = ringBufferCapacity;
    }

    public boolean a() {
        return this instanceof IdleEmpty;
    }

    public ByteBuffer b() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    public ByteBuffer c() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    public ReadWriteBufferState d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    public ReadWriteBufferState e() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    public ReadWriteBufferState f() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    public ReadWriteBufferState g() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }
}
