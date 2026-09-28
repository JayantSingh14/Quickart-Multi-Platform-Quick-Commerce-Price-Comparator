package androidx.media3.ui;

import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.concurrent.TimeUnit;

@UnstableApi
/* loaded from: classes3.dex */
public final class WearUnsuitableOutputPlaybackSuppressionResolverListener implements Player.Listener {
    static {
        TimeUnit.MINUTES.toMillis(5L);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void x1(Player player, Player.Events events) {
        if (Util.f5744a >= 20) {
            throw null;
        }
    }
}
