package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.SingleProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.preferences.core.PreferencesSerializer;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.FileSystem;
import okio.Path;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class OkioStorage<T> implements Storage<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedHashSet f3656e = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Synchronizer f3657f = new Synchronizer();

    /* renamed from: a, reason: collision with root package name */
    public final FileSystem f3658a;

    /* renamed from: b, reason: collision with root package name */
    public final Function2 f3659b;

    /* renamed from: c, reason: collision with root package name */
    public final Function0 f3660c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f3661d;

    @Metadata
    /* renamed from: androidx.datastore.core.okio.OkioStorage$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function2<Path, FileSystem, InterProcessCoordinator> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f3662c = new AnonymousClass1(2);

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Path path = (Path) obj;
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter((FileSystem) obj2, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(path, "path");
            String filePath = Path.Companion.a(path.f56973a.z(), true).f56973a.z();
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new SingleProcessCoordinator(filePath);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public OkioStorage(FileSystem fileSystem, Function0 producePath) {
        PreferencesSerializer serializer = PreferencesSerializer.f3729a;
        AnonymousClass1 coordinatorProducer = AnonymousClass1.f3662c;
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinatorProducer, "coordinatorProducer");
        Intrinsics.checkNotNullParameter(producePath, "producePath");
        this.f3658a = fileSystem;
        this.f3659b = coordinatorProducer;
        this.f3660c = producePath;
        this.f3661d = LazyKt.b(new Function0<Path>() { // from class: androidx.datastore.core.okio.OkioStorage$canonicalPath$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                OkioStorage okioStorage = this.f3663c;
                Path path = (Path) okioStorage.f3660c.invoke();
                path.getClass();
                if (okio.internal.Path.a(path) != -1) {
                    return Path.Companion.a(path.f56973a.z(), true);
                }
                throw new IllegalStateException(("OkioStorage requires absolute paths, but did not get an absolute path from producePath = " + okioStorage.f3660c + ", instead got " + path).toString());
            }
        });
    }

    @Override // androidx.datastore.core.Storage
    public final StorageConnection a() {
        String strZ = ((Path) this.f3661d.getValue()).f56973a.z();
        synchronized (f3657f) {
            LinkedHashSet linkedHashSet = f3656e;
            if (linkedHashSet.contains(strZ)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + strZ + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            linkedHashSet.add(strZ);
        }
        return new OkioStorageConnection(this.f3658a, (Path) this.f3661d.getValue(), (InterProcessCoordinator) AnonymousClass1.f3662c.invoke((Path) this.f3661d.getValue(), this.f3658a), new OkioStorage$createConnection$2(this));
    }
}
