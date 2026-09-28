package in.juspay.airborne;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public abstract class TrackerCallback {
    public abstract void track(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject);

    public final void trackAndLogException(@NotNull String tag, @NotNull String category, @NotNull String subCategory, @NotNull String label, @NotNull String description, @NotNull Throwable e2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(subCategory, "subCategory");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(e2, "e");
        Log.e(tag, description, e2);
        trackException(category, subCategory, label, description, e2);
    }

    public abstract void trackException(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Throwable th);
}
