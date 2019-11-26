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
        //edicaoDocumentoDeCliente_DocumentoValido_DeveEditarComSucesso()
        driver.findElement(By.id("loginTela")).sendKeys("admin");
        driver.findElement(By.id("senhaTela")).sendKeys("admin");
        driver.findElement(By.id("logar")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("index"));
    }

}
