package androidx.core.view;

import android.content.Context;
import android.view.VelocityTracker;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public class DifferentialMotionFlingController {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3032a;

    /* renamed from: b, reason: collision with root package name */
    public final DifferentialMotionFlingTarget f3033b;

    /* renamed from: c, reason: collision with root package name */
    public VelocityTracker f3034c;

    /* renamed from: d, reason: collision with root package name */
    public float f3035d;

    /* renamed from: e, reason: collision with root package name */
    public int f3036e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f3037f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f3038g = -1;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f3039h = {Api.BaseClientBuilder.API_PRIORITY_OTHER, 0};

    @VisibleForTesting
    public interface DifferentialVelocityProvider {
    }

    @VisibleForTesting
    public interface FlingVelocityThresholdCalculator {
    }

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this.f3032a = context;
        this.f3033b = differentialMotionFlingTarget;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.MotionEvent r27, int r28) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DifferentialMotionFlingController.a(android.view.MotionEvent, int):void");
    }
}
