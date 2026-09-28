package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class FileNamePattern extends ContextAwareBase {
    static {
        HashMap map = new HashMap();
        map.put("i", IntegerTokenConverter.class.getName());
        map.put("d", DateTokenConverter.class.getName());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 31;
    }

    public final String toString() {
        return null;
    }
}
