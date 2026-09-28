package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BackEventCompat {

    /* renamed from: a, reason: collision with root package name */
    public final float f118a;

    /* renamed from: b, reason: collision with root package name */
    public final float f119b;

    /* renamed from: c, reason: collision with root package name */
    public final float f120c;

    /* renamed from: d, reason: collision with root package name */
    public final int f121d;

    @Metadata
    public static final class Companion {
    }

    @Target({ElementType.TYPE_USE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    @RestrictTo
    public @interface SwipeEdge {
    }

    public BackEventCompat(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Api34Impl api34Impl = Api34Impl.f117a;
        float fD = api34Impl.d(backEvent);
        float fE = api34Impl.e(backEvent);
        float fB = api34Impl.b(backEvent);
        int iC = api34Impl.c(backEvent);
        this.f118a = fD;
        this.f119b = fE;
        this.f120c = fB;
        this.f121d = iC;
    }

    public final float a() {
        return this.f120c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackEventCompat{touchX=");
        sb.append(this.f118a);
        sb.append(", touchY=");
        sb.append(this.f119b);
        sb.append(", progress=");
        sb.append(this.f120c);
        sb.append(", swipeEdge=");
        return android.support.v4.media.b.n(sb, this.f121d, '}');
    }
}
