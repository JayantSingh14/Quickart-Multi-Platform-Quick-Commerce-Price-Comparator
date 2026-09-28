package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f10689a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10690b;

    /* renamed from: c, reason: collision with root package name */
    public Parcelable f10691c;

    /* renamed from: androidx.media3.session.legacy.RatingCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public final RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readFloat(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public RatingCompat(float f2, int i2) {
        this.f10689a = i2;
        this.f10690b = f2;
    }

    public static RatingCompat a(Parcelable parcelable) {
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2 = null;
        if (parcelable != null) {
            Rating rating = (Rating) parcelable;
            int ratingStyle = rating.getRatingStyle();
            if (!rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        ratingCompat2 = new RatingCompat(-1.0f, ratingStyle);
                        break;
                }
            } else {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = new RatingCompat(rating.hasHeart() ? 1.0f : 0.0f, 1);
                        break;
                    case 2:
                        ratingCompat = new RatingCompat(rating.isThumbUp() ? 1.0f : 0.0f, 2);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat2 = e(rating.getStarRating(), ratingStyle);
                        break;
                    case 6:
                        ratingCompat2 = d(rating.getPercentRating());
                        break;
                }
                ratingCompat2 = ratingCompat;
            }
            ratingCompat2.getClass();
            ratingCompat2.f10691c = parcelable;
        }
        return ratingCompat2;
    }

    public static RatingCompat d(float f2) {
        if (f2 >= 0.0f && f2 <= 100.0f) {
            return new RatingCompat(f2, 6);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat e(float f2, int i2) {
        float f3;
        if (i2 == 3) {
            f3 = 3.0f;
        } else if (i2 == 4) {
            f3 = 4.0f;
        } else {
            if (i2 != 5) {
                Log.e("Rating", "Invalid rating style (" + i2 + ") for a star rating");
                return null;
            }
            f3 = 5.0f;
        }
        if (f2 >= 0.0f && f2 <= f3) {
            return new RatingCompat(f2, i2);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public final float b() {
        int i2 = this.f10689a;
        if ((i2 == 3 || i2 == 4 || i2 == 5) && c()) {
            return this.f10690b;
        }
        return -1.0f;
    }

    public final boolean c() {
        return this.f10690b >= 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f10689a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f10689a);
        sb.append(" rating=");
        float f2 = this.f10690b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10689a);
        parcel.writeFloat(this.f10690b);
    }
}
