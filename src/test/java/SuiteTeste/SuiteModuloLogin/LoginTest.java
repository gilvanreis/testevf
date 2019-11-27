package SuiteTeste.SuiteModuloLogin;

import Core.BaseLoginTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Gilvan Reis on 22/11/2019.
 */

public class LoginTest extends BaseLoginTest {
    @Test
    public void telaInicial_ComLoginValido_DeveriaLogarComSucesso(){
        Assert.assertTrue(driver.getCurrentUrl().contains("index"));
    }

}
