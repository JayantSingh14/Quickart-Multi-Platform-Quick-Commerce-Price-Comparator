package com.bumptech.glide.request;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* loaded from: classes3.dex */
public interface RequestCoordinator {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RequestState {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestState[] f16454a = {new RequestState("RUNNING", 0), new RequestState("PAUSED", 1), new RequestState("CLEARED", 2), new RequestState(MerchantConstants.SUCCESS, 3), new RequestState("FAILED", 4)};

        /* JADX INFO: Fake field, exist only in values array */
        RequestState EF5;

        public static RequestState valueOf(String str) {
            return (RequestState) Enum.valueOf(RequestState.class, str);
        }

        public static RequestState[] values() {
            return (RequestState[]) f16454a.clone();
        }
    }
}
