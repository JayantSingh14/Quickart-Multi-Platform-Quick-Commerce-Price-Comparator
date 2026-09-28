package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements Function1<IOException, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DiskLruCache f56458c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.f56458c = diskLruCache;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        IOException it = (IOException) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        byte[] bArr = Util.f56394a;
        this.f56458c.f56430j = true;
        return Unit.f53572a;
    }
}
