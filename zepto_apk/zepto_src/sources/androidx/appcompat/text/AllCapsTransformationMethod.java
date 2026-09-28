package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo
/* loaded from: classes3.dex */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    public final Locale f465a;

    public AllCapsTransformationMethod(Context context) {
        this.f465a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f465a);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
    }
}
