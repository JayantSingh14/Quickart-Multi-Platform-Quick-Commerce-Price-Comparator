package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class ScrollFeedbackProviderCompat {

    /* renamed from: a, reason: collision with root package name */
    public final ScrollFeedbackProviderImpl f3065a;

    @RequiresApi
    public static class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {

        /* renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f3066a;

        public ScrollFeedbackProviderApi35Impl(NestedScrollView nestedScrollView) {
            this.f3066a = ScrollFeedbackProvider.createProvider(nestedScrollView);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void a(int i2, int i3, int i4, boolean z) {
            this.f3066a.onScrollLimit(i2, i3, i4, z);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void b(int i2, int i3, int i4, int i5) {
            this.f3066a.onScrollProgress(i2, i3, i4, i5);
        }
    }

    public static class ScrollFeedbackProviderBaseImpl implements ScrollFeedbackProviderImpl {
        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void a(int i2, int i3, int i4, boolean z) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void b(int i2, int i3, int i4, int i5) {
        }
    }

    public interface ScrollFeedbackProviderImpl {
        void a(int i2, int i3, int i4, boolean z);

        void b(int i2, int i3, int i4, int i5);
    }

    public ScrollFeedbackProviderCompat(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f3065a = new ScrollFeedbackProviderApi35Impl(nestedScrollView);
        } else {
            this.f3065a = new ScrollFeedbackProviderBaseImpl();
        }
    }

    public final void a(int i2, int i3, int i4, boolean z) {
        this.f3065a.a(i2, i3, i4, z);
    }

    public final void b(int i2, int i3, int i4, int i5) {
        this.f3065a.b(i2, i3, i4, i5);
    }
}
