package in.juspay.hypersmshandler;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public interface Tracker {
    void trackAction(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Object obj);

    void trackAndLogException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Throwable th);
}
