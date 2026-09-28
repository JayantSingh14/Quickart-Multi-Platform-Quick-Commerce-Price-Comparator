package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface MainDispatcherFactory {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    MainCoroutineDispatcher a(List list);

    int b();
}
