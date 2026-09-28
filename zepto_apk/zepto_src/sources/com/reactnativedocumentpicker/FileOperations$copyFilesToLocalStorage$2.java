package com.reactnativedocumentpicker;

import android.support.v4.media.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2", f = "FileOperations.kt", l = {Type.RKEY}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
final class FileOperations$copyFilesToLocalStorage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WritableArray>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f46344a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f46345b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileOperations f46346c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f46347d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CopyDestination f46348e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f46349f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileOperations$copyFilesToLocalStorage$2(FileOperations fileOperations, ReactApplicationContext reactApplicationContext, CopyDestination copyDestination, ReadableArray readableArray, Continuation continuation) {
        super(2, continuation);
        this.f46346c = fileOperations;
        this.f46347d = reactApplicationContext;
        this.f46348e = copyDestination;
        this.f46349f = readableArray;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FileOperations$copyFilesToLocalStorage$2 fileOperations$copyFilesToLocalStorage$2 = new FileOperations$copyFilesToLocalStorage$2(this.f46346c, this.f46347d, this.f46348e, this.f46349f, continuation);
        fileOperations$copyFilesToLocalStorage$2.f46345b = obj;
        return fileOperations$copyFilesToLocalStorage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileOperations$copyFilesToLocalStorage$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        WritableArray writableArray;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f46344a;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f46345b;
            this.f46346c.getClass();
            CopyDestination copyDestination = CopyDestination.f46327d;
            CopyDestination copyDestination2 = this.f46348e;
            ReactApplicationContext reactApplicationContext = this.f46347d;
            File file = new File(copyDestination2 == copyDestination ? reactApplicationContext.getFilesDir() : reactApplicationContext.getCacheDir(), UUID.randomUUID().toString());
            if (!file.mkdir()) {
                throw new IOException(b.C("Failed to create directory at ", file.getAbsolutePath()));
            }
            IntRange intRangeF = RangesKt.f(0, this.f46349f.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.r(intRangeF, 10));
            Iterator<Integer> it = intRangeF.iterator();
            while (((IntProgressionIterator) it).f53843c) {
                arrayList.add(BuildersKt.a(coroutineScope, null, new FileOperations$copyFilesToLocalStorage$2$copyJobs$1$1(this.f46349f, ((IntIterator) it).a(), this.f46346c, this.f46347d, file, null), 3));
            }
            WritableArray writableArrayCreateArray = Arguments.createArray();
            this.f46345b = writableArrayCreateArray;
            this.f46344a = 1;
            Object objA = AwaitKt.a(arrayList, this);
            if (objA == coroutineSingletons) {
                return coroutineSingletons;
            }
            writableArray = writableArrayCreateArray;
            obj = objA;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            writableArray = (WritableArray) this.f46345b;
            ResultKt.b(obj);
        }
        Iterator it2 = ((Iterable) obj).iterator();
        while (it2.hasNext()) {
            writableArray.pushMap((WritableMap) it2.next());
        }
        return writableArray;
    }
}
