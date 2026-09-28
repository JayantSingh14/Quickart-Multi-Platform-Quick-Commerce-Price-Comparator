package io.sentry.protocol;

import com.swmansion.reanimated.layoutReanimation.Snapshot;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class ViewHierarchyNode implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52971a;

    /* renamed from: b, reason: collision with root package name */
    public String f52972b;

    /* renamed from: c, reason: collision with root package name */
    public String f52973c;

    /* renamed from: d, reason: collision with root package name */
    public String f52974d;

    /* renamed from: e, reason: collision with root package name */
    public Double f52975e;

    /* renamed from: f, reason: collision with root package name */
    public Double f52976f;

    /* renamed from: g, reason: collision with root package name */
    public Double f52977g;

    /* renamed from: h, reason: collision with root package name */
    public Double f52978h;

    /* renamed from: i, reason: collision with root package name */
    public String f52979i;

    /* renamed from: j, reason: collision with root package name */
    public Double f52980j;

    /* renamed from: k, reason: collision with root package name */
    public List f52981k;

    /* renamed from: l, reason: collision with root package name */
    public HashMap f52982l;

    public static final class Deserializer implements JsonDeserializer<ViewHierarchyNode> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "rendering_system":
                        viewHierarchyNode.f52971a = objectReader.a1();
                        break;
                    case "identifier":
                        viewHierarchyNode.f52973c = objectReader.a1();
                        break;
                    case "height":
                        viewHierarchyNode.f52976f = objectReader.W();
                        break;
                    case "x":
                        viewHierarchyNode.f52977g = objectReader.W();
                        break;
                    case "y":
                        viewHierarchyNode.f52978h = objectReader.W();
                        break;
                    case "tag":
                        viewHierarchyNode.f52974d = objectReader.a1();
                        break;
                    case "type":
                        viewHierarchyNode.f52972b = objectReader.a1();
                        break;
                    case "alpha":
                        viewHierarchyNode.f52980j = objectReader.W();
                        break;
                    case "width":
                        viewHierarchyNode.f52975e = objectReader.W();
                        break;
                    case "children":
                        viewHierarchyNode.f52981k = objectReader.I1(iLogger, this);
                        break;
                    case "visibility":
                        viewHierarchyNode.f52979i = objectReader.a1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            viewHierarchyNode.f52982l = map;
            return viewHierarchyNode;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52971a != null) {
            objectWriter.d("rendering_system").e(this.f52971a);
        }
        if (this.f52972b != null) {
            objectWriter.d("type").e(this.f52972b);
        }
        if (this.f52973c != null) {
            objectWriter.d("identifier").e(this.f52973c);
        }
        if (this.f52974d != null) {
            objectWriter.d("tag").e(this.f52974d);
        }
        if (this.f52975e != null) {
            objectWriter.d(Snapshot.WIDTH).f(this.f52975e);
        }
        if (this.f52976f != null) {
            objectWriter.d(Snapshot.HEIGHT).f(this.f52976f);
        }
        if (this.f52977g != null) {
            objectWriter.d("x").f(this.f52977g);
        }
        if (this.f52978h != null) {
            objectWriter.d("y").f(this.f52978h);
        }
        if (this.f52979i != null) {
            objectWriter.d("visibility").e(this.f52979i);
        }
        if (this.f52980j != null) {
            objectWriter.d("alpha").f(this.f52980j);
        }
        List list = this.f52981k;
        if (list != null && !list.isEmpty()) {
            objectWriter.d("children").h(iLogger, this.f52981k);
        }
        HashMap map = this.f52982l;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52982l.get(str));
            }
        }
        objectWriter.t();
    }
}
