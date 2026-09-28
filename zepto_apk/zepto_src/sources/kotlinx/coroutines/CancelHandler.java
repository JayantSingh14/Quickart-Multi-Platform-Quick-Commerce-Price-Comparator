package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface CancelHandler extends NotCompleted {

    @Metadata
    public static final class UserSupplied implements CancelHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Function1 f54057a;

        public UserSupplied(Function1 function1) {
            this.f54057a = function1;
        }

        @Override // kotlinx.coroutines.CancelHandler
        public final void b(Throwable th) {
            this.f54057a.invoke(th);
        }

        public final String toString() {
            return "CancelHandler.UserSupplied[" + this.f54057a.getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + ']';
        }
    }

    void b(Throwable th);
}
