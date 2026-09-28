package j$.time.format;

import java.lang.ref.SoftReference;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class t extends s {

    /* renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap f53356i = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final E f53357e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f53358f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f53359g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f53360h;

    public t(E e2, boolean z) {
        super(j$.time.temporal.o.f53432e, "ZoneText(" + e2 + ")");
        this.f53359g = new HashMap();
        this.f53360h = new HashMap();
        Objects.requireNonNull(e2, "textStyle");
        this.f53357e = e2;
        this.f53358f = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    @Override // j$.time.format.s, j$.time.format.InterfaceC0122e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(j$.time.format.w r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.t.q(j$.time.format.w, java.lang.StringBuilder):boolean");
    }

    @Override // j$.time.format.s
    public final m a(u uVar) {
        m mVar;
        if (this.f53357e == E.NARROW) {
            return super.a(uVar);
        }
        Locale locale = uVar.f53361a.f53287b;
        boolean z = uVar.f53362b;
        Set set = j$.time.zone.h.f53495d;
        int size = set.size();
        HashMap map = z ? this.f53359g : this.f53360h;
        Map.Entry entry = (Map.Entry) map.get(locale);
        if (entry != null && ((Integer) entry.getKey()).intValue() == size && (mVar = (m) ((SoftReference) entry.getValue()).get()) != null) {
            return mVar;
        }
        m mVar2 = uVar.f53362b ? new m("", null, null) : new l("", null, null);
        String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
        int length = zoneStrings.length;
        char c2 = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(mVar2)));
                return mVar2;
            }
            String[] strArr = zoneStrings[i2];
            String str = strArr[c2];
            if (set.contains(str)) {
                mVar2.a(str, str);
                HashMap map2 = F.f53306d;
                String str2 = (String) map2.get(str);
                HashMap map3 = F.f53309g;
                if (str2 == null && map3.containsKey(str)) {
                    str = (String) map3.get(str);
                    str2 = (String) map2.get(str);
                }
                if (str2 != null) {
                    Map map4 = (Map) F.f53308f.get(str2);
                    str = (map4 == null || !map4.containsKey(locale.getCountry())) ? (String) F.f53307e.get(str2) : (String) map4.get(locale.getCountry());
                }
                if (map3.containsKey(str)) {
                    str = (String) map3.get(str);
                }
                for (int i3 = this.f53357e != E.FULL ? 2 : 1; i3 < strArr.length; i3 += 2) {
                    mVar2.a(strArr[i3], str);
                }
            }
            i2++;
            c2 = 0;
        }
    }
}
