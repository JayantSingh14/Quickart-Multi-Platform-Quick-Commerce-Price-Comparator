package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.action.ActionUtil;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes3.dex */
public class PropertyAction extends Action {
    public static void Y1(InterpretationContext interpretationContext, InputStream inputStream, ActionUtil.Scope scope) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        int iOrdinal = scope.ordinal();
        if (iOrdinal == 0) {
            interpretationContext.getClass();
            for (String str : properties.keySet()) {
                String property = properties.getProperty(str);
                if (str != null && property != null) {
                    interpretationContext.f13564f.put(str, property.trim());
                }
            }
            return;
        }
        if (iOrdinal == 1) {
            ContextUtil contextUtil = new ContextUtil(interpretationContext.f13733b);
            for (String str2 : properties.keySet()) {
                contextUtil.f13733b.s0(str2, properties.getProperty(str2));
            }
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        for (String str3 : properties.keySet()) {
            try {
                System.setProperty(str3, properties.getProperty(str3));
            } catch (SecurityException e2) {
                interpretationContext.o1("Failed to set system property [" + str3 + "]", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x015c A[PHI: r4
      0x015c: PHI (r4v10 char) = (r4v7 char), (r4v8 char), (r4v9 char) binds: [B:60:0x015a, B:63:0x0160, B:66:0x0165] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ch.qos.logback.core.joran.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T1(ch.qos.logback.core.joran.spi.InterpretationContext r12, java.lang.String r13, org.xml.sax.helpers.AttributesImpl r14) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.joran.action.PropertyAction.T1(ch.qos.logback.core.joran.spi.InterpretationContext, java.lang.String, org.xml.sax.helpers.AttributesImpl):void");
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
    }
}
