package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.UnstableApi;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayMap f10604c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f10605d;

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f10606a;

    /* renamed from: b, reason: collision with root package name */
    public MediaMetadata f10607b;

    /* renamed from: androidx.media3.session.legacy.MediaMetadataCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MediaMetadataCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaMetadataCompat[] newArray(int i2) {
            return new MediaMetadataCompat[i2];
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f10608a = new Bundle();

        public final void a(String str, Bitmap bitmap) {
            Integer num = (Integer) MediaMetadataCompat.f10604c.get(str);
            if (num != null && num.intValue() != 2) {
                throw new IllegalArgumentException(b.D("The ", str, " key cannot be used to put a Bitmap"));
            }
            this.f10608a.putParcelable(str, bitmap);
        }

        public final void b(String str, long j2) {
            Integer num = (Integer) MediaMetadataCompat.f10604c.get(str);
            if (num != null && num.intValue() != 0) {
                throw new IllegalArgumentException(b.D("The ", str, " key cannot be used to put a long"));
            }
            this.f10608a.putLong(str, j2);
        }

        public final void c(String str, RatingCompat ratingCompat) {
            Parcelable parcelable;
            Integer num = (Integer) MediaMetadataCompat.f10604c.get(str);
            if (num != null && num.intValue() != 3) {
                throw new IllegalArgumentException(b.D("The ", str, " key cannot be used to put a Rating"));
            }
            if (ratingCompat.f10691c == null) {
                boolean zC = ratingCompat.c();
                int i2 = ratingCompat.f10689a;
                if (zC) {
                    float f2 = ratingCompat.f10690b;
                    switch (i2) {
                        case 1:
                            ratingCompat.f10691c = Rating.newHeartRating(i2 == 1 && f2 == 1.0f);
                            break;
                        case 2:
                            ratingCompat.f10691c = Rating.newThumbRating(i2 == 2 && f2 == 1.0f);
                            break;
                        case 3:
                        case 4:
                        case 5:
                            ratingCompat.f10691c = Rating.newStarRating(i2, ratingCompat.b());
                            break;
                        case 6:
                            if (i2 != 6 || !ratingCompat.c()) {
                                f2 = -1.0f;
                            }
                            ratingCompat.f10691c = Rating.newPercentageRating(f2);
                            break;
                        default:
                            parcelable = null;
                            break;
                    }
                } else {
                    ratingCompat.f10691c = Rating.newUnratedRating(i2);
                }
                parcelable = ratingCompat.f10691c;
            } else {
                parcelable = ratingCompat.f10691c;
            }
            this.f10608a.putParcelable(str, parcelable);
        }

        public final void d(String str, String str2) {
            Integer num = (Integer) MediaMetadataCompat.f10604c.get(str);
            if (num != null && num.intValue() != 1) {
                throw new IllegalArgumentException(b.D("The ", str, " key cannot be used to put a String"));
            }
            this.f10608a.putCharSequence(str, str2);
        }

        public final void e(CharSequence charSequence, String str) {
            Integer num = (Integer) MediaMetadataCompat.f10604c.get(str);
            if (num != null && num.intValue() != 1) {
                throw new IllegalArgumentException(b.D("The ", str, " key cannot be used to put a CharSequence"));
            }
            this.f10608a.putCharSequence(str, charSequence);
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f10604c = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        arrayMap.put("android.media.metadata.ARTIST", 1);
        arrayMap.put("android.media.metadata.DURATION", 0);
        arrayMap.put("android.media.metadata.ALBUM", 1);
        arrayMap.put("android.media.metadata.AUTHOR", 1);
        arrayMap.put("android.media.metadata.WRITER", 1);
        arrayMap.put("android.media.metadata.COMPOSER", 1);
        arrayMap.put("android.media.metadata.COMPILATION", 1);
        arrayMap.put("android.media.metadata.DATE", 1);
        arrayMap.put("android.media.metadata.YEAR", 0);
        arrayMap.put("android.media.metadata.GENRE", 1);
        arrayMap.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap.put("android.media.metadata.ART", 2);
        arrayMap.put("android.media.metadata.ART_URI", 1);
        arrayMap.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap.put("android.media.metadata.USER_RATING", 3);
        arrayMap.put("android.media.metadata.RATING", 3);
        arrayMap.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        arrayMap.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        f10605d = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        CREATOR = new AnonymousClass1();
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f10606a = bundle2;
        MediaSessionCompat.a(bundle2);
    }

    public final long a(String str) {
        return this.f10606a.getLong(str, 0L);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f10606a);
    }

    public MediaMetadataCompat(Parcel parcel) {
        Bundle bundle = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        bundle.getClass();
        this.f10606a = bundle;
    }
}
