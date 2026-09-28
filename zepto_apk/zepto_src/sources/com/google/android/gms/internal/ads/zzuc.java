package com.google.android.gms.internal.ads;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import androidx.annotation.RequiresApi;
import java.util.HashSet;
import java.util.Iterator;

@RequiresApi
/* loaded from: classes4.dex */
public final class zzuc {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f35637a;

    /* renamed from: b, reason: collision with root package name */
    public LoudnessCodecController f35638b;

    public zzuc() {
        throw null;
    }

    public final void a(int i2) {
        LoudnessCodecController loudnessCodecController = this.f35638b;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f35638b = null;
        }
        LoudnessCodecController loudnessCodecControllerCreate = LoudnessCodecController.create(i2, zzgyb.f33369a, new zztz());
        this.f35638b = loudnessCodecControllerCreate;
        Iterator it = this.f35637a.iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    public final void b(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!this.f35637a.remove(mediaCodec) || (loudnessCodecController = this.f35638b) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public zzuc(int i2) {
        this.f35637a = new HashSet();
    }
}
