package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@RequiresApi
/* loaded from: classes4.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {

    /* renamed from: e, reason: collision with root package name */
    public static WeakReference f41629e;

    /* renamed from: c, reason: collision with root package name */
    public Rect f41632c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f41630a = true;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f41631b = true;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableViewShapeProvider f41633d = new ShapeableViewShapeProvider();

    public interface ShapeProvider {
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
    }

    @Override // android.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        f41629e = new WeakReference(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference weakReference;
        KeyEvent.Callback callback;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = f41629e) != null && this.f41633d != null && (callback = (View) weakReference.get()) != null) {
            ShapeAppearanceModel shapeAppearanceModel = callback instanceof Shapeable ? ((Shapeable) callback).getShapeAppearanceModel() : null;
            if (shapeAppearanceModel != null) {
                viewOnCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, shapeAppearanceModel);
            }
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public final void onMapSharedElements(List list, Map map) {
        View view;
        final Activity activityA;
        if (list.isEmpty() || map.isEmpty() || (view = (View) map.get(list.get(0))) == null || (activityA = ContextUtils.a(view.getContext())) == null) {
            return;
        }
        final Window window = activityA.getWindow();
        boolean z = this.f41630a;
        boolean z2 = this.f41631b;
        if (z) {
            Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
            if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
                MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
                window.setSharedElementReenterTransition(null);
                if (z2) {
                    if (materialContainerTransform.getDuration() >= 0) {
                        window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
                    }
                    materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            Window window2 = window;
                            WeakReference weakReference = MaterialContainerTransformSharedElementCallback.f41629e;
                            Drawable background = window2.getDecorView().getBackground();
                            if (background == null) {
                                return;
                            }
                            background.mutate().clearColorFilter();
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                            Window window2 = window;
                            WeakReference weakReference = MaterialContainerTransformSharedElementCallback.f41629e;
                            Drawable background = window2.getDecorView().getBackground();
                            if (background == null) {
                                return;
                            }
                            background.mutate().setColorFilter(BlendModeColorFilterCompat.a(BlendModeCompat.CLEAR));
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform2 = (MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform2.f41593a = true;
            materialContainerTransform2.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
                @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                public final void onTransitionEnd(Transition transition) {
                    View view2;
                    WeakReference weakReference = MaterialContainerTransformSharedElementCallback.f41629e;
                    if (weakReference != null && (view2 = (View) weakReference.get()) != null) {
                        view2.setAlpha(1.0f);
                        MaterialContainerTransformSharedElementCallback.f41629e = null;
                    }
                    Activity activity = activityA;
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (z2) {
                if (materialContainerTransform2.getDuration() >= 0) {
                    window.setTransitionBackgroundFadeDuration(materialContainerTransform2.getDuration());
                }
                materialContainerTransform2.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.3
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public final void onTransitionStart(Transition transition) {
                        Window window2 = window;
                        WeakReference weakReference = MaterialContainerTransformSharedElementCallback.f41629e;
                        Drawable background = window2.getDecorView().getBackground();
                        if (background == null) {
                            return;
                        }
                        background.mutate().setColorFilter(BlendModeColorFilterCompat.a(BlendModeCompat.CLEAR));
                    }
                });
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        if (!list2.isEmpty() && (((View) list2.get(0)).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)) {
            ((View) list2.get(0)).setTag(R.id.mtrl_motion_snapshot_view, null);
        }
        if (!this.f41630a && !list2.isEmpty()) {
            View view = (View) list2.get(0);
            RectF rectF = TransitionUtils.f41653a;
            this.f41632c = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        this.f41630a = false;
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            ((View) list2.get(0)).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.f41630a || list2.isEmpty() || this.f41632c == null) {
            return;
        }
        View view = (View) list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f41632c.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f41632c.height(), 1073741824));
        Rect rect = this.f41632c;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
