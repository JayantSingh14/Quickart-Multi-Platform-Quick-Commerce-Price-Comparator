package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MotionPaths implements Comparable<MotionPaths> {

    /* renamed from: a, reason: collision with root package name */
    public float f1785a;

    /* renamed from: b, reason: collision with root package name */
    public float f1786b;

    /* renamed from: c, reason: collision with root package name */
    public float f1787c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1788d = new HashMap();

    public final void a(MotionWidget motionWidget) {
        motionWidget.f1790b.getClass();
        Easing easing = Easing.f1810b;
        motionWidget.f1790b.getClass();
        motionWidget.f1791c.getClass();
        for (String str : motionWidget.f1789a.f1915a.keySet()) {
            CustomVariable customVariable = (CustomVariable) motionWidget.f1789a.f1915a.get(str);
            if (customVariable != null) {
                this.f1788d.put(str, customVariable);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f1785a, motionPaths.f1785a);
    }
}
