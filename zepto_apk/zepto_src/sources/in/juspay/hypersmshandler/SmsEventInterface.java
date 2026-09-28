package in.juspay.hypersmshandler;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public interface SmsEventInterface {

    @Keep
    @Metadata
    public enum RetrieverEvents {
        ON_ATTACH,
        ON_RECEIVE,
        ON_EXECUTE
    }

    void onActivityResultEvent(@NotNull String str);

    void onSentReceiverEvent(int i2);

    void onSmsConsentEvent(@NotNull Intent intent, int i2, @Nullable Bundle bundle);

    void onSmsReceiverEvent(@NotNull String str);

    void onSmsRetrieverEvent(@NotNull RetrieverEvents retrieverEvents, @NotNull String str);
}
