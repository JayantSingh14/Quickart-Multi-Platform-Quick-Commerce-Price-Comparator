package androidx.media3.session;

import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.session.MediaControllerImplBase;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class d0 implements MediaControllerImplBase.RemoteSessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10343a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10344b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f10345c;

    public /* synthetic */ d0(MediaControllerImplBase mediaControllerImplBase, List list, int i2) {
        this.f10343a = i2;
        this.f10344b = mediaControllerImplBase;
        this.f10345c = list;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void d(IMediaSession iMediaSession, int i2) {
        List list = this.f10345c;
        int i3 = 0;
        MediaControllerImplBase mediaControllerImplBase = this.f10344b;
        int i4 = this.f10343a;
        mediaControllerImplBase.getClass();
        switch (i4) {
            case 0:
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                while (i3 < list.size()) {
                    builder.h(((MediaItem) list.get(i3)).c(true));
                    i3++;
                }
                iMediaSession.j4(mediaControllerImplBase.f9972c, i2, new BundleListRetriever(builder.j()), true);
                break;
            default:
                UnmodifiableListIterator unmodifiableListIterator2 = ImmutableList.f42665b;
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                while (i3 < list.size()) {
                    builder2.h(((MediaItem) list.get(i3)).c(true));
                    i3++;
                }
                iMediaSession.N6(mediaControllerImplBase.f9972c, i2, new BundleListRetriever(builder2.j()));
                break;
        }
    }
}
