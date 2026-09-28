package com.brentvatne.common.react;

import com.brentvatne.common.api.TimedMetadata;
import com.brentvatne.common.react.VideoEventEmitter;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoEventEmitter.EventBuilder f15463b;

    public /* synthetic */ b(VideoEventEmitter.EventBuilder eventBuilder, int i2) {
        this.f15462a = i2;
        this.f15463b = eventBuilder;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f15462a) {
            case 0:
                float fFloatValue = ((Float) obj).floatValue();
                this.f15463b.a(EventTypes.v, new n(fFloatValue, 0));
                break;
            case 1:
                float fFloatValue2 = ((Float) obj).floatValue();
                this.f15463b.a(EventTypes.w, new n(fFloatValue2, 1));
                break;
            case 2:
                final String textTrackData = (String) obj;
                Intrinsics.checkNotNullParameter(textTrackData, "textTrackData");
                final int i2 = 1;
                this.f15463b.a(EventTypes.z, new Function1() { // from class: com.brentvatne.common.react.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Serializable serializable = textTrackData;
                        WritableMap dispatch = (WritableMap) obj2;
                        switch (i2) {
                            case 0:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                WritableArray writableArrayCreateArray = Arguments.createArray();
                                int i3 = 0;
                                for (Object obj3 : (ArrayList) serializable) {
                                    int i4 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt.b0();
                                        throw null;
                                    }
                                    TimedMetadata timedMetadata = (TimedMetadata) obj3;
                                    WritableMap writableMapCreateMap = Arguments.createMap();
                                    writableMapCreateMap.putString("identifier", timedMetadata.f15415a);
                                    writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_VALUE, timedMetadata.f15416b);
                                    writableArrayCreateArray.pushMap(writableMapCreateMap);
                                    i3 = i4;
                                }
                                Unit unit = Unit.f53572a;
                                dispatch.putArray("metadata", writableArrayCreateArray);
                                return Unit.f53572a;
                            default:
                                Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                dispatch.putString("subtitleTracks", (String) serializable);
                                return Unit.f53572a;
                        }
                    }
                });
                break;
            case 3:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                this.f15463b.a(EventTypes.C, new h(zBooleanValue, 1));
                break;
            case 4:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                this.f15463b.a(EventTypes.p, new h(zBooleanValue2, 3));
                break;
            case 5:
                boolean zBooleanValue3 = ((Boolean) obj).booleanValue();
                this.f15463b.a(EventTypes.f15435h, new h(zBooleanValue3, 2));
                break;
            case 6:
                final ArrayList metadataArrayList = (ArrayList) obj;
                Intrinsics.checkNotNullParameter(metadataArrayList, "metadataArrayList");
                if (metadataArrayList.size() != 0) {
                    final int i3 = 0;
                    this.f15463b.a(EventTypes.s, new Function1() { // from class: com.brentvatne.common.react.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Serializable serializable = metadataArrayList;
                            WritableMap dispatch = (WritableMap) obj2;
                            switch (i3) {
                                case 0:
                                    Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                    WritableArray writableArrayCreateArray = Arguments.createArray();
                                    int i32 = 0;
                                    for (Object obj3 : (ArrayList) serializable) {
                                        int i4 = i32 + 1;
                                        if (i32 < 0) {
                                            CollectionsKt.b0();
                                            throw null;
                                        }
                                        TimedMetadata timedMetadata = (TimedMetadata) obj3;
                                        WritableMap writableMapCreateMap = Arguments.createMap();
                                        writableMapCreateMap.putString("identifier", timedMetadata.f15415a);
                                        writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_VALUE, timedMetadata.f15416b);
                                        writableArrayCreateArray.pushMap(writableMapCreateMap);
                                        i32 = i4;
                                    }
                                    Unit unit = Unit.f53572a;
                                    dispatch.putArray("metadata", writableArrayCreateArray);
                                    return Unit.f53572a;
                                default:
                                    Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
                                    dispatch.putString("subtitleTracks", (String) serializable);
                                    return Unit.f53572a;
                            }
                        }
                    });
                    break;
                } else {
                    break;
                }
            default:
                boolean zBooleanValue4 = ((Boolean) obj).booleanValue();
                this.f15463b.a(EventTypes.u, new h(zBooleanValue4, 0));
                break;
        }
        return Unit.f53572a;
    }
}
