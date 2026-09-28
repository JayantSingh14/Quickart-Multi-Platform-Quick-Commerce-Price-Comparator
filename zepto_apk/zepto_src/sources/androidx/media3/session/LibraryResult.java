package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class LibraryResult<V> {

    /* renamed from: g, reason: collision with root package name */
    public static final String f9941g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f9942h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f9943i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f9944j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f9945k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f9946l;

    /* renamed from: a, reason: collision with root package name */
    public final int f9947a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9948b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9949c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9950d;

    /* renamed from: e, reason: collision with root package name */
    public final MediaLibraryService.LibraryParams f9951e;

    /* renamed from: f, reason: collision with root package name */
    public final SessionError f9952f;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    static {
        int i2 = Util.f5744a;
        f9941g = Integer.toString(0, 36);
        f9942h = Integer.toString(1, 36);
        f9943i = Integer.toString(2, 36);
        f9944j = Integer.toString(3, 36);
        f9945k = Integer.toString(4, 36);
        f9946l = Integer.toString(5, 36);
    }

    public LibraryResult(int i2, long j2, MediaLibraryService.LibraryParams libraryParams, SessionError sessionError, Object obj, int i3) {
        this.f9947a = i2;
        this.f9948b = j2;
        this.f9951e = libraryParams;
        this.f9952f = sessionError;
        this.f9949c = obj;
        this.f9950d = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.LibraryResult a(android.os.Bundle r11) {
        /*
            r0 = 1
            java.lang.String r1 = androidx.media3.session.LibraryResult.f9941g
            r2 = 0
            int r4 = r11.getInt(r1, r2)
            java.lang.String r1 = androidx.media3.session.LibraryResult.f9942h
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r5 = r11.getLong(r1, r5)
            java.lang.String r1 = androidx.media3.session.LibraryResult.f9943i
            android.os.Bundle r1 = r11.getBundle(r1)
            r3 = 0
            if (r1 != 0) goto L1d
            r7 = r3
            goto L22
        L1d:
            androidx.media3.session.MediaLibraryService$LibraryParams r1 = androidx.media3.session.MediaLibraryService.LibraryParams.a(r1)
            r7 = r1
        L22:
            java.lang.String r1 = androidx.media3.session.LibraryResult.f9946l
            android.os.Bundle r1 = r11.getBundle(r1)
            if (r1 == 0) goto L30
            androidx.media3.session.SessionError r1 = androidx.media3.session.SessionError.a(r1)
        L2e:
            r8 = r1
            goto L39
        L30:
            if (r4 == 0) goto L38
            androidx.media3.session.SessionError r1 = new androidx.media3.session.SessionError
            r1.<init>(r4)
            goto L2e
        L38:
            r8 = r3
        L39:
            java.lang.String r1 = androidx.media3.session.LibraryResult.f9945k
            int r10 = r11.getInt(r1)
            if (r10 == r0) goto L81
            r1 = 2
            java.lang.String r9 = androidx.media3.session.LibraryResult.f9944j
            if (r10 == r1) goto L83
            r1 = 3
            if (r10 == r1) goto L53
            r11 = 4
            if (r10 != r11) goto L4d
            goto L81
        L4d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>()
            throw r11
        L53:
            android.os.IBinder r11 = r11.getBinder(r9)
            if (r11 != 0) goto L5a
            goto L81
        L5a:
            com.google.common.collect.ImmutableList r11 = androidx.media3.common.BundleListRetriever.a(r11)
            com.google.common.collect.UnmodifiableListIterator r1 = com.google.common.collect.ImmutableList.f42665b
            com.google.common.collect.ImmutableList$Builder r1 = new com.google.common.collect.ImmutableList$Builder
            r1.<init>()
        L65:
            int r3 = r11.size()
            if (r2 >= r3) goto L7d
            java.lang.Object r3 = r11.get(r2)
            android.os.Bundle r3 = (android.os.Bundle) r3
            r3.getClass()
            androidx.media3.common.MediaItem r3 = androidx.media3.common.MediaItem.b(r3)
            r1.h(r3)
            int r2 = r2 + r0
            goto L65
        L7d:
            com.google.common.collect.ImmutableList r3 = r1.j()
        L81:
            r9 = r3
            goto L8f
        L83:
            android.os.Bundle r11 = r11.getBundle(r9)
            if (r11 != 0) goto L8a
            goto L81
        L8a:
            androidx.media3.common.MediaItem r3 = androidx.media3.common.MediaItem.b(r11)
            goto L81
        L8f:
            androidx.media3.session.LibraryResult r3 = new androidx.media3.session.LibraryResult
            r3.<init>(r4, r5, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.LibraryResult.a(android.os.Bundle):androidx.media3.session.LibraryResult");
    }

    public static LibraryResult b(int i2) {
        SessionError sessionError = new SessionError("no error message provided", i2, Bundle.EMPTY);
        return new LibraryResult(sessionError.f10243a, SystemClock.elapsedRealtime(), null, sessionError, null, 4);
    }

    public static LibraryResult c(List list, MediaLibraryService.LibraryParams libraryParams) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d((MediaItem) it.next());
        }
        return new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, ImmutableList.o(list), 3);
    }

    public static void d(MediaItem mediaItem) {
        if (TextUtils.isEmpty(mediaItem.f5257a)) {
            throw new IllegalArgumentException("mediaId must not be empty");
        }
        MediaMetadata mediaMetadata = mediaItem.f5260d;
        Assertions.b(mediaMetadata.q != null, "mediaMetadata must specify isBrowsable");
        Assertions.b(mediaMetadata.r != null, "mediaMetadata must specify isPlayable");
    }
}
