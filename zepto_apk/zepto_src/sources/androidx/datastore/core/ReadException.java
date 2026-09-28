package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReadException<T> extends State<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f3605b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadException(int i2, Throwable readException) {
        super(i2);
        Intrinsics.checkNotNullParameter(readException, "readException");
        this.f3605b = readException;
    }
}
