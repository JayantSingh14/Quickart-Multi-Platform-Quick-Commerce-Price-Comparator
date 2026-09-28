package com.amazon.android.apay.commonlibrary.interfaces.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonPayTransactionRequest {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f14944a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final HashMap<String, Object> f14945b;

    public AmazonPayTransactionRequest(@NotNull String paymentUrl, @Nullable HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(paymentUrl, "paymentUrl");
        this.f14944a = paymentUrl;
        this.f14945b = map;
    }

    @Nullable
    public final HashMap<String, Object> getData() {
        return this.f14945b;
    }

    @NotNull
    public final String getPaymentUrl() {
        return this.f14944a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonPayTransactionRequest(@NotNull String paymentUrl) {
        this(paymentUrl, null);
        Intrinsics.checkNotNullParameter(paymentUrl, "paymentUrl");
    }
}
