package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class IncludeAction extends Action {

    /* renamed from: d, reason: collision with root package name */
    public String f13515d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13516e;

    public static void Y1(SaxEventRecorder saxEventRecorder) {
        ArrayList arrayList = saxEventRecorder.f13544b;
        if (arrayList.size() == 0) {
            return;
        }
        SaxEvent saxEvent = (SaxEvent) arrayList.get(0);
        if (saxEvent != null && saxEvent.f13541b.equalsIgnoreCase("included")) {
            arrayList.remove(0);
        }
        ArrayList arrayList2 = saxEventRecorder.f13544b;
        SaxEvent saxEvent2 = (SaxEvent) arrayList.get(arrayList2.size() - 1);
        if (saxEvent2 == null || !saxEvent2.f13541b.equalsIgnoreCase("included")) {
            return;
        }
        arrayList.remove(arrayList2.size() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x017e A[ORIG_RETURN, RETURN] */
    @Override // ch.qos.logback.core.joran.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T1(ch.qos.logback.core.joran.spi.InterpretationContext r10, java.lang.String r11, org.xml.sax.helpers.AttributesImpl r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.joran.action.IncludeAction.T1(ch.qos.logback.core.joran.spi.InterpretationContext, java.lang.String, org.xml.sax.helpers.AttributesImpl):void");
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
