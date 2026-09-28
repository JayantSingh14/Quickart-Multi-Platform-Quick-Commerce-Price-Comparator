package com.amazon.android.apay.commonlibrary.interfaces.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayAuthorizationRequest;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public interface SDKAuthRole {
    @NotNull
    Intent getAuthorizationIntent(@NotNull AmazonPayAuthorizationRequest amazonPayAuthorizationRequest, @NotNull Context context);

    void startAuth(@Nullable List<String> list, @NotNull String str, @NotNull String str2, @NotNull Activity activity, int i2);
}
