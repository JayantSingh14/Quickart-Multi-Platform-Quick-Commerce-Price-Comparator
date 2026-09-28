package io.sentry.android.replay;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.SentryReplayOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@StabilityInferred(parameters = 0)
@Metadata
/* loaded from: classes3.dex */
public final class ScreenshotRecorderConfig {

    /* renamed from: a, reason: collision with root package name */
    public final int f52485a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52486b;

    /* renamed from: c, reason: collision with root package name */
    public final float f52487c;

    /* renamed from: d, reason: collision with root package name */
    public final float f52488d;

    /* renamed from: e, reason: collision with root package name */
    public final int f52489e;

    /* renamed from: f, reason: collision with root package name */
    public final int f52490f;

    @Metadata
    public static final class Companion {
        public static ScreenshotRecorderConfig a(Context context, SentryReplayOptions sessionReplay) {
            Rect rect;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sessionReplay, "sessionReplay");
            Object systemService = context.getSystemService("window");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                rect = windowManager.getCurrentWindowMetrics().getBounds();
            } else {
                Point point = new Point();
                windowManager.getDefaultDisplay().getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            Intrinsics.checkNotNullExpressionValue(rect, "if (VERSION.SDK_INT >= V…enBounds.y)\n            }");
            int iB = MathKt.b((rect.height() / context.getResources().getDisplayMetrics().density) * sessionReplay.f51863g.sizeScale);
            int i2 = iB % 16;
            Integer numValueOf = Integer.valueOf(i2 <= 8 ? iB - i2 : iB + (16 - i2));
            float fWidth = rect.width() / context.getResources().getDisplayMetrics().density;
            SentryReplayOptions.SentryReplayQuality sentryReplayQuality = sessionReplay.f51863g;
            int iB2 = MathKt.b(fWidth * sentryReplayQuality.sizeScale);
            int i3 = iB2 % 16;
            Integer numValueOf2 = Integer.valueOf(i3 <= 8 ? iB2 - i3 : iB2 + (16 - i3));
            int iIntValue = numValueOf.intValue();
            int iIntValue2 = numValueOf2.intValue();
            return new ScreenshotRecorderConfig(iIntValue2, iIntValue, iIntValue2 / rect.width(), iIntValue / rect.height(), sessionReplay.f51864h, sentryReplayQuality.bitRate);
        }
    }

    public ScreenshotRecorderConfig(int i2, int i3, float f2, float f3, int i4, int i5) {
        this.f52485a = i2;
        this.f52486b = i3;
        this.f52487c = f2;
        this.f52488d = f3;
        this.f52489e = i4;
        this.f52490f = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenshotRecorderConfig)) {
            return false;
        }
        ScreenshotRecorderConfig screenshotRecorderConfig = (ScreenshotRecorderConfig) obj;
        return this.f52485a == screenshotRecorderConfig.f52485a && this.f52486b == screenshotRecorderConfig.f52486b && Float.compare(this.f52487c, screenshotRecorderConfig.f52487c) == 0 && Float.compare(this.f52488d, screenshotRecorderConfig.f52488d) == 0 && this.f52489e == screenshotRecorderConfig.f52489e && this.f52490f == screenshotRecorderConfig.f52490f;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f52490f) + android.support.v4.media.a.b(this.f52489e, (Float.hashCode(this.f52488d) + ((Float.hashCode(this.f52487c) + android.support.v4.media.a.b(this.f52486b, Integer.hashCode(this.f52485a) * 31, 31)) * 31)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScreenshotRecorderConfig(recordingWidth=");
        sb.append(this.f52485a);
        sb.append(", recordingHeight=");
        sb.append(this.f52486b);
        sb.append(", scaleFactorX=");
        sb.append(this.f52487c);
        sb.append(", scaleFactorY=");
        sb.append(this.f52488d);
        sb.append(", frameRate=");
        sb.append(this.f52489e);
        sb.append(", bitRate=");
        return android.support.v4.media.b.n(sb, this.f52490f, ')');
    }
}
