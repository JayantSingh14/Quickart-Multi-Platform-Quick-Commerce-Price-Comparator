package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.util.SampleRateUtils;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class SentryReplayOptions {

    /* renamed from: a, reason: collision with root package name */
    public Double f51857a;

    /* renamed from: b, reason: collision with root package name */
    public Double f51858b;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet f51859c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f51860d;

    /* renamed from: e, reason: collision with root package name */
    public String f51861e;

    /* renamed from: f, reason: collision with root package name */
    public String f51862f;

    /* renamed from: g, reason: collision with root package name */
    public final SentryReplayQuality f51863g;

    /* renamed from: h, reason: collision with root package name */
    public final int f51864h;

    /* renamed from: i, reason: collision with root package name */
    public final long f51865i;

    /* renamed from: j, reason: collision with root package name */
    public final long f51866j;

    /* renamed from: k, reason: collision with root package name */
    public final long f51867k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f51868l;

    /* renamed from: m, reason: collision with root package name */
    public SdkVersion f51869m;

    public enum SentryReplayQuality {
        LOW(0.8f, 50000, 10),
        MEDIUM(1.0f, 75000, 30),
        HIGH(1.0f, 100000, 50);

        public final int bitRate;
        public final int screenshotQuality;
        public final float sizeScale;

        SentryReplayQuality(float f2, int i2, int i3) {
            this.sizeScale = f2;
            this.bitRate = i2;
            this.screenshotQuality = i3;
        }

        @NotNull
        public String serializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public SentryReplayOptions(boolean z, SdkVersion sdkVersion) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.f51859c = copyOnWriteArraySet;
        this.f51860d = new CopyOnWriteArraySet();
        this.f51861e = null;
        this.f51862f = null;
        this.f51863g = SentryReplayQuality.MEDIUM;
        this.f51864h = 1;
        this.f51865i = 30000L;
        this.f51866j = 5000L;
        this.f51867k = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR;
        this.f51868l = true;
        if (z) {
            return;
        }
        b(true);
        a(true);
        copyOnWriteArraySet.add("android.webkit.WebView");
        copyOnWriteArraySet.add("android.widget.VideoView");
        copyOnWriteArraySet.add("androidx.media3.ui.PlayerView");
        copyOnWriteArraySet.add("com.google.android.exoplayer2.ui.PlayerView");
        copyOnWriteArraySet.add("com.google.android.exoplayer2.ui.StyledPlayerView");
        this.f51869m = sdkVersion;
    }

    public final void a(boolean z) {
        if (z) {
            this.f51859c.add("android.widget.ImageView");
            this.f51860d.remove("android.widget.ImageView");
        } else {
            this.f51860d.add("android.widget.ImageView");
            this.f51859c.remove("android.widget.ImageView");
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.f51859c.add("android.widget.TextView");
            this.f51860d.remove("android.widget.TextView");
        } else {
            this.f51860d.add("android.widget.TextView");
            this.f51859c.remove("android.widget.TextView");
        }
    }

    public final void c(Double d2) {
        if (SampleRateUtils.a(true, d2)) {
            this.f51858b = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    public final void d(Double d2) {
        if (SampleRateUtils.a(true, d2)) {
            this.f51857a = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }
}
