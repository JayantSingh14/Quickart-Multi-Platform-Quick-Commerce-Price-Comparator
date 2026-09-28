package ch.qos.logback.core.spi;

import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusBase;
import ch.qos.logback.core.status.WarnStatus;

/* loaded from: classes.dex */
public class ContextAwareBase implements ContextAware {

    /* renamed from: a, reason: collision with root package name */
    public int f13732a;

    /* renamed from: b, reason: collision with root package name */
    public Context f13733b;

    /* renamed from: c, reason: collision with root package name */
    public final ContextAware f13734c;

    public ContextAwareBase() {
        this.f13732a = 0;
        this.f13734c = this;
    }

    public final void J1(String str) {
        w1(new WarnStatus(str, S1()));
    }

    public final void O1(String str, Throwable th) {
        w1(new WarnStatus(str, S1(), (Exception) th));
    }

    public Object S1() {
        return this.f13734c;
    }

    @Override // ch.qos.logback.core.spi.ContextAware
    public void V(Context context) {
        Context context2 = this.f13733b;
        if (context2 == null) {
            this.f13733b = context;
        } else if (context2 != context) {
            throw new IllegalStateException("Context has been already set");
        }
    }

    public final void l1(String str) {
        w1(new ErrorStatus(str, S1()));
    }

    public final void o1(String str, Throwable th) {
        w1(new ErrorStatus(str, S1(), th));
    }

    public final void s1(String str) {
        w1(new InfoStatus(str, S1()));
    }

    public final void w1(Status status) {
        Context context = this.f13733b;
        if (context != null) {
            BasicStatusManager basicStatusManagerD = context.D();
            if (basicStatusManagerD != null) {
                basicStatusManagerD.a((StatusBase) status);
                return;
            }
            return;
        }
        int i2 = this.f13732a;
        this.f13732a = i2 + 1;
        if (i2 == 0) {
            System.out.println("LOGBACK: No context given for " + this);
        }
    }

    public ContextAwareBase(DynamicConverter dynamicConverter) {
        this.f13732a = 0;
        this.f13734c = dynamicConverter;
    }
}
