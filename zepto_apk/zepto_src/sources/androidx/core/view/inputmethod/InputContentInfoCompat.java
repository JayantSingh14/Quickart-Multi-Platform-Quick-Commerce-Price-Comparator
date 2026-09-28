package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public final class InputContentInfoCompat {

    /* renamed from: a, reason: collision with root package name */
    public final InputContentInfoCompatImpl f3220a;

    public static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f3222a;

        /* renamed from: b, reason: collision with root package name */
        public final ClipDescription f3223b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f3224c;

        public InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f3222a = uri;
            this.f3223b = clipDescription;
            this.f3224c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Object a() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri b() {
            return this.f3222a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final void c() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri d() {
            return this.f3224c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final ClipDescription getDescription() {
            return this.f3223b;
        }
    }

    public interface InputContentInfoCompatImpl {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f3220a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.f3220a = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    @RequiresApi
    public static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        /* renamed from: a, reason: collision with root package name */
        public final InputContentInfo f3221a;

        public InputContentInfoCompatApi25Impl(Object obj) {
            this.f3221a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Object a() {
            return this.f3221a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri b() {
            return this.f3221a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final void c() {
            this.f3221a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri d() {
            return this.f3221a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final ClipDescription getDescription() {
            return this.f3221a.getDescription();
        }

        public InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f3221a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public InputContentInfoCompat(InputContentInfoCompatApi25Impl inputContentInfoCompatApi25Impl) {
        this.f3220a = inputContentInfoCompatApi25Impl;
    }
}
