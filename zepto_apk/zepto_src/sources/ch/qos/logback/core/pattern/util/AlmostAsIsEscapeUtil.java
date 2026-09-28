package ch.qos.logback.core.pattern.util;

/* loaded from: classes3.dex */
public class AlmostAsIsEscapeUtil extends RestrictedEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.RestrictedEscapeUtil, ch.qos.logback.core.pattern.util.IEscapeUtil
    public final void a(String str, StringBuffer stringBuffer, char c2, int i2) {
        super.a("%)", stringBuffer, c2, i2);
    }
}
