package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: classes.dex */
public final class DataStoreFactory {
    public static DataStoreImpl a(Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        CorruptionHandler noOpCorruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            noOpCorruptionHandler = new NoOpCorruptionHandler();
        }
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        return new DataStoreImpl(storage, CollectionsKt.H(new DataMigrationInitializer$Companion$getInitializer$1(migrations, null)), noOpCorruptionHandler, scope);
    }
}
