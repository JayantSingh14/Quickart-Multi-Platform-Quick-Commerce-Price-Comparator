package org.shadow.apache.commons.lang3;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ObjectUtils {

    public static class Null implements Serializable {
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}
