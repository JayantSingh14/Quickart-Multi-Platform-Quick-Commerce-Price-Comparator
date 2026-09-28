package com.facebook.react.uimanager.events;

import android.view.View;
import com.facebook.react.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class PointerEventHelper {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes.dex */
    public static final class EVENT {

        /* renamed from: a, reason: collision with root package name */
        public static final EVENT f19757a;

        /* renamed from: b, reason: collision with root package name */
        public static final EVENT f19758b;

        /* renamed from: c, reason: collision with root package name */
        public static final EVENT f19759c;

        /* renamed from: d, reason: collision with root package name */
        public static final EVENT f19760d;

        /* renamed from: e, reason: collision with root package name */
        public static final EVENT f19761e;

        /* renamed from: f, reason: collision with root package name */
        public static final EVENT f19762f;

        /* renamed from: g, reason: collision with root package name */
        public static final EVENT f19763g;

        /* renamed from: h, reason: collision with root package name */
        public static final EVENT f19764h;

        /* renamed from: i, reason: collision with root package name */
        public static final EVENT f19765i;

        /* renamed from: j, reason: collision with root package name */
        public static final EVENT f19766j;

        /* renamed from: k, reason: collision with root package name */
        public static final EVENT f19767k;

        /* renamed from: l, reason: collision with root package name */
        public static final EVENT f19768l;

        /* renamed from: m, reason: collision with root package name */
        public static final EVENT f19769m;
        public static final EVENT n;
        public static final EVENT o;
        public static final EVENT p;
        public static final EVENT q;
        public static final EVENT r;
        public static final /* synthetic */ EVENT[] s;
        public static final /* synthetic */ EnumEntries t;

        static {
            EVENT event = new EVENT("CANCEL", 0);
            f19757a = event;
            EVENT event2 = new EVENT("CANCEL_CAPTURE", 1);
            f19758b = event2;
            EVENT event3 = new EVENT("CLICK", 2);
            f19759c = event3;
            EVENT event4 = new EVENT("CLICK_CAPTURE", 3);
            f19760d = event4;
            EVENT event5 = new EVENT("DOWN", 4);
            f19761e = event5;
            EVENT event6 = new EVENT("DOWN_CAPTURE", 5);
            f19762f = event6;
            EVENT event7 = new EVENT("ENTER", 6);
            f19763g = event7;
            EVENT event8 = new EVENT("ENTER_CAPTURE", 7);
            f19764h = event8;
            EVENT event9 = new EVENT("LEAVE", 8);
            f19765i = event9;
            EVENT event10 = new EVENT("LEAVE_CAPTURE", 9);
            f19766j = event10;
            EVENT event11 = new EVENT("MOVE", 10);
            f19767k = event11;
            EVENT event12 = new EVENT("MOVE_CAPTURE", 11);
            f19768l = event12;
            EVENT event13 = new EVENT("UP", 12);
            f19769m = event13;
            EVENT event14 = new EVENT("UP_CAPTURE", 13);
            n = event14;
            EVENT event15 = new EVENT("OUT", 14);
            o = event15;
            EVENT event16 = new EVENT("OUT_CAPTURE", 15);
            p = event16;
            EVENT event17 = new EVENT("OVER", 16);
            q = event17;
            EVENT event18 = new EVENT("OVER_CAPTURE", 17);
            r = event18;
            EVENT[] eventArr = {event, event2, event3, event4, event5, event6, event7, event8, event9, event10, event11, event12, event13, event14, event15, event16, event17, event18};
            s = eventArr;
            t = EnumEntriesKt.a(eventArr);
        }

        public static EVENT valueOf(String str) {
            return (EVENT) Enum.valueOf(EVENT.class, str);
        }

        public static EVENT[] values() {
            return (EVENT[]) s.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[EVENT.values().length];
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                EVENT event = EVENT.f19757a;
                iArr[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                EVENT event2 = EVENT.f19757a;
                iArr[12] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                EVENT event3 = EVENT.f19757a;
                iArr[13] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                EVENT event4 = EVENT.f19757a;
                iArr[0] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                EVENT event5 = EVENT.f19757a;
                iArr[1] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                EVENT event6 = EVENT.f19757a;
                iArr[2] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                EVENT event7 = EVENT.f19757a;
                iArr[3] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        int iHashCode = str.hashCode();
        return iHashCode != -1780335505 ? iHashCode != -1065042973 ? iHashCode == 1343400710 && str.equals("topPointerOut") : str.equals("topPointerUp") : str.equals("topPointerLeave");
    }

    public static final boolean b(View view, EVENT event) {
        int iOrdinal;
        Intrinsics.checkNotNullParameter(event, "event");
        if (view != null && (iOrdinal = event.ordinal()) != 0 && iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5 && iOrdinal != 12 && iOrdinal != 13) {
            Object tag = view.getTag(R.id.pointer_events);
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            if (num == null || (num.intValue() & (1 << event.ordinal())) == 0) {
                return false;
            }
        }
        return true;
    }
}
