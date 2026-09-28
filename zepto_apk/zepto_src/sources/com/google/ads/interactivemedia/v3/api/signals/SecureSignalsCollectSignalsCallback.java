package com.google.ads.interactivemedia.v3.api.signals;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface SecureSignalsCollectSignalsCallback {
    void onFailure(@NonNull Exception exc);

    void onSuccess(@NonNull String str);
}
