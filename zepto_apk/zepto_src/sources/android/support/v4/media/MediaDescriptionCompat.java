package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f51a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f52b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f53c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f54d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f55e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f56f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f57g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f58h;

    /* renamed from: i, reason: collision with root package name */
    public MediaDescription f59i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        @Nullable
        @DoNotInline
        public static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        @Nullable
        @DoNotInline
        public static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        @Nullable
        @DoNotInline
        public static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        @Nullable
        @DoNotInline
        public static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @Nullable
        @DoNotInline
        public static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @Nullable
        @DoNotInline
        public static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        @Nullable
        @DoNotInline
        public static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        @DoNotInline
        public static void j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        @DoNotInline
        public static void k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        public static void l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        @DoNotInline
        public static void m(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @DoNotInline
        public static void n(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        @DoNotInline
        public static void o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        @DoNotInline
        public static void p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @Nullable
        @DoNotInline
        public static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        @DoNotInline
        public static void b(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f60a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f61b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f62c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f63d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f64e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f65f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f66g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f67h;
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f51a = str;
        this.f52b = charSequence;
        this.f53c = charSequence2;
        this.f54d = charSequence3;
        this.f55e = bitmap;
        this.f56f = uri;
        this.f57g = bundle;
        this.f58h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        Builder builder = new Builder();
        MediaDescription mediaDescription = (MediaDescription) obj;
        builder.f60a = Api21Impl.g(mediaDescription);
        builder.f61b = Api21Impl.i(mediaDescription);
        builder.f62c = Api21Impl.h(mediaDescription);
        builder.f63d = Api21Impl.c(mediaDescription);
        builder.f64e = Api21Impl.e(mediaDescription);
        builder.f65f = Api21Impl.f(mediaDescription);
        Bundle bundleD = Api21Impl.d(mediaDescription);
        if (bundleD != null) {
            bundleD = MediaSessionCompat.b(bundleD);
        }
        Uri uri = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (uri == null) {
            bundle = bundleD;
        } else if (!bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleD.size() != 2) {
            bundleD.remove("android.support.v4.media.description.MEDIA_URI");
            bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleD;
        }
        builder.f66g = bundle;
        if (uri != null) {
            builder.f67h = uri;
        } else {
            builder.f67h = Api23Impl.a(mediaDescription);
        }
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(builder.f60a, builder.f61b, builder.f62c, builder.f63d, builder.f64e, builder.f65f, builder.f66g, builder.f67h);
        mediaDescriptionCompat.f59i = mediaDescription;
        return mediaDescriptionCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f52b) + ", " + ((Object) this.f53c) + ", " + ((Object) this.f54d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        MediaDescription mediaDescriptionA = this.f59i;
        if (mediaDescriptionA == null) {
            MediaDescription.Builder builderB = Api21Impl.b();
            Api21Impl.n(builderB, this.f51a);
            Api21Impl.p(builderB, this.f52b);
            Api21Impl.o(builderB, this.f53c);
            Api21Impl.j(builderB, this.f54d);
            Api21Impl.l(builderB, this.f55e);
            Api21Impl.m(builderB, this.f56f);
            Api21Impl.k(builderB, this.f57g);
            Api23Impl.b(builderB, this.f58h);
            mediaDescriptionA = Api21Impl.a(builderB);
            this.f59i = mediaDescriptionA;
        }
        mediaDescriptionA.writeToParcel(parcel, i2);
    }
}
