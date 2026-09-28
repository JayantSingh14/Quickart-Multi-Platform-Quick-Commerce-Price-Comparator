package com.airbnb.lottie;

import com.airbnb.lottie.configurations.reducemotion.SystemReducedMotionOption;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;

/* loaded from: classes3.dex */
public class LottieConfig {

    public static final class Builder {

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$1, reason: invalid class name */
        class AnonymousClass1 implements LottieNetworkCacheProvider {
        }

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$2, reason: invalid class name */
        class AnonymousClass2 implements LottieNetworkCacheProvider {
        }

        public Builder() {
            new SystemReducedMotionOption();
        }
    }
}
