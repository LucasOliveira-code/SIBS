package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Utils;

public class PortalSibsPage extends Utils {
    WebDriver driver;
    public PortalSibsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarAplicacao() {
        driver.get("https://www.mbway.pt/");
    }

    public void selecionarOpcao(String menu) {
        Utils.validaElementoNaTela(By.xpath("//span[text()='" + menu + "']"));
        Utils.clicar(By.xpath("//span[text()='" + menu + "']"));
    }

    public void selecionarBtn(String btn) {
        Utils.validaElementoNaTela(By.xpath("(//span[text()='" + btn + "'])[2]"));
        Utils.clicar(By.xpath("(//span[text()='" + btn + "'])[2]"));
    }

    public void preencherCampo(String campo, String text) {
        WebElement iframe = driver.findElement(By.id("onboardingIframe"));
        driver.switchTo().frame(iframe);
        Utils.aguardarElementoExistir(By.xpath("//input[@name='" + campo + "']"));
        Utils.digitar(By.xpath("//input[@name='" + campo + "']"), text);
        driver.switchTo().defaultContent();
    }

    public void selecionarCampo(String campo, String opcao) {
        WebElement iframe = driver.findElement(By.id("onboardingIframe"));
        driver.switchTo().frame(iframe);
        Utils.validaElementoNaTela(By.xpath("//select[@name='" + campo + "']"));
        Utils.clicar(By.xpath("//select[@name='" + campo + "']//..//*[text()='" +opcao+ "']"));
        driver.switchTo().defaultContent();
    }

    public void aceitarPolitica() {
        WebElement iframe = driver.findElement(By.id("onboardingIframe"));
        driver.switchTo().frame(iframe);
        Utils.validaElementoNaTela(By.xpath("//input[@name='optin']//.."));
        Utils.clicar(By.xpath("//input[@name='optin']//.."));
        driver.switchTo().defaultContent();
    }

    public void bntSubmeter() {
        WebElement iframe = driver.findElement(By.id("onboardingIframe"));
        driver.switchTo().frame(iframe);
        Utils.validaElementoNaTela(By.xpath("//a[text()='Submeter']"));
        Utils.clicar(By.xpath("//a[text()='Submeter']"));
        driver.switchTo().defaultContent();
    }

    public void mensagemSubmissao() {
        WebElement iframe = driver.findElement(By.id("onboardingIframe"));
        driver.switchTo().frame(iframe);
        Utils.validaElementoNaTela(By.xpath("//*[text()='Obrigado pela Submissão!']"));
        driver.switchTo().defaultContent();
    }

}
