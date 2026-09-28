package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Logger;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class LoggerComparator implements Comparator<Logger> {
    @Override // java.util.Comparator
    public final int compare(Logger logger, Logger logger2) {
        Logger logger3 = logger;
        Logger logger4 = logger2;
        if (logger3.f13242a.equals(logger4.f13242a)) {
            return 0;
        }
        String str = logger3.f13242a;
        if (str.equals("ROOT")) {
            return -1;
        }
        String str2 = logger4.f13242a;
        if (str2.equals("ROOT")) {
            return 1;
        }
        return str.compareTo(str2);
    }
}
