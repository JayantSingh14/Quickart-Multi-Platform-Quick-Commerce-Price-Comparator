package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    @Override // androidx.datastore.core.CorruptionHandler
    public final Object a(CorruptionException corruptionException) throws CorruptionException {
        throw corruptionException;
    }
}
