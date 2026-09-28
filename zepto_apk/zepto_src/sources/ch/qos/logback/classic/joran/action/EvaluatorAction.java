package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction;

/* loaded from: classes3.dex */
public class EvaluatorAction extends AbstractEventEvaluatorAction {
    @Override // ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction
    public final String Y1() {
        return JaninoEventEvaluator.class.getName();
    }
}
