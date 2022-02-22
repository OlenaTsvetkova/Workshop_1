package website;

import java.util.List;

public class WebsiteImpl implements Website {

    private final List<Page> pages;

    public WebsiteImpl(List<Page> pages) {
        this.pages = pages;
    }

    @Override
    public List<Page> getPages() {
        return pages;
    }
}
