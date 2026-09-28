package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.chuckerteam.chucker.internal.support.b;
import com.chuckerteam.chucker.internal.support.c;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes4.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    /* renamed from: e, reason: collision with root package name */
    public static final int f40399e = R.attr.alertDialogStyle;

    /* renamed from: f, reason: collision with root package name */
    public static final int f40400f = R.style.MaterialAlertDialog_MaterialComponents;

    /* renamed from: g, reason: collision with root package name */
    public static final int f40401g = R.attr.materialAlertDialogTheme;

    /* renamed from: c, reason: collision with root package name */
    public final MaterialShapeDrawable f40402c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f40403d;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialAlertDialogBuilder(MainActivity mainActivity) {
        int i2 = f40401g;
        TypedValue typedValueA = MaterialAttributes.a(i2, mainActivity);
        int i3 = typedValueA == null ? 0 : typedValueA.data;
        int i4 = f40399e;
        int i5 = f40400f;
        Context contextA = MaterialThemeOverlay.a(mainActivity, null, i4, i5);
        contextA = i3 != 0 ? new ContextThemeWrapper(contextA, i3) : contextA;
        TypedValue typedValueA2 = MaterialAttributes.a(i2, mainActivity);
        super(contextA, typedValueA2 == null ? 0 : typedValueA2.data);
        Context context = getContext();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R.styleable.MaterialAlertDialog;
        ThemeEnforcement.a(context, null, i4, i5);
        ThemeEnforcement.b(context, null, iArr, i4, i5, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i4, i5);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f40403d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        int iD = MaterialColors.d(context, R.attr.colorSurface, getClass().getCanonicalName());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, R.styleable.MaterialAlertDialog, i4, i5);
        int color = typedArrayObtainStyledAttributes2.getColor(R.styleable.MaterialAlertDialog_backgroundTint, iD);
        typedArrayObtainStyledAttributes2.recycle();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i4, i5);
        materialShapeDrawable.k(context);
        materialShapeDrawable.m(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                ShapeAppearanceModel.Builder builderG = materialShapeDrawable.f40974a.f40989a.g();
                builderG.c(dimension);
                materialShapeDrawable.setShapeAppearanceModel(builderG.a());
            }
        }
        this.f40402c = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder a(Drawable drawable) {
        this.f282a.f260c = drawable;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final void b(CharSequence charSequence) {
        this.f282a.f263f = charSequence;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.c(charSequence, onClickListener);
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        Window window = alertDialogCreate.getWindow();
        View decorView = window.getDecorView();
        MaterialShapeDrawable materialShapeDrawable = this.f40402c;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.l(ViewCompat.j(decorView));
        }
        Rect rect = this.f40403d;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f40402c, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(alertDialogCreate, rect));
        return alertDialogCreate;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder d(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.d(charSequence, onClickListener);
        return this;
    }

    public final void e(CharSequence charSequence, c cVar) {
        super.c(charSequence, cVar);
    }

    public final void f(CharSequence charSequence, b bVar) {
        super.d(charSequence, bVar);
    }

    public final MaterialAlertDialogBuilder g(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButton(int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButton(int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }
}
