package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ConcatenatingMediaSource;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7824a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompositeMediaSource f7825b;

    public /* synthetic */ b(CompositeMediaSource compositeMediaSource, int i2) {
        this.f7824a = i2;
        this.f7825b = compositeMediaSource;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f7824a) {
            case 0:
                MediaItem mediaItem = ConcatenatingMediaSource.n;
                ConcatenatingMediaSource concatenatingMediaSource = (ConcatenatingMediaSource) this.f7825b;
                concatenatingMediaSource.getClass();
                switch (message.what) {
                    case 1:
                        Object obj = message.obj;
                        int i2 = Util.f5744a;
                        ((ConcatenatingMediaSource.MessageData) obj).getClass();
                        throw null;
                    case 2:
                        Object obj2 = message.obj;
                        int i3 = Util.f5744a;
                        ((ConcatenatingMediaSource.MessageData) obj2).getClass();
                        throw null;
                    case 3:
                        Object obj3 = message.obj;
                        int i4 = Util.f5744a;
                        ShuffleOrder shuffleOrder = concatenatingMediaSource.f7537m;
                        ((ConcatenatingMediaSource.MessageData) obj3).getClass();
                        concatenatingMediaSource.f7537m = shuffleOrder.a(0, 1);
                        throw null;
                    case 4:
                        Object obj4 = message.obj;
                        int i5 = Util.f5744a;
                        ((ConcatenatingMediaSource.MessageData) obj4).getClass();
                        concatenatingMediaSource.f7537m = null;
                        if (!concatenatingMediaSource.f7536l) {
                            concatenatingMediaSource.f7535k.obtainMessage(5).sendToTarget();
                            concatenatingMediaSource.f7536l = true;
                        }
                        return true;
                    case 5:
                        concatenatingMediaSource.f7536l = false;
                        new HashSet();
                        new ConcatenatingMediaSource.ConcatenatedTimeline(concatenatingMediaSource.f7537m);
                        throw null;
                    case 6:
                        Object obj5 = message.obj;
                        int i6 = Util.f5744a;
                        Set set = (Set) obj5;
                        synchronized (concatenatingMediaSource) {
                            try {
                                Iterator it = set.iterator();
                                if (!it.hasNext()) {
                                    throw null;
                                }
                                ((ConcatenatingMediaSource.HandlerAndRunnable) it.next()).getClass();
                                throw null;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    default:
                        throw new IllegalStateException();
                }
            default:
                ConcatenatingMediaSource2 concatenatingMediaSource2 = (ConcatenatingMediaSource2) this.f7825b;
                concatenatingMediaSource2.getClass();
                if (message.what != 1) {
                    return true;
                }
                concatenatingMediaSource2.f7539l = false;
                ConcatenatingMediaSource2.s0();
                throw null;
        }
    }
}
