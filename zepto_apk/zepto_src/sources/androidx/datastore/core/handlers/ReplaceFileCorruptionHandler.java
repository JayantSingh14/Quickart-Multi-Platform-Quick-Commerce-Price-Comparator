package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f3646a;

    public ReplaceFileCorruptionHandler(Function1 produceNewData) {
        Intrinsics.checkNotNullParameter(produceNewData, "produceNewData");
        this.f3646a = produceNewData;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    public final Object a(CorruptionException corruptionException) {
        return this.f3646a.invoke(corruptionException);
    }
}
