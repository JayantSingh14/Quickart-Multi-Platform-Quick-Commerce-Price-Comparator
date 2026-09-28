package in.juspay.hyper.core;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public interface FragmentHooks {
    void requestPermission(@NotNull String[] strArr, int i2);

    void startActivityForResult(@NotNull Intent intent, int i2, @Nullable Bundle bundle);

    void startIntentSenderForResult(@NotNull IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle);
}
