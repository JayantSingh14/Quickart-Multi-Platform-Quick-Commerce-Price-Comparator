package com.google.ads.interactivemedia.v3.api.signals;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface SecureSignalsInitializeCallback {
    void onFailure(@NonNull Exception exc);

    void onSuccess();
}
