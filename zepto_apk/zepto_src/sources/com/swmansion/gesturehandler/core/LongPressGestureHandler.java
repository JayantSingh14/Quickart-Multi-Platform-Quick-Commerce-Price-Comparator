package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    public long M;
    public final float N;
    public float O;
    public int P;
    public float Q;
    public float R;
    public long S;
    public long T;
    public Handler U;
    public int V;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    public LongPressGestureHandler(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.M = 500L;
        this.y = true;
        float f2 = context.getResources().getDisplayMetrics().density * 10.0f;
        float f3 = f2 * f2;
        this.N = f3;
        this.O = f3;
        this.P = 1;
    }

    public static Pair H(MotionEvent motionEvent, boolean z) {
        if (z) {
            int pointerCount = motionEvent.getPointerCount();
            float f2 = 0.0f;
            float y = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != motionEvent.getActionIndex()) {
                    float x = motionEvent.getX(i2) + f2;
                    y = motionEvent.getY(i2) + y;
                    f2 = x;
                }
            }
            return new Pair(Float.valueOf(f2 / (motionEvent.getPointerCount() - 1)), Float.valueOf(y / (motionEvent.getPointerCount() - 1)));
        }
        IntRange intRangeF = RangesKt.f(0, motionEvent.getPointerCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.r(intRangeF, 10));
        Iterator<Integer> it = intRangeF.iterator();
        while (((IntProgressionIterator) it).f53843c) {
            arrayList.add(Float.valueOf(motionEvent.getX(((IntIterator) it).a())));
        }
        float fO = (float) CollectionsKt.o(arrayList);
        IntRange intRangeF2 = RangesKt.f(0, motionEvent.getPointerCount());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(intRangeF2, 10));
        Iterator<Integer> it2 = intRangeF2.iterator();
        while (((IntProgressionIterator) it2).f53843c) {
            arrayList2.add(Float.valueOf(motionEvent.getY(((IntIterator) it2).a())));
        }
        return new Pair(Float.valueOf(fO), Float.valueOf((float) CollectionsKt.o(arrayList2)));
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void g(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.T = SystemClock.uptimeMillis();
        super.g(event);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void h(int i2, int i3) {
        this.T = SystemClock.uptimeMillis();
        super.h(i2, i3);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (B(sourceEvent)) {
            if (this.f46719f == 0) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.T = jUptimeMillis;
                this.S = jUptimeMillis;
                d();
                Pair pairH = H(sourceEvent, false);
                float fFloatValue = ((Number) pairH.f53533a).floatValue();
                float fFloatValue2 = ((Number) pairH.f53534b).floatValue();
                this.Q = fFloatValue;
                this.R = fFloatValue2;
                this.V++;
            }
            if (sourceEvent.getActionMasked() == 5) {
                this.V++;
                Pair pairH2 = H(sourceEvent, false);
                float fFloatValue3 = ((Number) pairH2.f53533a).floatValue();
                float fFloatValue4 = ((Number) pairH2.f53534b).floatValue();
                this.Q = fFloatValue3;
                this.R = fFloatValue4;
                if (this.V > this.P) {
                    l();
                    this.V = 0;
                }
            }
            if (this.f46719f == 2 && this.V == this.P && (sourceEvent.getActionMasked() == 0 || sourceEvent.getActionMasked() == 5)) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.U = handler;
                long j2 = this.M;
                if (j2 > 0) {
                    handler.postDelayed(new androidx.constraintlayout.helper.widget.a(this, 27), j2);
                } else if (j2 == 0) {
                    a(false);
                }
            }
            if (sourceEvent.getActionMasked() == 1 || sourceEvent.getActionMasked() == 12) {
                this.V--;
                Handler handler2 = this.U;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                    this.U = null;
                }
                if (this.f46719f == 4) {
                    j();
                    return;
                } else {
                    l();
                    return;
                }
            }
            if (sourceEvent.getActionMasked() == 6) {
                int i2 = this.V - 1;
                this.V = i2;
                if (i2 < this.P && this.f46719f != 4) {
                    l();
                    this.V = 0;
                    return;
                }
                Pair pairH3 = H(sourceEvent, true);
                float fFloatValue5 = ((Number) pairH3.f53533a).floatValue();
                float fFloatValue6 = ((Number) pairH3.f53534b).floatValue();
                this.Q = fFloatValue5;
                this.R = fFloatValue6;
                return;
            }
            Pair pairH4 = H(sourceEvent, false);
            float fFloatValue7 = ((Number) pairH4.f53533a).floatValue();
            float fFloatValue8 = ((Number) pairH4.f53534b).floatValue();
            float f2 = fFloatValue7 - this.Q;
            float f3 = fFloatValue8 - this.R;
            if ((f3 * f3) + (f2 * f2) > this.O) {
                if (this.f46719f == 4) {
                    e();
                } else {
                    l();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        this.V = 0;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void x() {
        Handler handler = this.U;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.U = null;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void y() {
        super.y();
        this.M = 500L;
        this.O = this.N;
    }
}
