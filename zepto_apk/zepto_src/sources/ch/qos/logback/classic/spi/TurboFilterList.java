package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class TurboFilterList extends CopyOnWriteArrayList<TurboFilter> {
    public final FilterReply b(Level level, Logger logger, Exception exc, String str, Object[] objArr) {
        int size = size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 1) {
            try {
                return get(0).T1(level, str);
            } catch (IndexOutOfBoundsException unused) {
            }
        } else {
            for (Object obj : toArray()) {
                FilterReply filterReplyT1 = ((TurboFilter) obj).T1(level, str);
                if (filterReplyT1 == FilterReply.f13739a || filterReplyT1 == FilterReply.f13741c) {
                    return filterReplyT1;
                }
            }
        }
        return filterReply;
    }
}
