package com.zeptoconsumerapp.modules.helper;

import android.content.Context;
import android.content.SharedPreferences;
import bridges.CommsModule;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import com.zeptoconsumerapp.modules.event.type.NotificationEventType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StorageHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f47656a = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static StorageHelper f47657b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public final StorageHelper a() {
            StorageHelper storageHelper;
            StorageHelper storageHelper2 = StorageHelper.f47657b;
            if (storageHelper2 != null) {
                return storageHelper2;
            }
            synchronized (this) {
                storageHelper = StorageHelper.f47657b;
                if (storageHelper == null) {
                    storageHelper = new StorageHelper();
                    StorageHelper.f47657b = storageHelper;
                }
            }
            return storageHelper;
        }
    }

    public static String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return b().getString(key, null);
        } catch (Exception e2) {
            Timber.d("DataStorageHelper").e(e2, "Failed to fetch ID", new Object[0]);
            Object obj = LogEventUseCase.f47644a;
            LogEventUseCase.Companion.b(NotificationEventType.f47652c.a(), MapsKt.g(new Pair("error", e2.getMessage())));
            return null;
        }
    }

    public static SharedPreferences b() {
        Context applicationContext = ContextProvider.f47615b.a().a().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new IllegalStateException("DataStorageHelper: Context not set. Call setContext() first.");
    }

    public static void c(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            SharedPreferences.Editor editorEdit = b().edit();
            editorEdit.putString(key, value);
            editorEdit.apply();
        } catch (Exception e2) {
            Timber.d("DataStorageHelper").e(e2, "Failed to save ID", new Object[0]);
            Object obj = LogEventUseCase.f47644a;
            LogEventUseCase.Companion.b(NotificationEventType.f47651b.a(), MapsKt.g(new Pair("error", e2.getMessage())));
        }
    }
}
