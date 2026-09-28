package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.media3.common.Player;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class ConnectionState {

    /* renamed from: l, reason: collision with root package name */
    public static final String f9906l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f9907m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;

    /* renamed from: a, reason: collision with root package name */
    public final int f9908a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9909b;

    /* renamed from: c, reason: collision with root package name */
    public final IMediaSession f9910c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f9911d;

    /* renamed from: e, reason: collision with root package name */
    public final SessionCommands f9912e;

    /* renamed from: f, reason: collision with root package name */
    public final Player.Commands f9913f;

    /* renamed from: g, reason: collision with root package name */
    public final Player.Commands f9914g;

    /* renamed from: h, reason: collision with root package name */
    public final Bundle f9915h;

    /* renamed from: i, reason: collision with root package name */
    public final Bundle f9916i;

    /* renamed from: j, reason: collision with root package name */
    public final PlayerInfo f9917j;

    /* renamed from: k, reason: collision with root package name */
    public final ImmutableList f9918k;

    public final class InProcessBinder extends Binder {
        public InProcessBinder() {
        }
    }

    static {
        int i2 = Util.f5744a;
        f9906l = Integer.toString(0, 36);
        f9907m = Integer.toString(1, 36);
        n = Integer.toString(2, 36);
        o = Integer.toString(9, 36);
        p = Integer.toString(3, 36);
        q = Integer.toString(4, 36);
        r = Integer.toString(5, 36);
        s = Integer.toString(6, 36);
        t = Integer.toString(11, 36);
        u = Integer.toString(7, 36);
        v = Integer.toString(8, 36);
        w = Integer.toString(10, 36);
    }

    public ConnectionState(int i2, int i3, IMediaSession iMediaSession, PendingIntent pendingIntent, ImmutableList immutableList, SessionCommands sessionCommands, Player.Commands commands, Player.Commands commands2, Bundle bundle, Bundle bundle2, PlayerInfo playerInfo) {
        this.f9908a = i2;
        this.f9909b = i3;
        this.f9910c = iMediaSession;
        this.f9911d = pendingIntent;
        this.f9918k = immutableList;
        this.f9912e = sessionCommands;
        this.f9913f = commands;
        this.f9914g = commands2;
        this.f9915h = bundle;
        this.f9916i = bundle2;
        this.f9917j = playerInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.media3.session.IMediaSession] */
    public static ConnectionState a(Bundle bundle) {
        ImmutableList immutableListR;
        IMediaSession.Stub.Proxy proxy;
        IBinder binder = bundle.getBinder(w);
        if (binder instanceof InProcessBinder) {
            return ConnectionState.this;
        }
        int i2 = bundle.getInt(f9906l, 0);
        int i3 = bundle.getInt(v, 0);
        IBinder binder2 = bundle.getBinder(f9907m);
        binder2.getClass();
        IBinder iBinder = binder2;
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(n);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(o);
        if (parcelableArrayList != null) {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i4);
                bundle2.getClass();
                builder.h(CommandButton.b(i3, bundle2));
            }
            immutableListR = builder.j();
        } else {
            immutableListR = ImmutableList.r();
        }
        ImmutableList immutableList = immutableListR;
        Bundle bundle3 = bundle.getBundle(p);
        SessionCommands sessionCommandsA = bundle3 == null ? SessionCommands.f10236b : SessionCommands.a(bundle3);
        Bundle bundle4 = bundle.getBundle(r);
        Player.Commands commandsB = bundle4 == null ? Player.Commands.f5430b : Player.Commands.b(bundle4);
        Bundle bundle5 = bundle.getBundle(q);
        Player.Commands commandsB2 = bundle5 == null ? Player.Commands.f5430b : Player.Commands.b(bundle5);
        Bundle bundle6 = bundle.getBundle(s);
        Bundle bundle7 = bundle.getBundle(t);
        Bundle bundle8 = bundle.getBundle(u);
        PlayerInfo playerInfoH = bundle8 == null ? PlayerInfo.F : PlayerInfo.h(i3, bundle8);
        Bundle bundle9 = bundle7;
        int i5 = IMediaSession.Stub.f9937a;
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaSession");
        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaSession)) {
            IMediaSession.Stub.Proxy proxy2 = new IMediaSession.Stub.Proxy();
            proxy2.f9938a = iBinder;
            proxy = proxy2;
        } else {
            proxy = (IMediaSession) iInterfaceQueryLocalInterface;
        }
        if (bundle6 == null) {
            bundle6 = Bundle.EMPTY;
        }
        Bundle bundle10 = bundle6;
        if (bundle9 == null) {
            bundle9 = Bundle.EMPTY;
        }
        return new ConnectionState(i2, i3, proxy, pendingIntent, immutableList, sessionCommandsA, commandsB2, commandsB, bundle10, bundle9, playerInfoH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle b(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(f9906l, this.f9908a);
        bundle.putBinder(f9907m, this.f9910c.asBinder());
        bundle.putParcelable(n, this.f9911d);
        ImmutableList immutableList = this.f9918k;
        if (!immutableList.isEmpty()) {
            bundle.putParcelableArrayList(o, BundleCollectionUtil.b(immutableList, new o0(28)));
        }
        SessionCommands sessionCommands = this.f9912e;
        sessionCommands.getClass();
        Bundle bundle2 = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        UnmodifiableIterator it = sessionCommands.f10238a.iterator();
        while (it.hasNext()) {
            arrayList.add(((SessionCommand) it.next()).b());
        }
        bundle2.putParcelableArrayList(SessionCommands.f10237c, arrayList);
        bundle.putBundle(p, bundle2);
        Player.Commands commands = this.f9913f;
        bundle.putBundle(q, commands.c());
        Player.Commands commands2 = this.f9914g;
        bundle.putBundle(r, commands2.c());
        bundle.putBundle(s, this.f9915h);
        bundle.putBundle(t, this.f9916i);
        bundle.putBundle(u, this.f9917j.g(MediaUtils.d(commands, commands2), false, false).j(i2));
        bundle.putInt(v, this.f9909b);
        return bundle;
    }
}
