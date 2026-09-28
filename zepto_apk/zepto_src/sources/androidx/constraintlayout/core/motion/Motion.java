package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Motion implements TypedValues {

    /* renamed from: a, reason: collision with root package name */
    public final MotionWidget f1779a;

    /* renamed from: b, reason: collision with root package name */
    public final MotionPaths f1780b;

    /* renamed from: c, reason: collision with root package name */
    public final MotionPaths f1781c;

    /* renamed from: d, reason: collision with root package name */
    public final MotionConstrainedPoint f1782d;

    /* renamed from: e, reason: collision with root package name */
    public final MotionConstrainedPoint f1783e;

    /* renamed from: androidx.constraintlayout.core.motion.Motion$1, reason: invalid class name */
    class AnonymousClass1 implements DifferentialInterpolator {
    }

    public Motion(MotionWidget motionWidget) {
        new Rect();
        this.f1780b = new MotionPaths();
        this.f1781c = new MotionPaths();
        this.f1782d = new MotionConstrainedPoint();
        this.f1783e = new MotionConstrainedPoint();
        new ArrayList();
        new ArrayList();
        this.f1779a = motionWidget;
    }

    public final void a(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f1781c;
        motionPaths.getClass();
        motionPaths.f1785a = 1.0f;
        this.f1779a.f1789a.getClass();
        float f2 = 0;
        this.f1779a.f1789a.getClass();
        this.f1779a.f1789a.getClass();
        this.f1779a.f1789a.getClass();
        motionPaths.f1786b = f2;
        motionPaths.f1787c = f2;
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionPaths.f1786b = f2;
        motionPaths.f1787c = f2;
        motionPaths.a(motionWidget);
        this.f1783e.a(motionWidget);
    }

    public final void b(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f1780b;
        motionPaths.getClass();
        motionPaths.f1785a = 0.0f;
        motionWidget.f1789a.getClass();
        float f2 = 0;
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionWidget.f1789a.getClass();
        motionPaths.f1786b = f2;
        motionPaths.f1787c = f2;
        motionPaths.a(motionWidget);
        this.f1782d.a(motionWidget);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        MotionPaths motionPaths = this.f1780b;
        sb.append(motionPaths.f1786b);
        sb.append(" y: ");
        sb.append(motionPaths.f1787c);
        sb.append(" end: x: ");
        MotionPaths motionPaths2 = this.f1781c;
        sb.append(motionPaths2.f1786b);
        sb.append(" y: ");
        sb.append(motionPaths2.f1787c);
        return sb.toString();
    }
}
