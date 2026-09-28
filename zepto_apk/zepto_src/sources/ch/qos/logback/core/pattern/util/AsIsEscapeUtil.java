package ch.qos.logback.core.pattern.util;

/* loaded from: classes3.dex */
public class AsIsEscapeUtil implements IEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public final void a(String str, StringBuffer stringBuffer, char c2, int i2) {
        stringBuffer.append("\\");
        stringBuffer.append(c2);
    }
}
