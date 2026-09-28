package ch.qos.logback.core.boolex;

import android.support.v4.media.b;
import java.util.ArrayList;
import org.codehaus.janino.ScriptEvaluator;

/* loaded from: classes3.dex */
public abstract class JaninoEventEvaluatorBase<E> extends EventEvaluatorBase<E> {

    /* renamed from: f, reason: collision with root package name */
    public int f13459f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f13460g = new ArrayList();

    public abstract String T1();

    public abstract Object[] U1(Object obj);

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public final boolean k0(Object obj) throws EvaluationException {
        if (!this.f13458e) {
            throw new IllegalStateException(b.r(new StringBuilder("Evaluator ["), this.f13457d, "] was called in stopped state"));
        }
        ScriptEvaluator scriptEvaluator = null;
        try {
            scriptEvaluator.evaluate(U1(obj));
            throw null;
        } catch (Exception e2) {
            int i2 = this.f13459f + 1;
            this.f13459f = i2;
            if (i2 >= 4) {
                this.f13458e = false;
            }
            throw new EvaluationException(b.r(new StringBuilder("Evaluator ["), this.f13457d, "] caused an exception"), e2);
        }
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluatorBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        try {
            T1();
            throw null;
        } catch (Exception e2) {
            o1("Could not start evaluator with expression [null]", e2);
        }
    }
}
