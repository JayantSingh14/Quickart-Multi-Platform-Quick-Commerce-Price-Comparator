package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Companion f53541c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f53542d = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    public volatile Function0 f53543a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f53544b;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // kotlin.Lazy
    public final boolean d() {
        return this.f53544b != UNINITIALIZED_VALUE.f53566a;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj = this.f53544b;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f53566a;
        if (obj != uninitialized_value) {
            return obj;
        }
        Function0 function0 = this.f53543a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f53542d;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uninitialized_value, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(this) != uninitialized_value) {
                }
            }
            this.f53543a = null;
            return objInvoke;
        }
        return this.f53544b;
    }

    public final String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
