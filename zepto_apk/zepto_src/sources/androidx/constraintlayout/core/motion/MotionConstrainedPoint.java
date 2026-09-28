package androidx.constraintlayout.core.motion;

import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1784a = new LinkedHashMap();

    public final void a(MotionWidget motionWidget) {
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1791c.getClass();
        for (String str : motionWidget.f1789a.f1915a.keySet()) {
            CustomVariable customVariable = (CustomVariable) motionWidget.f1789a.f1915a.get(str);
            if (customVariable != null) {
                this.f1784a.put(str, customVariable);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        motionConstrainedPoint.getClass();
        return Float.compare(0.0f, 0.0f);
    }
}
