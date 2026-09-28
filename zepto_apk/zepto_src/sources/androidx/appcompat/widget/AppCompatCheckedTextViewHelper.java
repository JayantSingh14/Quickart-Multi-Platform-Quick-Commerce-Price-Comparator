package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
class AppCompatCheckedTextViewHelper {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatCheckedTextView f822a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f823b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f824c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f825d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f826e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f827f;

    public AppCompatCheckedTextViewHelper(AppCompatCheckedTextView appCompatCheckedTextView) {
        this.f822a = appCompatCheckedTextView;
    }

    public final void a() {
        AppCompatCheckedTextView appCompatCheckedTextView = this.f822a;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f825d || this.f826e) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f825d) {
                    drawableMutate.setTintList(this.f823b);
                }
                if (this.f826e) {
                    drawableMutate.setTintMode(this.f824c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }
}
