package com.truecaller.android.sdk.legacy;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.truecaller.android.sdk.common.models.TrueProfile;

@Keep
/* loaded from: classes4.dex */
public interface ITrueCallback {
    void onFailureProfileShared(@NonNull TrueError trueError);

    void onSuccessProfileShared(@NonNull TrueProfile trueProfile);

    void onVerificationRequired(TrueError trueError);
}
