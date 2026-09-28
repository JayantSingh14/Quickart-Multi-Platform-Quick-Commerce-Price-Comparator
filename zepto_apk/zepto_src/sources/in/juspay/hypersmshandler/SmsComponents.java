package in.juspay.hypersmshandler;

import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes4.dex */
public interface SmsComponents {
    @NotNull
    Context getContext();

    @NotNull
    SmsEventInterface getSmsEventInterface();

    @NotNull
    Tracker getTracker();
}
