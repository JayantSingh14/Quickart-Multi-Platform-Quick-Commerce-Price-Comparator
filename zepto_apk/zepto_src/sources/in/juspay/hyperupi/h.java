package in.juspay.hyperupi;

import android.media.MediaPlayer;

/* loaded from: classes4.dex */
public final /* synthetic */ class h implements MediaPlayer.OnCompletionListener {
    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
        UPIBridge.playSound$lambda$14(mediaPlayer);
    }
}
