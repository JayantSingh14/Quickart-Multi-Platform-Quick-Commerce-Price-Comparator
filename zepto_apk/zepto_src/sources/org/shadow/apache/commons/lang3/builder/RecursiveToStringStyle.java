package org.shadow.apache.commons.lang3.builder;

import java.util.Collection;
import org.shadow.apache.commons.lang3.ClassUtils;

/* loaded from: classes5.dex */
public class RecursiveToStringStyle extends ToStringStyle {
    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public void c(StringBuffer stringBuffer, String str, Object obj) {
        if (ClassUtils.f57703b.containsKey(obj.getClass()) || String.class.equals(obj.getClass())) {
            stringBuffer.append(obj);
        } else {
            stringBuffer.append(new ReflectionToStringBuilder(obj, this).toString());
        }
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
    public final void d(StringBuffer stringBuffer, String str, Collection collection) {
        b(stringBuffer, collection);
        if (s() && collection != null) {
            ToStringStyle.u(collection);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(collection)));
        }
        k(stringBuffer, str, collection.toArray());
    }
}
