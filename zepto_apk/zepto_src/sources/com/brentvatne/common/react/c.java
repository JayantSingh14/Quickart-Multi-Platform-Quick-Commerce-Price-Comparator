package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Function8 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15464a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter f15465b;

    public /* synthetic */ c(VideoEventEmitter.EventBuilder eventBuilder, VideoEventEmitter videoEventEmitter) {
        this.f15464a = eventBuilder;
        this.f15465b = videoEventEmitter;
    }

    public final Object a(Object obj, Object obj2, Object obj3, Number number, Serializable serializable, Object obj4, Serializable serializable2, Object obj5) {
        final long jLongValue = ((Long) obj).longValue();
        final long jLongValue2 = ((Long) obj2).longValue();
        final int iIntValue = ((Integer) obj3).intValue();
        final int iIntValue2 = ((Integer) number).intValue();
        final ArrayList audioTracks = (ArrayList) serializable;
        final ArrayList textTracks = (ArrayList) obj4;
        final ArrayList videoTracks = (ArrayList) serializable2;
        final String str = (String) obj5;
        Intrinsics.checkNotNullParameter(audioTracks, "audioTracks");
        Intrinsics.checkNotNullParameter(textTracks, "textTracks");
        Intrinsics.checkNotNullParameter(videoTracks, "videoTracks");
        EventTypes eventTypes = EventTypes.f15431d;
        final VideoEventEmitter videoEventEmitter = this.f15465b;
        this.f15464a.a(eventTypes, new Function1() { // from class: com.brentvatne.common.react.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj6) {
                WritableMap dispatch = (WritableMap) obj6;
                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                dispatch.putDouble("duration", jLongValue / 1000.0d);
                dispatch.putDouble("currentTime", jLongValue2 / 1000.0d);
                videoEventEmitter.getClass();
                WritableMap writableMapCreateMap = Arguments.createMap();
                int i2 = iIntValue;
                if (i2 > 0) {
                    writableMapCreateMap.putInt(Snapshot.WIDTH, i2);
                }
                int i3 = iIntValue2;
                if (i3 > 0) {
                    writableMapCreateMap.putInt(Snapshot.HEIGHT, i3);
                }
                writableMapCreateMap.putString("orientation", i2 > i3 ? "landscape" : i2 < i3 ? "portrait" : "square");
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
                dispatch.putMap("naturalSize", writableMapCreateMap);
                String str2 = str;
                if (str2 != null) {
                    dispatch.putString("trackId", str2);
                }
                dispatch.putArray("videoTracks", VideoEventEmitter.d(videoTracks));
                dispatch.putArray("audioTracks", VideoEventEmitter.b(audioTracks));
                dispatch.putArray("textTracks", VideoEventEmitter.c(textTracks));
                dispatch.putBoolean("canPlayFastForward", true);
                dispatch.putBoolean("canPlaySlowForward", true);
                dispatch.putBoolean("canPlaySlowReverse", true);
                dispatch.putBoolean("canPlayReverse", true);
                dispatch.putBoolean("canPlayFastForward", true);
                dispatch.putBoolean("canStepBackward", true);
                dispatch.putBoolean("canStepForward", true);
                return Unit.f53572a;
            }
        });
        return Unit.f53572a;
    }
}
