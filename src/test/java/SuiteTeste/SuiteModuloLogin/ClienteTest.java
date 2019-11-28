package SuiteTeste.SuiteModuloLogin;

import Core.BaseLoginTest;
import Utils.GeraCpfCnpj;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Gilvan Reis on 26/11/2019.
 */
public class ClienteTest extends BaseLoginTest {
    public void selectItemFromList(String fieldId, String value){
        //Seleciona o Elemento pelo id
        WebElement campo = driver.findElement(By.id(fieldId));
        //Executa javascript para abrir Dropdown do select2 jquery
        //Os oo só são carregados após abrir uma vez
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String OpenDropdownSript = "$('#"+fieldId+"').select2('open')";
        js.executeScript(OpenDropdownSript, campo);
        //Executa javascript para remover a classe que deixa o componente padrão de select hidden
        String removeHiddenClassScript = "$('#"+fieldId+"').removeClass('select2-hidden-accessible')";
        js.executeScript(removeHiddenClassScript, campo);
        //Seleciona a opção a partir do componente padrão de select
        Select combo = new Select(campo);
        combo.selectByVisibleText(value);
        //Executa javascript para fechar o Componente de Dropdown do select2
        String closeDropdownScript = "$('#"+fieldId+"').select2('close')";
        js.executeScript(closeDropdownScript, campo);
    }
    GeraCpfCnpj teste = new GeraCpfCnpj();

    @Test
    public void IncluirCliente_ComDocumentoCpfValido_DeveriaIncluirSucesso() throws InterruptedException {
        GeraCpfCnpj cpfCnpj = new GeraCpfCnpj();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://vfcli.varejofacil.com/cliente/cadastro?clearCache=true");
        driver.findElement(By.linkText("Incluir")).click();
        selectItemFromList("tipoPessoa","Física");
        driver.findElement(By.id("cpfCnpjPassaporte")).click();
        driver.findElement(By.id("cpfCnpjPassaporte")).sendKeys(Keys.HOME + cpfCnpj.cpf() + Keys.TAB);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ajaxLoadingStatusWithImage"))));
        driver.findElement(By.id("nome")).sendKeys("FICTICIO NAME");
        selectItemFromList("holding","GERAL");
        driver.findElement(By.id("cep")).sendKeys(Keys.HOME + "60811110" + Keys.TAB);
        driver.findElement(By.id("numero")).sendKeys(Keys.HOME + "800");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ajaxLoadingStatusWithImage"))));
        driver.findElement(By.id("btn_salvar")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.alerta-msg"))));

        String str = driver.findElement(By.cssSelector("span.alerta-msg")).getText();

        Assert.assertEquals(str,"Operação concluída com sucesso.");

    }

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
