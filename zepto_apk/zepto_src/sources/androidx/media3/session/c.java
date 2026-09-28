package androidx.media3.session;

import android.graphics.Bitmap;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.legacy.MediaSessionCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10321b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10322c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10323d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10324e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10325f;

    public /* synthetic */ c(ConnectedControllersManager connectedControllersManager, ConnectedControllersManager.AsyncCommand asyncCommand, AtomicBoolean atomicBoolean, ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        this.f10320a = 0;
        this.f10321b = connectedControllersManager;
        this.f10322c = asyncCommand;
        this.f10323d = atomicBoolean;
        this.f10325f = connectedControllerRecord;
        this.f10324e = atomicBoolean2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i2 = 0;
        Object obj = this.f10325f;
        Object obj2 = this.f10324e;
        Object obj3 = this.f10323d;
        Object obj4 = this.f10322c;
        Object obj5 = this.f10321b;
        switch (this.f10320a) {
            case 0:
                ConnectedControllersManager connectedControllersManager = (ConnectedControllersManager) obj5;
                connectedControllersManager.getClass();
                ((ConnectedControllersManager.AsyncCommand) obj4).run().q(new d(connectedControllersManager, (AtomicBoolean) obj3, (ConnectedControllersManager.ConnectedControllerRecord) obj, (AtomicBoolean) obj2), MoreExecutors.a());
                break;
            case 1:
                ((AtomicReference) obj4).set(((MediaLibraryServiceLegacyStub) obj5).n.z((MediaSession.ControllerInfo) obj3, (MediaLibraryService.LibraryParams) obj2));
                ((ConditionVariable) obj).e();
                break;
            case 2:
                int i3 = MediaLibraryServiceLegacyStub.o;
                ((MediaLibraryServiceLegacyStub) obj5).getClass();
                ImmutableList immutableList = (ImmutableList) obj3;
                if (((AtomicInteger) obj4).incrementAndGet() == immutableList.size()) {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        ArrayList arrayList2 = (ArrayList) obj2;
                        if (i2 >= arrayList2.size()) {
                            ((SettableFuture) obj).n(arrayList);
                            break;
                        } else {
                            ListenableFuture listenableFuture = (ListenableFuture) arrayList2.get(i2);
                            if (listenableFuture != null) {
                                try {
                                    bitmap = (Bitmap) Futures.b(listenableFuture);
                                } catch (CancellationException | ExecutionException e2) {
                                    Log.c("MLSLegacyStub", "Failed to get bitmap", e2);
                                }
                            } else {
                                bitmap = null;
                            }
                            arrayList.add(LegacyConversions.a((MediaItem) immutableList.get(i2), bitmap));
                            i2++;
                        }
                    }
                }
                break;
            default:
                MediaSessionLegacyStub.ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast = (MediaSessionLegacyStub.ControllerLegacyCbForBroadcast) obj5;
                controllerLegacyCbForBroadcast.getClass();
                ArrayList arrayList3 = (ArrayList) obj3;
                if (((AtomicInteger) obj4).incrementAndGet() == arrayList3.size()) {
                    ArrayList arrayList4 = new ArrayList();
                    while (true) {
                        ArrayList arrayList5 = (ArrayList) obj2;
                        if (i2 >= arrayList5.size()) {
                            int i4 = Util.f5744a;
                            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
                            if (i4 >= 21) {
                                mediaSessionLegacyStub.f10119k.o(arrayList4);
                                break;
                            } else {
                                ArrayList arrayListG = MediaUtils.g(arrayList4);
                                Timeline timeline = (Timeline) obj;
                                if (arrayListG.size() != timeline.o()) {
                                    Log.g("MediaSessionLegacyStub", "Sending " + arrayListG.size() + " items out of " + timeline.o());
                                }
                                mediaSessionLegacyStub.f10119k.o(arrayListG);
                                break;
                            }
                        } else {
                            ListenableFuture listenableFuture2 = (ListenableFuture) arrayList5.get(i2);
                            if (listenableFuture2 != null) {
                                try {
                                    bitmap2 = (Bitmap) Futures.b(listenableFuture2);
                                } catch (CancellationException | ExecutionException e3) {
                                    Log.c("MediaSessionLegacyStub", "Failed to get bitmap", e3);
                                }
                            } else {
                                bitmap2 = null;
                            }
                            arrayList4.add(new MediaSessionCompat.QueueItem(null, LegacyConversions.i((MediaItem) arrayList3.get(i2), bitmap2), i2 == -1 ? -1L : i2));
                            i2++;
                        }
                    }
                }
                break;
        }
    }

    public /* synthetic */ c(Object obj, Serializable serializable, Object obj2, Object obj3, Object obj4, int i2) {
        this.f10320a = i2;
        this.f10321b = obj;
        this.f10322c = serializable;
        this.f10323d = obj2;
        this.f10324e = obj3;
        this.f10325f = obj4;
    }
}
