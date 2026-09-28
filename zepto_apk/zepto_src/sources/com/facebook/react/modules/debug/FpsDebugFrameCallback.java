package com.facebook.react.modules.debug;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FpsDebugFrameCallback implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f19085a;

    /* renamed from: b, reason: collision with root package name */
    public Choreographer f19086b;

    /* renamed from: c, reason: collision with root package name */
    public final UIManagerModule f19087c;

    /* renamed from: d, reason: collision with root package name */
    public final DidJSUpdateUiDuringFrameDetector f19088d;

    /* renamed from: e, reason: collision with root package name */
    public long f19089e;

    /* renamed from: f, reason: collision with root package name */
    public long f19090f;

    /* renamed from: g, reason: collision with root package name */
    public int f19091g;

    /* renamed from: h, reason: collision with root package name */
    public int f19092h;

    /* renamed from: i, reason: collision with root package name */
    public int f19093i;

    /* renamed from: j, reason: collision with root package name */
    public int f19094j;

    /* renamed from: k, reason: collision with root package name */
    public double f19095k;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class FpsInfo {
    }

    public FpsDebugFrameCallback(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f19085a = reactContext;
        this.f19087c = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.f19088d = new DidJSUpdateUiDuringFrameDetector();
        this.f19089e = -1L;
        this.f19090f = -1L;
        this.f19095k = 60.0d;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        boolean z;
        if (this.f19089e == -1) {
            this.f19089e = j2;
        }
        long j3 = this.f19090f;
        this.f19090f = j2;
        DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector = this.f19088d;
        synchronized (didJSUpdateUiDuringFrameDetector) {
            try {
                boolean zC = DidJSUpdateUiDuringFrameDetectorKt.c(didJSUpdateUiDuringFrameDetector.f19083d, j3, j2);
                long jB = DidJSUpdateUiDuringFrameDetectorKt.b(didJSUpdateUiDuringFrameDetector.f19080a, j3, j2);
                long jB2 = DidJSUpdateUiDuringFrameDetectorKt.b(didJSUpdateUiDuringFrameDetector.f19081b, j3, j2);
                z = false;
                boolean z2 = (jB == -1 && jB2 == -1) ? didJSUpdateUiDuringFrameDetector.f19084e : jB > jB2;
                if (zC || (z2 && !DidJSUpdateUiDuringFrameDetectorKt.c(didJSUpdateUiDuringFrameDetector.f19082c, j3, j2))) {
                    z = true;
                }
                DidJSUpdateUiDuringFrameDetectorKt.a(didJSUpdateUiDuringFrameDetector.f19080a, j2);
                DidJSUpdateUiDuringFrameDetectorKt.a(didJSUpdateUiDuringFrameDetector.f19081b, j2);
                DidJSUpdateUiDuringFrameDetectorKt.a(didJSUpdateUiDuringFrameDetector.f19082c, j2);
                DidJSUpdateUiDuringFrameDetectorKt.a(didJSUpdateUiDuringFrameDetector.f19083d, j2);
                didJSUpdateUiDuringFrameDetector.f19084e = z2;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.f19094j++;
        }
        this.f19091g++;
        int i2 = (int) (((this.f19095k * ((int) ((this.f19090f - this.f19089e) / 1000000.0d))) / 1000) + 1);
        if ((i2 - this.f19092h) - 1 >= 4) {
            this.f19093i++;
        }
        this.f19092h = i2;
        Choreographer choreographer = this.f19086b;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }
}
