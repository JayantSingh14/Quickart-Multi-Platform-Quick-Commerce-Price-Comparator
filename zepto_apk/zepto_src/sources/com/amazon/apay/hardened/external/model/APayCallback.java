package com.amazon.apay.hardened.external.model;

/* loaded from: classes3.dex */
public interface APayCallback {
    void onError(APayError aPayError);

    void onSuccess();
}
