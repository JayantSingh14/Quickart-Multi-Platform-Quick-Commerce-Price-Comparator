package ch.qos.logback.classic.spi;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class StackTraceElementProxy implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final StackTraceElement f13375a;

    /* renamed from: b, reason: collision with root package name */
    public transient String f13376b;

    /* renamed from: c, reason: collision with root package name */
    public ClassPackagingData f13377c;

    public StackTraceElementProxy(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            throw new IllegalArgumentException("ste cannot be null");
        }
        this.f13375a = stackTraceElement;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StackTraceElementProxy stackTraceElementProxy = (StackTraceElementProxy) obj;
        if (!this.f13375a.equals(stackTraceElementProxy.f13375a)) {
            return false;
        }
        ClassPackagingData classPackagingData = this.f13377c;
        if (classPackagingData == null) {
            if (stackTraceElementProxy.f13377c != null) {
                return false;
            }
        } else if (!classPackagingData.equals(stackTraceElementProxy.f13377c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f13375a.hashCode();
    }

    public final String toString() {
        if (this.f13376b == null) {
            this.f13376b = "at " + this.f13375a.toString();
        }
        return this.f13376b;
    }
}
