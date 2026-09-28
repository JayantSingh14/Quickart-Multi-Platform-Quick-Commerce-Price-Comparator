package com.truecaller.android.sdk.oAuth;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes.dex */
public interface TcOAuthCallback {
    void onFailure(@NotNull TcOAuthError tcOAuthError);

    void onSuccess(@NotNull TcOAuthData tcOAuthData);

    void onVerificationRequired(@Nullable TcOAuthError tcOAuthError);
}
