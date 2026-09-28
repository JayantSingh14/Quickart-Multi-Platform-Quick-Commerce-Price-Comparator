package in.juspay.hyper.core;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public interface TrackerInterface {
    void addLogToPersistedQueue(@NotNull JSONObject jSONObject);

    void track(@NotNull JSONObject jSONObject);

    void trackAction(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Object obj);

    void trackAndLogException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Throwable th);

    void trackApiCalls(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Integer num, @Nullable String str4, @Nullable Long l2, @Nullable Long l3, @Nullable Object obj, @Nullable Object obj2, @Nullable String str5);

    void trackLifecycle(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Object obj);
}
