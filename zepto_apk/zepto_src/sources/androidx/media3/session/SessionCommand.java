package androidx.media3.session;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class SessionCommand {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableList f10228d = ImmutableList.t(40010);

    /* renamed from: e, reason: collision with root package name */
    public static final ImmutableList f10229e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f10230f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f10231g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f10232h;

    /* renamed from: a, reason: collision with root package name */
    public final int f10233a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10234b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f10235c;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CommandCode {
    }

    static {
        Object[] objArr = {50000, 50001, 50002, 50003, 50004, 50005, 50006};
        ObjectArrays.a(7, objArr);
        f10229e = ImmutableList.m(7, objArr);
        int i2 = Util.f5744a;
        f10230f = Integer.toString(0, 36);
        f10231g = Integer.toString(1, 36);
        f10232h = Integer.toString(2, 36);
    }

    public SessionCommand(int i2) {
        Assertions.b(i2 != 0, "commandCode shouldn't be COMMAND_CODE_CUSTOM");
        this.f10233a = i2;
        this.f10234b = "";
        this.f10235c = Bundle.EMPTY;
    }

    public static SessionCommand a(Bundle bundle) {
        int i2 = bundle.getInt(f10230f, 0);
        if (i2 != 0) {
            return new SessionCommand(i2);
        }
        String string = bundle.getString(f10231g);
        string.getClass();
        Bundle bundle2 = bundle.getBundle(f10232h);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionCommand(string, bundle2);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f10230f, this.f10233a);
        bundle.putString(f10231g, this.f10234b);
        bundle.putBundle(f10232h, this.f10235c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionCommand)) {
            return false;
        }
        SessionCommand sessionCommand = (SessionCommand) obj;
        return this.f10233a == sessionCommand.f10233a && TextUtils.equals(this.f10234b, sessionCommand.f10234b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10234b, Integer.valueOf(this.f10233a)});
    }

    public SessionCommand(String str, Bundle bundle) {
        this.f10233a = 0;
        str.getClass();
        this.f10234b = str;
        bundle.getClass();
        this.f10235c = new Bundle(bundle);
    }
}
