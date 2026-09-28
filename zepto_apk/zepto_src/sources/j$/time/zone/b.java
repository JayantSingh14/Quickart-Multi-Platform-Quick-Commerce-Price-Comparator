package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a, reason: collision with root package name */
    public final long f53477a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalDateTime f53478b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneOffset f53479c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneOffset f53480d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f53477a, ((b) obj).f53477a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f53477a = localDateTime.b0(zoneOffset);
        this.f53478b = localDateTime;
        this.f53479c = zoneOffset;
        this.f53480d = zoneOffset2;
    }

    public b(long j2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f53477a = j2;
        this.f53478b = LocalDateTime.K(j2, 0, zoneOffset);
        this.f53479c = zoneOffset;
        this.f53480d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f53477a == bVar.f53477a && this.f53479c.equals(bVar.f53479c) && this.f53480d.equals(bVar.f53480d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f53478b.hashCode() ^ this.f53479c.hashCode()) ^ Integer.rotateLeft(this.f53480d.hashCode(), 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        ZoneOffset zoneOffset = this.f53480d;
        int totalSeconds = zoneOffset.getTotalSeconds();
        ZoneOffset zoneOffset2 = this.f53479c;
        sb.append(totalSeconds > zoneOffset2.getTotalSeconds() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f53478b);
        sb.append(zoneOffset2);
        sb.append(" to ");
        sb.append(zoneOffset);
        sb.append(']');
        return sb.toString();
    }
}
