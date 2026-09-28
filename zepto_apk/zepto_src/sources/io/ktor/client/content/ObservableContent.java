package io.ktor.client.content;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes3.dex */
public final class ObservableContent extends OutgoingContent.ReadChannelContent {

    /* renamed from: a, reason: collision with root package name */
    public final OutgoingContent f49328a;

    /* renamed from: b, reason: collision with root package name */
    public final Job f49329b;

    /* renamed from: c, reason: collision with root package name */
    public final Function3 f49330c;

    /* renamed from: d, reason: collision with root package name */
    public final ByteReadChannel f49331d;

    public ObservableContent(OutgoingContent delegate, Job callContext, Function3 listener) {
        ByteReadChannel byteReadChannelT0;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f49328a = delegate;
        this.f49329b = callContext;
        this.f49330c = listener;
        if (delegate instanceof OutgoingContent.ByteArrayContent) {
            byteReadChannelT0 = ByteChannelCtorKt.a(((OutgoingContent.ByteArrayContent) delegate).d());
        } else {
            if (delegate instanceof OutgoingContent.ProtocolUpgrade) {
                throw new UnsupportedContentTypeException(delegate);
            }
            if (delegate instanceof OutgoingContent.NoContent) {
                ByteReadChannel.f51074a.getClass();
                byteReadChannelT0 = ByteReadChannel.Companion.a();
            } else if (delegate instanceof OutgoingContent.ReadChannelContent) {
                byteReadChannelT0 = ((OutgoingContent.ReadChannelContent) delegate).d();
            } else {
                if (!(delegate instanceof OutgoingContent.WriteChannelContent)) {
                    throw new NoWhenBranchMatchedException();
                }
                byteReadChannelT0 = CoroutinesKt.a(GlobalScope.f54113a, callContext, true, new ObservableContent$content$1(this, null)).t0();
            }
        }
        this.f49331d = byteReadChannelT0;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return this.f49328a.a();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return this.f49328a.b();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Headers c() {
        return this.f49328a.c();
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public final ByteReadChannel d() {
        return ByteChannelUtilsKt.a(this.f49331d, this.f49329b, this.f49328a.a(), this.f49330c);
    }
}
