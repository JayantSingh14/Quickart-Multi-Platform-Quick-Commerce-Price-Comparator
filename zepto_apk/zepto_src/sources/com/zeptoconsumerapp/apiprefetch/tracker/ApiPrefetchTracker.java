package com.zeptoconsumerapp.apiprefetch.tracker;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class ApiPrefetchTracker {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final Map<String, ApiState> _apiMap = new LinkedHashMap();

    @Metadata
    public static final class Companion {
        @JvmStatic
        @Keep
        @Nullable
        public final String getApiStateData(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ApiState apiState = (ApiState) ApiPrefetchTracker._apiMap.get(id);
            if (apiState != null) {
                return apiState.getData();
            }
            return null;
        }

        @JvmStatic
        @Keep
        @Nullable
        public final String getApiStateError(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ApiState apiState = (ApiState) ApiPrefetchTracker._apiMap.get(id);
            if (apiState != null) {
                return apiState.getError();
            }
            return null;
        }

        @JvmStatic
        @Keep
        @NotNull
        public final String getApiStateStatus(@NotNull String id) {
            ApiStatus status;
            String strName;
            Intrinsics.checkNotNullParameter(id, "id");
            ApiState apiState = (ApiState) ApiPrefetchTracker._apiMap.get(id);
            return (apiState == null || (status = apiState.getStatus()) == null || (strName = status.name()) == null) ? "NOT_STARTED" : strName;
        }

        @JvmStatic
        @Keep
        public final void moveToError(@NotNull String id, @NotNull String error) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(error, "error");
            ApiState apiState = (ApiState) ApiPrefetchTracker._apiMap.get(id);
            if (apiState != null) {
                ApiPrefetchTracker._apiMap.put(id, ApiState.copy$default(apiState, null, ApiStatus.ERROR, null, error, 5, null));
            }
        }

        @JvmStatic
        @Keep
        public final void moveToSuccess(@NotNull String id, @NotNull String data) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(data, "data");
            ApiState apiState = (ApiState) ApiPrefetchTracker._apiMap.get(id);
            if (apiState != null) {
                ApiPrefetchTracker._apiMap.put(id, ApiState.copy$default(apiState, null, ApiStatus.SUCCESS, data, null, 9, null));
            }
        }

        @JvmStatic
        @Keep
        public final void start(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ApiPrefetchTracker._apiMap.put(id, new ApiState(id, ApiStatus.IN_PROGRESS, null, null, 12, null));
        }
    }

    @JvmStatic
    @Keep
    @Nullable
    public static final String getApiStateData(@NotNull String str) {
        return Companion.getApiStateData(str);
    }

    @JvmStatic
    @Keep
    @Nullable
    public static final String getApiStateError(@NotNull String str) {
        return Companion.getApiStateError(str);
    }

    @JvmStatic
    @Keep
    @NotNull
    public static final String getApiStateStatus(@NotNull String str) {
        return Companion.getApiStateStatus(str);
    }

    @JvmStatic
    @Keep
    public static final void moveToError(@NotNull String str, @NotNull String str2) {
        Companion.moveToError(str, str2);
    }

    @JvmStatic
    @Keep
    public static final void moveToSuccess(@NotNull String str, @NotNull String str2) {
        Companion.moveToSuccess(str, str2);
    }

    @JvmStatic
    @Keep
    public static final void start(@NotNull String str) {
        Companion.start(str);
    }
}
