package kotlin.io.path;

import com.horcrux.svg.b;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1 implements Function3 {
    public final Void a(Path path, Path path2, Exception exception) throws Exception {
        Intrinsics.checkNotNullParameter(path, "<unused var>");
        Intrinsics.checkNotNullParameter(path2, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return a(b.k(obj), b.k(obj2), (Exception) obj3);
    }
}
