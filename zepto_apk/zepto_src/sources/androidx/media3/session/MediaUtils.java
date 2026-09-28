package androidx.media3.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.FlagSet;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class MediaUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final MediaBrowserServiceCompat.BrowserRoot f10167a = new MediaBrowserServiceCompat.BrowserRoot("androidx.media3.session.MediaLibraryService", null);

    public static boolean a(SessionPositionInfo sessionPositionInfo, SessionPositionInfo sessionPositionInfo2) {
        Player.PositionInfo positionInfo = sessionPositionInfo.f10249a;
        int i2 = positionInfo.f5441b;
        Player.PositionInfo positionInfo2 = sessionPositionInfo2.f10249a;
        return i2 == positionInfo2.f5441b && positionInfo.f5444e == positionInfo2.f5444e && positionInfo.f5447h == positionInfo2.f5447h && positionInfo.f5448i == positionInfo2.f5448i;
    }

    public static int b(long j2, long j3) {
        if (j2 == -9223372036854775807L || j3 == -9223372036854775807L) {
            return 0;
        }
        if (j3 == 0) {
            return 100;
        }
        return Util.k((int) ((j2 * 100) / j3), 0, 100);
    }

    public static long c(PlayerInfo playerInfo, long j2, long j3, long j4) {
        boolean zEquals = playerInfo.f10170c.equals(SessionPositionInfo.f10247l);
        SessionPositionInfo sessionPositionInfo = playerInfo.f10170c;
        boolean z = zEquals || j3 < sessionPositionInfo.f10251c;
        if (playerInfo.v) {
            if (z || j2 == -9223372036854775807L) {
                if (j4 == -9223372036854775807L) {
                    j4 = SystemClock.elapsedRealtime() - sessionPositionInfo.f10251c;
                }
                long j5 = sessionPositionInfo.f10249a.f5445f + ((long) (j4 * playerInfo.f10174g.f5427a));
                long j6 = sessionPositionInfo.f10252d;
                return j6 != -9223372036854775807L ? Math.min(j5, j6) : j5;
            }
        } else if (z || j2 == -9223372036854775807L) {
            return sessionPositionInfo.f10249a.f5445f;
        }
        return j2;
    }

    public static Player.Commands d(Player.Commands commands, Player.Commands commands2) {
        if (commands == null || commands2 == null) {
            return Player.Commands.f5430b;
        }
        Player.Commands.Builder builder = new Player.Commands.Builder();
        int i2 = 0;
        while (true) {
            FlagSet flagSet = commands.f5432a;
            if (i2 >= flagSet.f5210a.size()) {
                return builder.d();
            }
            if (commands2.a(flagSet.b(i2))) {
                builder.a(flagSet.b(i2));
            }
            i2++;
        }
    }

    public static Pair e(PlayerInfo playerInfo, PlayerInfo.BundlingExclusions bundlingExclusions, PlayerInfo playerInfo2, PlayerInfo.BundlingExclusions bundlingExclusions2, Player.Commands commands) {
        boolean z = bundlingExclusions2.f10197a;
        boolean z2 = bundlingExclusions2.f10198b;
        if (z && commands.a(17) && !bundlingExclusions.f10197a) {
            Timeline timeline = playerInfo.f10177j;
            PlayerInfo.Builder builderE = android.support.v4.media.a.e(playerInfo2, playerInfo2);
            builderE.f10190j = timeline;
            playerInfo2 = builderE.a();
            bundlingExclusions2 = new PlayerInfo.BundlingExclusions(false, z2);
        }
        if (z2 && commands.a(30) && !bundlingExclusions.f10198b) {
            Tracks tracks = playerInfo.D;
            PlayerInfo.Builder builderE2 = android.support.v4.media.a.e(playerInfo2, playerInfo2);
            builderE2.D = tracks;
            playerInfo2 = builderE2.a();
            bundlingExclusions2 = new PlayerInfo.BundlingExclusions(bundlingExclusions2.f10197a, false);
        }
        return new Pair(playerInfo2, bundlingExclusions2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(Player player, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        int i2 = mediaItemsWithStartPosition.f10089b;
        ImmutableList immutableList = mediaItemsWithStartPosition.f10088a;
        if (i2 == -1) {
            if (player.D1(20)) {
                player.y1(immutableList);
                return;
            } else {
                if (immutableList.isEmpty()) {
                    return;
                }
                player.v0((MediaItem) immutableList.get(0));
                return;
            }
        }
        boolean zD1 = player.D1(20);
        long j2 = mediaItemsWithStartPosition.f10090c;
        if (zD1) {
            player.c1(immutableList, mediaItemsWithStartPosition.f10089b, j2);
        } else {
            if (immutableList.isEmpty()) {
                return;
            }
            player.k1((MediaItem) immutableList.get(0), j2);
        }
    }

    public static ArrayList g(List list) {
        ArrayList arrayList = new ArrayList();
        Parcel parcelObtain = Parcel.obtain();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                Parcelable parcelable = (Parcelable) list.get(i2);
                parcelObtain.writeParcelable(parcelable, 0);
                if (parcelObtain.dataSize() >= 262144) {
                    break;
                }
                arrayList.add(parcelable);
            } finally {
                parcelObtain.recycle();
            }
        }
        return arrayList;
    }
}
