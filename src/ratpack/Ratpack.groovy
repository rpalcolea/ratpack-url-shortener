import rpalcolea.UrlShortenerService

import static ratpack.groovy.Groovy.ratpack

UrlShortenerService service = UrlShortenerService.instance

ratpack {
  handlers {

      get("add") {
          String url = request.queryParams.url
          if(!url) response.send "Parameter 'url' not provided"
          if(!service.isValid(url)) response.send "A valid URL was not provided"
          String id = service.addURL(url)
          response.send "Your new URL is: ${id}"
      }

      get(":id") {
        String id = context.getPathTokens().get("id")
        if(!id) response.send "Parameter 'id' not provided"
        String url = service.getURL(id)
        if (!url) response.send "Couldn´ find a URL for ${id}"
        redirect(url)
      }

    assets "public"
  }
}
