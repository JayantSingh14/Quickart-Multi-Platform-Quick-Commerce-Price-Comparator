package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class PathNode {

    /* renamed from: a, reason: collision with root package name */
    public final Object f53763a;

    public PathNode(Path path, Object obj) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f53763a = obj;
    }
}
