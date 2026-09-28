package coil3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: classes.dex */
public /* synthetic */ class SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private {
    private static final /* synthetic */ AtomicReferenceFieldUpdater reference$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.class, Object.class, "reference$volatile");
    private volatile /* synthetic */ Object reference$volatile;

    private SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private() {
    }

    private final /* synthetic */ Object getReference$volatile() {
        return this.reference$volatile;
    }

    private final /* synthetic */ void setReference$volatile(Object obj) {
        this.reference$volatile = obj;
    }

    public /* synthetic */ SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
