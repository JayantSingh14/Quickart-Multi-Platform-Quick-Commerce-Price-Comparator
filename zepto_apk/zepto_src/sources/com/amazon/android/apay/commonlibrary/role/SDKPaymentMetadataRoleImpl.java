package com.amazon.android.apay.commonlibrary.role;

import android.app.Activity;
import com.amazon.android.apay.commonlibrary.commonlib.manager.PaymentMetaDataManager;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKPaymentMetadataRole;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionMetadataRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class SDKPaymentMetadataRoleImpl implements SDKPaymentMetadataRole {
    @Override // com.amazon.android.apay.commonlibrary.interfaces.internal.SDKPaymentMetadataRole
    @NotNull
    public String fetchPaymentMetadata(@NotNull AmazonPayTransactionMetadataRequest amazonPayTransactionMetaDataRequest, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(amazonPayTransactionMetaDataRequest, "amazonPayTransactionMetaDataRequest");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new PaymentMetaDataManager().getPaymentMetaData(amazonPayTransactionMetaDataRequest, activity);
    }
}
