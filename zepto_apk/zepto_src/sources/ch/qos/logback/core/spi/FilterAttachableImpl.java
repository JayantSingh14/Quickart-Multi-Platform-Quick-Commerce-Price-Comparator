package ch.qos.logback.core.spi;

import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.util.COWArrayList;

/* loaded from: classes.dex */
public final class FilterAttachableImpl<E> implements FilterAttachable<E> {

    /* renamed from: a, reason: collision with root package name */
    public final COWArrayList f13738a = new COWArrayList(new Filter[0]);

    public final FilterReply b(Object obj) {
        COWArrayList cOWArrayList = this.f13738a;
        cOWArrayList.d();
        for (Filter filter : (Filter[]) cOWArrayList.f13798c) {
            FilterReply filterReplyT1 = filter.T1(obj);
            if (filterReplyT1 == FilterReply.f13739a || filterReplyT1 == FilterReply.f13741c) {
                return filterReplyT1;
            }
        }
        return FilterReply.f13740b;
    }
}
