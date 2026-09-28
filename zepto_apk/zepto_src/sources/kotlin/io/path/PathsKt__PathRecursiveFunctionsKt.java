package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                CopyActionResult[] copyActionResultArr = CopyActionResult.f53757a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                CopyActionResult[] copyActionResultArr2 = CopyActionResult.f53757a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[1] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                OnErrorResult[] onErrorResultArr = OnErrorResult.f53761a;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static final FileVisitResult a(Path path, Exception exc) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(null, "base");
        try {
            PathRelativizer.f53764a.getClass();
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(null, "base");
            throw null;
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage() + "\nthis path: " + path + "\nbase path: null", e2);
        }
    }
}
