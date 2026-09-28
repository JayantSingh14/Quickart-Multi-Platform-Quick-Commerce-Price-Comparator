package androidx.datastore.core;

import com.google.android.gms.internal.ads.zzfxz;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class FileStorage<T> implements Storage<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashSet f3550c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f3551d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f3552a;

    /* renamed from: b, reason: collision with root package name */
    public final Function0 f3553b;

    @Metadata
    /* renamed from: androidx.datastore.core.FileStorage$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<File, InterProcessCoordinator> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f3554c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            File file = (File) obj;
            Intrinsics.checkNotNullParameter(file, "it");
            Intrinsics.checkNotNullParameter(file, "file");
            String filePath = file.getCanonicalFile().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "file.canonicalFile.absolutePath");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new SingleProcessCoordinator(filePath);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public FileStorage(Function0 produceFile) {
        zzfxz serializer = zzfxz.f31992a;
        AnonymousClass1 coordinatorProducer = AnonymousClass1.f3554c;
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinatorProducer, "coordinatorProducer");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        this.f3552a = coordinatorProducer;
        this.f3553b = produceFile;
    }

    @Override // androidx.datastore.core.Storage
    public final StorageConnection a() throws IOException {
        final File file = ((File) this.f3553b.invoke()).getCanonicalFile();
        synchronized (f3551d) {
            String path = file.getAbsolutePath();
            LinkedHashSet linkedHashSet = f3550c;
            if (linkedHashSet.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            Intrinsics.checkNotNullExpressionValue(path, "path");
            linkedHashSet.add(path);
        }
        Intrinsics.checkNotNullExpressionValue(file, "file");
        zzfxz zzfxzVar = zzfxz.f31992a;
        return new FileStorageConnection(file, (InterProcessCoordinator) AnonymousClass1.f3554c.invoke(file), new Function0<Unit>() { // from class: androidx.datastore.core.FileStorage$createConnection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object obj = FileStorage.f3551d;
                File file2 = file;
                synchronized (obj) {
                    FileStorage.f3550c.remove(file2.getAbsolutePath());
                }
                return Unit.f53572a;
            }
        });
    }
}
