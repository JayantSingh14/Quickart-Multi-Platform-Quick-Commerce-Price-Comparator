package ch.qos.logback.core.status;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public abstract class StatusBase implements Status {

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayList f13746g = new ArrayList(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f13747a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13748b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13749c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f13750d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f13751e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13752f = System.currentTimeMillis();

    public StatusBase(int i2, String str, Object obj, Throwable th) {
        this.f13747a = i2;
        this.f13748b = str;
        this.f13749c = obj;
        this.f13751e = th;
    }

    @Override // ch.qos.logback.core.status.Status
    public final int a() {
        return this.f13747a;
    }

    @Override // ch.qos.logback.core.status.Status
    public final Long b() {
        return Long.valueOf(this.f13752f);
    }

    @Override // ch.qos.logback.core.status.Status
    public final Throwable c() {
        return this.f13751e;
    }

    @Override // ch.qos.logback.core.status.Status
    public final synchronized int d() {
        int i2;
        i2 = this.f13747a;
        Iterator it = iterator();
        while (it.hasNext()) {
            int iD = ((Status) it.next()).d();
            if (iD > i2) {
                i2 = iD;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @Override // ch.qos.logback.core.status.Status
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean e() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.ArrayList r0 = r1.f13750d     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L10
            if (r0 <= 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.status.StatusBase.e():boolean");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusBase statusBase = (StatusBase) obj;
        if (this.f13747a != statusBase.f13747a) {
            return false;
        }
        String str = statusBase.f13748b;
        String str2 = this.f13748b;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final synchronized void f(ErrorStatus errorStatus) {
        try {
            if (this.f13750d == null) {
                this.f13750d = new ArrayList();
            }
            this.f13750d.add(errorStatus);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ch.qos.logback.core.status.Status
    public final String getMessage() {
        return this.f13748b;
    }

    public final int hashCode() {
        int i2 = (this.f13747a + 31) * 31;
        String str = this.f13748b;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    @Override // ch.qos.logback.core.status.Status
    public final synchronized Iterator iterator() {
        ArrayList arrayList = this.f13750d;
        if (arrayList != null) {
            return arrayList.iterator();
        }
        return f13746g.iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iD = d();
        if (iD == 0) {
            sb.append("INFO");
        } else if (iD == 1) {
            sb.append("WARN");
        } else if (iD == 2) {
            sb.append(MerchantConstants.ERROR);
        }
        Object obj = this.f13749c;
        if (obj != null) {
            sb.append(" in ");
            sb.append(obj);
            sb.append(" -");
        }
        sb.append(StringUtils.SPACE);
        sb.append(this.f13748b);
        Throwable th = this.f13751e;
        if (th != null) {
            sb.append(StringUtils.SPACE);
            sb.append(th);
        }
        return sb.toString();
    }
}
