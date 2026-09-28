package ch.qos.logback.core.joran.conditional;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ThenAction extends ThenOrElseActionBase {
    @Override // ch.qos.logback.core.joran.conditional.ThenOrElseActionBase
    public final void Y1(IfAction ifAction, ArrayList arrayList) {
        IfState ifState = (IfState) ifAction.f13530d.firstElement();
        if (!ifState.f13534d) {
            throw new IllegalStateException("setThenSaxEventList() invoked on inactive IfAction");
        }
        ifState.f13532b = arrayList;
    }
}
