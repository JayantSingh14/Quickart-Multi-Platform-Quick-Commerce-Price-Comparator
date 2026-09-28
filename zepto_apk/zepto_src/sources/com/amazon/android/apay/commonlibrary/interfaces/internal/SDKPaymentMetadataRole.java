package com.amazon.android.apay.commonlibrary.interfaces.internal;

import android.app.Activity;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionMetadataRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public interface SDKPaymentMetadataRole {
    @NotNull
    String fetchPaymentMetadata(@NotNull AmazonPayTransactionMetadataRequest amazonPayTransactionMetadataRequest, @NotNull Activity activity);
}
