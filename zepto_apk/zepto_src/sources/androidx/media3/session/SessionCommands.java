package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class SessionCommands {

    /* renamed from: b, reason: collision with root package name */
    public static final SessionCommands f10236b = new Builder().b();

    /* renamed from: c, reason: collision with root package name */
    public static final String f10237c;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableSet f10238a;

    static {
        int i2 = Util.f5744a;
        f10237c = Integer.toString(0, 36);
    }

    public SessionCommands(HashSet hashSet) {
        this.f10238a = ImmutableSet.o(hashSet);
    }

    public static SessionCommands a(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f10237c);
        if (parcelableArrayList == null) {
            Log.h("SessionCommands", "Missing commands. Creating an empty SessionCommands");
            return f10236b;
        }
        Builder builder = new Builder();
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            builder.f10239a.add(SessionCommand.a((Bundle) parcelableArrayList.get(i2)));
        }
        return builder.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionCommands) {
            return this.f10238a.equals(((SessionCommands) obj).f10238a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f10238a);
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f10239a;

        public Builder() {
            this.f10239a = new HashSet();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(ImmutableList immutableList) {
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                this.f10239a.add(new SessionCommand(((Integer) immutableList.get(i2)).intValue()));
            }
        }

        public final SessionCommands b() {
            return new SessionCommands(this.f10239a);
        }

        public Builder(SessionCommands sessionCommands) {
            sessionCommands.getClass();
            this.f10239a = new HashSet(sessionCommands.f10238a);
        }
    }
}
