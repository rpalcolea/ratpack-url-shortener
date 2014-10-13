package rpalcolea

import redis.clients.jedis.Jedis
import java.nio.charset.StandardCharsets
import com.google.common.hash.Hashing
import org.apache.commons.validator.routines.UrlValidator

@Singleton
class UrlShortenerService {

    Jedis jedis = new Jedis("localhost")
    UrlValidator urlValidator = new UrlValidator()

    String getURL(String id) {
        return jedis.get(id)
    }

    String addURL(String url) {
        String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString()
        jedis.set(id, url)
        return id
    }

    boolean isValid(String url) {
        return !urlValidator.isValid(url)
    }
}
