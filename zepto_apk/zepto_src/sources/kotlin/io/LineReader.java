package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LineReader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LineReader f53747a = new LineReader();

    static {
        Intrinsics.checkNotNullExpressionValue(ByteBuffer.wrap(new byte[32]), "wrap(...)");
        Intrinsics.checkNotNullExpressionValue(CharBuffer.wrap(new char[32]), "wrap(...)");
    }
}
