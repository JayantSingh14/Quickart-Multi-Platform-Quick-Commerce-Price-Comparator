package com.amazon.android.apay.commonlibrary.interfaces.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public enum PaymentInstrumentType {
    AMAZON_PAY_WALLET("AMAZON_PAY_WALLET");


    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f14955a;

    PaymentInstrumentType(String str) {
        this.f14955a = str;
    }

    @NotNull
    public final String getType() {
        return this.f14955a;
    }

    @NotNull
    public final String getValue() {
        return this.f14955a;
    }
}
