package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.horcrux.svg.events.SvgLoadEvent;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ImageLoadEvent extends Event<ImageLoadEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f19938a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19939b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19940c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19941d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19942e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19943f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19944g;

    @Metadata
    public static final class Companion {
        public static String a(int i2) {
            if (i2 == 1) {
                return "topError";
            }
            if (i2 == 2) {
                return SvgLoadEvent.EVENT_NAME;
            }
            if (i2 == 3) {
                return "topLoadEnd";
            }
            if (i2 == 4) {
                return "topLoadStart";
            }
            if (i2 == 5) {
                return "topProgress";
            }
            throw new IllegalStateException(("Invalid image event: " + i2).toString());
        }
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    /* loaded from: classes3.dex */
    public @interface ImageEventType {
    }

    public /* synthetic */ ImageLoadEvent(int i2, int i3, int i4) {
        this(i2, i3, i4, null, null, 0, 0, 0, 0);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) this.f19938a;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        int i2 = this.f19938a;
        if (i2 == 1) {
            writableMapCreateMap.putString("error", this.f19939b);
            return writableMapCreateMap;
        }
        if (i2 == 2) {
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putString("uri", this.f19940c);
            writableMapCreateMap2.putDouble(Snapshot.WIDTH, this.f19941d);
            writableMapCreateMap2.putDouble(Snapshot.HEIGHT, this.f19942e);
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "apply(...)");
            writableMapCreateMap.putMap("source", writableMapCreateMap2);
            return writableMapCreateMap;
        }
        if (i2 != 5) {
            return writableMapCreateMap;
        }
        int i3 = this.f19943f;
        writableMapCreateMap.putInt("loaded", i3);
        int i4 = this.f19944g;
        writableMapCreateMap.putInt("total", i4);
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, i3 / i4);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return Companion.a(this.f19938a);
    }

    public ImageLoadEvent(int i2, int i3, int i4, String str, String str2, int i5, int i6, int i7, int i8) {
        super(i2, i3);
        this.f19938a = i4;
        this.f19939b = str;
        this.f19940c = str2;
        this.f19941d = i5;
        this.f19942e = i6;
        this.f19943f = i7;
        this.f19944g = i8;
    }
}
