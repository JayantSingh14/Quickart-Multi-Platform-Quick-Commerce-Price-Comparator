package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: classes3.dex */
public final class ZipFilesKt$openZip$1 extends Lambda implements Function1<ZipEntry, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final ZipFilesKt$openZip$1 f57060c = new ZipFilesKt$openZip$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ZipEntry it = (ZipEntry) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.TRUE;
    }
}
