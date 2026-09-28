package j$.time.format;

import j$.time.DateTimeException;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final TemporalAccessor f53370a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f53371b;

    /* renamed from: c, reason: collision with root package name */
    public int f53372c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Type inference failed for: r2v2, types: [j$.time.chrono.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w(j$.time.temporal.TemporalAccessor r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.w.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }

    public final Object b(TemporalQuery temporalQuery) {
        TemporalAccessor temporalAccessor = this.f53370a;
        Object objE = temporalAccessor.e(temporalQuery);
        if (objE != null || this.f53372c != 0) {
            return objE;
        }
        throw new DateTimeException("Unable to extract " + temporalQuery + " from temporal " + temporalAccessor);
    }

    public final Long a(j$.time.temporal.n nVar) {
        int i2 = this.f53372c;
        TemporalAccessor temporalAccessor = this.f53370a;
        if (i2 <= 0 || temporalAccessor.g(nVar)) {
            return Long.valueOf(temporalAccessor.h(nVar));
        }
        return null;
    }

    public final String toString() {
        return this.f53370a.toString();
    }
}
