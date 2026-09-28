package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioStorage;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.FileSystem;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes.dex */
public final class PreferenceDataStoreFactory {
    public static PreferenceDataStore a(ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope, final Function0 produceFile) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        OkioStorage storage = new OkioStorage(FileSystem.SYSTEM, new Function0<Path>(produceFile) { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Lambda f3724c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.f3724c = (Lambda) produceFile;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                File file = (File) this.f3724c.invoke();
                Intrinsics.checkNotNullParameter(file, "<this>");
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (Intrinsics.b(StringsKt.T(ClassUtils.PACKAGE_SEPARATOR_CHAR, name, ""), "preferences_pb")) {
                    String str = Path.f56972b;
                    File absoluteFile = file.getAbsoluteFile();
                    Intrinsics.checkNotNullExpressionValue(absoluteFile, "file.absoluteFile");
                    return Path.Companion.b(absoluteFile);
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
            }
        });
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new PreferenceDataStore(new PreferenceDataStore(DataStoreFactory.a(storage, replaceFileCorruptionHandler, migrations, scope)));
    }

    public static PreferenceDataStore b(ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function0 function0) {
        EmptyList emptyList = EmptyList.f53609a;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return a(replaceFileCorruptionHandler, emptyList, CoroutineScopeKt.a(DefaultIoScheduler.f55150b.plus(SupervisorKt.b())), function0);
    }
}
