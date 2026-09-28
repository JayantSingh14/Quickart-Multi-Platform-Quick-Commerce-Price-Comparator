package okio.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

@Metadata
@DebugMetadata(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", l = {75}, m = "invokeSuspend")
/* renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* loaded from: classes3.dex */
final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f57020b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f57021c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FileSystem f57022d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Path f57023e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, Continuation continuation) {
        super(2, continuation);
        this.f57022d = fileSystem;
        this.f57023e = path;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.f57022d, this.f57023e, continuation);
        fileSystem$commonDeleteRecursively$sequence$1.f57021c = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f57020b;
        if (i2 == 0) {
            ResultKt.b(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f57021c;
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f57020b = 1;
            if (FileSystem.a(sequenceScope, this.f57022d, arrayDeque, this.f57023e, false, true, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
