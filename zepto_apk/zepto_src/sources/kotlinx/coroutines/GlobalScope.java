package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
@DelicateCoroutinesApi
/* loaded from: classes.dex */
public final class GlobalScope implements CoroutineScope {

    /* renamed from: a, reason: collision with root package name */
    public static final GlobalScope f54113a = new GlobalScope();

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return EmptyCoroutineContext.f53685a;
    }
}
