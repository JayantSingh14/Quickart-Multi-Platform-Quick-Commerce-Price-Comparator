package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15469a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15470b;

    public /* synthetic */ e(VideoEventEmitter.EventBuilder eventBuilder, int i2) {
        this.f15469a = i2;
        this.f15470b = eventBuilder;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f15469a) {
            case 0:
                String adEvent = (String) obj;
                Intrinsics.checkNotNullParameter(adEvent, "adEvent");
                this.f15470b.a(EventTypes.B, new d(3, adEvent, (Map) obj2));
                break;
            case 1:
                final boolean zBooleanValue = ((Boolean) obj).booleanValue();
                final boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                this.f15470b.a(EventTypes.q, new Function1() { // from class: com.brentvatne.common.react.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        WritableMap dispatch = (WritableMap) obj3;
                        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                        dispatch.putBoolean("isPlaying", zBooleanValue);
                        dispatch.putBoolean("isSeeking", zBooleanValue2);
                        return Unit.f53572a;
                    }
                });
                break;
            default:
                final long jLongValue = ((Long) obj).longValue();
                final long jLongValue2 = ((Long) obj2).longValue();
                this.f15470b.a(EventTypes.f15436i, new Function1() { // from class: com.brentvatne.common.react.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        WritableMap dispatch = (WritableMap) obj3;
                        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                        dispatch.putDouble("currentTime", jLongValue / 1000.0d);
                        dispatch.putDouble("seekTime", jLongValue2 / 1000.0d);
                        return Unit.f53572a;
                    }
                });
                break;
        }
        return Unit.f53572a;
    }
}
