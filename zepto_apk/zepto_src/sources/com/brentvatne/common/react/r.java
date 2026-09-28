package com.brentvatne.common.react;

import android.graphics.PointF;
import android.text.TextUtils;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.brentvatne.react.VideoManagerModule;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionRepository;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.rnscreens.ScreenFragmentWrapper;
import com.swmansion.rnscreens.ScreenStack;
import com.swmansion.rnscreens.ScreenStackFragmentWrapper;
import java.io.Closeable;
import java.net.URLDecoder;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final /* synthetic */ class r implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15508a;

    public /* synthetic */ r(int i2) {
        this.f15508a = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        String requestContentType;
        boolean zN = false;
        switch (this.f15508a) {
            case 0:
                Intrinsics.checkNotNullParameter((WritableMap) obj, "<this>");
                return Unit.f53572a;
            case 1:
                return VideoManagerModule.exitPictureInPictureCmd$lambda$6((ReactExoplayerView) obj);
            case 2:
                return VideoManagerModule.enterPictureInPictureCmd$lambda$5((ReactExoplayerView) obj);
            case 3:
                String entry = (String) obj;
                Intrinsics.checkNotNullParameter(entry, "entry");
                List listSplit$default = StringsKt__StringsKt.split$default(entry, new String[]{"="}, false, 0, 6, null);
                return android.support.v4.media.b.l((String) listSplit$default.get(0), ": ", listSplit$default.size() > 1 ? URLDecoder.decode((String) listSplit$default.get(1), "UTF-8") : "");
            case 4:
                MatchResult it = (MatchResult) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.b().f53838a);
            case 5:
                String str = (String) obj;
                HttpTransactionRepository httpTransactionRepositoryB = RepositoryProvider.b();
                return (str == null || StringsKt.z(str)) ? ((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).f16717a.q().d() : TextUtils.isDigitsOnly(str) ? ((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).b(str, "") : ((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).b("", str);
            case 6:
                HttpTransaction httpTransaction = (HttpTransaction) obj;
                if (httpTransaction != null && !Intrinsics.b(httpTransaction.getFormattedPath(true), httpTransaction.getFormattedPath(false))) {
                    zN = true;
                }
                return Boolean.valueOf(zN);
            case 7:
                HttpTransaction httpTransaction2 = (HttpTransaction) obj;
                if (httpTransaction2 != null && (requestContentType = httpTransaction2.getRequestContentType()) != null) {
                    zN = StringsKt.n(requestContentType, "x-www-form-urlencoded", true);
                }
                return Boolean.valueOf(zN);
            case 8:
                Closeable it2 = (Closeable) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.close();
                return Unit.f53572a;
            case 9:
                MapBuffer.Entry entry2 = (MapBuffer.Entry) obj;
                int i2 = ReadableMapBuffer.f18731d;
                Intrinsics.checkNotNullParameter(entry2, "entry");
                StringBuilder sb = new StringBuilder();
                sb.append(entry2.getKey());
                sb.append('=');
                int iOrdinal = entry2.getType().ordinal();
                if (iOrdinal == 0) {
                    sb.append(entry2.f());
                } else if (iOrdinal == 1) {
                    sb.append(entry2.d());
                } else if (iOrdinal == 2) {
                    sb.append(entry2.b());
                } else if (iOrdinal == 3) {
                    sb.append('\"');
                    sb.append(entry2.c());
                    sb.append('\"');
                } else if (iOrdinal == 4) {
                    sb.append(entry2.e().toString());
                } else {
                    if (iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    sb.append(entry2.a());
                }
                return sb;
            case 10:
                Exception it3 = (Exception) obj;
                Intrinsics.checkNotNullParameter(it3, "it");
                throw it3;
            case 11:
                GestureHandler it4 = (GestureHandler) obj;
                PointF pointF = GestureHandlerOrchestrator.f46732m;
                Intrinsics.checkNotNullParameter(it4, "it");
                if (GestureHandlerOrchestrator.Companion.a(it4.f46719f) && !it4.H) {
                    zN = true;
                }
                return Boolean.valueOf(zN);
            case 12:
                ScreenFragmentWrapper it5 = (ScreenFragmentWrapper) obj;
                int i3 = ScreenStack.r;
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.l());
            case 13:
                ScreenFragmentWrapper it6 = (ScreenFragmentWrapper) obj;
                int i4 = ScreenStack.r;
                Intrinsics.checkNotNullParameter(it6, "it");
                return (ScreenStackFragmentWrapper) it6;
            case 14:
                return Float.valueOf(0.0f);
            case 15:
                ArraysKt.h(null, obj);
                throw null;
            default:
                CharSequence it7 = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it7, "it");
                return it7.toString();
        }
    }
}
