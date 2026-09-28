package ch.qos.logback.core.spi;

import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusBase;

/* loaded from: classes3.dex */
public class ContextAwareImpl implements ContextAware {

    /* renamed from: a, reason: collision with root package name */
    public int f13735a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Context f13736b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13737c;

    public ContextAwareImpl(Context context, Object obj) {
        this.f13736b = context;
        this.f13737c = obj;
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public final void V(Context context) {
        Context context2 = this.f13736b;
        if (context2 == null) {
            this.f13736b = context;
        } else if (context2 != context) {
            throw new IllegalStateException("Context has been already set");
        }
    }

    public final void b(String str) {
        d(new ErrorStatus(str, e()));
    }

    public final void c(String str, Throwable th) {
        d(new ErrorStatus(2, str, e(), th));
    }

    public final void d(Status status) {
        Context context = this.f13736b;
        if (context != null) {
            BasicStatusManager basicStatusManagerD = context.D();
            if (basicStatusManagerD != null) {
                basicStatusManagerD.a((StatusBase) status);
                return;
            }
            return;
        }
        int i2 = this.f13735a;
        this.f13735a = i2 + 1;
        if (i2 == 0) {
            System.out.println("LOGBACK: No context given for " + this);
        }
    }

    public Object e() {
        return this.f13737c;
    }
}
