package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalQuery;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Set;

/* loaded from: classes2.dex */
public class s implements InterfaceC0122e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile AbstractMap.SimpleImmutableEntry f53352c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile AbstractMap.SimpleImmutableEntry f53353d;

    /* renamed from: a, reason: collision with root package name */
    public final TemporalQuery f53354a;

    /* renamed from: b, reason: collision with root package name */
    public final String f53355b;

    public m a(u uVar) {
        Set<String> set = j$.time.zone.h.f53495d;
        int size = set.size();
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = uVar.f53362b ? f53352c : f53353d;
        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
            synchronized (this) {
                try {
                    simpleImmutableEntry = uVar.f53362b ? f53352c : f53353d;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        Integer numValueOf = Integer.valueOf(size);
                        m mVar = uVar.f53362b ? new m("", null, null) : new l("", null, null);
                        for (String str : set) {
                            mVar.a(str, str);
                        }
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, mVar);
                        if (uVar.f53362b) {
                            f53352c = simpleImmutableEntry;
                        } else {
                            f53353d = simpleImmutableEntry;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (m) simpleImmutableEntry.getValue();
    }

    public s(TemporalQuery temporalQuery, String str) {
        this.f53354a = temporalQuery;
        this.f53355b = str;
    }

    @Override // j$.time.format.InterfaceC0122e
    public boolean q(w wVar, StringBuilder sb) {
        ZoneId zoneId = (ZoneId) wVar.b(this.f53354a);
        if (zoneId == null) {
            return false;
        }
        sb.append(zoneId.getId());
        return true;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        int i3;
        int length = charSequence.length();
        if (i2 > length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == length) {
            return ~i2;
        }
        char cCharAt = charSequence.charAt(i2);
        if (cCharAt == '+' || cCharAt == '-') {
            return b(uVar, charSequence, i2, i2, j.f53325e);
        }
        int i4 = i2 + 2;
        if (length >= i4) {
            char cCharAt2 = charSequence.charAt(i2 + 1);
            if (uVar.a(cCharAt, 'U') && uVar.a(cCharAt2, 'T')) {
                int i5 = i2 + 3;
                if (length >= i5 && uVar.a(charSequence.charAt(i4), 'C')) {
                    return b(uVar, charSequence, i2, i5, j.f53326f);
                }
                return b(uVar, charSequence, i2, i4, j.f53326f);
            }
            if (uVar.a(cCharAt, 'G') && length >= (i3 = i2 + 3) && uVar.a(cCharAt2, 'M') && uVar.a(charSequence.charAt(i4), 'T')) {
                int i6 = i2 + 4;
                if (length >= i6 && uVar.a(charSequence.charAt(i3), '0')) {
                    uVar.e(ZoneId.of("GMT0"));
                    return i6;
                }
                return b(uVar, charSequence, i2, i3, j.f53326f);
            }
        }
        m mVarA = a(uVar);
        ParsePosition parsePosition = new ParsePosition(i2);
        String strC = mVarA.c(charSequence, parsePosition);
        if (strC == null) {
            if (!uVar.a(cCharAt, 'Z')) {
                return ~i2;
            }
            uVar.e(ZoneOffset.UTC);
            return i2 + 1;
        }
        uVar.e(ZoneId.of(strC));
        return parsePosition.getIndex();
    }

    public static int b(u uVar, CharSequence charSequence, int i2, int i3, j jVar) {
        String upperCase = charSequence.subSequence(i2, i3).toString().toUpperCase();
        if (i3 >= charSequence.length()) {
            uVar.e(ZoneId.of(upperCase));
            return i3;
        }
        if (charSequence.charAt(i3) != '0' && !uVar.a(charSequence.charAt(i3), 'Z')) {
            u uVar2 = new u(uVar.f53361a);
            uVar2.f53362b = uVar.f53362b;
            uVar2.f53363c = uVar.f53363c;
            int iS = jVar.s(uVar2, charSequence, i3);
            try {
                if (iS < 0) {
                    if (jVar == j.f53325e) {
                        return ~i2;
                    }
                    uVar.e(ZoneId.of(upperCase));
                    return i3;
                }
                uVar.e(ZoneId.J(upperCase, ZoneOffset.ofTotalSeconds((int) uVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return iS;
            } catch (DateTimeException unused) {
                return ~i2;
            }
        }
        uVar.e(ZoneId.of(upperCase));
        return i3;
    }

    public final String toString() {
        return this.f53355b;
    }
}
