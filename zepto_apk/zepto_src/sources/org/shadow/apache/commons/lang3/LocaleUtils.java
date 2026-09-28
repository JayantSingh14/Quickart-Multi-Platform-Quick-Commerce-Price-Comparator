package org.shadow.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class LocaleUtils {

    public static class SyncAvoid {

        /* renamed from: a, reason: collision with root package name */
        public static final List f57721a;

        static {
            ArrayList arrayList = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
            f57721a = Collections.unmodifiableList(arrayList);
            Collections.unmodifiableSet(new HashSet(arrayList));
        }
    }

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
