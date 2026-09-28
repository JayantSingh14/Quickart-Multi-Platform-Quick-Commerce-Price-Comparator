package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public interface WriteScope<T> extends ReadScope<T> {
    Object d(Object obj, ContinuationImpl continuationImpl);
}
