package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes3.dex */
public final class MissingMainCoroutineDispatcherFactory implements MainDispatcherFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final MissingMainCoroutineDispatcherFactory f55100a = new MissingMainCoroutineDispatcherFactory();

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final MainCoroutineDispatcher a(List list) {
        return new MissingMainCoroutineDispatcher();
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public final int b() {
        return -1;
    }
}
