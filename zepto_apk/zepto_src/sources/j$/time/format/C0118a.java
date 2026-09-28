package j$.time.format;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: j$.time.format.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0118a extends z {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f53310d;

    public C0118a(y yVar) {
        this.f53310d = yVar;
    }

    @Override // j$.time.format.z
    public final String b(j$.time.chrono.k kVar, j$.time.temporal.n nVar, long j2, E e2, Locale locale) {
        return this.f53310d.a(j2, e2);
    }

    @Override // j$.time.format.z
    public final String c(j$.time.temporal.n nVar, long j2, E e2, Locale locale) {
        return this.f53310d.a(j2, e2);
    }

    @Override // j$.time.format.z
    public final Iterator d(j$.time.chrono.k kVar, j$.time.temporal.n nVar, E e2, Locale locale) {
        List list = (List) this.f53310d.f53374b.get(e2);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    @Override // j$.time.format.z
    public final Iterator e(j$.time.temporal.n nVar, E e2, Locale locale) {
        List list = (List) this.f53310d.f53374b.get(e2);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
