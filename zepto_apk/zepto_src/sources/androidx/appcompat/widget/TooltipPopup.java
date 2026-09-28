package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo
/* loaded from: classes3.dex */
class TooltipPopup {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1253a;

    /* renamed from: b, reason: collision with root package name */
    public final View f1254b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f1255c;

    /* renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f1256d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f1257e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f1258f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f1259g;

    public TooltipPopup(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1256d = layoutParams;
        this.f1257e = new Rect();
        this.f1258f = new int[2];
        this.f1259g = new int[2];
        this.f1253a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1254b = viewInflate;
        this.f1255c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
