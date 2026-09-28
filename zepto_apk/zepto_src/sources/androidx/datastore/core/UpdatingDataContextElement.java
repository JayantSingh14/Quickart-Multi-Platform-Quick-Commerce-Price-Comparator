package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class UpdatingDataContextElement implements CoroutineContext.Element {

    /* renamed from: a, reason: collision with root package name */
    public final UpdatingDataContextElement f3643a;

    /* renamed from: b, reason: collision with root package name */
    public final DataStoreImpl f3644b;

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class Key implements CoroutineContext.Key<UpdatingDataContextElement> {

            /* renamed from: a, reason: collision with root package name */
            public static final Key f3645a = new Key();
        }
    }

    public UpdatingDataContextElement(UpdatingDataContextElement updatingDataContextElement, DataStoreImpl instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.f3643a = updatingDataContextElement;
        this.f3644b = instance;
    }

    public final void b(DataStoreImpl candidate) {
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        if (this.f3644b == candidate) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        UpdatingDataContextElement updatingDataContextElement = this.f3643a;
        if (updatingDataContextElement != null) {
            updatingDataContextElement.b(candidate);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.a(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Companion.Key.f3645a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.c(this, coroutineContext);
    }
}
