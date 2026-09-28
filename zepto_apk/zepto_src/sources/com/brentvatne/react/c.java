package com.brentvatne.react;

import android.content.Context;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.chuckerteam.chucker.internal.support.SharableKt;
import com.chuckerteam.chucker.internal.support.TransactionDetailsSharable;
import com.swmansion.rnscreens.CustomSearchView;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.SearchBarView;
import in.juspay.hypersdk.services.HyperPaymentsServices;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15639a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15640b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f15639a = i2;
        this.f15640b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object objA;
        boolean z = true;
        Object obj2 = this.f15640b;
        switch (this.f15639a) {
            case 0:
                return VideoManagerModule.setPlayerPauseStateCmd$lambda$1((Boolean) obj2, (ReactExoplayerView) obj);
            case 1:
                TransactionDetailsSharable it = (TransactionDetailsSharable) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return SharableKt.c(it, (Context) obj2);
            case 2:
                MatchResult m2 = (MatchResult) obj;
                Intrinsics.checkNotNullParameter(m2, "m");
                return m2.a().get(1) + "tr=" + ((String) obj2);
            case 3:
                InputStream inputStream = (InputStream) obj;
                if (inputStream == null) {
                    throw new FileNotFoundException("No input stream was found for the source file");
                }
                FileChannel channel = new FileOutputStream((File) obj2).getChannel();
                try {
                    if (channel.transferFrom(Channels.newChannel(inputStream), 0L, Long.MAX_VALUE) == 0) {
                        throw new IOException("No data was copied to the destination file");
                    }
                    Unit unit = Unit.f53572a;
                    CloseableKt.a(channel, null);
                    return Unit.f53572a;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.a(channel, th);
                        throw th2;
                    }
                }
            case 4:
                return Float.valueOf(((ScreenStackFragment) obj2).k().getHeight());
            case 5:
                return SearchBarView.j((SearchBarView) obj2, (CustomSearchView) obj);
            case 6:
                return ((HyperPaymentsServices) obj2).lambda$process$6((JSONObject) obj);
            case 7:
                return obj == ((AbstractCollection) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 8:
                Map.Entry it2 = (Map.Entry) obj;
                AbstractMap.Companion companion = AbstractMap.f53591c;
                Intrinsics.checkNotNullParameter(it2, "it");
                AbstractMap abstractMap = (AbstractMap) obj2;
                StringBuilder sb = new StringBuilder();
                Object key = it2.getKey();
                sb.append(key == abstractMap ? "(this Map)" : String.valueOf(key));
                sb.append('=');
                Object value = it2.getValue();
                sb.append(value != abstractMap ? String.valueOf(value) : "(this Map)");
                return sb.toString();
            case 9:
                String it3 = (String) obj;
                Intrinsics.checkNotNullParameter(it3, "it");
                ((ArrayList) obj2).add(it3);
                return Unit.f53572a;
            case 10:
                KTypeProjection it4 = (KTypeProjection) obj;
                TypeReference.Companion companion2 = TypeReference.f53808d;
                Intrinsics.checkNotNullParameter(it4, "it");
                ((TypeReference) obj2).getClass();
                it4.getClass();
                return "*";
            case 11:
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) obj2;
                if (!booleanRef.f53798a && Intrinsics.b(obj, null)) {
                    booleanRef.f53798a = true;
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                Function1 function1 = (Function1) obj2;
                Throwable th3 = (Throwable) obj;
                int i2 = ExceptionsConstructorKt.f55075a;
                try {
                    Result.Companion companion3 = Result.f53538b;
                    Throwable th4 = (Throwable) function1.invoke(th3);
                    boolean zB = Intrinsics.b(th3.getMessage(), th4.getMessage());
                    objA = th4;
                    if (!zB) {
                        boolean zB2 = Intrinsics.b(th4.getMessage(), th3.toString());
                        objA = th4;
                        if (!zB2) {
                            objA = null;
                        }
                    }
                } catch (Throwable th5) {
                    Result.Companion companion4 = Result.f53538b;
                    objA = ResultKt.a(th5);
                }
                return (Throwable) (objA instanceof Result.Failure ? null : objA);
        }
    }
}
