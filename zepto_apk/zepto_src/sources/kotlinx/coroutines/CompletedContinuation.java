package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class CompletedContinuation<R> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f54067a;

    /* renamed from: b, reason: collision with root package name */
    public final CancelHandler f54068b;

    /* renamed from: c, reason: collision with root package name */
    public final Function3 f54069c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f54070d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f54071e;

    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th) {
        this.f54067a = obj;
        this.f54068b = cancelHandler;
        this.f54069c = function3;
        this.f54070d = obj2;
        this.f54071e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static CompletedContinuation a(CompletedContinuation completedContinuation, CancelHandler cancelHandler, CancellationException cancellationException, int i2) {
        Object obj = completedContinuation.f54067a;
        if ((i2 & 2) != 0) {
            cancelHandler = completedContinuation.f54068b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        Function3 function3 = completedContinuation.f54069c;
        Object obj2 = completedContinuation.f54070d;
        CancellationException cancellationException2 = cancellationException;
        if ((i2 & 16) != 0) {
            cancellationException2 = completedContinuation.f54071e;
        }
        completedContinuation.getClass();
        return new CompletedContinuation(obj, cancelHandler2, function3, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.b(this.f54067a, completedContinuation.f54067a) && Intrinsics.b(this.f54068b, completedContinuation.f54068b) && Intrinsics.b(this.f54069c, completedContinuation.f54069c) && Intrinsics.b(this.f54070d, completedContinuation.f54070d) && Intrinsics.b(this.f54071e, completedContinuation.f54071e);
    }

    public final int hashCode() {
        Object obj = this.f54067a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f54068b;
        int iHashCode2 = (iHashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function3 function3 = this.f54069c;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.f54070d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f54071e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f54067a + ", cancelHandler=" + this.f54068b + ", onCancellation=" + this.f54069c + ", idempotentResume=" + this.f54070d + ", cancelCause=" + this.f54071e + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, CancellationException cancellationException, int i2) {
        this(obj, (i2 & 2) != 0 ? null : cancelHandler, (i2 & 4) != 0 ? null : function3, (Object) null, (i2 & 16) != 0 ? null : cancellationException);
    }
}
