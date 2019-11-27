package SuiteTeste.SuiteModuloLogin;

import Core.BaseLoginTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Gilvan Reis on 26/11/2019.
 */
public class ClienteTest extends BaseLoginTest {
    @Test
    public void PesquisaCliente_DeveriaClicarEmPesquisarSucesso() {
        driver.get("https://vfcli.varejofacil.com/cliente/cadastro?clearCache=true");
        driver.findElement(By.id("botaoPesquisar")).click();
        Assert.assertTrue(true);

    }
    @Test
    public void PesquisaCliente_ComDocumentoCpfValido_DeveriaPesquisarSucesso() {
        driver.get("https://vfcli.varejofacil.com/cliente/cadastro?clearCache=true");
        driver.findElement(By.id("cpfCnpjPassaporte")).sendKeys("29245890880");
        driver.findElement(By.id("botaoPesquisar")).click();
        Assert.assertTrue(true);

    }

}
