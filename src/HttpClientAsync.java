import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientAsync {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();

        // CompletableFuture represents and synchronous computation in Java,
        // introduced in Java 8.
        CompletableFuture<HttpResponse<String>> responseFuture =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        responseFuture.thenAccept(response -> System.out.println(response.version()));
        // result: nothing printed
        // sendAsync() will return a CompleteableFuture immediately without waiting for the server response
        // so the main code will keep on executing, configuring the callback on the future, and thenAccept
        // but this callback will only be triggered once the server returns a response
        // the http client will use a background thread to make the call
        // the server response will take a while, and in the meanwhile, our app will have ended.

        // this joins the app thread that our code runs on with the future
        // the join() will wait until the future has been completed
        // if it's completed, that also means that our theAccept callback will run.
        responseFuture.join();
        // result: HTTP_2

        // the sync and blocking send() API is easier to use,
        // but the async API will help you create responsive and more scalable apps


    }
}
