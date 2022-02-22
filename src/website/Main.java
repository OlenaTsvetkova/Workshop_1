package website;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Page about1 = new PageImpl("https://example.com/about1", "About1", List.of(Firefox.class));
        about1.buildHtml("""
                  ,---.   ,--.                       ,--.      ,--.\s
                 /  O  \\  |  |-.   ,---.  ,--.,--. ,-'  '-.   /   |\s
                |  .-.  | | .-. ' | .-. | |  ||  | '-.  .-'   `|  |\s
                |  | |  | | `-' | ' '-' ' '  ''  '   |  |      |  |\s
                `--' `--'  `---'   `---'   `----'    `--'      `--'\s
                """);

        Page about2 = new PageImpl("https://example.com/about2", "About1", List.of(Firefox.class));
        about2.buildHtml("""
                  ,---.   ,--.                       ,--.      ,--.\s
                 /  O  \\  |  |-.   ,---.  ,--.,--. ,-'  '-.   /   |\s
                |  .-.  | | .-. ' | .-. | |  ||  | '-.  .-'   `|  |\s
                |  | |  | | `-' | ' '-' ' '  ''  '   |  |      |  |\s
                `--' `--'  `---'   `---'   `----'    `--'      `--'\s
                """);

        Website website = new WebsiteImpl(List.of(about1, about2));


        Browser googleChrome = new GoogleChrome();
        Browser firefox = new Firefox();

        firefox.openWebsite(website);
    }
}
