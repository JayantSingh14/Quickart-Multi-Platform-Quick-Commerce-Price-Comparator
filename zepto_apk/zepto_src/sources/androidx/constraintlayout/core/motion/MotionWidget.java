package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;

/* loaded from: classes3.dex */
public class MotionWidget implements TypedValues {

    /* renamed from: a, reason: collision with root package name */
    public final WidgetFrame f1789a;

    /* renamed from: b, reason: collision with root package name */
    public final Motion f1790b;

    /* renamed from: c, reason: collision with root package name */
    public final PropertySet f1791c;

    public static class Motion {
    }

    public static class PropertySet {
    }

    public MotionWidget() {
        this.f1789a = new WidgetFrame();
        this.f1790b = new Motion();
        this.f1791c = new PropertySet();
    }

    public final String toString() {
        this.f1789a.getClass();
        return "0, 0, 0, 0";
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f1789a = new WidgetFrame();
        this.f1790b = new Motion();
        this.f1791c = new PropertySet();
        this.f1789a = widgetFrame;
    }
}
