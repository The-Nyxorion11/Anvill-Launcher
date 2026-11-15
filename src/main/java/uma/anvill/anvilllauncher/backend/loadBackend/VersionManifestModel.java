package uma.anvill.anvilllauncher.backend.loadBackend;

import java.util.List;

public class VersionManifestModel {

    public Latest latest;
    public List<VersionEntry> versions;

    public static class Latest {
        public String release;
        public String snapshot;
    }

    public static class VersionEntry {
        public String id;
        public String type;
        public String url;
        public String time;
        public String releaseTime;
        public String sha1;
        public int complianceLevel;
    }
}
