package com.zeptoconsumerapp.Startup;

import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class AppCacheManager {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static boolean a(File file) {
            if (file != null && file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    Iterator itA = ArrayIteratorKt.a(list);
                    boolean z = true;
                    while (itA.hasNext()) {
                        String str = (String) itA.next();
                        Intrinsics.c(str);
                        if (!StringsKt.O(str, "image_cache", false) && !StringsKt.O(str, "lottie", false) && !a(new File(file, str))) {
                            z = false;
                        }
                    }
                    if (z && file.delete()) {
                        return true;
                    }
                }
            } else if (file != null && file.isFile()) {
                return file.delete();
            }
            return false;
        }
    }
}
