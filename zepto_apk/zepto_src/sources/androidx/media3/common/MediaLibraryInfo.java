package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.util.HashSet;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaLibraryInfo {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f5377a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f5378b = "media3.common";

    public static synchronized void a(String str) {
        if (f5377a.add(str)) {
            f5378b += ", " + str;
        }
    }
}
