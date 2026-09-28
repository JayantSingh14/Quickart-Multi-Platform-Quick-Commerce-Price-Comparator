package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a extends Clock implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f53207b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f53208a;

    public a(ZoneId zoneId) {
        this.f53208a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f53207b = new a(ZoneOffset.UTC);
    }

    @Override // j$.time.Clock
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // j$.time.Clock
    public final Instant instant() {
        return Instant.A(System.currentTimeMillis());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f53208a.equals(((a) obj).f53208a);
    }

    public final int hashCode() {
        return this.f53208a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f53208a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
