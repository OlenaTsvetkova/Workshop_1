package website;

import website.exception.PageCannotBeClosedException;
import website.exception.PageNotLoadedException;

public interface Page {

    String getUrl();

    String getTitle();

    String getHtmlContent();

    boolean supports(Class<? extends Browser> clazz);

    void load() throws PageNotLoadedException;

    void refresh() throws PageCannotBeClosedException, PageNotLoadedException;

    void buildHtml(String html);
}
