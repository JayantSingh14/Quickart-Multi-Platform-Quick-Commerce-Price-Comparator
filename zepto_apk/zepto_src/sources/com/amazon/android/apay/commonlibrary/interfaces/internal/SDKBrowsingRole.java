package com.amazon.android.apay.commonlibrary.interfaces.internal;

import android.app.Activity;
import android.content.Context;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public interface SDKBrowsingRole {
    @NotNull
    Map<String, Object> getBrowsingIntent(@NotNull AmazonPayTransactionRequest amazonPayTransactionRequest, @NotNull Context context);

    void startBrowsing(@NotNull AmazonPayTransactionRequest amazonPayTransactionRequest, @NotNull Activity activity, int i2);
}
