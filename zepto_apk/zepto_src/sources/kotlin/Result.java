package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@JvmInline
/* loaded from: classes.dex */
public final class Result<T> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53538b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f53539a;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    public static final class Failure implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f53540a;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.f53540a = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                return Intrinsics.b(this.f53540a, ((Failure) obj).f53540a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f53540a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.f53540a + ')';
        }
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).f53540a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Result) {
            return Intrinsics.b(this.f53539a, ((Result) obj).f53539a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f53539a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f53539a;
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
