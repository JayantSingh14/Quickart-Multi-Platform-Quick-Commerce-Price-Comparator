package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
class ShapeableDelegateV33 extends ShapeableDelegate {
    public ShapeableDelegateV33(FrameLayout frameLayout) {
        e(frameLayout);
    }

    @DoNotInline
    private void e(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV33.1
            @Override // android.view.ViewOutlineProvider
            public final void getOutline(View view2, Outline outline) {
                Path path = ShapeableDelegateV33.this.f41083e;
                if (path.isEmpty()) {
                    return;
                }
                outline.setPath(path);
            }
        });
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final void b(FrameLayout frameLayout) {
        frameLayout.setClipToOutline(!this.f41079a);
        if (this.f41079a) {
            frameLayout.invalidate();
        } else {
            frameLayout.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean c() {
        return this.f41079a;
    }
}
