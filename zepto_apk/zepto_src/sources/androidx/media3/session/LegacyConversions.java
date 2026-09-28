package androidx.media3.session;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.HeartRating;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PercentageRating;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Rating;
import androidx.media3.common.StarRating;
import androidx.media3.common.ThumbRating;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.legacy.AudioAttributesCompat;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.RatingCompat;
import com.brentvatne.exoplayer.VideoPlaybackService;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
class LegacyConversions {

    /* renamed from: a, reason: collision with root package name */
    public static final ImmutableSet f9940a;

    public static class ConversionException extends Exception {
    }

    static {
        new MediaBrowserServiceCompat.BrowserRoot("androidx.media3.session.MediaLibraryService", null);
        f9940a = ImmutableSet.u("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", "android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
    }

    public static MediaBrowserCompat.MediaItem a(MediaItem mediaItem, Bitmap bitmap) {
        MediaDescriptionCompat mediaDescriptionCompatI = i(mediaItem, bitmap);
        MediaMetadata mediaMetadata = mediaItem.f5260d;
        Boolean bool = mediaMetadata.q;
        int i2 = (bool == null || !bool.booleanValue()) ? 0 : 1;
        Boolean bool2 = mediaMetadata.r;
        if (bool2 != null && bool2.booleanValue()) {
            i2 |= 2;
        }
        return new MediaBrowserCompat.MediaItem(mediaDescriptionCompatI, i2);
    }

    public static long b(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j2) {
        long j3 = playbackStateCompat == null ? 0L : playbackStateCompat.f10660c;
        long jD = d(playbackStateCompat, mediaMetadataCompat, j2);
        long jE = e(mediaMetadataCompat);
        return jE == -9223372036854775807L ? Math.max(jD, j3) : Util.l(j3, jD, jE);
    }

    public static byte[] c(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long d(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j2) {
        if (playbackStateCompat == null) {
            return 0L;
        }
        long jMax = playbackStateCompat.f10659b;
        if (playbackStateCompat.f10658a == 3) {
            jMax = Math.max(0L, jMax + ((long) (playbackStateCompat.f10661d * ((j2 == -9223372036854775807L ? null : Long.valueOf(j2)) != null ? r2.longValue() : SystemClock.elapsedRealtime() - playbackStateCompat.f10665h))));
        }
        long j3 = jMax;
        long jE = e(mediaMetadataCompat);
        return jE == -9223372036854775807L ? Math.max(0L, j3) : Util.l(j3, 0L, jE);
    }

    public static long e(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.f10606a.containsKey("android.media.metadata.DURATION")) {
            return -9223372036854775807L;
        }
        long jA = mediaMetadataCompat.a("android.media.metadata.DURATION");
        if (jA <= 0) {
            return -9223372036854775807L;
        }
        return jA;
    }

    public static long f(int i2) {
        switch (i2) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unrecognized FolderType: "));
        }
    }

    public static int g(long j2) {
        if (j2 == 0) {
            return 0;
        }
        if (j2 == 1) {
            return 1;
        }
        if (j2 == 2) {
            return 2;
        }
        if (j2 == 3) {
            return 3;
        }
        if (j2 == 4) {
            return 4;
        }
        if (j2 == 5) {
            return 5;
        }
        return j2 == 6 ? 6 : 0;
    }

    public static MediaLibraryService.LibraryParams h(VideoPlaybackService videoPlaybackService, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(videoPlaybackService.getClassLoader());
            int i2 = bundle.getInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", -1);
            if (i2 >= 0) {
                bundle.remove("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS");
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                bundle.putBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", z);
            }
            MediaLibraryService.LibraryParams.Builder builder = new MediaLibraryService.LibraryParams.Builder();
            builder.f10034d = bundle;
            builder.f10031a = bundle.getBoolean("android.service.media.extra.RECENT");
            builder.f10032b = bundle.getBoolean("android.service.media.extra.OFFLINE");
            builder.f10033c = bundle.getBoolean("android.service.media.extra.SUGGESTED");
            return new MediaLibraryService.LibraryParams(builder.f10034d, builder.f10031a, builder.f10032b, builder.f10033c);
        } catch (Exception unused) {
            MediaLibraryService.LibraryParams.Builder builder2 = new MediaLibraryService.LibraryParams.Builder();
            builder2.f10034d = bundle;
            return new MediaLibraryService.LibraryParams(builder2.f10034d, builder2.f10031a, builder2.f10032b, builder2.f10033c);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.legacy.MediaDescriptionCompat i(androidx.media3.common.MediaItem r18, android.graphics.Bitmap r19) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.LegacyConversions.i(androidx.media3.common.MediaItem, android.graphics.Bitmap):androidx.media3.session.legacy.MediaDescriptionCompat");
    }

    public static MediaItem j(MediaDescriptionCompat mediaDescriptionCompat, boolean z, boolean z2) {
        String str = mediaDescriptionCompat.f10587a;
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        builder.f5266a = str;
        MediaItem.RequestMetadata.Builder builder2 = new MediaItem.RequestMetadata.Builder();
        builder2.f5354a = mediaDescriptionCompat.f10594h;
        builder.f5278m = new MediaItem.RequestMetadata(builder2);
        builder.f5276k = l(mediaDescriptionCompat, 0, z, z2);
        return builder.a();
    }

    public static MediaItem k(String str, MediaMetadataCompat mediaMetadataCompat, int i2) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str != null) {
            builder.f5266a = str;
        }
        CharSequence charSequence = mediaMetadataCompat.f10606a.getCharSequence("android.media.metadata.MEDIA_URI");
        String string = charSequence != null ? charSequence.toString() : null;
        if (string != null) {
            MediaItem.RequestMetadata.Builder builder2 = new MediaItem.RequestMetadata.Builder();
            builder2.f5354a = Uri.parse(string);
            builder.f5278m = new MediaItem.RequestMetadata(builder2);
        }
        builder.f5276k = m(mediaMetadataCompat, i2);
        return builder.a();
    }

    public static MediaMetadata l(MediaDescriptionCompat mediaDescriptionCompat, int i2, boolean z, boolean z2) {
        RatingCompat ratingCompat;
        byte[] bArrC;
        if (mediaDescriptionCompat == null) {
            return MediaMetadata.J;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.f5397f = mediaDescriptionCompat.f10589c;
        builder.f5398g = mediaDescriptionCompat.f10590d;
        builder.f5404m = mediaDescriptionCompat.f10592f;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                ratingCompat = new RatingCompat(-1.0f, i2);
                break;
            default:
                ratingCompat = null;
                break;
        }
        builder.f5400i = q(ratingCompat);
        Bitmap bitmap = mediaDescriptionCompat.f10591e;
        if (bitmap != null) {
            try {
                bArrC = c(bitmap);
            } catch (IOException e2) {
                Log.i("LegacyConversions", "Failed to convert iconBitmap to artworkData", e2);
                bArrC = null;
            }
            builder.b(bArrC, 3);
        }
        Bundle bundle = mediaDescriptionCompat.f10593g;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : null;
        if (bundle2 != null && bundle2.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            builder.p = Integer.valueOf(g(bundle2.getLong("android.media.extra.BT_FOLDER_TYPE")));
            bundle2.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        builder.q = Boolean.valueOf(z);
        if (bundle2 != null && bundle2.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            builder.G = Integer.valueOf((int) bundle2.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
            bundle2.remove("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        CharSequence charSequence = mediaDescriptionCompat.f10588b;
        if (bundle2 == null || !bundle2.containsKey("androidx.media3.mediadescriptioncompat.title")) {
            builder.f5392a = charSequence;
        } else {
            builder.f5392a = bundle2.getCharSequence("androidx.media3.mediadescriptioncompat.title");
            builder.f5396e = charSequence;
            bundle2.remove("androidx.media3.mediadescriptioncompat.title");
        }
        if (bundle2 != null && !bundle2.isEmpty()) {
            builder.H = bundle2;
        }
        builder.r = Boolean.valueOf(z2);
        return new MediaMetadata(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MediaMetadata m(MediaMetadataCompat mediaMetadataCompat, int i2) {
        RatingCompat ratingCompatA;
        RatingCompat ratingCompatA2;
        RatingCompat ratingCompat;
        String string;
        if (mediaMetadataCompat == null) {
            return MediaMetadata.J;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        Bundle bundle = mediaMetadataCompat.f10606a;
        CharSequence charSequence = bundle.getCharSequence("android.media.metadata.TITLE");
        CharSequence charSequence2 = bundle.getCharSequence("android.media.metadata.DISPLAY_TITLE");
        builder.f5392a = charSequence != null ? charSequence : charSequence2;
        Bitmap bitmap = null;
        if (charSequence == null) {
            charSequence2 = null;
        }
        builder.f5396e = charSequence2;
        builder.f5397f = bundle.getCharSequence("android.media.metadata.DISPLAY_SUBTITLE");
        builder.f5398g = bundle.getCharSequence("android.media.metadata.DISPLAY_DESCRIPTION");
        builder.f5393b = bundle.getCharSequence("android.media.metadata.ARTIST");
        builder.f5394c = bundle.getCharSequence("android.media.metadata.ALBUM");
        builder.f5395d = bundle.getCharSequence("android.media.metadata.ALBUM_ARTIST");
        try {
            ratingCompatA = RatingCompat.a(bundle.getParcelable("android.media.metadata.RATING"));
        } catch (Exception e2) {
            android.util.Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e2);
            ratingCompatA = null;
        }
        builder.f5401j = q(ratingCompatA);
        if (bundle.containsKey("android.media.metadata.DURATION")) {
            long jA = mediaMetadataCompat.a("android.media.metadata.DURATION");
            if (jA >= 0) {
                builder.c(Long.valueOf(jA));
            }
        }
        try {
            ratingCompatA2 = RatingCompat.a(bundle.getParcelable("android.media.metadata.USER_RATING"));
        } catch (Exception e3) {
            android.util.Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e3);
            ratingCompatA2 = null;
        }
        Rating ratingQ = q(ratingCompatA2);
        if (ratingQ != null) {
            builder.f5400i = ratingQ;
        } else {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    ratingCompat = new RatingCompat(-1.0f, i2);
                    break;
                default:
                    ratingCompat = null;
                    break;
            }
            builder.f5400i = q(ratingCompat);
        }
        if (bundle.containsKey("android.media.metadata.YEAR")) {
            builder.s = Integer.valueOf((int) mediaMetadataCompat.a("android.media.metadata.YEAR"));
        }
        String[] strArr = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI"};
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 < 2) {
                String str = strArr[i4];
                if (bundle.containsKey(str)) {
                    CharSequence charSequence3 = bundle.getCharSequence(str);
                    if (charSequence3 != null) {
                        string = charSequence3.toString();
                    }
                } else {
                    i4++;
                }
            }
        }
        string = null;
        if (string != null) {
            builder.f5404m = Uri.parse(string);
        }
        String[] strArr2 = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART"};
        while (true) {
            if (i3 < 2) {
                String str2 = strArr2[i3];
                if (bundle.containsKey(str2)) {
                    try {
                        bitmap = (Bitmap) bundle.getParcelable(str2);
                    } catch (Exception e4) {
                        android.util.Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e4);
                    }
                } else {
                    i3++;
                }
            }
        }
        if (bitmap != null) {
            try {
                builder.b(c(bitmap), 3);
            } catch (IOException e5) {
                Log.i("LegacyConversions", "Failed to convert artworkBitmap to artworkData", e5);
            }
        }
        boolean zContainsKey = bundle.containsKey("android.media.metadata.BT_FOLDER_TYPE");
        builder.q = Boolean.valueOf(zContainsKey);
        if (zContainsKey) {
            builder.p = Integer.valueOf(g(mediaMetadataCompat.a("android.media.metadata.BT_FOLDER_TYPE")));
        }
        if (bundle.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            builder.G = Integer.valueOf((int) mediaMetadataCompat.a("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
        }
        builder.r = Boolean.TRUE;
        Bundle bundle2 = new Bundle(bundle);
        UnmodifiableIterator it = f9940a.iterator();
        while (it.hasNext()) {
            bundle2.remove((String) it.next());
        }
        if (!bundle2.isEmpty()) {
            builder.H = bundle2;
        }
        return new MediaMetadata(builder);
    }

    public static MediaMetadataCompat n(MediaMetadata mediaMetadata, String str, Uri uri, long j2, Bitmap bitmap) {
        Long l2;
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
        builder.d("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = mediaMetadata.f5379a;
        if (charSequence != null) {
            builder.e(charSequence, "android.media.metadata.TITLE");
        }
        CharSequence charSequence2 = mediaMetadata.f5383e;
        if (charSequence2 != null) {
            builder.e(charSequence2, "android.media.metadata.DISPLAY_TITLE");
        }
        CharSequence charSequence3 = mediaMetadata.f5384f;
        if (charSequence3 != null) {
            builder.e(charSequence3, "android.media.metadata.DISPLAY_SUBTITLE");
        }
        CharSequence charSequence4 = mediaMetadata.f5385g;
        if (charSequence4 != null) {
            builder.e(charSequence4, "android.media.metadata.DISPLAY_DESCRIPTION");
        }
        CharSequence charSequence5 = mediaMetadata.f5380b;
        if (charSequence5 != null) {
            builder.e(charSequence5, "android.media.metadata.ARTIST");
        }
        CharSequence charSequence6 = mediaMetadata.f5381c;
        if (charSequence6 != null) {
            builder.e(charSequence6, "android.media.metadata.ALBUM");
        }
        CharSequence charSequence7 = mediaMetadata.f5382d;
        if (charSequence7 != null) {
            builder.e(charSequence7, "android.media.metadata.ALBUM_ARTIST");
        }
        if (mediaMetadata.t != null) {
            builder.b("android.media.metadata.YEAR", r4.intValue());
        }
        if (uri != null) {
            builder.d("android.media.metadata.MEDIA_URI", uri.toString());
        }
        Uri uri2 = mediaMetadata.f5391m;
        if (uri2 != null) {
            builder.d("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            builder.d("android.media.metadata.ALBUM_ART_URI", uri2.toString());
        }
        if (bitmap != null) {
            builder.a("android.media.metadata.DISPLAY_ICON", bitmap);
            builder.a("android.media.metadata.ALBUM_ART", bitmap);
        }
        Integer num = mediaMetadata.p;
        if (num != null && num.intValue() != -1) {
            builder.b("android.media.metadata.BT_FOLDER_TYPE", f(num.intValue()));
        }
        if (j2 == -9223372036854775807L && (l2 = mediaMetadata.f5386h) != null) {
            j2 = l2.longValue();
        }
        if (j2 != -9223372036854775807L) {
            builder.b("android.media.metadata.DURATION", j2);
        }
        RatingCompat ratingCompatR = r(mediaMetadata.f5387i);
        if (ratingCompatR != null) {
            builder.c("android.media.metadata.USER_RATING", ratingCompatR);
        }
        RatingCompat ratingCompatR2 = r(mediaMetadata.f5388j);
        if (ratingCompatR2 != null) {
            builder.c("android.media.metadata.RATING", ratingCompatR2);
        }
        if (mediaMetadata.H != null) {
            builder.b("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", r4.intValue());
        }
        Bundle bundle = mediaMetadata.I;
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    builder.e((CharSequence) obj, str2);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    builder.b(str2, ((Number) obj).longValue());
                }
            }
        }
        return new MediaMetadataCompat(builder.f10608a);
    }

    public static PlaybackException o(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null || playbackStateCompat.f10658a != 7) {
            return null;
        }
        CharSequence charSequence = playbackStateCompat.f10664g;
        String string = charSequence != null ? charSequence.toString() : null;
        int iT = t(playbackStateCompat.f10663f);
        if (iT == -5) {
            iT = 2000;
        } else if (iT == -1) {
            iT = 1000;
        }
        int i2 = iT;
        Bundle bundle = playbackStateCompat.f10668k;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        return new PlaybackException(string, null, i2, bundle, SystemClock.elapsedRealtime());
    }

    public static int p(int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                Log.h("LegacyConversions", "Unrecognized RepeatMode: " + i2 + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                return 0;
            }
        }
        return i3;
    }

    public static Rating q(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        float f2 = ratingCompat.f10690b;
        int i2 = ratingCompat.f10689a;
        switch (i2) {
            case 1:
                if (ratingCompat.c()) {
                    return new HeartRating(i2 == 1 && f2 == 1.0f);
                }
                return new HeartRating();
            case 2:
                if (ratingCompat.c()) {
                    return new ThumbRating(i2 == 2 && f2 == 1.0f);
                }
                return new ThumbRating();
            case 3:
                return ratingCompat.c() ? new StarRating(ratingCompat.b(), 3) : new StarRating(3);
            case 4:
                return ratingCompat.c() ? new StarRating(ratingCompat.b(), 4) : new StarRating(4);
            case 5:
                return ratingCompat.c() ? new StarRating(ratingCompat.b(), 5) : new StarRating(5);
            case 6:
                if (!ratingCompat.c()) {
                    return new PercentageRating();
                }
                if (i2 != 6 || !ratingCompat.c()) {
                    f2 = -1.0f;
                }
                return new PercentageRating(f2);
            default:
                return null;
        }
    }

    public static RatingCompat r(Rating rating) {
        if (rating != null) {
            int iX = x(rating);
            if (!rating.b()) {
                switch (iX) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return new RatingCompat(-1.0f, iX);
                    default:
                        return null;
                }
            }
            switch (iX) {
                case 1:
                    return new RatingCompat(((HeartRating) rating).f5245c ? 1.0f : 0.0f, 1);
                case 2:
                    return new RatingCompat(((ThumbRating) rating).f5465c ? 1.0f : 0.0f, 2);
                case 3:
                case 4:
                case 5:
                    return RatingCompat.e(((StarRating) rating).f5455c, iX);
                case 6:
                    return RatingCompat.d(((PercentageRating) rating).f5414b);
            }
        }
        return null;
    }

    public static int s(int i2) {
        if (i2 == -1 || i2 == 0) {
            return 0;
        }
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 3) {
                Log.h("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + i2 + " was converted to `Player.REPEAT_MODE_OFF`");
                return 0;
            }
        }
        return i3;
    }

    public static int t(int i2) {
        switch (i2) {
            case 1:
                return -2;
            case 2:
                return -6;
            case 3:
                return -102;
            case 4:
                return -103;
            case 5:
                return -104;
            case 6:
                return -105;
            case 7:
                return -106;
            case 8:
                return -110;
            case 9:
                return -107;
            case 10:
                return 1;
            case 11:
                return -109;
            default:
                return -1;
        }
    }

    public static boolean u(int i2) {
        if (i2 == -1 || i2 == 0) {
            return false;
        }
        if (i2 == 1 || i2 == 2) {
            return true;
        }
        throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unrecognized ShuffleMode: "));
    }

    public static void v(ListenableFuture listenableFuture) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = 3000;
        while (true) {
            try {
                try {
                    listenableFuture.get(j2, TimeUnit.MILLISECONDS);
                    if (z) {
                        return;
                    } else {
                        return;
                    }
                } catch (InterruptedException unused) {
                    z = true;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (jElapsedRealtime2 >= 3000) {
                        throw new TimeoutException();
                    }
                    j2 = 3000 - jElapsedRealtime2;
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static int w(AudioAttributes audioAttributes) {
        AudioAttributesCompat.Builder builder = new AudioAttributesCompat.Builder();
        builder.a(audioAttributes.f5149a);
        builder.b(audioAttributes.f5150b);
        AudioAttributesCompat.AudioAttributesImpl.Builder builder2 = builder.f10428a;
        builder2.a(audioAttributes.f5151c);
        int iB = builder2.build().b();
        if (iB == Integer.MIN_VALUE) {
            return 3;
        }
        return iB;
    }

    public static int x(Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (!(rating instanceof StarRating)) {
            return rating instanceof PercentageRating ? 6 : 0;
        }
        int i2 = ((StarRating) rating).f5454b;
        int i3 = 3;
        if (i2 != 3) {
            i3 = 4;
            if (i2 != 4) {
                i3 = 5;
                if (i2 != 5) {
                    return 0;
                }
            }
        }
        return i3;
    }

    public static boolean y(long j2, long j3) {
        return (j2 & j3) != 0;
    }
}
