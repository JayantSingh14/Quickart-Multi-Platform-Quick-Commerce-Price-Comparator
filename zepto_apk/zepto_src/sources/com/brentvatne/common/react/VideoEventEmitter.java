package com.brentvatne.common.react;

import com.brentvatne.common.api.Track;
import com.brentvatne.common.api.VideoTrack;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class VideoEventEmitter {
    public b A;

    /* renamed from: a, reason: collision with root package name */
    public a f15442a;

    /* renamed from: b, reason: collision with root package name */
    public c f15443b;

    /* renamed from: c, reason: collision with root package name */
    public f f15444c;

    /* renamed from: d, reason: collision with root package name */
    public g f15445d;

    /* renamed from: e, reason: collision with root package name */
    public g f15446e;

    /* renamed from: f, reason: collision with root package name */
    public e f15447f;

    /* renamed from: g, reason: collision with root package name */
    public e f15448g;

    /* renamed from: h, reason: collision with root package name */
    public a f15449h;

    /* renamed from: i, reason: collision with root package name */
    public a f15450i;

    /* renamed from: j, reason: collision with root package name */
    public a f15451j;

    /* renamed from: k, reason: collision with root package name */
    public a f15452k;

    /* renamed from: l, reason: collision with root package name */
    public a f15453l;

    /* renamed from: m, reason: collision with root package name */
    public a f15454m;
    public b n;
    public b o;
    public a p;
    public b q;
    public a r;
    public b s;
    public b t;
    public b u;
    public d v;
    public d w;
    public d x;
    public b y;
    public e z;

    @Metadata
    public static final class EventBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final int f15455a;

        /* renamed from: b, reason: collision with root package name */
        public final int f15456b;

        /* renamed from: c, reason: collision with root package name */
        public final EventDispatcher f15457c;

        public EventBuilder(int i2, int i3, EventDispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            this.f15455a = i2;
            this.f15456b = i3;
            this.f15457c = dispatcher;
        }

        public final void a(final EventTypes event, final Function1 function1) {
            Intrinsics.checkNotNullParameter(event, "event");
            final int i2 = this.f15455a;
            final int i3 = this.f15456b;
            this.f15457c.g(new Event<Event<?>>(i2, i3) { // from class: com.brentvatne.common.react.VideoEventEmitter$EventBuilder$dispatch$1
                @Override // com.facebook.react.uimanager.events.Event
                public final WritableMap getEventData() {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    Function1 rVar = function1;
                    if (rVar == null) {
                        rVar = new r(0);
                    }
                    rVar.invoke(writableMapCreateMap);
                    return writableMapCreateMap;
                }

                @Override // com.facebook.react.uimanager.events.Event
                public final String getEventName() {
                    return android.support.v4.media.b.C("top", StringsKt.F(event.f15441a, "on"));
                }
            });
        }
    }

    public static WritableArray b(ArrayList arrayList) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (arrayList != null) {
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                Track track = (Track) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("index", i2);
                writableMapCreateMap.putString("title", track.f15417a);
                String str = track.f15418b;
                if (str != null) {
                    writableMapCreateMap.putString("type", str);
                }
                String str2 = track.f15419c;
                if (str2 != null) {
                    writableMapCreateMap.putString("language", str2);
                }
                int i4 = track.f15421e;
                if (i4 > 0) {
                    writableMapCreateMap.putInt("bitrate", i4);
                }
                writableMapCreateMap.putBoolean("selected", track.f15420d);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i2 = i3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    public static WritableArray c(ArrayList arrayList) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (arrayList != null) {
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                Track track = (Track) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("index", i2);
                writableMapCreateMap.putString("title", track.f15417a);
                writableMapCreateMap.putString("type", track.f15418b);
                writableMapCreateMap.putString("language", track.f15419c);
                writableMapCreateMap.putBoolean("selected", track.f15420d);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i2 = i3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    public static WritableArray d(ArrayList arrayList) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (arrayList != null) {
            int i2 = 0;
            for (Object obj : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.b0();
                    throw null;
                }
                VideoTrack videoTrack = (VideoTrack) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt(Snapshot.WIDTH, videoTrack.f15422a);
                writableMapCreateMap.putInt(Snapshot.HEIGHT, videoTrack.f15423b);
                writableMapCreateMap.putInt("bitrate", videoTrack.f15424c);
                writableMapCreateMap.putString("codecs", videoTrack.f15425d);
                writableMapCreateMap.putString("trackId", videoTrack.f15427f);
                writableMapCreateMap.putInt("index", videoTrack.f15426e);
                writableMapCreateMap.putBoolean("selected", false);
                writableMapCreateMap.putInt("rotation", videoTrack.f15428g);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i2 = i3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    public final void a(ThemedReactContext reactContext, ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, view.getId());
        int iD = UIManagerHelper.d(reactContext);
        if (eventDispatcherB != null) {
            EventBuilder eventBuilder = new EventBuilder(iD, view.getId(), eventDispatcherB);
            a aVar = new a(eventBuilder, 0);
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.f15442a = aVar;
            c cVar = new c(eventBuilder, this);
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.f15443b = cVar;
            f fVar = new f(eventBuilder);
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            this.f15444c = fVar;
            g gVar = new g(eventBuilder, 0);
            Intrinsics.checkNotNullParameter(gVar, "<set-?>");
            this.f15445d = gVar;
            g gVar2 = new g(eventBuilder, 1);
            Intrinsics.checkNotNullParameter(gVar2, "<set-?>");
            this.f15446e = gVar2;
            e eVar = new e(eventBuilder, 1);
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.f15447f = eVar;
            e eVar2 = new e(eventBuilder, 2);
            Intrinsics.checkNotNullParameter(eVar2, "<set-?>");
            this.f15448g = eVar2;
            a aVar2 = new a(eventBuilder, 2);
            Intrinsics.checkNotNullParameter(aVar2, "<set-?>");
            this.f15449h = aVar2;
            a aVar3 = new a(eventBuilder, 3);
            Intrinsics.checkNotNullParameter(aVar3, "<set-?>");
            this.f15450i = aVar3;
            a aVar4 = new a(eventBuilder, 4);
            Intrinsics.checkNotNullParameter(aVar4, "<set-?>");
            this.f15451j = aVar4;
            a aVar5 = new a(eventBuilder, 1);
            Intrinsics.checkNotNullParameter(aVar5, "<set-?>");
            this.f15452k = aVar5;
            a aVar6 = new a(eventBuilder, 5);
            Intrinsics.checkNotNullParameter(aVar6, "<set-?>");
            this.f15453l = aVar6;
            a aVar7 = new a(eventBuilder, 6);
            Intrinsics.checkNotNullParameter(aVar7, "<set-?>");
            this.f15454m = aVar7;
            b bVar = new b(eventBuilder, 4);
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.n = bVar;
            b bVar2 = new b(eventBuilder, 5);
            Intrinsics.checkNotNullParameter(bVar2, "<set-?>");
            this.o = bVar2;
            a aVar8 = new a(eventBuilder, 7);
            Intrinsics.checkNotNullParameter(aVar8, "<set-?>");
            this.p = aVar8;
            b bVar3 = new b(eventBuilder, 6);
            Intrinsics.checkNotNullParameter(bVar3, "<set-?>");
            this.q = bVar3;
            a aVar9 = new a(eventBuilder, 8);
            Intrinsics.checkNotNullParameter(aVar9, "<set-?>");
            this.r = aVar9;
            b bVar4 = new b(eventBuilder, 7);
            Intrinsics.checkNotNullParameter(bVar4, "<set-?>");
            this.s = bVar4;
            b bVar5 = new b(eventBuilder, 0);
            Intrinsics.checkNotNullParameter(bVar5, "<set-?>");
            this.t = bVar5;
            b bVar6 = new b(eventBuilder, 1);
            Intrinsics.checkNotNullParameter(bVar6, "<set-?>");
            this.u = bVar6;
            d dVar = new d(0, eventBuilder, this);
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.v = dVar;
            d dVar2 = new d(1, eventBuilder, this);
            Intrinsics.checkNotNullParameter(dVar2, "<set-?>");
            this.w = dVar2;
            d dVar3 = new d(2, eventBuilder, this);
            Intrinsics.checkNotNullParameter(dVar3, "<set-?>");
            this.x = dVar3;
            b bVar7 = new b(eventBuilder, 2);
            Intrinsics.checkNotNullParameter(bVar7, "<set-?>");
            this.y = bVar7;
            e eVar3 = new e(eventBuilder, 0);
            Intrinsics.checkNotNullParameter(eVar3, "<set-?>");
            this.z = eVar3;
            b bVar8 = new b(eventBuilder, 3);
            Intrinsics.checkNotNullParameter(bVar8, "<set-?>");
            this.A = bVar8;
        }
    }
}
