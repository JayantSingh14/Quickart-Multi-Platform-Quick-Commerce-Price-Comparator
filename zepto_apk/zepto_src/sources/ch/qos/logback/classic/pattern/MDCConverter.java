package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.Map;

/* loaded from: classes3.dex */
public class MDCConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public String f13316f;

    /* renamed from: g, reason: collision with root package name */
    public String f13317g = "";

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        Map mapM = ((ILoggingEvent) obj).m();
        if (mapM == null) {
            return this.f13317g;
        }
        String str = this.f13316f;
        if (str != null) {
            String str2 = (String) mapM.get(str);
            return str2 != null ? str2 : this.f13317g;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : mapM.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append((String) entry.getKey());
            sb.append('=');
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        String strF = f();
        String[] strArr = new String[2];
        if (strF != null) {
            strArr[0] = strF;
            int iIndexOf = strF.indexOf(":-");
            if (iIndexOf != -1) {
                strArr[0] = strF.substring(0, iIndexOf);
                strArr[1] = strF.substring(iIndexOf + 2);
            }
        }
        this.f13316f = strArr[0];
        String str = strArr[1];
        if (str != null) {
            this.f13317g = str;
        }
        this.f13651e = true;
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13316f = null;
        this.f13651e = false;
    }
}
