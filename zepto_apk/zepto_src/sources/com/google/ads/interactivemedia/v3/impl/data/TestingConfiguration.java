package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzoo;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;
import com.google.android.gms.common.annotation.KeepForSdk;

@zzoo(zza = zzba.class, zzb = {"extraParams", "isTv", "ignoreStrictModeFalsePositives"})
/* loaded from: classes3.dex */
public abstract class TestingConfiguration {

    @NonNull
    public static final String PARAMETER_KEY = "tcnfp";

    public interface Builder {
        @NonNull
        @KeepForSdk
        TestingConfiguration build();

        @NonNull
        Builder disableExperiments(boolean z);

        @NonNull
        Builder disableOnScreenDetection(boolean z);

        @NonNull
        Builder disableSkipFadeTransition(boolean z);

        @NonNull
        Builder enableMonitorAppLifecycle(boolean z);

        Builder extraParams(zzqi<String, Object> zzqiVar);

        @NonNull
        Builder forceAndroidTvMode(boolean z);

        Builder forceExperimentIds(zzqf<Integer> zzqfVar);

        @NonNull
        Builder forceTvMode(boolean z);

        @NonNull
        Builder ignoreStrictModeFalsePositives(boolean z);

        @NonNull
        Builder useTestStreamManager(boolean z);

        @NonNull
        Builder useVideoElementMock(boolean z);

        @NonNull
        Builder videoElementMockDuration(float f2);
    }

    @NonNull
    @KeepForSdk
    public static Builder builder() {
        zzay zzayVar = new zzay();
        zzayVar.disableExperiments(true);
        zzayVar.disableOnScreenDetection(false);
        zzayVar.disableSkipFadeTransition(true);
        zzayVar.useVideoElementMock(false);
        zzayVar.videoElementMockDuration(30.0f);
        zzayVar.useTestStreamManager(false);
        zzayVar.ignoreStrictModeFalsePositives(false);
        zzayVar.forceTvMode(false);
        zzayVar.forceAndroidTvMode(false);
        zzayVar.forceExperimentIds(null);
        zzayVar.enableMonitorAppLifecycle(true);
        return zzayVar;
    }

    @NonNull
    @KeepForSdk
    public Builder copy() {
        zzay zzayVar = new zzay();
        zzayVar.disableExperiments(disableExperiments());
        zzayVar.disableOnScreenDetection(disableOnScreenDetection());
        zzayVar.disableSkipFadeTransition(disableSkipFadeTransition());
        zzayVar.useVideoElementMock(useVideoElementMock());
        zzayVar.videoElementMockDuration(videoElementMockDuration());
        zzayVar.useTestStreamManager(useTestStreamManager());
        zzayVar.forceExperimentIds(forceExperimentIds());
        zzayVar.enableMonitorAppLifecycle(enableMonitorAppLifecycle());
        zzayVar.forceTvMode(forceTvMode());
        zzayVar.forceAndroidTvMode(forceAndroidTvMode());
        zzayVar.ignoreStrictModeFalsePositives(ignoreStrictModeFalsePositives());
        zzayVar.extraParams(extraParams());
        return zzayVar;
    }

    public abstract boolean disableExperiments();

    public abstract boolean disableOnScreenDetection();

    public abstract boolean disableSkipFadeTransition();

    public abstract boolean enableMonitorAppLifecycle();

    @Nullable
    public abstract zzqi<String, Object> extraParams();

    public abstract boolean forceAndroidTvMode();

    @Nullable
    public abstract zzqf<Integer> forceExperimentIds();

    public abstract boolean forceTvMode();

    public abstract boolean ignoreStrictModeFalsePositives();

    public abstract boolean useTestStreamManager();

    public abstract boolean useVideoElementMock();

    public abstract float videoElementMockDuration();
}
