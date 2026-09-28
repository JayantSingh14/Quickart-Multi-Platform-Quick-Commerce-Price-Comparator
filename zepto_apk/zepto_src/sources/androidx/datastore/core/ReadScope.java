package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public interface ReadScope<T> extends Closeable {
    Object a(Continuation continuation);
}
