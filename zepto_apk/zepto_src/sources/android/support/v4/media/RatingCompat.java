package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f69a;

    /* renamed from: b, reason: collision with root package name */
    public final float f70b;

    /* renamed from: android.support.v4.media.RatingCompat$1, reason: invalid class name */
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

    @RequiresApi
    public static class Api19Impl {
        @DoNotInline
        public static float a(Rating rating) {
            return rating.getPercentRating();
        }

        @DoNotInline
        public static int b(Rating rating) {
            return rating.getRatingStyle();
        }

        @DoNotInline
        public static float c(Rating rating) {
            return rating.getStarRating();
        }

        @DoNotInline
        public static boolean d(Rating rating) {
            return rating.hasHeart();
        }

        @DoNotInline
        public static boolean e(Rating rating) {
            return rating.isRated();
        }

        @DoNotInline
        public static boolean f(Rating rating) {
            return rating.isThumbUp();
        }

        @DoNotInline
        public static Rating g(boolean z) {
            return Rating.newHeartRating(z);
        }

        @DoNotInline
        public static Rating h(float f2) {
            return Rating.newPercentageRating(f2);
        }

        @DoNotInline
        public static Rating i(int i2, float f2) {
            return Rating.newStarRating(i2, f2);
        }

        @DoNotInline
        public static Rating j(boolean z) {
            return Rating.newThumbRating(z);
        }

        @DoNotInline
        public static Rating k(int i2) {
            return Rating.newUnratedRating(i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Style {
    }

    public RatingCompat(float f2, int i2) {
        this.f69a = i2;
        this.f70b = f2;
    }

    public static void a(Rating rating) {
        float f2;
        if (rating != null) {
            int iB = Api19Impl.b(rating);
            RatingCompat ratingCompat = null;
            if (!Api19Impl.e(rating)) {
                switch (iB) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        ratingCompat = new RatingCompat(-1.0f, iB);
                        break;
                }
            } else {
                switch (iB) {
                    case 1:
                        ratingCompat = new RatingCompat(Api19Impl.d(rating) ? 1.0f : 0.0f, 1);
                        break;
                    case 2:
                        ratingCompat = new RatingCompat(Api19Impl.f(rating) ? 1.0f : 0.0f, 2);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        float fC = Api19Impl.c(rating);
                        if (iB == 3) {
                            f2 = 3.0f;
                        } else if (iB == 4) {
                            f2 = 4.0f;
                        } else if (iB != 5) {
                            Log.e("Rating", "Invalid rating style (" + iB + ") for a star rating");
                            break;
                        } else {
                            f2 = 5.0f;
                        }
                        if (fC >= 0.0f && fC <= f2) {
                            ratingCompat = new RatingCompat(fC, iB);
                            break;
                        } else {
                            Log.e("Rating", "Trying to set out of range star-based rating");
                            break;
                        }
                        break;
                    case 6:
                        float fA = Api19Impl.a(rating);
                        if (fA >= 0.0f && fA <= 100.0f) {
                            ratingCompat = new RatingCompat(fA, 6);
                            break;
                        } else {
                            Log.e("Rating", "Invalid percentage-based rating value");
                            break;
                        }
                        break;
                    default:
                        return;
                }
            }
            ratingCompat.getClass();
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f69a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f69a);
        sb.append(" rating=");
        float f2 = this.f70b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f69a);
        parcel.writeFloat(this.f70b);
    }
}
