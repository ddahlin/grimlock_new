package GrimlockInitialisation.InitalisationUtils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Params {
    public Map Device;
    public Map Website;
    public Map NetworkSniffer;
    public Map Remote;
    public Map Application;
    public Map Capabilites;
    public boolean IS_MOBILE;
    public boolean IS_LOCAL;
    public String WEB_OBJECT_TO_TEST;

    public Params(Map params) {
        IS_MOBILE = getBoolen(params.get("is_mobile").toString());
        IS_LOCAL = getBoolen(params.get("is_local").toString());
        WEB_OBJECT_TO_TEST = params.get("web_object_to_test").toString();
        if (params.get("device") != null)
            buildDeviceParams(params.get("device").toString());
        if (params.get("website") != null)
            buildWebsiteParams(params.get("website").toString());
        if (params.get("network_sniffer") != null)
            if (!params.get("network_sniffer").toString().toLowerCase().contains("false") &&
                    !params.get("network_sniffer").toString().toLowerCase().contains("charles") &&
                    !params.get("network_sniffer").toString().toLowerCase().contains("bmp"))
                buildNetworkSnifferParams(params.get("network_sniffer").toString());
        if (params.get("remote") != null)
            buildRemoteParams(params.get("remote").toString());
        if (params.get("application") != null)
            buildApplicationParams(params.get("application").toString());
        if (params.get("capability") != null)
            buildCapabilitesParams(params.get("capability").toString());

        if (Device == null && Application == null && Website == null) {
            if (params.containsKey("browser")) {
                if (!params.get("browser").toString().toLowerCase().contains("false")) {
                    Website = new HashMap();
                    Website.put("browser", params.get("browser"));
                    Website.put("browser_version", params.get("browser_version"));
                    if(params.containsKey("driver_path"))
                        Website.put("driver_path",params.get("driver_path"));
                }
            }
            if (params.containsKey("application_name")) {
                if (!params.get("application_name").toString().toLowerCase().contains("false") ) {
                    Application = new HashMap();
                    Application.put("application_name", params.get("application_name"));
                    Application.put("application_path", params.get("application_path"));
                }

            }
            if (IS_MOBILE) {
                Device = new HashMap();
                Device.put("udid", params.get("udid"));
                Device.put("device_name", params.get("device_name"));
                Device.put("device_version", params.get("device_version"));
                Device.put("platform", params.get("platform"));
                Device.put("xcode_org_id", params.get("xcode_org_id"));
                if (params.containsKey("appium_path"))
                    Device.put("appium_path", params.get("appium_path"));
            }
            if (params.containsKey("os")) {
                if (!params.get("os").toString().toLowerCase().contains("false")) {
                    Website.put("os", params.get("os"));
                    Website.put("os_version", params.get("os_version"));
                }
            }
            if (params.containsKey("network_sniffer")) {
                NetworkSniffer = new HashMap();
                NetworkSniffer.put("network_sniffer", params.get("network_sniffer"));
                NetworkSniffer.put("port", params.get("sniffer_port"));
            }
            if (params.containsKey("browserstack_user_name")) {
                buildRemoteParams("browserstack");
            }

        }
    }


    private boolean getBoolen(String b) {
        if (b.toLowerCase().contains("true"))
            return true;
        else return false;
    }

    private String getValue(Map map, String key) {
        if (map.get(key) != null)
            return map.get(key).toString();
        else
            return "false";
    }

    public String getDevice(String key) {
        return getValue(Device, key);
    }

    public String getWebsite(String key) {
        return getValue(Website, key);
    }

    public String getNetworkSniffer(String key) {
        return getValue(NetworkSniffer, key);
    }

    public String getRemote(String key) {
        return getValue(Remote, key);
    }

    public String getApplication(String key) {
        return getValue(Application, key);
    }

    public String getCapabilites(String key) {
        return getValue(Capabilites, key);
    }

    private void buildCapabilitesParams(String id) {
        Capabilites = buildMap("", id, Capabilites);
    }

    private void buildNetworkSnifferParams(String udid) {
        NetworkSniffer = buildMap("./src/main/resources/TestConfiguration/NetworkSniffers.xml",
                udid, NetworkSniffer);
    }

    private void buildRemoteParams(String name) {
        Remote = buildMap("./src/main/resources/TestConfiguration/Remotes.xml",
                name, Remote);
    }

    private void buildApplicationParams(String name) {
        Application = buildMap("./src/main/resources/TestConfiguration/Applications.xml",
                name, Application);
    }

    private void buildWebsiteParams(String Id) {
        Website = buildMap("./src/main/resources/TestConfiguration/Websites.xml",
                Id, Website);
    }

    private void buildDeviceParams(String udid) {
        Device = buildMap("./src/main/resources/TestConfiguration/Devices.xml",
                udid, Device);
    }

    private Map buildMap(String Path, String key, Map map) {
        try {
            String text = null;
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(
                    new File(Path)));
            String Key = "";
            while (reader.hasNext()) {
                int Event = reader.next();

                switch (Event) {
                    case XMLStreamConstants.START_ELEMENT: {
                        if (key.equals(reader.getAttributeValue(0))) {
                            Key = reader.getLocalName();
                            map = new HashMap();
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        if (map == null) break;
                        text = reader.getText().trim();
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (map == null) break;
                        if (!text.isEmpty())
                            map.put(reader.getLocalName(), text);
                        if (Key.contains(reader.getLocalName()))
                            return map;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
