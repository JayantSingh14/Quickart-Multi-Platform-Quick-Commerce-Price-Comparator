package com.google.firebase.messaging;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* loaded from: classes4.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    public static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {

        /* renamed from: a, reason: collision with root package name */
        public static final MessagingClientEventEncoder f44665a = new MessagingClientEventEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44666b;

        /* renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f44667c;

        /* renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f44668d;

        /* renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f44669e;

        /* renamed from: f, reason: collision with root package name */
        public static final FieldDescriptor f44670f;

        /* renamed from: g, reason: collision with root package name */
        public static final FieldDescriptor f44671g;

        /* renamed from: h, reason: collision with root package name */
        public static final FieldDescriptor f44672h;

        /* renamed from: i, reason: collision with root package name */
        public static final FieldDescriptor f44673i;

        /* renamed from: j, reason: collision with root package name */
        public static final FieldDescriptor f44674j;

        /* renamed from: k, reason: collision with root package name */
        public static final FieldDescriptor f44675k;

        /* renamed from: l, reason: collision with root package name */
        public static final FieldDescriptor f44676l;

        /* renamed from: m, reason: collision with root package name */
        public static final FieldDescriptor f44677m;
        public static final FieldDescriptor n;
        public static final FieldDescriptor o;
        public static final FieldDescriptor p;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("projectNumber");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f44666b = android.support.v4.media.a.h(atProtobuf, builder);
            FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder("messageId");
            AtProtobuf atProtobuf2 = new AtProtobuf();
            atProtobuf2.f44515a = 2;
            f44667c = android.support.v4.media.a.h(atProtobuf2, builder2);
            FieldDescriptor.Builder builder3 = new FieldDescriptor.Builder("instanceId");
            AtProtobuf atProtobuf3 = new AtProtobuf();
            atProtobuf3.f44515a = 3;
            f44668d = android.support.v4.media.a.h(atProtobuf3, builder3);
            FieldDescriptor.Builder builder4 = new FieldDescriptor.Builder("messageType");
            AtProtobuf atProtobuf4 = new AtProtobuf();
            atProtobuf4.f44515a = 4;
            f44669e = android.support.v4.media.a.h(atProtobuf4, builder4);
            FieldDescriptor.Builder builder5 = new FieldDescriptor.Builder("sdkPlatform");
            AtProtobuf atProtobuf5 = new AtProtobuf();
            atProtobuf5.f44515a = 5;
            f44670f = android.support.v4.media.a.h(atProtobuf5, builder5);
            FieldDescriptor.Builder builder6 = new FieldDescriptor.Builder("packageName");
            AtProtobuf atProtobuf6 = new AtProtobuf();
            atProtobuf6.f44515a = 6;
            f44671g = android.support.v4.media.a.h(atProtobuf6, builder6);
            FieldDescriptor.Builder builder7 = new FieldDescriptor.Builder("collapseKey");
            AtProtobuf atProtobuf7 = new AtProtobuf();
            atProtobuf7.f44515a = 7;
            f44672h = android.support.v4.media.a.h(atProtobuf7, builder7);
            FieldDescriptor.Builder builder8 = new FieldDescriptor.Builder("priority");
            AtProtobuf atProtobuf8 = new AtProtobuf();
            atProtobuf8.f44515a = 8;
            f44673i = android.support.v4.media.a.h(atProtobuf8, builder8);
            FieldDescriptor.Builder builder9 = new FieldDescriptor.Builder("ttl");
            AtProtobuf atProtobuf9 = new AtProtobuf();
            atProtobuf9.f44515a = 9;
            f44674j = android.support.v4.media.a.h(atProtobuf9, builder9);
            FieldDescriptor.Builder builder10 = new FieldDescriptor.Builder("topic");
            AtProtobuf atProtobuf10 = new AtProtobuf();
            atProtobuf10.f44515a = 10;
            f44675k = android.support.v4.media.a.h(atProtobuf10, builder10);
            FieldDescriptor.Builder builder11 = new FieldDescriptor.Builder("bulkId");
            AtProtobuf atProtobuf11 = new AtProtobuf();
            atProtobuf11.f44515a = 11;
            f44676l = android.support.v4.media.a.h(atProtobuf11, builder11);
            FieldDescriptor.Builder builder12 = new FieldDescriptor.Builder("event");
            AtProtobuf atProtobuf12 = new AtProtobuf();
            atProtobuf12.f44515a = 12;
            f44677m = android.support.v4.media.a.h(atProtobuf12, builder12);
            FieldDescriptor.Builder builder13 = new FieldDescriptor.Builder("analyticsLabel");
            AtProtobuf atProtobuf13 = new AtProtobuf();
            atProtobuf13.f44515a = 13;
            n = android.support.v4.media.a.h(atProtobuf13, builder13);
            FieldDescriptor.Builder builder14 = new FieldDescriptor.Builder("campaignId");
            AtProtobuf atProtobuf14 = new AtProtobuf();
            atProtobuf14.f44515a = 14;
            o = android.support.v4.media.a.h(atProtobuf14, builder14);
            FieldDescriptor.Builder builder15 = new FieldDescriptor.Builder("composerLabel");
            AtProtobuf atProtobuf15 = new AtProtobuf();
            atProtobuf15.f44515a = 15;
            p = android.support.v4.media.a.h(atProtobuf15, builder15);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.b(f44666b, messagingClientEvent.f44848a);
            objectEncoderContext.f(f44667c, messagingClientEvent.f44849b);
            objectEncoderContext.f(f44668d, messagingClientEvent.f44850c);
            objectEncoderContext.f(f44669e, messagingClientEvent.f44851d);
            objectEncoderContext.f(f44670f, messagingClientEvent.f44852e);
            objectEncoderContext.f(f44671g, messagingClientEvent.f44853f);
            objectEncoderContext.f(f44672h, messagingClientEvent.f44854g);
            objectEncoderContext.c(f44673i, messagingClientEvent.f44855h);
            objectEncoderContext.c(f44674j, messagingClientEvent.f44856i);
            objectEncoderContext.f(f44675k, messagingClientEvent.f44857j);
            objectEncoderContext.b(f44676l, 0L);
            objectEncoderContext.f(f44677m, messagingClientEvent.f44858k);
            objectEncoderContext.f(n, messagingClientEvent.f44859l);
            objectEncoderContext.b(o, 0L);
            objectEncoderContext.f(p, messagingClientEvent.f44860m);
        }
    }

    public static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {

        /* renamed from: a, reason: collision with root package name */
        public static final MessagingClientEventExtensionEncoder f44678a = new MessagingClientEventExtensionEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44679b;

        static {
            FieldDescriptor.Builder builder = new FieldDescriptor.Builder("messagingClientEvent");
            AtProtobuf atProtobuf = new AtProtobuf();
            atProtobuf.f44515a = 1;
            f44679b = android.support.v4.media.a.h(atProtobuf, builder);
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f44679b, ((MessagingClientEventExtension) obj).f44887a);
        }
    }

    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a, reason: collision with root package name */
        public static final ProtoEncoderDoNotUseEncoder f44680a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f44681b = FieldDescriptor.a("messagingClientEventExtension");

        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).f(f44681b, ((ProtoEncoderDoNotUse) obj).a());
        }
    }
}
