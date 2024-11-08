package support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

/**
 * Classe que contem os metodos de interação com o browser
 *
 * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
 */

public class Utils extends RunCucumberTest {

    private static final WebDriverWait wait = new WebDriverWait(driver, 45);

    private static final String LOAD = "//*[@aria-label='carregando' or @alt='Carregando']";

    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * Clica no elemento indicado.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void clicar(By seletor) {
        wait.until(ExpectedConditions.elementToBeClickable(seletor)).click();
    }

    /**
     * Clica no elemento utilizando JavaScript
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void clicarJs(By seletor) {
        js.executeScript("arguments[0].click();", driver.findElement(seletor));
    }

    /**
     * Digita o valor informado no seletor indicado.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void digitar(By seletor, String valor) {
        limpar(seletor);
        wait.until(ExpectedConditions.elementToBeClickable(seletor)).sendKeys(valor);
    }

    /**
     * Digita o valor informado no seletor indicado utilizando JavaScript.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void digitarJs(By seletor, String valor) {
        js.executeScript("arguments[0].value='" + valor + "';", driver.findElement(seletor));
    }

    /**
     * Limpa o seletor.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void limpar(By seletor) {
        wait.until(ExpectedConditions.elementToBeClickable(seletor)).clear();
    }

    /**
     * Tempo de expera de 2 segundos
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void aguardar() {
        aguardar(2);
    }

    /**
     * Inseir o tempo de expera em segundos.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void aguardar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Valida se o Elemento existe.
     *
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     *
     * @return booleano
     */
    public static boolean elementoExiste(By seletor) {
        return driver.findElements(seletor).size() != 0;
    }

    /**
     * Aguardar por 30 segundos para conter o elemento na tela.
     *
     * @param seletor
     *
     * @return booleano
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     * @throws InterruptedException
     */
    public static boolean aguardarElementoExistir(By seletor) {
        aguardar(1);
        boolean resp;
        System.out.println("---------------------------------------------------------------------------------------");
        for (int i = 0; i < 8; i++) {
            resp = elementoExiste(seletor);
            //Logger.infoLine(String.format("Aguardando existencia na tela do elemento %s - %d", seletor, i));
            if (resp) {
                return resp;
            }
        }
        return false;
    }

    /**
     * Valida se elemento esta visivel na tela. Caso o elemento não conter na tela é lancada uma exeção
     *
     *  @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     */
    public static void validaElementoNaTela(By seletor) {
        wait.until(ExpectedConditions.presenceOfElementLocated(seletor));
    }

    /**
     * Aguardar por ate 30 segundos o elemento sair da tela.
     *
     * @return booleano
     * @author <a href="mailto:lucas.oliver_85@hotmail.com">Lucas Oliveira</a>
     * @throws InterruptedException
     */
    public static boolean aguardarLoading() {
        boolean resp;
        for (int i = 0; i < 60; i++) {
            resp = driver.findElements(By.xpath(LOAD)).size() == 0;
            System.out.println(String.format("Load na tela - %d", i));
            if (resp) {
                return true;
            }
            aguardar(1);
        }
        return false;
    }

}
