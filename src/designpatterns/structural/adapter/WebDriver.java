package designpatterns.adapter;

/**
 * @author Heshan Karunaratne
 */
interface WebDriver {
    public void getElement();

    public void selectElement();
}

class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get Element from Chrome Driver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select Element from Chrome Driver");
    }
}

class IEDriver {

    public void findElement() {
        System.out.println("Find Element from IE Driver");
    }

    public void clickElement() {
        System.out.println("Click Element from IE Driver");
    }
}

class WebDriverAdapter implements WebDriver {

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

class AdapterTest {
    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver w = new WebDriverAdapter(e);
        w.getElement();
        w.selectElement();
    }
}