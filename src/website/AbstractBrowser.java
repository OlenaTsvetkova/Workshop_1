package website;

import website.exception.PageNotLoadedException;

import java.util.List;

public abstract class AbstractBrowser implements Browser {

    @Override
    public void openWebsite(Website website) {
        List<Page> pages = website.getPages();

        if (pages == null || pages.isEmpty()) {
            System.out.println("Website is empty");
        } else {
            website.getPages().forEach(this::showPage);
        }
    }

    private void showPage(Page page) {
        if (page.supports(this.getClass())) {
            try {
                page.load();
            } catch (PageNotLoadedException e) {
                System.out.println("Can't open a page");
            }
        } else {
            System.out.printf("Browser %s doesn't support this page: %s\n", getName(), page.getUrl());
        }
    }
}
