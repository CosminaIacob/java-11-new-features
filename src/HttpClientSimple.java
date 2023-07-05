import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientSimple {
    public static void main(String[] args) throws IOException, InterruptedException {
        // returns an instance with all default settings
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("Https://pluralsight.com"))
                .GET()
                .build();
        // A BodyHandler implementation tells the HttpClient
        // how to turn the bytes of the response body into our desired results
        // result to be interpreted as String, in this case
        // HttpClient send() method is the blocking and synchronous impl,
        // so the send method only returns when an actual response is there
        // so isn't guaranteed that the headers will be available for print.
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.headers().map());
        // result:
        // {:status=[301], content-length=[134], content-type=[text/html], date=[Wed, 05 Jul 2023 07:55:19 GMT],
        // location=[https://www.pluralsight.com:443/], server=[awselb/2.0]}

    }
}
