package ch.qos.logback.core.status;

import ch.qos.logback.core.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class StatusUtil {

    /* renamed from: a, reason: collision with root package name */
    public final StatusManager f13754a;

    public StatusUtil(Context context) {
        this.f13754a = context.D();
    }

    public static ArrayList a(long j2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Status status = (Status) it.next();
            if (status.b().longValue() >= j2) {
                arrayList.add(status);
            }
        }
        return arrayList;
    }

    public final boolean b(long j2) {
        ArrayList arrayListA = a(j2, this.f13754a.b());
        Pattern patternCompile = Pattern.compile("XML_PARSING");
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            Status status = (Status) it.next();
            if (2 == status.a() && patternCompile.matcher(status.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }
}
