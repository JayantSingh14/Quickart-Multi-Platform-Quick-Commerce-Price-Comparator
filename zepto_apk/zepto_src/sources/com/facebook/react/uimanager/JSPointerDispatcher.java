package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.e;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class JSPointerDispatcher {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f19372j = {0, 0};

    /* renamed from: a, reason: collision with root package name */
    public HashMap f19373a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f19374b;

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f19381i;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f19376d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public int f19377e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f19378f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f19379g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f19380h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19375c = new HashMap();

    public JSPointerDispatcher(ViewGroup viewGroup) {
        this.f19381i = viewGroup;
    }

    public static void a(String str, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, ArrayList arrayList, EventDispatcher eventDispatcher) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            eventDispatcher.g(PointerEvent.d(str, ((TouchTargetHelper.ViewTarget) it.next()).f19489a, pointerEventState, motionEvent));
        }
    }

    public static ArrayList b(List list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2, boolean z) {
        ArrayList arrayList = new ArrayList(list);
        if (!z) {
            boolean z2 = false;
            for (int size = list.size() - 1; size >= 0; size--) {
                View view = ((TouchTargetHelper.ViewTarget) list.get(size)).f19490b;
                if (!z2 && !PointerEventHelper.b(view, event2) && !PointerEventHelper.b(view, event)) {
                    arrayList.remove(size);
                } else if (!z2 && PointerEventHelper.b(view, event2)) {
                    z2 = true;
                }
            }
        }
        return arrayList;
    }

    public static boolean e(List list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TouchTargetHelper.ViewTarget viewTarget = (TouchTargetHelper.ViewTarget) it.next();
            if (PointerEventHelper.b(viewTarget.f19490b, event) || PointerEventHelper.b(viewTarget.f19490b, event2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(int i2, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        int i3 = pointerEventState.f19749b;
        HashMap map = pointerEventState.f19753f;
        List arrayList = i2 != -1 ? (List) map.get(Integer.valueOf(i3)) : new ArrayList();
        HashMap map2 = this.f19373a;
        List arrayList2 = (map2 == null || !map2.containsKey(Integer.valueOf(i3))) ? new ArrayList() : (List) this.f19373a.get(Integer.valueOf(i3));
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i4 < Math.min(arrayList.size(), arrayList2.size()) && ((TouchTargetHelper.ViewTarget) arrayList.get((arrayList.size() - 1) - i4)).equals(arrayList2.get((arrayList2.size() - 1) - i4))) {
            View view = ((TouchTargetHelper.ViewTarget) arrayList.get((arrayList.size() - 1) - i4)).f19490b;
            if (!z && PointerEventHelper.b(view, PointerEventHelper.EVENT.f19764h)) {
                z = true;
            }
            if (!z2 && PointerEventHelper.b(view, PointerEventHelper.EVENT.f19766j)) {
                z2 = true;
            }
            i4++;
        }
        if (i4 < Math.max(arrayList.size(), arrayList2.size())) {
            this.f19379g = (this.f19379g + 1) % Api.BaseClientBuilder.API_PRIORITY_OTHER;
            if (arrayList2.size() > 0) {
                int i5 = ((TouchTargetHelper.ViewTarget) arrayList2.get(0)).f19489a;
                if (e(arrayList2, PointerEventHelper.EVENT.o, PointerEventHelper.EVENT.p)) {
                    eventDispatcher.g(PointerEvent.d("topPointerOut", i5, pointerEventState, motionEvent));
                }
                ArrayList arrayListB = b(arrayList2.subList(0, arrayList2.size() - i4), PointerEventHelper.EVENT.f19765i, PointerEventHelper.EVENT.f19766j, z2);
                if (arrayListB.size() > 0) {
                    a("topPointerLeave", pointerEventState, motionEvent, arrayListB, eventDispatcher);
                }
            }
            if (e(arrayList, PointerEventHelper.EVENT.q, PointerEventHelper.EVENT.r)) {
                eventDispatcher.g(PointerEvent.d("topPointerOver", i2, pointerEventState, motionEvent));
            }
            ArrayList arrayListB2 = b(arrayList.subList(0, arrayList.size() - i4), PointerEventHelper.EVENT.f19763g, PointerEventHelper.EVENT.f19764h, z);
            if (arrayListB2.size() > 0) {
                Collections.reverse(arrayListB2);
                a("topPointerEnter", pointerEventState, motionEvent, arrayListB2, eventDispatcher);
            }
        }
        HashMap map3 = new HashMap(map);
        if (i2 == -1) {
            map3.remove(Integer.valueOf(i3));
        }
        this.f19373a = map3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.util.List] */
    public final void d(MotionEvent motionEvent, EventDispatcher eventDispatcher, boolean z) {
        ViewGroup viewGroup;
        int[] iArr;
        int i2;
        View view;
        ArrayList arrayList;
        int i3;
        float[] fArr;
        char c2;
        char c3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 2;
        if (this.f19377e != -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        HashSet hashSet = this.f19376d;
        if (actionMasked == 0) {
            this.f19378f = motionEvent.getPointerId(0);
        } else if (actionMasked == 7) {
            hashSet.add(Integer.valueOf(pointerId));
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        int i8 = 0;
        while (true) {
            int pointerCount = motionEvent.getPointerCount();
            viewGroup = this.f19381i;
            iArr = f19372j;
            int i9 = i6;
            if (i8 >= pointerCount) {
                break;
            }
            float x = motionEvent.getX(i8);
            float y = motionEvent.getY(i8);
            float[] fArr2 = new float[i7];
            fArr2[i9] = x;
            fArr2[1] = y;
            float f2 = fArr2[i9];
            float f3 = fArr2[1];
            float[] fArr3 = TouchTargetHelper.f19482a;
            UiThreadUtil.assertOnUiThread();
            HashSet hashSet2 = hashSet;
            float[] fArr4 = new float[i7];
            fArr4[i9] = f2;
            fArr4[1] = f3;
            ArrayList arrayList2 = new ArrayList();
            View viewD = TouchTargetHelper.d(fArr4, viewGroup, arrayList2);
            if (viewD != null) {
                View view2 = viewD;
                i5 = pointerId;
                int i10 = i9;
                while (view2 != null && view2.getId() <= 0) {
                    view2 = (View) view2.getParent();
                    i10++;
                }
                i4 = actionMasked;
                arrayList2 = arrayList2;
                if (i10 > 0) {
                    int size = arrayList2.size();
                    arrayList2 = arrayList2;
                    if (i10 <= size) {
                        arrayList2 = arrayList2.subList(i10, arrayList2.size());
                    }
                }
                int iReactTagForTouch = view2 instanceof ReactCompoundView ? ((ReactCompoundView) view2).reactTagForTouch(fArr4[i9], fArr4[1]) : view2.getId();
                if (iReactTagForTouch != view2.getId()) {
                    arrayList2.add(i9, new TouchTargetHelper.ViewTarget(iReactTagForTouch, null));
                }
            } else {
                i4 = actionMasked;
                i5 = pointerId;
            }
            int pointerId2 = motionEvent.getPointerId(i8);
            map.put(Integer.valueOf(pointerId2), fArr4);
            map2.put(Integer.valueOf(pointerId2), arrayList2);
            map3.put(Integer.valueOf(pointerId2), fArr2);
            Integer numValueOf = Integer.valueOf(pointerId2);
            viewGroup.getLocationOnScreen(iArr);
            map4.put(numValueOf, new float[]{fArr2[0] + iArr[0], fArr2[1] + iArr[1]});
            i8++;
            pointerId = i5;
            hashSet = hashSet2;
            actionMasked = i4;
            i6 = 0;
            i7 = 2;
        }
        int i11 = actionMasked;
        HashSet hashSet3 = hashSet;
        PointerEvent.PointerEventState pointerEventState = new PointerEvent.PointerEventState(this.f19378f, pointerId, this.f19380h, UIManagerHelper.e(viewGroup), map, map2, map3, map4, hashSet3);
        boolean z2 = z && motionEvent.getActionMasked() == 10;
        if (z2) {
            HashMap map5 = this.f19373a;
            List list = map5 != null ? (List) map5.get(Integer.valueOf(pointerId)) : null;
            if (list == null || list.isEmpty()) {
                return;
            }
            TouchTargetHelper.ViewTarget viewTarget = (TouchTargetHelper.ViewTarget) e.k(1, list);
            i2 = viewTarget.f19489a;
            map2.put(Integer.valueOf(pointerId), new ArrayList());
            view = viewTarget.f19490b;
        } else {
            List list2 = (List) map2.get(Integer.valueOf(pointerId));
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            TouchTargetHelper.ViewTarget viewTarget2 = (TouchTargetHelper.ViewTarget) list2.get(0);
            i2 = viewTarget2.f19489a;
            view = viewTarget2.f19490b;
        }
        c(i2, pointerEventState, motionEvent, eventDispatcher);
        HashMap map6 = this.f19375c;
        switch (i11) {
            case 0:
            case 5:
                List list3 = (List) map2.get(Integer.valueOf(pointerId));
                this.f19379g = (this.f19379g + 1) % Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (!hashSet3.contains(Integer.valueOf(pointerId))) {
                    if (e(list3, PointerEventHelper.EVENT.q, PointerEventHelper.EVENT.r)) {
                        eventDispatcher.g(PointerEvent.d("topPointerOver", i2, pointerEventState, motionEvent));
                    }
                    ArrayList arrayListB = b(list3, PointerEventHelper.EVENT.f19763g, PointerEventHelper.EVENT.f19764h, false);
                    Collections.reverse(arrayListB);
                    a("topPointerEnter", pointerEventState, motionEvent, arrayListB, eventDispatcher);
                }
                if (e(list3, PointerEventHelper.EVENT.f19759c, PointerEventHelper.EVENT.f19760d)) {
                    map6.put(Integer.valueOf(pointerId), new ArrayList(list3));
                }
                if (e(list3, PointerEventHelper.EVENT.f19761e, PointerEventHelper.EVENT.f19762f)) {
                    eventDispatcher.g(PointerEvent.d("topPointerDown", i2, pointerEventState, motionEvent));
                    break;
                }
                break;
            case 1:
            case 6:
                this.f19379g = (this.f19379g + 1) % Api.BaseClientBuilder.API_PRIORITY_OTHER;
                List<TouchTargetHelper.ViewTarget> list4 = (List) map2.get(Integer.valueOf(pointerId));
                if (e(list4, PointerEventHelper.EVENT.f19769m, PointerEventHelper.EVENT.n)) {
                    eventDispatcher.g(PointerEvent.d("topPointerUp", i2, pointerEventState, motionEvent));
                }
                if (!hashSet3.contains(Integer.valueOf(pointerId))) {
                    if (e(list4, PointerEventHelper.EVENT.o, PointerEventHelper.EVENT.p)) {
                        eventDispatcher.g(PointerEvent.d("topPointerOut", i2, pointerEventState, motionEvent));
                    }
                    a("topPointerLeave", pointerEventState, motionEvent, b(list4, PointerEventHelper.EVENT.f19765i, PointerEventHelper.EVENT.f19766j, false), eventDispatcher);
                }
                List list5 = (List) map6.remove(Integer.valueOf(pointerId));
                if (list5 != null && e(list4, PointerEventHelper.EVENT.f19759c, PointerEventHelper.EVENT.f19760d)) {
                    if (list5.isEmpty() || list4.isEmpty()) {
                        arrayList = new ArrayList();
                    } else {
                        HashSet hashSet4 = new HashSet(list5);
                        ArrayList arrayList3 = new ArrayList();
                        for (TouchTargetHelper.ViewTarget viewTarget3 : list4) {
                            if (hashSet4.contains(viewTarget3)) {
                                arrayList3.add(viewTarget3);
                            }
                        }
                        arrayList = arrayList3;
                    }
                    if (!arrayList.isEmpty()) {
                        eventDispatcher.g(PointerEvent.d("topClick", ((TouchTargetHelper.ViewTarget) arrayList.get(0)).f19489a, pointerEventState, motionEvent));
                    }
                }
                if (motionEvent.getActionMasked() == 1) {
                    this.f19378f = -1;
                }
                hashSet3.remove(Integer.valueOf(pointerId));
                break;
            case 2:
                h(i2, pointerEventState, motionEvent, eventDispatcher);
                break;
            case 3:
                Assertions.b(this.f19377e == -1, "Expected to not have already sent a cancel for this gesture");
                List list6 = (List) map2.get(Integer.valueOf(pointerId));
                if (list6.isEmpty() || view == null) {
                    i3 = -1;
                } else {
                    if (e(list6, PointerEventHelper.EVENT.f19757a, PointerEventHelper.EVENT.f19758b)) {
                        int i12 = ((TouchTargetHelper.ViewTarget) list6.get(0)).f19489a;
                        Rect rect = new Rect(0, 0, 1, 1);
                        viewGroup.offsetDescendantRectToMyCoords(view, rect);
                        int[] iArr2 = {rect.top, rect.left};
                        float f4 = iArr2[0];
                        float f5 = iArr2[1];
                        HashMap map7 = new HashMap(map);
                        HashMap map8 = new HashMap(map3);
                        HashMap map9 = new HashMap(map4);
                        float[] fArr5 = {f4, f5};
                        Iterator it = map7.entrySet().iterator();
                        while (it.hasNext()) {
                            ((Map.Entry) it.next()).setValue(fArr5);
                        }
                        float[] fArr6 = {0.0f, 0.0f};
                        Iterator it2 = map8.entrySet().iterator();
                        while (it2.hasNext()) {
                            ((Map.Entry) it2.next()).setValue(fArr6);
                        }
                        viewGroup.getLocationOnScreen(iArr);
                        float[] fArr7 = {fArr5[0] + iArr[0], fArr5[1] + iArr[1]};
                        Iterator it3 = map9.entrySet().iterator();
                        while (it3.hasNext()) {
                            ((Map.Entry) it3.next()).setValue(fArr7);
                        }
                        PointerEvent.PointerEventState pointerEventState2 = new PointerEvent.PointerEventState(pointerEventState.f19748a, pointerEventState.f19749b, pointerEventState.f19750c, pointerEventState.f19751d, map7, new HashMap(map2), map8, map9, new HashSet(pointerEventState.f19756i));
                        Assertions.c(eventDispatcher);
                        eventDispatcher.g(PointerEvent.d("topPointerCancel", i12, pointerEventState2, motionEvent));
                    }
                    this.f19379g = (this.f19379g + 1) % Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    i3 = -1;
                    this.f19378f = -1;
                }
                c(i3, pointerEventState, motionEvent, eventDispatcher);
                break;
            case 4:
            case 8:
            default:
                FLog.q("ReactNative", "Motion Event was ignored. Action=" + i11 + " Target=" + i2);
                return;
            case 7:
                float[] fArr8 = (float[]) map3.get(Integer.valueOf(pointerId));
                HashMap map10 = this.f19374b;
                if (map10 == null || !map10.containsKey(Integer.valueOf(pointerId))) {
                    c2 = 0;
                    c3 = 1;
                    fArr = new float[]{0.0f, 0.0f};
                } else {
                    fArr = (float[]) this.f19374b.get(Integer.valueOf(pointerId));
                    c3 = 1;
                    c2 = 0;
                }
                if (Math.abs(fArr[c2] - fArr8[c2]) > 0.1f || Math.abs(fArr[c3] - fArr8[c3]) > 0.1f) {
                    h(i2, pointerEventState, motionEvent, eventDispatcher);
                    break;
                } else {
                    return;
                }
                break;
            case 9:
                return;
            case 10:
                if (z2) {
                    h(i2, pointerEventState, motionEvent, eventDispatcher);
                    break;
                }
                break;
        }
        this.f19374b = new HashMap(pointerEventState.f19754g);
        this.f19380h = motionEvent.getButtonState();
        hashSet3.retainAll(this.f19374b.keySet());
    }

    public final void f() {
        this.f19377e = -1;
    }

    public final void g(View view, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.f19377e != -1 || view == null) {
            return;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        this.f19381i.getLocationOnScreen(new int[2]);
        motionEventObtain.setLocation(motionEvent.getRawX() - r1[0], motionEvent.getRawY() - r1[1]);
        motionEventObtain.setAction(3);
        d(motionEventObtain, eventDispatcher, false);
        this.f19377e = view.getId();
    }

    public final void h(int i2, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (e((List) pointerEventState.f19753f.get(Integer.valueOf(pointerEventState.f19749b)), PointerEventHelper.EVENT.f19767k, PointerEventHelper.EVENT.f19768l)) {
            short s = (short) (65535 & this.f19379g);
            PointerEvent pointerEvent = (PointerEvent) PointerEvent.f19740g.b();
            if (pointerEvent == null) {
                pointerEvent = new PointerEvent();
            }
            PointerEvent pointerEvent2 = pointerEvent;
            Assertions.c(motionEvent);
            pointerEvent2.c("topPointerMove", i2, pointerEventState, motionEvent, s);
            eventDispatcher.g(pointerEvent2);
        }
    }
}
