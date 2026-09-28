package com.facebook.drawee.components;

import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ArrayBlockingQueue;

@Nullsafe
/* loaded from: classes3.dex */
public class DraweeEventTracker {

    /* renamed from: b, reason: collision with root package name */
    public static final DraweeEventTracker f17230b = new DraweeEventTracker();

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f17231c = true;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayBlockingQueue f17232a = new ArrayBlockingQueue(20);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Event {

        /* renamed from: a, reason: collision with root package name */
        public static final Event f17233a;

        /* renamed from: b, reason: collision with root package name */
        public static final Event f17234b;

        /* renamed from: c, reason: collision with root package name */
        public static final Event f17235c;

        /* renamed from: d, reason: collision with root package name */
        public static final Event f17236d;

        /* renamed from: e, reason: collision with root package name */
        public static final Event f17237e;

        /* renamed from: f, reason: collision with root package name */
        public static final Event f17238f;

        /* renamed from: g, reason: collision with root package name */
        public static final Event f17239g;

        /* renamed from: h, reason: collision with root package name */
        public static final Event f17240h;

        /* renamed from: i, reason: collision with root package name */
        public static final Event f17241i;

        /* renamed from: j, reason: collision with root package name */
        public static final Event f17242j;

        /* renamed from: k, reason: collision with root package name */
        public static final Event f17243k;

        /* renamed from: l, reason: collision with root package name */
        public static final Event f17244l;

        /* renamed from: m, reason: collision with root package name */
        public static final Event f17245m;
        public static final Event n;
        public static final Event o;
        public static final Event p;
        public static final Event q;
        public static final Event r;
        public static final Event s;
        public static final /* synthetic */ Event[] t;

        static {
            Event event = new Event("ON_SET_HIERARCHY", 0);
            f17233a = event;
            Event event2 = new Event("ON_CLEAR_HIERARCHY", 1);
            f17234b = event2;
            Event event3 = new Event("ON_SET_CONTROLLER", 2);
            f17235c = event3;
            Event event4 = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
            f17236d = event4;
            Event event5 = new Event("ON_CLEAR_CONTROLLER", 4);
            f17237e = event5;
            Event event6 = new Event("ON_INIT_CONTROLLER", 5);
            f17238f = event6;
            Event event7 = new Event("ON_ATTACH_CONTROLLER", 6);
            f17239g = event7;
            Event event8 = new Event("ON_DETACH_CONTROLLER", 7);
            f17240h = event8;
            Event event9 = new Event("ON_RELEASE_CONTROLLER", 8);
            f17241i = event9;
            Event event10 = new Event("ON_DATASOURCE_SUBMIT", 9);
            f17242j = event10;
            Event event11 = new Event("ON_DATASOURCE_RESULT", 10);
            f17243k = event11;
            Event event12 = new Event("ON_DATASOURCE_RESULT_INT", 11);
            f17244l = event12;
            Event event13 = new Event("ON_DATASOURCE_FAILURE", 12);
            f17245m = event13;
            Event event14 = new Event("ON_DATASOURCE_FAILURE_INT", 13);
            n = event14;
            Event event15 = new Event("ON_HOLDER_ATTACH", 14);
            o = event15;
            Event event16 = new Event("ON_HOLDER_DETACH", 15);
            p = event16;
            Event event17 = new Event("ON_DRAWABLE_SHOW", 16);
            q = event17;
            Event event18 = new Event("ON_DRAWABLE_HIDE", 17);
            r = event18;
            Event event19 = new Event("ON_ACTIVITY_START", 18);
            Event event20 = new Event("ON_ACTIVITY_STOP", 19);
            Event event21 = new Event("ON_RUN_CLEAR_CONTROLLER", 20);
            Event event22 = new Event("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
            Event event23 = new Event("ON_SAME_CONTROLLER_SKIPPED", 22);
            Event event24 = new Event("ON_SUBMIT_CACHE_HIT", 23);
            s = event24;
            t = new Event[]{event, event2, event3, event4, event5, event6, event7, event8, event9, event10, event11, event12, event13, event14, event15, event16, event17, event18, event19, event20, event21, event22, event23, event24};
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) t.clone();
        }
    }

    public final void a(Event event) {
        if (!f17231c) {
            return;
        }
        int i2 = 5;
        while (true) {
            ArrayBlockingQueue arrayBlockingQueue = this.f17232a;
            if (arrayBlockingQueue.offer(event) || i2 <= 0) {
                return;
            }
            arrayBlockingQueue.poll();
            i2--;
        }
    }

    public final String toString() {
        return this.f17232a.toString();
    }
}
