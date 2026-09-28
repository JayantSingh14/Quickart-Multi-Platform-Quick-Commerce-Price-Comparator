package kotlin.io.path;

import java.nio.file.Paths;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class PathRelativizer {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PathRelativizer f53764a = new PathRelativizer();

    static {
        Paths.get("", new String[0]);
        Paths.get("..", new String[0]);
    }
}
