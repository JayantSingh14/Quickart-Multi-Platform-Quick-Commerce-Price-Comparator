package org.shadow.apache.commons.lang3.exception;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.shadow.apache.commons.lang3.tuple.Pair;

/* loaded from: classes5.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f57756a = new ArrayList();

    public final String a(String str) {
        String string;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        ArrayList arrayList = this.f57756a;
        if (arrayList.size() > 0) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                sb.append("\t[");
                i2++;
                sb.append(i2);
                sb.append(':');
                sb.append((String) pair.a());
                sb.append("=");
                Object objB = pair.b();
                if (objB == null) {
                    sb.append("null");
                } else {
                    try {
                        string = objB.toString();
                    } catch (Exception e2) {
                        StringBuilder sb2 = new StringBuilder("Exception thrown on toString(): ");
                        StringWriter stringWriter = new StringWriter();
                        e2.printStackTrace(new PrintWriter((Writer) stringWriter, true));
                        sb2.append(stringWriter.getBuffer().toString());
                        string = sb2.toString();
                    }
                    sb.append(string);
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }
}
