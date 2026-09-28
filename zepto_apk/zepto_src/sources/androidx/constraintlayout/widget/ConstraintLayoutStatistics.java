package androidx.constraintlayout.widget;

import androidx.constraintlayout.core.Metrics;

/* loaded from: classes3.dex */
public class ConstraintLayoutStatistics {

    /* renamed from: a, reason: collision with root package name */
    public final Metrics f2448a;

    static {
        new String(new char[25]).replace((char) 0, ' ');
    }

    public ConstraintLayoutStatistics(ConstraintLayoutStatistics constraintLayoutStatistics) {
        Metrics metrics = new Metrics();
        this.f2448a = metrics;
        Metrics metrics2 = constraintLayoutStatistics.f2448a;
        metrics2.getClass();
        metrics.f1677a = metrics2.f1677a;
        metrics.f1683g = metrics2.f1683g;
        metrics.f1678b = metrics2.f1678b;
        metrics.f1681e = metrics2.f1681e;
        metrics.f1682f = metrics2.f1682f;
        metrics.f1679c = metrics2.f1679c;
        metrics.f1680d = metrics2.f1680d;
    }

    public final Object clone() {
        return new ConstraintLayoutStatistics(this);
    }
}
