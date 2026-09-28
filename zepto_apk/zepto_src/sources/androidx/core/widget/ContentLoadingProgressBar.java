package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes3.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3271c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f3272a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3273b;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.core.widget.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.core.widget.a] */
    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        final int i2 = 0;
        this.f3272a = new Runnable(this) { // from class: androidx.core.widget.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f3302b;

            {
                this.f3302b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f3302b;
                switch (i2) {
                    case 0:
                        int i3 = ContentLoadingProgressBar.f3271c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i4 = ContentLoadingProgressBar.f3271c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
        final int i3 = 1;
        this.f3273b = new Runnable(this) { // from class: androidx.core.widget.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContentLoadingProgressBar f3302b;

            {
                this.f3302b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = this.f3302b;
                switch (i3) {
                    case 0:
                        int i32 = ContentLoadingProgressBar.f3271c;
                        contentLoadingProgressBar.setVisibility(8);
                        break;
                    default:
                        int i4 = ContentLoadingProgressBar.f3271c;
                        contentLoadingProgressBar.getClass();
                        System.currentTimeMillis();
                        contentLoadingProgressBar.setVisibility(0);
                        break;
                }
            }
        };
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f3272a);
        removeCallbacks(this.f3273b);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3272a);
        removeCallbacks(this.f3273b);
    }
}
