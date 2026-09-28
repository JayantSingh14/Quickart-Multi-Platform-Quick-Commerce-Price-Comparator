package in.juspay.hypersmshandler;

import android.app.Activity;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Keep
@Metadata
/* loaded from: classes4.dex */
public interface JuspayDuiHook {
    void attach(@NotNull Activity activity);

    void detach(@NotNull Activity activity);

    @Nullable
    String execute(@NotNull Activity activity, @Nullable String str, @Nullable JSONObject jSONObject);
}
