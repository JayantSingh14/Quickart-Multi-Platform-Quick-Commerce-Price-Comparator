package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.zone.ZoneRules;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, j$.time.temporal.l, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b, reason: collision with root package name */
    public final int f53202b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f53203c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f53198d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f53199e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);

    /* renamed from: f, reason: collision with root package name */
    public static final ZoneOffset f53200f = ofTotalSeconds(-64800);

    /* renamed from: g, reason: collision with root package name */
    public static final ZoneOffset f53201g = ofTotalSeconds(64800);

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f53202b - this.f53202b;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset Z(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.f53199e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L63
            r1 = 3
            if (r0 == r1) goto L7f
            r4 = 5
            if (r0 == r4) goto L5a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L50
            r5 = 7
            if (r0 == r5) goto L43
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = c0(r7, r2, r3)
            int r1 = c0(r7, r6, r2)
            int r2 = c0(r7, r5, r2)
            goto L85
        L37:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = c0(r7, r2, r3)
            int r1 = c0(r7, r1, r3)
            int r2 = c0(r7, r4, r3)
            goto L85
        L50:
            int r0 = c0(r7, r2, r3)
            int r1 = c0(r7, r6, r2)
        L58:
            r2 = r3
            goto L85
        L5a:
            int r0 = c0(r7, r2, r3)
            int r1 = c0(r7, r1, r3)
            goto L58
        L63:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L7f:
            int r0 = c0(r7, r2, r3)
            r1 = r3
            r2 = r1
        L85:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L9e
            if (r3 != r5) goto L92
            goto L9e
        L92:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L9e:
            if (r3 != r5) goto La8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = ofHoursMinutesSeconds(r7, r0, r1)
            return r7
        La8:
            j$.time.ZoneOffset r7 = ofHoursMinutesSeconds(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.Z(java.lang.String):j$.time.ZoneOffset");
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        return new ZoneRules(this);
    }

    public static int c0(String str, int i2, boolean z) {
        if (z && str.charAt(i2 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) str));
        }
        char cCharAt = str.charAt(i2);
        char cCharAt2 = str.charAt(i2 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) str));
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.e(j$.time.temporal.o.f53431d);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i2, int i3, int i4) {
        if (i2 < -18 || i2 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i2 + " is not in the range -18 to 18");
        }
        if (i2 > 0) {
            if (i3 < 0 || i4 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i2 < 0) {
            if (i3 > 0 || i4 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i3 > 0 && i4 < 0) || (i3 < 0 && i4 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i3 < -59 || i3 > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
        if (i4 < -59 || i4 > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: value " + i4 + " is not in the range -59 to 59");
        }
        if (Math.abs(i2) != 18 || (i3 | i4) == 0) {
            return ofTotalSeconds((i3 * 60) + (i2 * MMKV.ExpireInHour) + i4);
        }
        throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
    }

    public static ZoneOffset ofTotalSeconds(int i2) {
        if (i2 < -64800 || i2 > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i2 % 900 == 0) {
            Integer numValueOf = Integer.valueOf(i2);
            ConcurrentHashMap concurrentHashMap = f53198d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(numValueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(numValueOf, new ZoneOffset(i2));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(numValueOf);
            f53199e.putIfAbsent(zoneOffset2.f53203c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i2);
    }

    public ZoneOffset(int i2) {
        String string;
        this.f53202b = i2;
        if (i2 == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i2);
            StringBuilder sb = new StringBuilder();
            int i3 = iAbs / MMKV.ExpireInHour;
            int i4 = (iAbs / 60) % 60;
            sb.append(i2 < 0 ? "-" : "+");
            sb.append(i3 < 10 ? "0" : "");
            sb.append(i3);
            sb.append(i4 < 10 ? ":0" : ":");
            sb.append(i4);
            int i5 = iAbs % 60;
            if (i5 != 0) {
                sb.append(i5 < 10 ? ":0" : ":");
                sb.append(i5);
            }
            string = sb.toString();
        }
        this.f53203c = string;
    }

    public int getTotalSeconds() {
        return this.f53202b;
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f53203c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.OFFSET_SECONDS : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f53202b;
        }
        if (nVar == null) {
            return super.l(nVar).a(h(nVar), nVar);
        }
        throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f53202b;
        }
        if (nVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
        return nVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        return (temporalQuery == j$.time.temporal.o.f53431d || temporalQuery == j$.time.temporal.o.f53432e) ? this : super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        return temporal.a(this.f53202b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneOffset) {
            if (this.f53202b == ((ZoneOffset) obj).f53202b) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.f53202b;
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.f53203c;
    }

    private Object writeReplace() {
        return new q((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void X(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(8);
        e0(objectOutput);
    }

    public final void e0(DataOutput dataOutput) throws IOException {
        int i2 = this.f53202b;
        int i3 = i2 % 900 == 0 ? i2 / 900 : 127;
        dataOutput.writeByte(i3);
        if (i3 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    public static ZoneOffset d0(ObjectInput objectInput) throws IOException {
        byte b2 = objectInput.readByte();
        return b2 == 127 ? ofTotalSeconds(objectInput.readInt()) : ofTotalSeconds(b2 * 900);
    }
}
