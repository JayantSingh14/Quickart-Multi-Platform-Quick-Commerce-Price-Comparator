package com.brentvatne.common.react;

import com.brentvatne.common.react.VideoEventEmitter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15467b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15468c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f15466a = i2;
        this.f15467b = obj;
        this.f15468c = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object obj2 = this.f15468c;
        Object obj3 = this.f15467b;
        switch (this.f15466a) {
            case 0:
                final ArrayList arrayList = (ArrayList) obj;
                final VideoEventEmitter videoEventEmitter = (VideoEventEmitter) obj2;
                final int i2 = 0;
                ((VideoEventEmitter.EventBuilder) obj3).a(EventTypes.x, new Function1() { // from class: com.brentvatne.common.react.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        WritableMap dispatch = (WritableMap) obj4;
                        switch (i2) {
                            case 0:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter.getClass();
                                dispatch.putArray("audioTracks", VideoEventEmitter.b(arrayList));
                                break;
                            case 1:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter.getClass();
                                dispatch.putArray("textTracks", VideoEventEmitter.c(arrayList));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter.getClass();
                                dispatch.putArray("videoTracks", VideoEventEmitter.d(arrayList));
                                break;
                        }
                        return Unit.f53572a;
                    }
                });
                break;
            case 1:
                final ArrayList arrayList2 = (ArrayList) obj;
                final VideoEventEmitter videoEventEmitter2 = (VideoEventEmitter) obj2;
                final int i3 = 1;
                ((VideoEventEmitter.EventBuilder) obj3).a(EventTypes.y, new Function1() { // from class: com.brentvatne.common.react.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        WritableMap dispatch = (WritableMap) obj4;
                        switch (i3) {
                            case 0:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter2.getClass();
                                dispatch.putArray("audioTracks", VideoEventEmitter.b(arrayList2));
                                break;
                            case 1:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter2.getClass();
                                dispatch.putArray("textTracks", VideoEventEmitter.c(arrayList2));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter2.getClass();
                                dispatch.putArray("videoTracks", VideoEventEmitter.d(arrayList2));
                                break;
                        }
                        return Unit.f53572a;
                    }
                });
                break;
            case 2:
                final ArrayList arrayList3 = (ArrayList) obj;
                final VideoEventEmitter videoEventEmitter3 = (VideoEventEmitter) obj2;
                final int i4 = 2;
                ((VideoEventEmitter.EventBuilder) obj3).a(EventTypes.A, new Function1() { // from class: com.brentvatne.common.react.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        WritableMap dispatch = (WritableMap) obj4;
                        switch (i4) {
                            case 0:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter3.getClass();
                                dispatch.putArray("audioTracks", VideoEventEmitter.b(arrayList3));
                                break;
                            case 1:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter3.getClass();
                                dispatch.putArray("textTracks", VideoEventEmitter.c(arrayList3));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                videoEventEmitter3.getClass();
                                dispatch.putArray("videoTracks", VideoEventEmitter.d(arrayList3));
                                break;
                        }
                        return Unit.f53572a;
                    }
                });
                break;
            default:
                WritableMap dispatch = (WritableMap) obj;
                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                dispatch.putString("event", (String) obj3);
                WritableMap writableMapCreateMap = Arguments.createMap();
                Map map = (Map) obj2;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        Intrinsics.c(str);
                        writableMapCreateMap.putString(str, str2);
                    }
                }
                Unit unit = Unit.f53572a;
                dispatch.putMap("data", writableMapCreateMap);
                break;
        }
        return Unit.f53572a;
    }
}
