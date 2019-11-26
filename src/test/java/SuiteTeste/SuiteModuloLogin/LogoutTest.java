package SuiteTeste.SuiteModuloLogin;

import Core.BaseLoginTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Gilvan Reis on 26/11/2019.
 */
public class LogoutTest extends BaseLoginTest{

    @Test
    public void telaHome_LogonValido_DeveriaDeslogarComSucesso(){
        //edicaoDocumentoDeCliente_DocumentoValido_DeveEditarComSucesso()
        driver.findElement(By.id("loginTela")).sendKeys("admin");
        driver.findElement(By.id("senhaTela")).sendKeys("admin");
        driver.findElement(By.id("logar")).click();
        driver.findElement(By.className("caret")).click();
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
