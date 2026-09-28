package com.swmansion.rnscreens.events;

import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ScreenEventEmitter {

    /* renamed from: a, reason: collision with root package name */
    public final Screen f47129a;

    public ScreenEventEmitter(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.f47129a = screen;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v3 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(float r10, boolean r11, boolean r12) {
        /*
            r9 = this;
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L7
        L5:
            r5 = r0
            goto Lf
        L7:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto Le
            goto L5
        Le:
            r5 = r10
        Lf:
            short r8 = com.swmansion.rnscreens.ScreenFragment.Companion.a(r5)
            com.swmansion.rnscreens.Screen r10 = r9.f47129a
            com.facebook.react.uimanager.events.EventDispatcher r0 = r10.getReactEventDispatcher()
            if (r0 == 0) goto L2d
            com.swmansion.rnscreens.events.ScreenTransitionProgressEvent r2 = new com.swmansion.rnscreens.events.ScreenTransitionProgressEvent
            int r3 = com.facebook.react.uimanager.UIManagerHelper.e(r10)
            int r4 = r10.getId()
            r6 = r11
            r7 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.g(r2)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.events.ScreenEventEmitter.a(float, boolean, boolean):void");
    }
}
