package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.Path;
import okio.internal.ResourceFileSystem;

@Metadata
/* loaded from: classes3.dex */
final class ResourceFileSystem$toJarRoot$zip$1 extends Lambda implements Function1<ZipEntry, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final ResourceFileSystem$toJarRoot$zip$1 f57046c = new ResourceFileSystem$toJarRoot$zip$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ZipEntry entry = (ZipEntry) obj;
        Intrinsics.checkNotNullParameter(entry, "entry");
        Path path = ResourceFileSystem.f57041d;
        return Boolean.valueOf(ResourceFileSystem.Companion.a(entry.f57047a));
    }
}
