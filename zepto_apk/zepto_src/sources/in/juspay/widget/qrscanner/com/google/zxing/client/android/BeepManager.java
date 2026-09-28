package in.juspay.widget.qrscanner.com.google.zxing.client.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.google.zxing.client.android.R;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class BeepManager {

    /* renamed from: d, reason: collision with root package name */
    private static final String f48841d = "BeepManager";

    /* renamed from: a, reason: collision with root package name */
    private final Context f48842a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f48843b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f48844c = false;

    public BeepManager(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f48842a = activity.getApplicationContext();
    }

    public boolean isBeepEnabled() {
        return this.f48843b;
    }

    public boolean isVibrateEnabled() {
        return this.f48844c;
    }

    public MediaPlayer playBeepSound() throws IllegalStateException, Resources.NotFoundException, IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) throws IllegalStateException {
                mediaPlayer2.stop();
                mediaPlayer2.release();
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) throws IllegalStateException {
                Log.w(BeepManager.f48841d, "Failed to beep " + i2 + ", " + i3);
                mediaPlayer2.stop();
                mediaPlayer2.release();
                return true;
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f48842a.getResources().openRawResourceFd(R.raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e2) {
            Log.w(f48841d, e2);
            mediaPlayer.release();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void playBeepSoundAndVibrate() {
        Vibrator vibrator;
        try {
            if (this.f48843b) {
                playBeepSound();
            }
            if (this.f48844c && (vibrator = (Vibrator) this.f48842a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public MediaPlayer playSound(String str) throws IllegalStateException, IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) throws IllegalStateException {
                mediaPlayer2.stop();
                mediaPlayer2.release();
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: in.juspay.widget.qrscanner.com.google.zxing.client.android.BeepManager.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) throws IllegalStateException {
                Log.w(BeepManager.f48841d, "Failed to beep " + i2 + ", " + i3);
                mediaPlayer2.stop();
                mediaPlayer2.release();
                return true;
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.f48842a.getResources().getAssets().openFd(str);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenFd.close();
                throw th;
            }
        } catch (IOException e2) {
            Log.w(f48841d, e2);
            mediaPlayer.release();
            return null;
        }
    }

    public void setBeepEnabled(boolean z) {
        this.f48843b = z;
    }

    public void setVibrateEnabled(boolean z) {
        this.f48844c = z;
    }
}
