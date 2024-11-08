package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import pages.PortalSibsPage;
import runner.RunCucumberTest;


public class PortalSibsStep extends RunCucumberTest {

    PortalSibsPage portalSibsPage = new PortalSibsPage(driver);

    @Given("^que estou no portal MBWay$")
    public void que_estou_no_portal_MBWay() {
        portalSibsPage.acessarAplicacao();
    }

    @When("^seleciono a opcao \"([^\"]*)\"$")
    public void seleciono_a_opcao(String opcao) {
        portalSibsPage.selecionarOpcao(opcao);
    }

    @Then("^clico no botao \"([^\"]*)\"$")
    public void clico_no_botao(String btn) {
        portalSibsPage.selecionarBtn(btn);
    }

    @And("^preencher no campo \"([^\"]*)\" meu nome completo \"([^\"]*)\"$")
    public void preencherNoCampoMeuNomeCompleto(String campo, String text) {
        portalSibsPage.preencherCampo(campo, text);
    }

    @And("^preencher no campo \"([^\"]*)\" meu numero de telefone \"([^\"]*)\"$")
    public void preencherNoCampoMeuNumeroDeTelefone(String campo, String text) {
        portalSibsPage.preencherCampo(campo, text);
    }

    @And("^preencher no campo \"([^\"]*)\" meu email \"([^\"]*)\"$")
    public void preencherNoCampoMeuEmail(String campo, String text) {
        portalSibsPage.preencherCampo(campo, text);
    }

    @And("^seleciono no campo \"([^\"]*)\" o pais \"([^\"]*)\"$")
    public void selecionoNoCampoOPais(String campo, String opcao) {
        portalSibsPage.selecionarCampo(campo, opcao);
    }

    @And("^preencher no campo \"([^\"]*)\" meu NIF \"([^\"]*)\"$")
    public void preencherNoCampoMeuNIF(String campo, String text) {
        portalSibsPage.preencherCampo(campo, text);
    }

    @And("^seleciono no campo \"([^\"]*)\" uma solucao \"([^\"]*)\"$")
    public void selecionoNoCampoUmaSolucao(String campo, String opcao) {
        portalSibsPage.selecionarCampo(campo, opcao);
    }

    @And("^seleciono no campo \"([^\"]*)\" o \"([^\"]*)\"$")
    public void selecionoNoCampoO(String campo, String opcao) {
        portalSibsPage.selecionarCampo(campo, opcao);
    }

    @Then("^aceito a politica de privacidade$")
    public void aceito_a_politica_de_privacidade() {
        portalSibsPage.aceitarPolitica();
    }

    @And("^clico no botao Submeter$")
    public void clicoNoBotaoSubmeter() {
        portalSibsPage.bntSubmeter();
    }

    @Then("^visualizo a mensagem Obrigado pela Submissao$")
    public void visualizo_a_mensagem_Obrigado_pela_Submissao() {
        portalSibsPage.mensagemSubmissao();
    }

}
