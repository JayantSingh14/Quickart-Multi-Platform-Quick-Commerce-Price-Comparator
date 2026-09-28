package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class ParseError {

    /* renamed from: a, reason: collision with root package name */
    public final int f55603a;

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f55604b;

    /* JADX WARN: Multi-variable type inference failed */
    public ParseError(int i2, Function0 message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f55603a = i2;
        this.f55604b = (Lambda) message;
    }
}
