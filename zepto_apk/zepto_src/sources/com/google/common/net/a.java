package com.google.common.net;

import android.util.Log;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapsSdkInitializedCallback;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.rnmaps.maps.MapView;
import in.juspay.hyperqr.QRCodeAnalyzer;
import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryOptions;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.SentryAndroid;
import io.sentry.android.replay.capture.SessionCaptureStrategy;
import io.sentry.protocol.SentryId;
import io.sentry.react.RNSentryModuleImpl;
import io.sentry.transport.ICurrentDateProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function, Continuation, Transformer, OnMapsSdkInitializedCallback, OnFailureListener, ICurrentDateProvider, Sentry.OptionsConfiguration, ScopeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43280a;

    public /* synthetic */ a(int i2) {
        this.f43280a = i2;
    }

    @Override // io.sentry.Sentry.OptionsConfiguration
    public void a(SentryOptions sentryOptions) {
        int i2 = SentryAndroid.f52194b;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        switch (this.f43280a) {
            case 0:
                return ImmutableMultiset.m((Collection) obj);
            default:
                MessagingClientEventExtension messagingClientEventExtension = (MessagingClientEventExtension) obj;
                messagingClientEventExtension.getClass();
                ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.f44731a;
                protobufEncoder.getClass();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    protobufEncoder.a(messagingClientEventExtension, byteArrayOutputStream);
                } catch (IOException unused) {
                }
                return byteArrayOutputStream.toByteArray();
        }
    }

    public void b(MapsInitializer.Renderer renderer) {
        String[] strArr = MapView.V0;
        Log.d("AirMapRenderer", renderer.toString());
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope it) {
        switch (this.f43280a) {
            case 8:
                int i2 = SessionCaptureStrategy.u;
                Intrinsics.checkNotNullParameter(it, "it");
                it.g(SentryId.f52907b);
                break;
            default:
                AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
                it.o();
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        QRCodeAnalyzer.analyze$lambda$1(exc);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f43280a) {
            case 1:
                return 403;
            default:
                return -1;
        }
    }
}
