package com.falcon.falconModule;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.falcon.FalconContextContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class StorageHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f20452a = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static volatile StorageHelper f20453b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public final StorageHelper a() {
            StorageHelper storageHelper;
            StorageHelper storageHelper2 = StorageHelper.f20453b;
            if (storageHelper2 != null) {
                return storageHelper2;
            }
            synchronized (this) {
                storageHelper = StorageHelper.f20453b;
                if (storageHelper == null) {
                    storageHelper = new StorageHelper();
                    StorageHelper.f20453b = storageHelper;
                }
            }
            return storageHelper;
        }
    }

    public static String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Context context = FalconContextContainer.f20435a;
            if (context == null) {
                throw new IllegalStateException("Application context is null in FalconContextContainer");
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("falcon_preferences", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return sharedPreferences.getString(key, null);
        } catch (Exception e2) {
            Log.e("FalconStorageHelper", "Failed to fetch key=" + key, e2);
            return null;
        }
    }

    public static void b(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Context context = FalconContextContainer.f20435a;
            if (context == null) {
                throw new IllegalStateException("Application context is null in FalconContextContainer");
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("falcon_preferences", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            sharedPreferences.edit().putString(key, value).apply();
        } catch (Exception e2) {
            Log.e("FalconStorageHelper", "Failed to save key=".concat(key), e2);
        }
    }
}
