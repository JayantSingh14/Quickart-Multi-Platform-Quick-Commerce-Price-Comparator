package androidx.fragment.app;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class FragmentHostCallback<H> extends FragmentContainer {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentActivity f4554a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentActivity f4555b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f4556c;

    /* renamed from: d, reason: collision with root package name */
    public final FragmentManager f4557d;

    public FragmentHostCallback(FragmentActivity context) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Handler handler = new Handler();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f4554a = context;
        this.f4555b = context;
        this.f4556c = handler;
        this.f4557d = new FragmentManagerImpl();
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View b(int i2) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean c() {
        return true;
    }

    public void d(PrintWriter writer, String[] strArr) {
        Intrinsics.checkNotNullParameter("  ", "prefix");
        Intrinsics.checkNotNullParameter(writer, "writer");
    }

    public abstract FragmentActivity e();

    public LayoutInflater f() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f4555b);
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(context)");
        return layoutInflaterFrom;
    }

    public boolean g(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return false;
    }

    public void h() {
    }
}
