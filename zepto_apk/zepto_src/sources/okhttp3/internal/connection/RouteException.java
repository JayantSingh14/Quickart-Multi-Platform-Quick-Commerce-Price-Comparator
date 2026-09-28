package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final IOException f56559a;

    /* renamed from: b, reason: collision with root package name */
    public IOException f56560b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException firstConnectException) {
        super(firstConnectException);
        Intrinsics.checkNotNullParameter(firstConnectException, "firstConnectException");
        this.f56559a = firstConnectException;
        this.f56560b = firstConnectException;
    }
}
