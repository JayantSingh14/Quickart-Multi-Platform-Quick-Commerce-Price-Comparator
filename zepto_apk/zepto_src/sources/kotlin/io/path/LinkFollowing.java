package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class LinkFollowing {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LinkFollowing f53760a = new LinkFollowing();

    static {
        LinkOption[] linkOptionArr = new LinkOption[1];
        LinkOption unused = LinkOption.NOFOLLOW_LINKS;
        LinkOption[] linkOptionArr2 = new LinkOption[0];
        SetsKt.e(FileVisitOption.FOLLOW_LINKS);
    }
}
