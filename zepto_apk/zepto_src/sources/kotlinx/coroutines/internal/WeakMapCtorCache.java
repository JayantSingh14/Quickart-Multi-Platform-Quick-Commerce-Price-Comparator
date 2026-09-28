package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class WeakMapCtorCache extends CtorCache {

    /* renamed from: a, reason: collision with root package name */
    public static final WeakMapCtorCache f55119a = new WeakMapCtorCache();

    static {
        new ReentrantReadWriteLock();
        new WeakHashMap();
    }
}
