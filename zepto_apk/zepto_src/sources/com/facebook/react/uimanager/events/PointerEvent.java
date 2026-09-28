package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public class PointerEvent extends Event<PointerEvent> {

    /* renamed from: g, reason: collision with root package name */
    public static final Pools.SynchronizedPool f19740g = new Pools.SynchronizedPool(6);

    /* renamed from: a, reason: collision with root package name */
    public MotionEvent f19741a;

    /* renamed from: b, reason: collision with root package name */
    public String f19742b;

    /* renamed from: c, reason: collision with root package name */
    public short f19743c = -1;

    /* renamed from: d, reason: collision with root package name */
    public List f19744d;

    /* renamed from: e, reason: collision with root package name */
    public PointerEventState f19745e;

    /* renamed from: f, reason: collision with root package name */
    public Event.EventAnimationDriverMatchSpec f19746f;

    public static class PointerEventState {

        /* renamed from: a, reason: collision with root package name */
        public final int f19748a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19749b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19750c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19751d;

        /* renamed from: e, reason: collision with root package name */
        public final HashMap f19752e;

        /* renamed from: f, reason: collision with root package name */
        public final HashMap f19753f;

        /* renamed from: g, reason: collision with root package name */
        public final HashMap f19754g;

        /* renamed from: h, reason: collision with root package name */
        public final HashMap f19755h;

        /* renamed from: i, reason: collision with root package name */
        public final HashSet f19756i;

        public PointerEventState(int i2, int i3, int i4, int i5, HashMap map, HashMap map2, HashMap map3, HashMap map4, HashSet hashSet) {
            this.f19748a = i2;
            this.f19749b = i3;
            this.f19750c = i4;
            this.f19751d = i5;
            this.f19752e = map;
            this.f19753f = map2;
            this.f19754g = map3;
            this.f19755h = map4;
            this.f19756i = new HashSet(hashSet);
        }
    }

    public static PointerEvent d(String str, int i2, PointerEventState pointerEventState, MotionEvent motionEvent) {
        PointerEvent pointerEvent = (PointerEvent) f19740g.b();
        if (pointerEvent == null) {
            pointerEvent = new PointerEvent();
        }
        PointerEvent pointerEvent2 = pointerEvent;
        Assertions.c(motionEvent);
        pointerEvent2.c(str, i2, pointerEventState, motionEvent, (short) 0);
        return pointerEvent2;
    }

    public final List a() {
        int i2;
        int actionIndex;
        actionIndex = this.f19741a.getActionIndex();
        String str = this.f19742b;
        str.getClass();
        switch (str) {
            case "topPointerEnter":
            case "topPointerLeave":
            case "topPointerDown":
            case "topPointerOver":
            case "topPointerUp":
            case "topClick":
            case "topPointerOut":
                return Arrays.asList(b(actionIndex));
            case "topPointerMove":
            case "topPointerCancel":
                ArrayList arrayList = new ArrayList();
                for (i2 = 0; i2 < this.f19741a.getPointerCount(); i2++) {
                    arrayList.add(b(i2));
                }
                return arrayList;
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0172 A[PHI: r13
      0x0172: PHI (r13v6 int) = (r13v5 int), (r13v7 int) binds: [B:35:0x0164, B:41:0x016f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.react.bridge.WritableMap b(int r21) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.PointerEvent.b(int):com.facebook.react.bridge.WritableMap");
    }

    public final void c(String str, int i2, PointerEventState pointerEventState, MotionEvent motionEvent, short s) {
        super.init(pointerEventState.f19751d, i2, motionEvent.getEventTime());
        this.f19742b = str;
        this.f19741a = MotionEvent.obtain(motionEvent);
        this.f19743c = s;
        this.f19745e = pointerEventState;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (this.f19741a == null) {
            ReactSoftExceptionLogger.logSoftException("PointerEvent", new IllegalStateException("Cannot dispatch a Pointer that has no MotionEvent; the PointerEvehas been recycled"));
            return;
        }
        if (this.f19744d == null) {
            this.f19744d = a();
        }
        List list = this.f19744d;
        if (list == null) {
            return;
        }
        boolean z = list.size() > 1;
        for (WritableMap writableMapCopy : this.f19744d) {
            if (z) {
                writableMapCopy = writableMapCopy.copy();
            }
            rCTEventEmitter.receiveEvent(getViewTag(), this.f19742b, writableMapCopy);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    @Override // com.facebook.react.uimanager.events.Event
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchModern(com.facebook.react.uimanager.events.RCTModernEventEmitter r14) {
        /*
            r13 = this;
            android.view.MotionEvent r0 = r13.f19741a
            if (r0 != 0) goto L11
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot dispatch a Pointer that has no MotionEvent; the PointerEvehas been recycled"
            r14.<init>(r0)
            java.lang.String r0 = "PointerEvent"
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r0, r14)
            return
        L11:
            java.util.List r0 = r13.f19744d
            if (r0 != 0) goto L1b
            java.util.List r0 = r13.a()
            r13.f19744d = r0
        L1b:
            java.util.List r0 = r13.f19744d
            if (r0 != 0) goto L21
            goto Lb7
        L21:
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L2b
            r0 = r2
            goto L2c
        L2b:
            r0 = r1
        L2c:
            java.util.List r3 = r13.f19744d
            java.util.Iterator r3 = r3.iterator()
        L32:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb7
            java.lang.Object r4 = r3.next()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            if (r0 == 0) goto L44
            com.facebook.react.bridge.WritableMap r4 = r4.copy()
        L44:
            r11 = r4
            int r6 = r13.getSurfaceId()
            int r7 = r13.getViewTag()
            java.lang.String r8 = r13.f19742b
            short r10 = r13.f19743c
            r4 = -1
            if (r10 == r4) goto L56
            r9 = r2
            goto L57
        L56:
            r9 = r1
        L57:
            r4 = 2
            if (r8 != 0) goto L5d
        L5a:
            r5 = r14
            r12 = r4
            goto Lb1
        L5d:
            int r5 = r8.hashCode()
            switch(r5) {
                case -1786514288: goto La6;
                case -1780335505: goto L9d;
                case -1304584214: goto L92;
                case -1304316135: goto L89;
                case -1304250340: goto L80;
                case -1065042973: goto L77;
                case 383186882: goto L6e;
                case 1343400710: goto L65;
                default: goto L64;
            }
        L64:
            goto Lae
        L65:
            java.lang.String r5 = "topPointerOut"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto Laf
            goto Lae
        L6e:
            java.lang.String r5 = "topPointerCancel"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L9b
            goto Lae
        L77:
            java.lang.String r5 = "topPointerUp"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L9b
            goto Lae
        L80:
            java.lang.String r5 = "topPointerOver"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto Laf
            goto Lae
        L89:
            java.lang.String r5 = "topPointerMove"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto Laf
            goto Lae
        L92:
            java.lang.String r5 = "topPointerDown"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L9b
            goto Lae
        L9b:
            r4 = 3
            goto L5a
        L9d:
            java.lang.String r5 = "topPointerLeave"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto Laf
            goto Lae
        La6:
            java.lang.String r5 = "topPointerEnter"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto Laf
        Lae:
            goto L5a
        Laf:
            r4 = 4
            goto L5a
        Lb1:
            r5.receiveEvent(r6, r7, r8, r9, r10, r11, r12)
            r14 = r5
            goto L32
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.PointerEvent.dispatchModern(com.facebook.react.uimanager.events.RCTModernEventEmitter):void");
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return this.f19743c;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final Event.EventAnimationDriverMatchSpec getEventAnimationDriverMatchSpec() {
        if (this.f19746f == null) {
            this.f19746f = new Event.EventAnimationDriverMatchSpec() { // from class: com.facebook.react.uimanager.events.PointerEvent.1
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
                
                    if (r4.equals("topPointerCancel") == false) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
                
                    if (r4.equals("topPointerUp") == false) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
                
                    if (r4.equals("topPointerOver") != false) goto L28;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
                
                    if (r4.equals("topPointerMove") == false) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
                
                    if (r4.equals("topPointerDown") == false) goto L25;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
                
                    r4 = r0.f19745e;
                    r4 = ((java.util.List) r4.f19753f.get(java.lang.Integer.valueOf(r4.f19749b))).iterator();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
                
                    if (r4.hasNext() == false) goto L38;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
                
                    if (((com.facebook.react.uimanager.TouchTargetHelper.ViewTarget) r4.next()).f19489a != r3) goto L39;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
                
                    return true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
                
                    return false;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
                
                    if (r4.equals("topPointerOut") == false) goto L25;
                 */
                @Override // com.facebook.react.uimanager.events.Event.EventAnimationDriverMatchSpec
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final boolean a(int r3, java.lang.String r4) {
                    /*
                        r2 = this;
                        com.facebook.react.uimanager.events.PointerEvent r0 = com.facebook.react.uimanager.events.PointerEvent.this
                        java.lang.String r1 = r0.f19742b
                        boolean r1 = r4.equals(r1)
                        if (r1 != 0) goto Lc
                        goto L76
                    Lc:
                        int r1 = r4.hashCode()
                        switch(r1) {
                            case -1304584214: goto L41;
                            case -1304316135: goto L38;
                            case -1304250340: goto L2f;
                            case -1065042973: goto L26;
                            case 383186882: goto L1d;
                            case 1343400710: goto L14;
                            default: goto L13;
                        }
                    L13:
                        goto L49
                    L14:
                        java.lang.String r1 = "topPointerOut"
                        boolean r4 = r4.equals(r1)
                        if (r4 != 0) goto L50
                        goto L49
                    L1d:
                        java.lang.String r1 = "topPointerCancel"
                        boolean r4 = r4.equals(r1)
                        if (r4 != 0) goto L50
                        goto L49
                    L26:
                        java.lang.String r1 = "topPointerUp"
                        boolean r4 = r4.equals(r1)
                        if (r4 != 0) goto L50
                        goto L49
                    L2f:
                        java.lang.String r1 = "topPointerOver"
                        boolean r4 = r4.equals(r1)
                        if (r4 == 0) goto L49
                        goto L50
                    L38:
                        java.lang.String r1 = "topPointerMove"
                        boolean r4 = r4.equals(r1)
                        if (r4 != 0) goto L50
                        goto L49
                    L41:
                        java.lang.String r1 = "topPointerDown"
                        boolean r4 = r4.equals(r1)
                        if (r4 != 0) goto L50
                    L49:
                        int r4 = r0.getViewTag()
                        if (r4 != r3) goto L76
                        goto L74
                    L50:
                        com.facebook.react.uimanager.events.PointerEvent$PointerEventState r4 = r0.f19745e
                        int r0 = r4.f19749b
                        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                        java.util.HashMap r4 = r4.f19753f
                        java.lang.Object r4 = r4.get(r0)
                        java.util.List r4 = (java.util.List) r4
                        java.util.Iterator r4 = r4.iterator()
                    L64:
                        boolean r0 = r4.hasNext()
                        if (r0 == 0) goto L76
                        java.lang.Object r0 = r4.next()
                        com.facebook.react.uimanager.TouchTargetHelper$ViewTarget r0 = (com.facebook.react.uimanager.TouchTargetHelper.ViewTarget) r0
                        int r0 = r0.f19489a
                        if (r0 != r3) goto L64
                    L74:
                        r3 = 1
                        return r3
                    L76:
                        r3 = 0
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.PointerEvent.AnonymousClass1.a(int, java.lang.String):boolean");
                }
            };
        }
        return this.f19746f;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return this.f19742b;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        this.f19744d = null;
        MotionEvent motionEvent = this.f19741a;
        this.f19741a = null;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        try {
            f19740g.a(this);
        } catch (IllegalStateException e2) {
            ReactSoftExceptionLogger.logSoftException("PointerEvent", e2);
        }
    }
}
