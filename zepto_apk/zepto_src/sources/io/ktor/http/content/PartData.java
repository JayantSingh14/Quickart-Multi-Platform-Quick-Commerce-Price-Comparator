package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public abstract class PartData {

    @Metadata
    public static final class BinaryChannelItem extends PartData {

        @Metadata
        /* renamed from: io.ktor.http.content.PartData$BinaryChannelItem$1, reason: invalid class name */
        final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Object invoke() {
                return Unit.f53572a;
            }
        }
    }

    @Metadata
    public static final class BinaryItem extends PartData {
    }

    @Metadata
    public static final class FileItem extends PartData {
    }

    @Metadata
    public static final class FormItem extends PartData {
    }
}
