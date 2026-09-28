package j$.time.format;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q implements InterfaceC0122e {

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.n f53346a;

    /* renamed from: b, reason: collision with root package name */
    public final E f53347b;

    /* renamed from: c, reason: collision with root package name */
    public final z f53348c;

    /* renamed from: d, reason: collision with root package name */
    public volatile i f53349d;

    public q(j$.time.temporal.n nVar, E e2, z zVar) {
        this.f53346a = nVar;
        this.f53347b = e2;
        this.f53348c = zVar;
    }

    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        String strC;
        Long lA = wVar.a(this.f53346a);
        if (lA == null) {
            return false;
        }
        j$.time.chrono.k kVar = (j$.time.chrono.k) wVar.f53370a.e(j$.time.temporal.o.f53429b);
        DateTimeFormatter dateTimeFormatter = wVar.f53371b;
        if (kVar == null || kVar == j$.time.chrono.r.f53253c) {
            strC = this.f53348c.c(this.f53346a, lA.longValue(), this.f53347b, dateTimeFormatter.f53287b);
        } else {
            strC = this.f53348c.b(kVar, this.f53346a, lA.longValue(), this.f53347b, dateTimeFormatter.f53287b);
        }
        if (strC != null) {
            sb.append(strC);
            return true;
        }
        if (this.f53349d == null) {
            this.f53349d = new i(this.f53346a, 1, 19, D.NORMAL);
        }
        return this.f53349d.q(wVar, sb);
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        Iterator itE;
        int length = charSequence.length();
        if (i2 < 0 || i2 > length) {
            throw new IndexOutOfBoundsException();
        }
        E e2 = uVar.f53363c ? this.f53347b : null;
        j$.time.chrono.k kVar = uVar.c().f53275c;
        if (kVar == null && (kVar = uVar.f53361a.f53290e) == null) {
            kVar = j$.time.chrono.r.f53253c;
        }
        j$.time.chrono.k kVar2 = kVar;
        z zVar = this.f53348c;
        j$.time.temporal.n nVar = this.f53346a;
        DateTimeFormatter dateTimeFormatter = uVar.f53361a;
        if (kVar2 == null || kVar2 == j$.time.chrono.r.f53253c) {
            itE = zVar.e(nVar, e2, dateTimeFormatter.f53287b);
        } else {
            itE = zVar.d(kVar2, nVar, e2, dateTimeFormatter.f53287b);
        }
        Iterator it = itE;
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                if (uVar.g(str, 0, charSequence, i2, str.length())) {
                    return uVar.f(this.f53346a, ((Long) entry.getValue()).longValue(), i2, str.length() + i2);
                }
            }
            if (nVar == j$.time.temporal.a.ERA && !uVar.f53363c) {
                Iterator it2 = kVar2.B().iterator();
                while (it2.hasNext()) {
                    String string = ((j$.time.chrono.l) it2.next()).toString();
                    if (uVar.g(string, 0, charSequence, i2, string.length())) {
                        return uVar.f(this.f53346a, r7.q(), i2, string.length() + i2);
                    }
                }
            }
            if (uVar.f53363c) {
                return ~i2;
            }
        }
        if (this.f53349d == null) {
            this.f53349d = new i(this.f53346a, 1, 19, D.NORMAL);
        }
        return this.f53349d.s(uVar, charSequence, i2);
    }

    public final String toString() {
        E e2 = E.FULL;
        j$.time.temporal.n nVar = this.f53346a;
        E e3 = this.f53347b;
        if (e3 == e2) {
            return "Text(" + nVar + ")";
        }
        return "Text(" + nVar + "," + e3 + ")";
    }
}
