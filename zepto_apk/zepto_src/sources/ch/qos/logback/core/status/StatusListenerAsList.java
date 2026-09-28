package ch.qos.logback.core.status;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StatusListenerAsList implements StatusListener {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13753a = new ArrayList();

    @Override // ch.qos.logback.core.status.StatusListener
    public final void z0(StatusBase statusBase) {
        this.f13753a.add(statusBase);
    }
}
