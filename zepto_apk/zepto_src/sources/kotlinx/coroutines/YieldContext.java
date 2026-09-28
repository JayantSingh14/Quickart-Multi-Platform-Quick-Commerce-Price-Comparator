package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class YieldContext extends AbstractCoroutineContextElement {

    /* renamed from: b, reason: collision with root package name */
    public static final Key f54173b = new Key();

    /* renamed from: a, reason: collision with root package name */
    public boolean f54174a;

    @Metadata
    public static final class Key implements CoroutineContext.Key<YieldContext> {
    }

    public YieldContext() {
        super(f54173b);
    }
}
