package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public enum NdkHandlerStrategy {
    SENTRY_HANDLER_STRATEGY_DEFAULT(0),
    SENTRY_HANDLER_STRATEGY_CHAIN_AT_START(1);

    private final int value;

    NdkHandlerStrategy(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
