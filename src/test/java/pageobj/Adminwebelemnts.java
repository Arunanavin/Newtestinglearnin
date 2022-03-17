package pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Adminwebelemnts {

    @FindBy(id="menu_admin_viewAdminModule")
	public static WebElement admintab;
    @FindBy(id="menu_admin_UserManagement")
    public static WebElement  usermanage;
    @FindBy(id="menu_admin_viewSystemUsers")
    public static WebElement user;
}
