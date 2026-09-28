package ch.qos.logback.classic.util;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class CopyOnInheritThreadLocal extends InheritableThreadLocal<HashMap<String, String>> {
    @Override // java.lang.InheritableThreadLocal
    public final HashMap<String, String> childValue(HashMap<String, String> map) {
        HashMap<String, String> map2 = map;
        if (map2 == null) {
            return null;
        }
        return new HashMap<>(map2);
    }
}
