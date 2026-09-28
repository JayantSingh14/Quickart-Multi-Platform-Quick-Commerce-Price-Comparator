package in.juspay.airborne.ota;

import in.juspay.hypersdk.core.PaymentConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class ReleaseConfig {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Config config;

    @NotNull
    private final PackageManifest pkg;

    @NotNull
    private final ResourceManifest resources;

    @NotNull
    private final String version;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Config configFromJSON(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString("version");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"version\")");
            long j2 = jSONObject.getLong("release_config_timeout");
            long j3 = jSONObject.getLong("boot_timeout");
            JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(\"properties\")");
            return new Config(string, j2, j3, jSONObject2);
        }

        private final Split getSplit(JSONArray jSONArray, int i2) throws JSONException {
            try {
                JSONObject json = jSONArray.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(json, "json");
                URL url = getURL(json, "url");
                String string = json.getString("file_path");
                Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"file_path\")");
                return new Split(url, string, json.has("is_downloaded") ? Boolean.valueOf(json.getBoolean("is_downloaded")) : null);
            } catch (JSONException unused) {
                throw new JSONException(android.support.v4.media.b.g(i2, "JSON at index '", "' is not a valid Split"));
            }
        }

        private final URL getURL(JSONObject jSONObject, String str) throws JSONException {
            try {
                return new URL(jSONObject.getString(str));
            } catch (MalformedURLException unused) {
                throw new JSONException(android.support.v4.media.b.D("Property '", str, "' is not a valid URL."));
            }
        }

        @NotNull
        /* renamed from: deSerialize-IoAF18A, reason: not valid java name */
        public final Object m61deSerializeIoAF18A(@NotNull String serialized) throws JSONException {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                JSONObject jSONObject = new JSONObject(serialized);
                String string = jSONObject.getString("version");
                Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"version\")");
                JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.Category.CONFIG);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(\"config\")");
                Config configConfigFromJSON = configFromJSON(jSONObject2);
                JSONObject jSONObject3 = jSONObject.getJSONObject(Constants.PACKAGE_DIR_NAME);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.getJSONObject(\"package\")");
                PackageManifest packageManifestPackageFromJSON = packageFromJSON(jSONObject3);
                JSONArray jSONArray = jSONObject.getJSONArray(Constants.RESOURCES_DIR_NAME);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "json.getJSONArray(\"resources\")");
                ReleaseConfig releaseConfig = new ReleaseConfig(string, configConfigFromJSON, packageManifestPackageFromJSON, resourcesFromJSON(jSONArray));
                Result.Companion companion = Result.f53538b;
                return releaseConfig;
            } catch (JSONException e2) {
                Result.Companion companion2 = Result.f53538b;
                return ResultKt.a(e2);
            }
        }

        @NotNull
        /* renamed from: deSerializeConfig-IoAF18A, reason: not valid java name */
        public final Object m62deSerializeConfigIoAF18A(@NotNull String serialized) {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                Result.Companion companion = Result.f53538b;
                return configFromJSON(new JSONObject(serialized));
            } catch (JSONException e2) {
                Result.Companion companion2 = Result.f53538b;
                return ResultKt.a(e2);
            }
        }

        @NotNull
        /* renamed from: deSerializePackage-IoAF18A, reason: not valid java name */
        public final Object m63deSerializePackageIoAF18A(@NotNull String serialized) {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                Result.Companion companion = Result.f53538b;
                return packageFromJSON(new JSONObject(serialized));
            } catch (JSONException e2) {
                Result.Companion companion2 = Result.f53538b;
                return ResultKt.a(e2);
            }
        }

        @NotNull
        /* renamed from: deSerializeResources-IoAF18A, reason: not valid java name */
        public final Object m64deSerializeResourcesIoAF18A(@NotNull String serialized) {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                Result.Companion companion = Result.f53538b;
                return resourcesFromJSON(new JSONArray(serialized));
            } catch (JSONException e2) {
                Result.Companion companion2 = Result.f53538b;
                return ResultKt.a(e2);
            }
        }

        @NotNull
        public final PackageManifest packageFromJSON(@NotNull JSONObject json) throws JSONException {
            Split split;
            Intrinsics.checkNotNullParameter(json, "json");
            Object obj = json.get("index");
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                URL url = getURL(jSONObject, "url");
                String string = jSONObject.getString("file_path");
                Intrinsics.checkNotNullExpressionValue(string, "indexValue.getString(\"file_path\")");
                split = new Split(url, string, json.has("is_downloaded") ? Boolean.valueOf(json.getBoolean("is_downloaded")) : null);
            } else {
                split = new Split(getURL(json, "index"));
            }
            String string2 = json.getString(CLConstants.FIELD_PAY_INFO_NAME);
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"name\")");
            String string3 = json.getString("version");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"version\")");
            JSONObject jSONObject2 = json.getJSONObject("properties");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(\"properties\")");
            JSONArray it = json.getJSONArray("important");
            int length = it.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                Companion companion = ReleaseConfig.Companion;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(companion.getSplit(it, i2));
            }
            JSONArray it2 = json.getJSONArray("lazy");
            int length2 = it2.length();
            ArrayList arrayList2 = new ArrayList(length2);
            for (int i3 = 0; i3 < length2; i3++) {
                Companion companion2 = ReleaseConfig.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                arrayList2.add(companion2.getSplit(it2, i3));
            }
            return new PackageManifest(string2, string3, jSONObject2, split, arrayList, arrayList2);
        }

        @NotNull
        public final ResourceManifest resourcesFromJSON(@NotNull JSONArray array) {
            Intrinsics.checkNotNullParameter(array, "array");
            int length = array.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(ReleaseConfig.Companion.getSplit(array, i2));
            }
            return new ResourceManifest(arrayList);
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class Config {
        private final long bootTimeout;

        @NotNull
        private final JSONObject properties;
        private final long releaseConfigTimeout;

        @NotNull
        private final String version;

        public Config(@NotNull String version, long j2, long j3, @NotNull JSONObject properties) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.version = version;
            this.releaseConfigTimeout = j2;
            this.bootTimeout = j3;
            this.properties = properties;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, long j2, long j3, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = config.version;
            }
            if ((i2 & 2) != 0) {
                j2 = config.releaseConfigTimeout;
            }
            if ((i2 & 4) != 0) {
                j3 = config.bootTimeout;
            }
            if ((i2 & 8) != 0) {
                jSONObject = config.properties;
            }
            JSONObject jSONObject2 = jSONObject;
            return config.copy(str, j2, j3, jSONObject2);
        }

        @NotNull
        public final String component1() {
            return this.version;
        }

        public final long component2() {
            return this.releaseConfigTimeout;
        }

        public final long component3() {
            return this.bootTimeout;
        }

        @NotNull
        public final JSONObject component4() {
            return this.properties;
        }

        @NotNull
        public final Config copy(@NotNull String version, long j2, long j3, @NotNull JSONObject properties) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(properties, "properties");
            return new Config(version, j2, j3, properties);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.b(this.version, config.version) && this.releaseConfigTimeout == config.releaseConfigTimeout && this.bootTimeout == config.bootTimeout && Intrinsics.b(this.properties, config.properties);
        }

        public final long getBootTimeout() {
            return this.bootTimeout;
        }

        @NotNull
        public final JSONObject getProperties() {
            return this.properties;
        }

        public final long getReleaseConfigTimeout() {
            return this.releaseConfigTimeout;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.properties.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.d(this.version.hashCode() * 31, 31, this.releaseConfigTimeout), 31, this.bootTimeout);
        }

        @NotNull
        public final JSONObject toJSON() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject().put("version", this.version).put("release_config_timeout", this.releaseConfigTimeout).put("boot_timeout", this.bootTimeout).put("properties", this.properties);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject()\n           …\"properties\", properties)");
            return jSONObjectPut;
        }

        @NotNull
        public String toString() {
            return "Config(version=" + this.version + ", releaseConfigTimeout=" + this.releaseConfigTimeout + ", bootTimeout=" + this.bootTimeout + ", properties=" + this.properties + ')';
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class PackageManifest {

        @NotNull
        private final List<Split> important;

        @Nullable
        private final Split index;

        @NotNull
        private final List<Split> lazy;

        @NotNull
        private final String name;

        @NotNull
        private final JSONObject properties;

        @NotNull
        private final String version;

        public PackageManifest(@NotNull String name, @NotNull String version, @NotNull JSONObject properties, @Nullable Split split, @NotNull List<Split> important, @NotNull List<Split> lazy) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(important, "important");
            Intrinsics.checkNotNullParameter(lazy, "lazy");
            this.name = name;
            this.version = version;
            this.properties = properties;
            this.index = split;
            this.important = important;
            this.lazy = lazy;
        }

        public static /* synthetic */ PackageManifest copy$default(PackageManifest packageManifest, String str, String str2, JSONObject jSONObject, Split split, List list, List list2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = packageManifest.name;
            }
            if ((i2 & 2) != 0) {
                str2 = packageManifest.version;
            }
            if ((i2 & 4) != 0) {
                jSONObject = packageManifest.properties;
            }
            if ((i2 & 8) != 0) {
                split = packageManifest.index;
            }
            if ((i2 & 16) != 0) {
                list = packageManifest.important;
            }
            if ((i2 & 32) != 0) {
                list2 = packageManifest.lazy;
            }
            List list3 = list;
            List list4 = list2;
            return packageManifest.copy(str, str2, jSONObject, split, list3, list4);
        }

        private final List<Split> getAllSplits() {
            ArrayList arrayListF0 = CollectionsKt.f0(this.important);
            Split split = this.index;
            List<Split> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.L(CollectionsKt.L(arrayListF0, split != null ? CollectionsKt.H(split) : EmptyList.f53609a), CollectionsKt.f0(this.lazy)));
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(importa…) + lazy.toMutableList())");
            return listUnmodifiableList;
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.version;
        }

        @NotNull
        public final JSONObject component3() {
            return this.properties;
        }

        @Nullable
        public final Split component4() {
            return this.index;
        }

        @NotNull
        public final List<Split> component5() {
            return this.important;
        }

        @NotNull
        public final List<Split> component6() {
            return this.lazy;
        }

        @NotNull
        public final PackageManifest copy(@NotNull String name, @NotNull String version, @NotNull JSONObject properties, @Nullable Split split, @NotNull List<Split> important, @NotNull List<Split> lazy) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(properties, "properties");
            Intrinsics.checkNotNullParameter(important, "important");
            Intrinsics.checkNotNullParameter(lazy, "lazy");
            return new PackageManifest(name, version, properties, split, important, lazy);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PackageManifest)) {
                return false;
            }
            PackageManifest packageManifest = (PackageManifest) obj;
            return Intrinsics.b(this.name, packageManifest.name) && Intrinsics.b(this.version, packageManifest.version) && Intrinsics.b(this.properties, packageManifest.properties) && Intrinsics.b(this.index, packageManifest.index) && Intrinsics.b(this.important, packageManifest.important) && Intrinsics.b(this.lazy, packageManifest.lazy);
        }

        @NotNull
        public final List<String> getFileNames() {
            List<Split> allSplits = getAllSplits();
            ArrayList arrayList = new ArrayList(CollectionsKt.r(allSplits, 10));
            Iterator<T> it = allSplits.iterator();
            while (it.hasNext()) {
                arrayList.add(((Split) it.next()).getFileName());
            }
            return arrayList;
        }

        @NotNull
        public final List<String> getFilePaths() {
            List<Split> allSplits = getAllSplits();
            ArrayList arrayList = new ArrayList(CollectionsKt.r(allSplits, 10));
            Iterator<T> it = allSplits.iterator();
            while (it.hasNext()) {
                arrayList.add(((Split) it.next()).getFilePath());
            }
            return arrayList;
        }

        @NotNull
        public final List<Split> getImportant() {
            return this.important;
        }

        @NotNull
        public final List<Split> getImportantSplits() {
            ArrayList arrayListF0 = CollectionsKt.f0(this.important);
            Split split = this.index;
            List<Split> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.L(arrayListF0, split != null ? CollectionsKt.H(split) : EmptyList.f53609a));
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(importa…) + listOfNotNull(index))");
            return listUnmodifiableList;
        }

        @Nullable
        public final Split getIndex() {
            return this.index;
        }

        @NotNull
        public final List<Split> getLazy() {
            return this.lazy;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final JSONObject getProperties() {
            return this.properties;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = (this.properties.hashCode() + androidx.fragment.app.e.e(this.name.hashCode() * 31, 31, this.version)) * 31;
            Split split = this.index;
            return this.lazy.hashCode() + androidx.fragment.app.e.f((iHashCode + (split == null ? 0 : split.hashCode())) * 31, 31, this.important);
        }

        @NotNull
        public final JSONObject toJSON() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject().put(CLConstants.FIELD_PAY_INFO_NAME, this.name).put("version", this.version).put("properties", this.properties);
            Split split = this.index;
            JSONObject jSONObjectPut2 = jSONObjectPut.put("index", split != null ? split.toJSON() : null);
            List<Split> list = this.important;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Split) it.next()).toJSON());
            }
            JSONObject jSONObjectPut3 = jSONObjectPut2.put("important", new JSONArray((Collection) arrayList));
            List<Split> list2 = this.lazy;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Split) it2.next()).toJSON());
            }
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("lazy", new JSONArray((Collection) arrayList2));
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut4, "JSONObject()\n           …azy.map { it.toJSON() }))");
            return jSONObjectPut4;
        }

        @NotNull
        public String toString() {
            return "PackageManifest(name=" + this.name + ", version=" + this.version + ", properties=" + this.properties + ", index=" + this.index + ", important=" + this.important + ", lazy=" + this.lazy + ')';
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class ResourceManifest implements List<Split>, KMappedMarker {

        @NotNull
        private final List<Split> entries;

        public ResourceManifest(@NotNull List<Split> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
        }

        private final List<Split> component1() {
            return this.entries;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResourceManifest copy$default(ResourceManifest resourceManifest, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = resourceManifest.entries;
            }
            return resourceManifest.copy(list);
        }

        /* renamed from: add, reason: avoid collision after fix types in other method */
        public void add2(int i2, Split split) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends Split> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(@NotNull Split element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return this.entries.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.entries.containsAll(elements);
        }

        @NotNull
        public final ResourceManifest copy(@NotNull List<Split> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new ResourceManifest(entries);
        }

        @Override // java.util.List, java.util.Collection
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResourceManifest) && Intrinsics.b(this.entries, ((ResourceManifest) obj).entries);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        @NotNull
        public Split get(int i2) {
            return this.entries.get(i2);
        }

        @NotNull
        public final List<String> getFilePaths() {
            List<Split> list = this.entries;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Split) it.next()).getFilePath());
            }
            return arrayList;
        }

        @Nullable
        public final Split getResource(@NotNull String name) {
            Object next;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterator<T> it = this.entries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.b(((Split) next).getFilePath(), name)) {
                    break;
                }
            }
            return (Split) next;
        }

        public int getSize() {
            return this.entries.size();
        }

        @Override // java.util.List, java.util.Collection
        public int hashCode() {
            return this.entries.hashCode();
        }

        public int indexOf(@NotNull Split element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return this.entries.indexOf(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.entries.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<Split> iterator() {
            return this.entries.iterator();
        }

        public int lastIndexOf(@NotNull Split element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return this.entries.lastIndexOf(element);
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<Split> listIterator() {
            return this.entries.listIterator();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public Split remove(int i2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<Split> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public Split set2(int i2, Split split) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public void sort(Comparator<? super Split> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        @NotNull
        public List<Split> subList(int i2, int i3) {
            return this.entries.subList(i2, i3);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @NotNull
        public final JSONArray toJSON() {
            JSONArray jSONArray = new JSONArray();
            Iterator<Split> it = this.entries.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            return jSONArray;
        }

        @NotNull
        public String toString() {
            return "ResourceManifest(entries=" + this.entries + ')';
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i2, Split split) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends Split> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Split) {
                return contains((Split) obj);
            }
            return false;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Split) {
                return indexOf((Split) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Split) {
                return lastIndexOf((Split) obj);
            }
            return -1;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<Split> listIterator(int i2) {
            return this.entries.listIterator(i2);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Split remove(int i2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Split set(int i2, Split split) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.b(this, array);
        }

        public boolean add(Split split) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ReleaseConfig(@NotNull String version, @NotNull Config config, @NotNull PackageManifest pkg, @NotNull ResourceManifest resources) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.version = version;
        this.config = config;
        this.pkg = pkg;
        this.resources = resources;
    }

    public static /* synthetic */ ReleaseConfig copy$default(ReleaseConfig releaseConfig, String str, Config config, PackageManifest packageManifest, ResourceManifest resourceManifest, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = releaseConfig.version;
        }
        if ((i2 & 2) != 0) {
            config = releaseConfig.config;
        }
        if ((i2 & 4) != 0) {
            packageManifest = releaseConfig.pkg;
        }
        if ((i2 & 8) != 0) {
            resourceManifest = releaseConfig.resources;
        }
        return releaseConfig.copy(str, config, packageManifest, resourceManifest);
    }

    @NotNull
    public final String component1() {
        return this.version;
    }

    @NotNull
    public final Config component2() {
        return this.config;
    }

    @NotNull
    public final PackageManifest component3() {
        return this.pkg;
    }

    @NotNull
    public final ResourceManifest component4() {
        return this.resources;
    }

    @NotNull
    public final ReleaseConfig copy(@NotNull String version, @NotNull Config config, @NotNull PackageManifest pkg, @NotNull ResourceManifest resources) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ReleaseConfig(version, config, pkg, resources);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReleaseConfig)) {
            return false;
        }
        ReleaseConfig releaseConfig = (ReleaseConfig) obj;
        return Intrinsics.b(this.version, releaseConfig.version) && Intrinsics.b(this.config, releaseConfig.config) && Intrinsics.b(this.pkg, releaseConfig.pkg) && Intrinsics.b(this.resources, releaseConfig.resources);
    }

    @NotNull
    public final Config getConfig() {
        return this.config;
    }

    @NotNull
    public final PackageManifest getPkg() {
        return this.pkg;
    }

    @NotNull
    public final ResourceManifest getResources() {
        return this.resources;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.resources.hashCode() + ((this.pkg.hashCode() + ((this.config.hashCode() + (this.version.hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public final String serialize() {
        String string = new JSONObject().put("version", this.version).put(PaymentConstants.Category.CONFIG, this.config.toJSON()).put(Constants.PACKAGE_DIR_NAME, this.pkg.toJSON()).put(Constants.RESOURCES_DIR_NAME, this.resources.toJSON()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject()\n           …)\n            .toString()");
        return string;
    }

    @NotNull
    public String toString() {
        return "ReleaseConfig(version=" + this.version + ", config=" + this.config + ", pkg=" + this.pkg + ", resources=" + this.resources + ')';
    }

    @Metadata
    public static final class Split {

        @NotNull
        private final String fileName;

        @NotNull
        private String filePath;

        @Nullable
        private Boolean isDownloaded;

        @NotNull
        private final URL url;

        public Split(@NotNull URL url, @NotNull String filePath, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            this.url = url;
            this.filePath = filePath;
            this.isDownloaded = bool;
            this.fileName = (String) CollectionsKt.F(StringsKt__StringsKt.split$default(filePath, new String[]{"/"}, false, 0, 6, null));
        }

        public static /* synthetic */ Split copy$default(Split split, URL url, String str, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                url = split.url;
            }
            if ((i2 & 2) != 0) {
                str = split.filePath;
            }
            if ((i2 & 4) != 0) {
                bool = split.isDownloaded;
            }
            return split.copy(url, str, bool);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final String component2() {
            return this.filePath;
        }

        @Nullable
        public final Boolean component3() {
            return this.isDownloaded;
        }

        @NotNull
        public final Split copy(@NotNull URL url, @NotNull String filePath, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new Split(url, filePath, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Split)) {
                return false;
            }
            Split split = (Split) obj;
            return Intrinsics.b(this.url.toURI(), split.url.toURI()) && Intrinsics.b(this.filePath, split.filePath);
        }

        @NotNull
        public final String getFileName() {
            return this.fileName;
        }

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        public final URL getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.filePath.hashCode() + (this.url.toURI().hashCode() * 31);
        }

        @Nullable
        public final Boolean isDownloaded() {
            return this.isDownloaded;
        }

        public final void setDownloaded(@Nullable Boolean bool) {
            this.isDownloaded = bool;
        }

        public final void setFilePath(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.filePath = str;
        }

        @NotNull
        public final JSONObject toJSON() throws JSONException {
            JSONObject json = new JSONObject().put("url", this.url.toString()).put("file_path", this.filePath);
            Boolean bool = this.isDownloaded;
            if (bool != null) {
                json.put("is_downloaded", bool);
            }
            Intrinsics.checkNotNullExpressionValue(json, "json");
            return json;
        }

        @NotNull
        public String toString() {
            return "Split(url=" + this.url + ", filePath=" + this.filePath + ", isDownloaded=" + this.isDownloaded + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Split(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            String path = url.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "url.path");
            this(url, (String) CollectionsKt.F(StringsKt__StringsKt.split$default(path, new String[]{"/"}, false, 0, 6, null)), null);
        }
    }
}
