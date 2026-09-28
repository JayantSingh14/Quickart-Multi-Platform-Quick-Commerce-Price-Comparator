package in.juspay.hypersdk.ui;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public interface IntentSenderDelegate {
    void startIntentSenderForResult(IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle);
}
