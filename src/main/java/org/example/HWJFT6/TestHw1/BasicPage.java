package org.example.HWJFT6.TestHw1;

import org.openqa.selenium.WebDriver;

public class BasicPage extends StartKit {
    public RoadMapMenu roadMapMenu;

    public BasicPage(WebDriver driver) {
        super(driver);
        roadMapMenu = new RoadMapMenu(driver);
    }
}
