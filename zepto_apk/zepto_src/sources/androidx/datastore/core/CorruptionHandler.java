package androidx.datastore.core;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface CorruptionHandler<T> {
    Object a(CorruptionException corruptionException);
}
