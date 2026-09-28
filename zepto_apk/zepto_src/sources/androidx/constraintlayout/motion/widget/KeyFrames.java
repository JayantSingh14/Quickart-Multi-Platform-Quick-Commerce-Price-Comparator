package androidx.constraintlayout.motion.widget;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class KeyFrames {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f2109b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2110a = new HashMap();

    static {
        HashMap map = new HashMap();
        f2109b = map;
        try {
            map.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            map.put("KeyPosition", KeyPosition.class.getConstructor(null));
            map.put("KeyCycle", KeyCycle.class.getConstructor(null));
            map.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            map.put("KeyTrigger", KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e2) {
            Log.e("KeyFrames", "unable to load", e2);
        }
    }

    public KeyFrames() {
    }

    public final void a(MotionController motionController) {
        Integer numValueOf = Integer.valueOf(motionController.f2156c);
        HashMap map = this.f2110a;
        ArrayList arrayList = (ArrayList) map.get(numValueOf);
        if (arrayList != null) {
            motionController.w.addAll(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) map.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                String str = ((ConstraintLayout.LayoutParams) motionController.f2155b.getLayoutParams()).Y;
                String str2 = key.f2087c;
                if ((str2 == null || str == null) ? false : str.matches(str2)) {
                    motionController.a(key);
                }
            }
        }
    }

    public final void b(Key key) {
        Integer numValueOf = Integer.valueOf(key.f2086b);
        HashMap map = this.f2110a;
        if (!map.containsKey(numValueOf)) {
            map.put(Integer.valueOf(key.f2086b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) map.get(Integer.valueOf(key.f2086b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public KeyFrames(android.content.Context r9, android.content.res.XmlResourceParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyFrames.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
