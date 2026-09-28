package ch.qos.logback.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class CachingDateFormatter {

    /* renamed from: a, reason: collision with root package name */
    public long f13800a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f13801b = null;

    /* renamed from: c, reason: collision with root package name */
    public final SimpleDateFormat f13802c;

    public CachingDateFormatter(String str) {
        this.f13802c = new SimpleDateFormat(str);
    }

    public final String a(long j2) {
        String str;
        synchronized (this) {
            try {
                if (j2 != this.f13800a) {
                    this.f13800a = j2;
                    this.f13801b = this.f13802c.format(new Date(j2));
                }
                str = this.f13801b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
