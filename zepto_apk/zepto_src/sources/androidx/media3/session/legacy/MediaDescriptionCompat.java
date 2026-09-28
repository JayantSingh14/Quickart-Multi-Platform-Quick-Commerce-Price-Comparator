package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f10587a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f10588b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f10589c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f10590d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f10591e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f10592f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f10593g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f10594h;

    /* renamed from: i, reason: collision with root package name */
    public MediaDescription f10595i;

    /* renamed from: androidx.media3.session.legacy.MediaDescriptionCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat createFromParcel(Parcel parcel) {
            MediaDescriptionCompat mediaDescriptionCompatA = MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
            mediaDescriptionCompatA.getClass();
            return mediaDescriptionCompatA;
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
        public String f10596a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f10597b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10598c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f10599d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f10600e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f10601f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f10602g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f10603h;
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f10587a = str;
        this.f10588b = charSequence;
        this.f10589c = charSequence2;
        this.f10590d = charSequence3;
        this.f10591e = bitmap;
        this.f10592f = uri;
        this.f10593g = bundle;
        this.f10594h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.legacy.MediaDescriptionCompat a(java.lang.Object r11) {
        /*
            r0 = 0
            if (r11 == 0) goto L89
            androidx.media3.session.legacy.MediaDescriptionCompat$Builder r1 = new androidx.media3.session.legacy.MediaDescriptionCompat$Builder
            r1.<init>()
            android.media.MediaDescription r11 = (android.media.MediaDescription) r11
            java.lang.String r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.g(r11)
            r1.f10596a = r2
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.i(r11)
            r1.f10597b = r2
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.h(r11)
            r1.f10598c = r2
            java.lang.CharSequence r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.c(r11)
            r1.f10599d = r2
            android.graphics.Bitmap r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.e(r11)
            r1.f10600e = r2
            android.net.Uri r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.f(r11)
            r1.f10601f = r2
            android.os.Bundle r2 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.d(r11)
            android.os.Bundle r2 = androidx.media3.session.legacy.MediaSessionCompat.t(r2)
            if (r2 == 0) goto L3e
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>(r2)
            r2 = r3
        L3e:
            if (r2 == 0) goto L62
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            if (r4 == 0) goto L60
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L5a
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L5a
            goto L64
        L5a:
            r2.remove(r3)
            r2.remove(r5)
        L60:
            r0 = r2
            goto L64
        L62:
            r4 = r0
            goto L60
        L64:
            r1.f10602g = r0
            if (r4 == 0) goto L6b
            r1.f10603h = r4
            goto L71
        L6b:
            android.net.Uri r0 = androidx.media3.session.legacy.MediaDescriptionCompat.Api23Impl.a(r11)
            r1.f10603h = r0
        L71:
            androidx.media3.session.legacy.MediaDescriptionCompat r2 = new androidx.media3.session.legacy.MediaDescriptionCompat
            java.lang.String r3 = r1.f10596a
            java.lang.CharSequence r4 = r1.f10597b
            java.lang.CharSequence r5 = r1.f10598c
            java.lang.CharSequence r6 = r1.f10599d
            android.graphics.Bitmap r7 = r1.f10600e
            android.net.Uri r8 = r1.f10601f
            android.os.Bundle r9 = r1.f10602g
            android.net.Uri r10 = r1.f10603h
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r2.f10595i = r11
            return r2
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.legacy.MediaDescriptionCompat.a(java.lang.Object):androidx.media3.session.legacy.MediaDescriptionCompat");
    }

    public final MediaDescription b() {
        MediaDescription mediaDescription = this.f10595i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builderB = Api21Impl.b();
        Api21Impl.n(builderB, this.f10587a);
        Api21Impl.p(builderB, this.f10588b);
        Api21Impl.o(builderB, this.f10589c);
        Api21Impl.j(builderB, this.f10590d);
        Api21Impl.l(builderB, this.f10591e);
        Api21Impl.m(builderB, this.f10592f);
        Api21Impl.k(builderB, this.f10593g);
        Api23Impl.b(builderB, this.f10594h);
        MediaDescription mediaDescriptionA = Api21Impl.a(builderB);
        this.f10595i = mediaDescriptionA;
        return mediaDescriptionA;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f10588b) + ", " + ((Object) this.f10589c) + ", " + ((Object) this.f10590d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        b().writeToParcel(parcel, i2);
    }
}
