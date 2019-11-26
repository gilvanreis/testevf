package SuiteTeste.SuiteModuloLogin;

import Core.BaseCore;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Gilvan Reis on 22/11/2019.
 */

public class LoginTest extends BaseCore{
    @Test
    public void telaInicial_LoginValido_DeveriaLogarComSucesso(){
        //edicaoDocumentoDeCliente_DocumentoValido_DeveEditarComSucesso()
        driver.findElement(By.id("loginTela")).sendKeys("admin");
        driver.findElement(By.id("senhaTela")).sendKeys("admin");
        driver.findElement(By.id("logar")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("index"));
    }

    @Test
    public void encodeDaTelaInicialTest(){
        String str = driver.findElement(By.xpath("/head/meta/charset")).getText();
        System.out.println(str);
        Assert.assertEquals("",str);
    }

}
