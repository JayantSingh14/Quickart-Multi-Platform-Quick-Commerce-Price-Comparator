package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.joran.event.InPlayListener;
import ch.qos.logback.core.joran.event.SaxEvent;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class ThenActionState implements InPlayListener {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f13536a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13537b;

    @Override // ch.qos.logback.core.joran.event.InPlayListener
    public final void x(SaxEvent saxEvent) {
        this.f13536a.add(saxEvent);
    }
}
