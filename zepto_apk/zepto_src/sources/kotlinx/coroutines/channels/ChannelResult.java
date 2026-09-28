package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;

@Metadata
@JvmInline
/* loaded from: classes.dex */
public final class ChannelResult<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final Failed f54254b = new Failed();

    /* renamed from: a, reason: collision with root package name */
    public final Object f54255a;

    @Metadata
    public static final class Closed extends Failed {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f54256a;

        public Closed(Throwable th) {
            this.f54256a = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Closed) {
                return Intrinsics.b(this.f54256a, ((Closed) obj).f54256a);
            }
            return false;
        }

        public final int hashCode() {
            Throwable th = this.f54256a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public final String toString() {
            return "Closed(" + this.f54256a + ')';
        }
    }

    @InternalCoroutinesApi
    @Metadata
    public static final class Companion {
        public static Closed a(Throwable th) {
            Closed closed = new Closed(th);
            Failed failed = ChannelResult.f54254b;
            return closed;
        }
    }

    @Metadata
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ ChannelResult(Object obj) {
        this.f54255a = obj;
    }

    public static final Throwable a(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.f54256a;
        }
        return null;
    }

    public static final Object b(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ChannelResult) {
            return Intrinsics.b(this.f54255a, ((ChannelResult) obj).f54255a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f54255a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f54255a;
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
