package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class ContentInfoCompat {

    /* renamed from: a, reason: collision with root package name */
    public final Compat f3018a;

    @RequiresApi
    public static final class Api31Impl {
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final BuilderCompat f3019a;

        public Builder(ClipData clipData, int i2) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f3019a = new BuilderCompat31Impl(clipData, i2);
                return;
            }
            BuilderCompatImpl builderCompatImpl = new BuilderCompatImpl();
            builderCompatImpl.f3021a = clipData;
            builderCompatImpl.f3022b = i2;
            this.f3019a = builderCompatImpl;
        }

        public final ContentInfoCompat a() {
            return this.f3019a.build();
        }

        public final void b(Bundle bundle) {
            this.f3019a.setExtras(bundle);
        }

        public final void c(int i2) {
            this.f3019a.b(i2);
        }

        public final void d(Uri uri) {
            this.f3019a.a(uri);
        }
    }

    public interface BuilderCompat {
        void a(Uri uri);

        void b(int i2);

        ContentInfoCompat build();

        void setExtras(Bundle bundle);
    }

    @RequiresApi
    public static final class BuilderCompat31Impl implements BuilderCompat {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f3020a;

        public BuilderCompat31Impl(ClipData clipData, int i2) {
            this.f3020a = androidx.core.os.a.j(clipData, i2);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void a(Uri uri) {
            this.f3020a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void b(int i2) {
            this.f3020a.setFlags(i2);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f3020a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setExtras(Bundle bundle) {
            this.f3020a.setExtras(bundle);
        }
    }

    public static final class BuilderCompatImpl implements BuilderCompat {

        /* renamed from: a, reason: collision with root package name */
        public ClipData f3021a;

        /* renamed from: b, reason: collision with root package name */
        public int f3022b;

        /* renamed from: c, reason: collision with root package name */
        public int f3023c;

        /* renamed from: d, reason: collision with root package name */
        public Uri f3024d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f3025e;

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void a(Uri uri) {
            this.f3024d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void b(int i2) {
            this.f3023c = i2;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setExtras(Bundle bundle) {
            this.f3025e = bundle;
        }
    }

    public interface Compat {
        int F();

        ContentInfo a();

        int b();

        ClipData c();
    }

    @RequiresApi
    public static final class Compat31Impl implements Compat {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo f3026a;

        public Compat31Impl(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.f3026a = androidx.core.os.a.l(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int F() {
            return this.f3026a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo a() {
            return this.f3026a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int b() {
            return this.f3026a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData c() {
            return this.f3026a.getClip();
        }

        public final String toString() {
            return "ContentInfoCompat{" + this.f3026a + "}";
        }
    }

    public static final class CompatImpl implements Compat {

        /* renamed from: a, reason: collision with root package name */
        public final ClipData f3027a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3028b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3029c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f3030d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f3031e;

        public CompatImpl(BuilderCompatImpl builderCompatImpl) {
            ClipData clipData = builderCompatImpl.f3021a;
            clipData.getClass();
            this.f3027a = clipData;
            int i2 = builderCompatImpl.f3022b;
            if (i2 < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
            }
            if (i2 > 5) {
                Locale locale2 = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
            }
            this.f3028b = i2;
            int i3 = builderCompatImpl.f3023c;
            if ((i3 & 1) == i3) {
                this.f3029c = i3;
                this.f3030d = builderCompatImpl.f3024d;
                this.f3031e = builderCompatImpl.f3025e;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i3) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int F() {
            return this.f3029c;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo a() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int b() {
            return this.f3028b;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData c() {
            return this.f3027a;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
            sb.append(this.f3027a.getDescription());
            sb.append(", source=");
            int i2 = this.f3028b;
            sb.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
            sb.append(", flags=");
            int i3 = this.f3029c;
            sb.append((i3 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i3));
            Uri uri = this.f3030d;
            if (uri == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb.append(str);
            return android.support.v4.media.b.r(sb, this.f3031e != null ? ", hasExtras" : "", "}");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Source {
    }

    public ContentInfoCompat(Compat compat) {
        this.f3018a = compat;
    }

    public final ClipData a() {
        return this.f3018a.c();
    }

    public final int b() {
        return this.f3018a.F();
    }

    public final int c() {
        return this.f3018a.b();
    }

    public final String toString() {
        return this.f3018a.toString();
    }
}
