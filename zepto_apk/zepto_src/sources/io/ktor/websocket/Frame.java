package io.ktor.websocket;

import android.support.v4.media.b;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputPrimitivesKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: classes3.dex */
public abstract class Frame {

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f51439h = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final boolean f51440a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameType f51441b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f51442c;

    /* renamed from: d, reason: collision with root package name */
    public final DisposableHandle f51443d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f51444e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f51445f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f51446g;

    @Metadata
    public static final class Binary extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.f51453f, data, NonDisposableHandle.f51460a, z2, z3, z4);
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Close extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(byte[] data) {
            super(true, FrameType.f51454g, data, NonDisposableHandle.f51460a, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public Close() {
            this(Frame.f51439h);
        }

        public Close(CloseReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
            try {
                OutputPrimitivesKt.a(bytePacketBuilder, reason.f51380a);
                String str = reason.f51381b;
                StringsKt.e(bytePacketBuilder, str, 0, str.length(), Charsets.UTF_8);
                ByteReadPacket packet = bytePacketBuilder.V();
                Intrinsics.checkNotNullParameter(packet, "packet");
                this(StringsKt.c(packet));
            } catch (Throwable th) {
                bytePacketBuilder.close();
                throw th;
            }
        }
    }

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[FrameType.values().length];
                try {
                    iArr[1] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    int i2 = FrameType.f51450c;
                    iArr[0] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    int i3 = FrameType.f51450c;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    int i4 = FrameType.f51450c;
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    int i5 = FrameType.f51450c;
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static Frame a(boolean z, FrameType frameType, byte[] data, boolean z2, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(frameType, "frameType");
            Intrinsics.checkNotNullParameter(data, "data");
            int iOrdinal = frameType.ordinal();
            if (iOrdinal == 0) {
                return new Text(z, data, z2, z3, z4);
            }
            if (iOrdinal == 1) {
                return new Binary(z, data, z2, z3, z4);
            }
            if (iOrdinal == 2) {
                return new Close(data);
            }
            if (iOrdinal == 3) {
                return new Ping(data);
            }
            if (iOrdinal == 4) {
                return new Pong(data, NonDisposableHandle.f51460a);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata
    public static final class Ping extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ping(byte[] data) {
            super(true, FrameType.f51455h, data, NonDisposableHandle.f51460a, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    @Metadata
    public static final class Pong extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pong(byte[] data, DisposableHandle disposableHandle) {
            super(true, FrameType.f51456i, data, disposableHandle, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(disposableHandle, "disposableHandle");
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Text extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.f51452e, data, NonDisposableHandle.f51460a, z2, z3, z4);
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    public Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4) {
        this.f51440a = z;
        this.f51441b = frameType;
        this.f51442c = bArr;
        this.f51443d = disposableHandle;
        this.f51444e = z2;
        this.f51445f = z3;
        this.f51446g = z4;
        Intrinsics.checkNotNullExpressionValue(ByteBuffer.wrap(bArr), "wrap(data)");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame ");
        sb.append(this.f51441b);
        sb.append(" (fin=");
        sb.append(this.f51440a);
        sb.append(", buffer len = ");
        return b.n(sb, this.f51442c.length, ')');
    }
}
