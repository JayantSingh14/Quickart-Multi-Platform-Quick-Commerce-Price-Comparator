package com.amazon.android.apay.commonlibrary.interfaces.model;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonPayTransactionMetadataRequest {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final HashMap<String, Object> f14943a;

    public AmazonPayTransactionMetadataRequest(@Nullable HashMap<String, Object> map) {
        this.f14943a = map;
    }

    @Nullable
    public final HashMap<String, Object> getData() {
        return this.f14943a;
    }

    public AmazonPayTransactionMetadataRequest() {
        this(null);
    }
}
