package register.models;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlCreation {

    private URL url;

    public UrlCreation() {
    }

    public String getUrl() {
        return url.toString();
    }
    public URL getUrlAsURL() { return url; }

    public void setUrl(String url) throws Exception {
        try {
            this.url = new URI(url).toURL();
        } catch (URISyntaxException | MalformedURLException _) {
            throw new Exception("Cannot be parsed to URL");
        }
    }

    @Override
    public String toString() {
        return "UrlCreation{" +  "url='" + url + '\'' + '}';
    }
}
