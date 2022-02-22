package website;

import website.exception.PageCannotBeClosedException;
import website.exception.PageNotLoadedException;

import java.util.List;

public class PageImpl implements Page {

    private final List<Class<? extends Browser>> supportedBrowsers;

    private final String url;
    private final String title;
    private String htmlContent;

    public PageImpl(String url, String title) {
        this.url = url;
        this.title = title;
        this.supportedBrowsers = List.of(GoogleChrome.class, Firefox.class);
    }

    public PageImpl(String url, String title, List<Class<? extends Browser>> supportedBrowsers) {
        this.url = url;
        this.title = title;
        this.supportedBrowsers = supportedBrowsers;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getHtmlContent() {
        return this.htmlContent;
    }

    @Override
    public boolean supports(Class<? extends Browser> clazz) {
        for (Class<? extends Browser> supportedBrowser : this.supportedBrowsers) {
            if (supportedBrowser.equals(clazz)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void load() throws PageNotLoadedException {
        System.out.println("Page is loading...");

        try {
            Thread.sleep(10L * htmlContent.length());
        } catch (InterruptedException e) {
            throw new PageNotLoadedException("Can't load the page. " + e.getMessage());
        }

        System.out.println("Page loaded");
        System.out.println("Url: " + getUrl());
        System.out.println("Title: " + getTitle());
        System.out.println(htmlContent);
    }

    @Override
    public void refresh() throws PageCannotBeClosedException, PageNotLoadedException {
        close();
        load();
    }

    @Override
    public void buildHtml(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    private void close() throws PageCannotBeClosedException {
        System.out.println("Page is closing...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new PageCannotBeClosedException("Can't close the page. " + e.getMessage());
        }

        System.out.println("Page is closed...");
    }
}
