package com.brentvatne.common.react;

import com.brentvatne.exoplayer.ReactExoplayerView;
import com.brentvatne.react.VideoManagerModule;
import com.facebook.react.bridge.WritableMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15500a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f15501b;

    public /* synthetic */ n(float f2, int i2) {
        this.f15500a = i2;
        this.f15501b = f2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f15500a) {
            case 0:
                WritableMap dispatch = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                dispatch.putDouble("playbackRate", this.f15501b);
                return Unit.f53572a;
            case 1:
                WritableMap dispatch2 = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch2, "$this$dispatch");
                dispatch2.putDouble("volume", this.f15501b);
                return Unit.f53572a;
            case 2:
                return VideoManagerModule.setVolumeCmd$lambda$3(this.f15501b, (ReactExoplayerView) obj);
            default:
                return VideoManagerModule.seekCmd$lambda$2(this.f15501b, (ReactExoplayerView) obj);
        }
    }
}
