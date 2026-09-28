package j$.time.temporal;

import j$.time.DayOfWeek;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class s implements Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap f53448g = new ConcurrentHashMap(4, 0.75f, 2);

    /* renamed from: h, reason: collision with root package name */
    public static final h f53449h;
    private static final long serialVersionUID = -1177360819670808121L;

    /* renamed from: a, reason: collision with root package name */
    public final DayOfWeek f53450a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53451b;

    /* renamed from: c, reason: collision with root package name */
    public final transient r f53452c;

    /* renamed from: d, reason: collision with root package name */
    public final transient r f53453d;

    /* renamed from: e, reason: collision with root package name */
    public final transient r f53454e;

    /* renamed from: f, reason: collision with root package name */
    public final transient r f53455f;

    static {
        new s(DayOfWeek.MONDAY, 4);
        a(DayOfWeek.SUNDAY, 1);
        f53449h = i.f53420d;
    }

    public static s a(DayOfWeek dayOfWeek, int i2) {
        String str = dayOfWeek.toString() + i2;
        ConcurrentHashMap concurrentHashMap = f53448g;
        s sVar = (s) concurrentHashMap.get(str);
        if (sVar != null) {
            return sVar;
        }
        concurrentHashMap.putIfAbsent(str, new s(dayOfWeek, i2));
        return (s) concurrentHashMap.get(str);
    }

    public s(DayOfWeek dayOfWeek, int i2) {
        ChronoUnit chronoUnit = ChronoUnit.DAYS;
        ChronoUnit chronoUnit2 = ChronoUnit.WEEKS;
        this.f53452c = new r("DayOfWeek", this, chronoUnit, chronoUnit2, r.f53439f);
        this.f53453d = new r("WeekOfMonth", this, chronoUnit2, ChronoUnit.MONTHS, r.f53440g);
        h hVar = i.f53420d;
        this.f53454e = new r("WeekOfWeekBasedYear", this, chronoUnit2, hVar, r.f53442i);
        this.f53455f = new r("WeekBasedYear", this, hVar, ChronoUnit.FOREVER, a.YEAR.f53410b);
        Objects.requireNonNull(dayOfWeek, "firstDayOfWeek");
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f53450a = dayOfWeek;
        this.f53451b = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.f53450a == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i2 = this.f53451b;
        if (i2 < 1 || i2 > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return a(this.f53450a, this.f53451b);
        } catch (IllegalArgumentException e2) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + e2.getMessage());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && hashCode() == obj.hashCode();
    }

    public final int hashCode() {
        return (this.f53450a.ordinal() * 7) + this.f53451b;
    }

    public final String toString() {
        return "WeekFields[" + this.f53450a + "," + this.f53451b + "]";
    }
}
