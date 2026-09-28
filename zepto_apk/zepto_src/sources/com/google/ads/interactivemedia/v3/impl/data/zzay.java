package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;

/* loaded from: classes3.dex */
final class zzay implements TestingConfiguration.Builder {
    private boolean disableExperiments;
    private boolean disableOnScreenDetection;
    private boolean disableSkipFadeTransition;
    private boolean enableMonitorAppLifecycle;
    private zzqi<String, Object> extraParams;
    private boolean forceAndroidTvMode;
    private zzqf<Integer> forceExperimentIds;
    private boolean forceTvMode;
    private boolean ignoreStrictModeFalsePositives;
    private short set$0;
    private boolean useTestStreamManager;
    private boolean useVideoElementMock;
    private float videoElementMockDuration;

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration build() {
        if (this.set$0 == 1023) {
            return new zzba(this.disableExperiments, this.disableOnScreenDetection, this.disableSkipFadeTransition, this.forceExperimentIds, this.useVideoElementMock, this.videoElementMockDuration, this.useTestStreamManager, this.enableMonitorAppLifecycle, this.forceTvMode, this.forceAndroidTvMode, this.ignoreStrictModeFalsePositives, this.extraParams);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" disableExperiments");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" disableOnScreenDetection");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" disableSkipFadeTransition");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" useVideoElementMock");
        }
        if ((this.set$0 & 16) == 0) {
            sb.append(" videoElementMockDuration");
        }
        if ((this.set$0 & 32) == 0) {
            sb.append(" useTestStreamManager");
        }
        if ((this.set$0 & 64) == 0) {
            sb.append(" enableMonitorAppLifecycle");
        }
        if ((this.set$0 & 128) == 0) {
            sb.append(" forceTvMode");
        }
        if ((this.set$0 & 256) == 0) {
            sb.append(" forceAndroidTvMode");
        }
        if ((this.set$0 & 512) == 0) {
            sb.append(" ignoreStrictModeFalsePositives");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableExperiments(boolean z) {
        this.disableExperiments = z;
        this.set$0 = (short) (this.set$0 | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableOnScreenDetection(boolean z) {
        this.disableOnScreenDetection = z;
        this.set$0 = (short) (this.set$0 | 2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableSkipFadeTransition(boolean z) {
        this.disableSkipFadeTransition = z;
        this.set$0 = (short) (this.set$0 | 4);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder enableMonitorAppLifecycle(boolean z) {
        this.enableMonitorAppLifecycle = z;
        this.set$0 = (short) (this.set$0 | 64);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder extraParams(zzqi<String, Object> zzqiVar) {
        this.extraParams = zzqiVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceAndroidTvMode(boolean z) {
        this.forceAndroidTvMode = z;
        this.set$0 = (short) (this.set$0 | 256);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceExperimentIds(zzqf<Integer> zzqfVar) {
        this.forceExperimentIds = zzqfVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceTvMode(boolean z) {
        this.forceTvMode = z;
        this.set$0 = (short) (this.set$0 | 128);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder ignoreStrictModeFalsePositives(boolean z) {
        this.ignoreStrictModeFalsePositives = z;
        this.set$0 = (short) (this.set$0 | 512);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useTestStreamManager(boolean z) {
        this.useTestStreamManager = z;
        this.set$0 = (short) (this.set$0 | 32);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useVideoElementMock(boolean z) {
        this.useVideoElementMock = z;
        this.set$0 = (short) (this.set$0 | 8);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder videoElementMockDuration(float f2) {
        this.videoElementMockDuration = f2;
        this.set$0 = (short) (this.set$0 | 16);
        return this;
    }
}
