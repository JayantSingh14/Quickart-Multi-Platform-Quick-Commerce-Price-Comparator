package j$.time.format;

import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f53361a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f53362b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53363c = true;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f53364d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f53365e;

    public u(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f53364d = arrayList;
        this.f53365e = null;
        this.f53361a = dateTimeFormatter;
        arrayList.add(new B());
    }

    public final boolean a(char c2, char c3) {
        if (this.f53362b) {
            return c2 == c3;
        }
        return b(c2, c3);
    }

    public final boolean g(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4) {
        if (i2 + i4 <= charSequence.length() && i3 + i4 <= charSequence2.length()) {
            if (this.f53362b) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (charSequence.charAt(i2 + i5) == charSequence2.charAt(i3 + i5)) {
                    }
                }
                return true;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                char cCharAt = charSequence.charAt(i2 + i6);
                char cCharAt2 = charSequence2.charAt(i3 + i6);
                if (cCharAt == cCharAt2 || Character.toUpperCase(cCharAt) == Character.toUpperCase(cCharAt2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(char c2, char c3) {
        return c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    public final B c() {
        return (B) this.f53364d.get(r0.size() - 1);
    }

    public final Long d(j$.time.temporal.a aVar) {
        return (Long) c().f53273a.get(aVar);
    }

    public final int f(j$.time.temporal.n nVar, long j2, int i2, int i3) {
        Objects.requireNonNull(nVar, "field");
        Long l2 = (Long) c().f53273a.put(nVar, Long.valueOf(j2));
        return (l2 == null || l2.longValue() == j2) ? i3 : ~i2;
    }

    public final void e(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        c().f53274b = zoneId;
    }

    public final String toString() {
        return c().toString();
    }
}
