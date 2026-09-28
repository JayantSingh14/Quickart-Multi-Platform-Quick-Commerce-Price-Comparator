package androidx.datastore.core;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Final<T> extends State<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f3579b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Final(Throwable finalException) {
        super(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        Intrinsics.checkNotNullParameter(finalException, "finalException");
        this.f3579b = finalException;
    }
}
