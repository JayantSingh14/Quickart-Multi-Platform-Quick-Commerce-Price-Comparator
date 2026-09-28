package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Function4 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15472a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15473b;

    public /* synthetic */ g(VideoEventEmitter.EventBuilder eventBuilder, int i2) {
        this.f15472a = i2;
        this.f15473b = eventBuilder;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
        int i2 = this.f15472a;
        final long jLongValue = ((Long) obj).longValue();
        switch (i2) {
            case 0:
                final long jLongValue2 = ((Long) obj2).longValue();
                final long jLongValue3 = ((Long) obj3).longValue();
                final double dDoubleValue = ((Double) obj4).doubleValue();
                this.f15473b.a(EventTypes.f15433f, new Function1() { // from class: com.brentvatne.common.react.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        WritableMap dispatch = (WritableMap) obj5;
                        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                        dispatch.putDouble("currentTime", jLongValue / 1000.0d);
                        dispatch.putDouble("playableDuration", jLongValue2 / 1000.0d);
                        dispatch.putDouble("seekableDuration", jLongValue3 / 1000.0d);
                        dispatch.putDouble("currentPlaybackTime", dDoubleValue);
                        return Unit.f53572a;
                    }
                });
                break;
            default:
                final int iIntValue = ((Integer) obj2).intValue();
                final int iIntValue2 = ((Integer) obj3).intValue();
                final String str = (String) obj4;
                this.f15473b.a(EventTypes.f15434g, new Function1() { // from class: com.brentvatne.common.react.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        WritableMap dispatch = (WritableMap) obj5;
                        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                        dispatch.putDouble("bitrate", jLongValue);
                        int i3 = iIntValue2;
                        if (i3 > 0) {
                            dispatch.putInt(Snapshot.WIDTH, i3);
                        }
                        int i4 = iIntValue;
                        if (i4 > 0) {
                            dispatch.putInt(Snapshot.HEIGHT, i4);
                        }
                        String str2 = str;
                        if (str2 != null) {
                            dispatch.putString("trackId", str2);
                        }
                        return Unit.f53572a;
                    }
                });
                break;
        }
        return Unit.f53572a;
    }
}
