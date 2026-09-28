package in.juspay.hyperutil;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public interface TrackerCallback {
    void track(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject);

    void trackAndLogException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Throwable th);

    void trackException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Throwable th);
}
