package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.RendererCapabilitiesList;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultRendererCapabilitiesList implements RendererCapabilitiesList {

    public static final class Factory implements RendererCapabilitiesList.Factory {

        /* renamed from: androidx.media3.exoplayer.DefaultRendererCapabilitiesList$Factory$1, reason: invalid class name */
        class AnonymousClass1 implements VideoRendererEventListener {
        }

        /* renamed from: androidx.media3.exoplayer.DefaultRendererCapabilitiesList$Factory$2, reason: invalid class name */
        class AnonymousClass2 implements AudioRendererEventListener {
        }
    }
}
